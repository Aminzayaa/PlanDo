package com.example.plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;
import com.example.plan.entity.SessionInfo;
import com.example.plan.entity.User;
import com.example.plan.form.LoginForm;
import com.example.plan.service.UserService;
import com.example.plan.util.ParamUtil;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String handleLoginForm(LoginForm loginForm, Model model) {
        // Validate that login_id and password are not null or empty
        if (loginForm.getLogin_id() == null || loginForm.getLogin_id().isEmpty() ||
            loginForm.getPassword() == null || loginForm.getPassword().isEmpty()) {
            model.addAttribute("errMsg", "Please insert value!");
            return "login"; // Return to login page with error message
        }

        // Proceed with authentication if validation passes
        User user = userService.authentication(loginForm.getLogin_id(), loginForm.getPassword());
        if (user != null) {
            SessionInfo sessionInfo = ParamUtil.getSessionInfo(session);
            sessionInfo.setLoginUser(user);
            session.setAttribute("sessionInfo", sessionInfo);
            storeLoginUserInSession(user); 
            model.addAttribute("user", user);
            return "redirect:/menu";
        } else {
            model.addAttribute("errMsg", "Invalid login Id or Password");
            return "login";
        }
    }

    public void storeLoginUserInSession(User user) {
        // Retrieve the existing SessionInfo object or create a new one
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
        if (sessionInfo == null) {
            sessionInfo = new SessionInfo();
            session.setAttribute("sessionInfo", sessionInfo);
        }
        // Additional logic to store user details in the session can be added here if needed
    }

    @PostMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        return "menu";
    }
}
