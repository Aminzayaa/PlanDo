package com.example.plan.util;


import com.example.plan.entity.SessionInfo;
import jakarta.servlet.http.HttpSession;

public class ParamUtil {

    public static SessionInfo getSessionInfo(HttpSession session) {

        SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
        if (sessionInfo == null) {

            return new SessionInfo();

        } else {

            return sessionInfo;

        }

    }

}

