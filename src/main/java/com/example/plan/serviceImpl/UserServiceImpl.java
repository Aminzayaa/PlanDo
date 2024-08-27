package com.example.plan.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.plan.dao.UserDao;
import com.example.plan.entity.User;
import com.example.plan.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User authentication(String login_id, String password) {
        return userDao.findByLoginIdAndPassword(login_id, password);
    }

	@Override
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public User findByUserId(Integer userId) {
	       return userDao.findByUserId(userId);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}
    
}