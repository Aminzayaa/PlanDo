package com.example.plan.entity;

import java.io.Serializable;

public class SessionInfo implements Serializable {
private static final long serialVersionUID = 1L;

    private User loginUser; 
    private User registerUser; 
    private User prevUpdateUser; 
    private User updateUser;
    // Default constructor
    public SessionInfo() {
    }

    // Constructor with loginUser initialization
    public SessionInfo(User loginUser) {
        this.loginUser = loginUser;

    }
    // Getters and Setters
    public User getLoginUser() {
        return loginUser;

    }



    public void setLoginUser(User loginUser) {

        this.loginUser = loginUser;

    }



    public User getRegisterUser() {

        return registerUser;

    }



    public void setRegisterUser(User registerUser) {

        this.registerUser = registerUser;

    }



    public User getPrevUpdateUser() {

        return prevUpdateUser;

    }



    public void setPrevUpdateUser(User prevUpdateUser) {

        this.prevUpdateUser = prevUpdateUser;

    }



    public User getUpdateUser() {

        return updateUser;

    }



    public void setUpdateUser(User updateUser) {

        this.updateUser = updateUser;

    }

}