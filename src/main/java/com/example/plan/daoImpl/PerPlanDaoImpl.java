package com.example.plan.daoImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.plan.dao.PerPlanDao;
import com.example.plan.entity.PerPlan;

@Repository
public class PerPlanDaoImpl implements PerPlanDao {

	 @Autowired
	    private NamedParameterJdbcTemplate jdbcTemplate;
    private Object plan_id;

	    @Override
	    public List<PerPlan> findAll() {
	        return jdbcTemplate.query("SELECT * FROM perplan ORDER BY user_id",
	                new BeanPropertyRowMapper<PerPlan>(PerPlan.class));
					
	    }

        @Override
        public int findPlanByPlan_id(Integer plan_id) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findPlanByPlan_id'");
        }

        @Override
        public void deleteByPlanId(int plan_id) {
            String sql = "DELETE FROM perplan WHERE plan_id = :plan_id";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("plan_id", plan_id);
            jdbcTemplate.update(sql, params);
        }

        @Override
        public PerPlan findPlanById(int plan_idd) {
        String sql = "SELECT * FROM perplan WHERE plan_id = :plan_id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("plan_id", plan_id);
        return jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(PerPlan.class));
    }
		


    @Override
    public List<PerPlan> findPlansByUserId(Integer user_id) {
        String sql = "SELECT * FROM perplan WHERE user_id = :user_id ORDER BY start_date";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("user_id", user_id);
        return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(PerPlan.class));
    }

    @Override
    public PerPlan findById(int planId) {
        String sql = "SELECT * FROM perplan WHERE plan_id = :plan_id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("plan_id", planId);
        return jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(PerPlan.class));
    }

    @Override
    public void update(PerPlan perPlan) {
        String sql = "UPDATE perplan SET title = :title, description = :description, start_date = :startDate, end_date = :endDate, status = :status WHERE plan_id = :plan_id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("title", perPlan.getTitle());
        params.addValue("description", perPlan.getDescription());
        params.addValue("startDate", perPlan.getStartDate());
        params.addValue("endDate", perPlan.getEndDate());
        params.addValue("status", perPlan.getStatus());
        params.addValue("plan_id", perPlan.getPlan_id());
        jdbcTemplate.update(sql, params);
    }

    @Override
    public void add(PerPlan perPlan) {
        String sql = "INSERT INTO perplan (user_id, title, description, start_date, end_date, status) VALUES (:user_id, :title, :description, :startDate, :endDate, :status)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("user_id", perPlan.getUser_id());  // Ensure this is set properly
        params.addValue("title", perPlan.getTitle());
        params.addValue("description", perPlan.getDescription());
        params.addValue("startDate", perPlan.getStartDate());
        params.addValue("endDate", perPlan.getEndDate());
        params.addValue("status", perPlan.getStatus());
        jdbcTemplate.update(sql, params);
    }
}
