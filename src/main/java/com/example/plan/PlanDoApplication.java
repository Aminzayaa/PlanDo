package com.example.plan;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.plan.entity.PerPlan;
import com.example.plan.entity.WorkPlan;
import com.example.plan.service.PerPlanService;
import com.example.plan.service.WorkPlanService;

@SpringBootApplication
public class PlanDoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PlanDoApplication.class, args);

		PerPlanService perPlanService = context.getBean(PerPlanService.class);
		List<PerPlan> list = perPlanService.findAll();
		for (PerPlan u : list) {
			System.out.println(u.getDescription());
		}
		WorkPlanService workPlanService = context.getBean(WorkPlanService.class);
		List<WorkPlan> workPlanlist = workPlanService.findAll();
		for (WorkPlan u : workPlanlist) {
			System.out.println(u.getDescription());
		}

	}

}
