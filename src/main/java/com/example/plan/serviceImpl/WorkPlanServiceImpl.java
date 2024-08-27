package com.example.plan.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.plan.dao.WorkPlanDao;
import com.example.plan.entity.WorkPlan;
import com.example.plan.service.WorkPlanService;

@Service
public class WorkPlanServiceImpl implements WorkPlanService {

	@Autowired
    private WorkPlanDao workPlanDao;

    public List<WorkPlan> findAll() {
        return workPlanDao.findAll();
    }
    @Override
    public List<WorkPlan> findByUserId(Long plan_id) {
        throw new UnsupportedOperationException("Unimplemented method 'findByUserId'");
    }
    @Override
    public void deletePlan(int plan_id) {
        workPlanDao.deleteByPlanId(plan_id);
    }

    @Override
    public List<WorkPlan> findWorkPlansByUserId(Integer user_id) {
        return workPlanDao.findWorkPlansByUserId(user_id);
    }

    @Override
    public WorkPlan findPlanById(int plan_id) {
        return workPlanDao.findById(plan_id);
    }

    @Override
    public void edit(WorkPlan workPlan) {
        workPlanDao.update(workPlan);  
    }

    @Override
    public void addPlan(WorkPlan workPlan) {
        workPlanDao.add(workPlan); 
    }
    @Override
    public void save(WorkPlan workPlan) {
       workPlanDao.save(workPlan);
    }
    @Override
    public void update(WorkPlan workPlan) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public WorkPlan findById(Long plan_id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
 
}