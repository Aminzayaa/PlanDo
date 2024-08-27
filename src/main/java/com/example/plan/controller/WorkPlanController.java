package com.example.plan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.plan.entity.PerPlan;
import com.example.plan.entity.SessionInfo;
import com.example.plan.entity.User;
import com.example.plan.entity.WorkPlan;
import com.example.plan.service.WorkPlanService;
import com.example.plan.util.ParamUtil;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/workPlan")
public class WorkPlanController {

    @Autowired
    HttpSession session;

    @Autowired
    private WorkPlanService workPlanService;

    @GetMapping
    public String workPlan(Model model) {
        SessionInfo sessionInfo = ParamUtil.getSessionInfo(session);
         User loginUser = sessionInfo.getLoginUser();

        List<WorkPlan> workPlanList = workPlanService.findWorkPlansByUserId(loginUser.getUserId());
        model.addAttribute("workPlanList", workPlanList);
        return "workPlan"; // This should map to workPlan.jsp
    }
    //   @GetMapping("/workPlan")
    //  	public String workPlan(Model model) {
    //      // Get the logged-in user's information
    //      SessionInfo sessionInfo = ParamUtil.getSessionInfo(session);
    //      User loginUser = sessionInfo.getLoginUser();

	//         List<WorkPlan> workPlanList = workPlanService.findPlansByUserId(loginUser.getUserId());
	//         model.addAttribute("workPlanList", workPlanList);
	//         return "workPlan";
	// 	}

    @PostMapping("/delete")
    public String deletePlan(@RequestParam("plan_id") int plan_id) {
        workPlanService.deletePlan(plan_id);
        return "redirect:/workPlan";
    }

    @PostMapping("/edit")
    public String editWorkPlan(@RequestParam("plan_id") int plan_id, Model model) {
        WorkPlan plan = workPlanService.findPlanById(plan_id);
        model.addAttribute("plan", plan);
        return "editWorkPlan"; // This should map to edit.jsp
    }

    @PostMapping("/addPlan")
    public String addWorkPlan(@ModelAttribute WorkPlan workPlan, RedirectAttributes redirectAttributes) {
        workPlanService.addPlan(workPlan);
        redirectAttributes.addFlashAttribute("message", "Plan added successfully!");
        return "redirect:/workPlan";
    }
	@GetMapping("/edit/{plan_id}")
    public String showEditForm(@PathVariable("plan_id") Long plan_id, Model model) {
        WorkPlan workPlan = workPlanService.findById(plan_id);
        model.addAttribute("plan", workPlan);
        return "editWorkPlan"; // Ensure this matches your JSP name
    }
    	@PostMapping("/update")
		public String updateWorkPlan(@ModelAttribute WorkPlan workPlan) {
			workPlanService.edit(workPlan);
			return "redirect:/workPlan"; // Redirect back to the list of plans
		}
}
