package com.example.plan.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.plan.entity.PerPlan;

@Service
public interface PerPlanService {

	PerPlanService perPlanDao = null;

    public List<PerPlan> findAll();

    public List<PerPlan> findByUserId(Long plan_id);

    public default List<PerPlan> getAllPlans() {
        return perPlanDao.findAll();
    }
    public void deletePlan(int plan_id);

    List<PerPlan> findPlansByUserId(Integer user_id);

    PerPlan findPlanById(int plan_id); 
    
    void edit(PerPlan perPlan);

    void addPlan(PerPlan perPlan);

    public void save(PerPlan newPlan);

    public List<PerPlan> loginUser();

    
}