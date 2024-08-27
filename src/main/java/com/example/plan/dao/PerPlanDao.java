package com.example.plan.dao;

import java.util.List;

import com.example.plan.entity.PerPlan;

public interface PerPlanDao {

	public List<PerPlan> findAll();

    public int findPlanByPlan_id(Integer plan_id);
    
    public void deleteByPlanId(int plan_id);
    
    public PerPlan findPlanById(int plan_id);
    
    List<PerPlan> findPlansByUserId(Integer user_id);
    
    PerPlan findById(int plan_id);  // Add this method
    
    void update(PerPlan perPlan);

    void add(PerPlan perPlan);
   
}