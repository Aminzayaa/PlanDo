package com.example.plan.daoImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.plan.dao.WorkPlanDao;
import com.example.plan.entity.WorkPlan;

@Repository
public class WorkPlanDaoImpl implements WorkPlanDao {

	 
	 @Autowired
	    private NamedParameterJdbcTemplate jdbcTemplate;
    private Object plan_id;

	    @Override
	    public List<WorkPlan> findAll() {
	        return jdbcTemplate.query("SELECT * FROM workplan ORDER BY user_id",
	                new BeanPropertyRowMapper<WorkPlan>(WorkPlan.class));
					
	    }

        // @Override
        // public int findPlanByPlan_id(Integer plan_id) {
        //     // TODO Auto-generated method stub
        //     throw new UnsupportedOperationException("Unimplemented method 'findPlanByPlan_id'");
        // }

        @Override
        public void deleteByPlanId(int plan_id) {
            String sql = "DELETE FROM workplan WHERE plan_id = :plan_id";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("plan_id", plan_id);
            jdbcTemplate.update(sql, params);
        }

        @Override
        public WorkPlan findPlanById(int plan_idd) {
        String sql = "SELECT * FROM workplan WHERE plan_id = :plan_id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("plan_id", plan_id);
        return jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(WorkPlan.class));
    }
		


    @Override
    public List<WorkPlan> findWorkPlansByUserId(Integer user_id) {
        String sql = "SELECT * FROM workplan WHERE user_id = :user_id ORDER BY start_date";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("user_id", user_id);
        return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(WorkPlan.class));
    }

    @Override
    public WorkPlan findById(int plan_id) {
        String sql = "SELECT * FROM workplan WHERE plan_id = :plan_id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("plan_id", plan_id);
        return jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(WorkPlan.class));
    }

    @Override
    public void update(WorkPlan workPlan) {
        String sql = "UPDATE workplan SET title = :title, description = :description, start_date = :startDate, end_date = :endDate, status = :status WHERE plan_id = :plan_id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("title", workPlan.getTitle());
        params.addValue("description", workPlan.getDescription());
        params.addValue("startDate", workPlan.getStartDate());
        params.addValue("endDate", workPlan.getEndDate());
        params.addValue("status", workPlan.getStatus());
        params.addValue("plan_id", workPlan.getPlan_id());
        jdbcTemplate.update(sql, params);
    }

    @Override
    public void add(WorkPlan workPlan) {
        String sql = "INSERT INTO workplan (user_id, title, description, start_date, end_date, status) VALUES (:user_id, :title, :description, :startDate, :endDate, :status)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("user_id", workPlan.getUser_id());  // Ensure this is set properly
        params.addValue("title", workPlan.getTitle());
        params.addValue("description", workPlan.getDescription());
        params.addValue("startDate", workPlan.getStartDate());
        params.addValue("endDate", workPlan.getEndDate());
        params.addValue("status", workPlan.getStatus());
        jdbcTemplate.update(sql, params);
    }

    @Override
    public void save(WorkPlan workPlan) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
		
    	

}