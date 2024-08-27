package com.example.plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.plan.form.UserForm;
import com.example.plan.service.UserService;
import com.example.plan.util.ParamUtil;


import jakarta.servlet.http.HttpSession;
import com.example.plan.entity.SessionInfo;
import com.example.plan.entity.User;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    HttpSession session;

    // Register action 
    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register"; // This should return the register.jsp view
    }

    @PostMapping("/user")
    public String registerUser(UserForm userForm, Model model) {
        if (userForm.getLogin_id() == null || userForm.getLogin_id().isEmpty() ||
            userForm.getName() == null || userForm.getName().isEmpty() ||
            userForm.getPassword() == null || userForm.getPassword().isEmpty() ||
            userForm.getEmail() == null || userForm.getEmail().isEmpty() ||
            userForm.getPhone_number() == null) {
            model.addAttribute("errMsg", "Please insert value!");
            return "register";
        }
        
        User newUser = new User(1, userForm.getLogin_id(), userForm.getName(), userForm.getPassword(),
                                userForm.getEmail(), userForm.getPhone_number());
        userService.insertUser(newUser);
        model.addAttribute("errMsg", "Successfully registered!");
        return "register";
    }

    // New method to show logged user's information
    @GetMapping("/profile")
    public String showProfile(Model model) {
        // Retrieve the session information and login user
        SessionInfo sessionInfo = ParamUtil.getSessionInfo(session);
        User loginUser = sessionInfo.getLoginUser();

        if (loginUser == null) {
            model.addAttribute("errMsg", "Session expired. Please log in again.");
            return "redirect:/login";
        }

        User user = userService.findByUserId(loginUser.getUserId());
        if (user == null) {
            model.addAttribute("errMsg", "User not found.");
            return "error";
        }

        UserForm userForm = new UserForm();
        userForm.setUser_id(user.getUserId());
        userForm.setLogin_id(user.getLoginId());
        userForm.setName(user.getName());
        userForm.setPassword(user.getPassword());
        userForm.setEmail(user.getEmail());
        userForm.setPhone_number(user.getPhone_number());

        model.addAttribute("userForm", userForm);
        return "profile";
    }

   //  Method to handle editing/updating user information
    @PostMapping("/editUser")
    public String updateUser(UserForm userForm, Model model) {
        User user = new User(userForm.getUser_id(), userForm.getLogin_id(), userForm.getName(),
                             userForm.getPassword(), userForm.getEmail(), userForm.getPhone_number());
                             
        int result = userService.updateUser(user);
        if (result > 0) {
            model.addAttribute("successMsg", "User information updated successfully.");
            return "redirect:/menu";
        } else {
            model.addAttribute("errMsg", "Failed to update user information.");
            return "profile";
        }
    }
    }