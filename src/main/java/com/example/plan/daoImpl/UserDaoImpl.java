package com.example.plan.daoImpl;


import java.util.List;

import com.example.plan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.plan.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<User> findAll() {
		return jdbcTemplate.query("SELECT * FROM users ORDER BY user_id", new BeanPropertyRowMapper<User>(User.class));
	}

	public User findByLoginIdAndPassword(String login_id, String password) {
		List<User> readList = jdbcTemplate.query(
				"SELECT * FROM users WHERE login_id = :login_id AND password = :password",
				new MapSqlParameterSource().addValue("login_id", login_id).addValue("password", password),
				new BeanPropertyRowMapper<User>(User.class));
		return readList.isEmpty() ? null : readList.get(0);
	}

//--------------
//@Override
public User findByUserId(Integer userId) {
    List<User> readList = jdbcTemplate.query(
            "SELECT * FROM users WHERE user_id = :user_id", 
            new MapSqlParameterSource().addValue("user_id", userId),
            new BeanPropertyRowMapper<User>(User.class));
    return readList.isEmpty() ? null : readList.get(0);
}

public int insertUser(User user) {
    int insertResult = jdbcTemplate.update(
            "INSERT INTO users (login_id, name, password, email, phone_number) VALUES (:login_id, :name, :password, :email, :phone_number)",
            new MapSqlParameterSource()
                    .addValue("login_id", user.getLoginId())
                    .addValue("name", user.getName())
                    .addValue("password", user.getPassword())
                    .addValue("email", user.getEmail())
                    .addValue("phone_number", user.getPhone_number()
                    		));
                    
    return insertResult;
}


//@Override
public int updateUser(User user) {
   
    int updateResult = jdbcTemplate.update(
            "UPDATE users SET name = :name, password = :password,  email = :email, phone_number = :phone_number WHERE login_id = :login_id",
            new MapSqlParameterSource()
            		.addValue("login_id", user.getLoginId())
                    .addValue("name", user.getName())
                    .addValue("password", user.getPassword())
                    .addValue("email", user.getEmail())
                    .addValue("phone_number", user.getPhone_number()
                    
    ));
    return updateResult;
}

//@Override
public void delete(Integer id) {
	// TODO Auto-generated method stub
	
}
}