package com.example.plan.dao;

import java.util.List;

import com.example.plan.entity.WorkPlan;

public interface WorkPlanDao {

	public List<WorkPlan> findAll();

    // public int findPlanByPlan_id(Integer plan_id);
    
    public void deleteByPlanId(int plan_id);
    
    public WorkPlan findPlanById(int plan_id);
    
    List<WorkPlan> findWorkPlansByUserId(Integer user_id);
    
    WorkPlan findById(int plan_id);  // Add this method
    
    void update(WorkPlan workPlan);

    void add(WorkPlan workPlan);

    public void save(WorkPlan workPlan);
    
}