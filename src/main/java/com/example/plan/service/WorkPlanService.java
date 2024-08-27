package com.example.plan.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.plan.entity.WorkPlan;

@Service
public interface WorkPlanService {

	WorkPlanService workPlanDao = null;
    public List<WorkPlan> findAll();

    public List<WorkPlan> findByUserId(Long plan_id);

    public default List<WorkPlan> getAllPlans() {
        return workPlanDao.findAll();
    }
    public void deletePlan(int plan_id);

    List<WorkPlan> findWorkPlansByUserId(Integer user_id);

    WorkPlan findPlanById(int plan_id); 

    void edit(WorkPlan workPlan);

    void addPlan(WorkPlan workPlan);

    public void save(WorkPlan newPlan);

    public void update(WorkPlan workPlan);
    
    public WorkPlan findById(Long plan_id);

    
}