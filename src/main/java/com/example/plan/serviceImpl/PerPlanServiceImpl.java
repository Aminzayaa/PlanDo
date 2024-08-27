package com.example.plan.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.plan.dao.PerPlanDao;
import com.example.plan.entity.PerPlan;
import com.example.plan.service.PerPlanService;

@Service
public class PerPlanServiceImpl implements PerPlanService {

	@Autowired
    private PerPlanDao perPlanDao;

    public List<PerPlan> findAll() {
        return perPlanDao.findAll();
    }
    @Override
    public List<PerPlan> findByUserId(Long plan_id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUserId'");
    }
    @Override
    public void deletePlan(int plan_id) {
        perPlanDao.deleteByPlanId(plan_id);
    }

    @Override
    public List<PerPlan> findPlansByUserId(Integer user_id) {
        return perPlanDao.findPlansByUserId(user_id);
    }

    @Override
    public PerPlan findPlanById(int plan_id) {
        return perPlanDao.findById(plan_id);
    }

    @Override
    public void edit(PerPlan perPlan) {
        perPlanDao.update(perPlan);  
    }

    @Override
    public void addPlan(PerPlan perPlan) {
        perPlanDao.add(perPlan); 
    }
    @Override
    public void save(PerPlan newPlan) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
    @Override
    public List<PerPlan> loginUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loginUser'");
    }
 
}