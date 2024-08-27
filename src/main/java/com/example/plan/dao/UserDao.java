package com.example.plan.dao;

import java.util.List;

import com.example.plan.entity.User;

public interface UserDao {

	public List<User> findAll();

	public User findByLoginIdAndPassword(String login_id, String password);
	
	public int insertUser(User user);
	    
	public void delete(Integer id);
	    
	public int updateUser(User user);

	public User findByUserId(Integer userId);

		
}