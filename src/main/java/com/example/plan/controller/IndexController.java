package com.example.plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import com.example.plan.entity.SessionInfo;
import com.example.plan.util.ParamUtil;


// Top screen controller
 
@Controller
public class IndexController {

 
    @Autowired
    HttpSession session;

//     Top screen display
    
    	@RequestMapping("/")
    	public String index(Model model) {
        SessionInfo sessionInfo = ParamUtil.getSessionInfo(session);

        if (sessionInfo.getLoginUser() == null) {
            // If you are not logged in, return to the top
        return "redirect:/login";
        }

        return "menu";
    }
 

}