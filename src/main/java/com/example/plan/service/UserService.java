package com.example.plan.service;

import java.util.List;

import com.example.plan.entity.User;


public interface UserService {

	public List<User> findAll();

	public User authentication(String login_id, String password);
	
	public int insertUser(User user);

	public User findByUserId(Integer userId);

	public int updateUser(User user);

	}