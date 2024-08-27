package com.example.plan.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.plan.entity.PerPlan;
import com.example.plan.entity.SessionInfo;
import com.example.plan.entity.User;
import com.example.plan.service.PerPlanService;
import com.example.plan.util.ParamUtil;
import jakarta.servlet.http.HttpSession;


@Controller
public class PerPlanController {

	@Autowired
    HttpSession session;

	 @Autowired
	    private PerPlanService perPlanService;
	

	   @GetMapping("/perPlan")
     	public String perPlan(Model model) {
         // Get the logged-in user's information
         SessionInfo sessionInfo = ParamUtil.getSessionInfo(session);
         User loginUser = sessionInfo.getLoginUser();

	        List<PerPlan> perPlanList = perPlanService.findPlansByUserId(loginUser.getUserId());
	        model.addAttribute("perPlanList", perPlanList);
	        return "perPlan";
		}
		

		 @PostMapping("/delete")
   		 public String deletePlan(@RequestParam("plan_id") int plan_id) {
        	perPlanService.deletePlan(plan_id);
        	return "redirect:/perPlan";
    	}


		@PostMapping("/edit")
		public String editPlan(@RequestParam("plan_id") int planId, Model model) {
			PerPlan plan = perPlanService.findPlanById(planId);
			model.addAttribute("plan", plan);
			return "edit"; // This maps to edit.jsp
		}
	
		// Handle form submission for updating the plan
		@PostMapping("/update")
		public String updatePlan(@ModelAttribute PerPlan perPlan) {
			perPlanService.edit(perPlan);
			return "redirect:/perPlan"; // Redirect back to the list of plans
		}


		@PostMapping("/addPlan")
    	public String addPlan(@ModelAttribute PerPlan perPlan, RedirectAttributes redirectAttributes) {
        perPlanService.addPlan(perPlan);
        redirectAttributes.addFlashAttribute("message", "Plan added successfully!");
        return "redirect:/perPlan"; // Redirect to the list or overview page
    }


}

