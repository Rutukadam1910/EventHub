package com.event.event_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.event.event_management.module.College;
import com.event.event_management.module.CollegeDashboard;
import com.event.event_management.services.CollegeDashboardServices;

@Controller
public class DashboardController {

//	@GetMapping("/eventRegistration")
//	public String geteventregi() {
//		return "aboutevent";
//	}
	
	@Autowired
	private CollegeDashboardServices cs;
	
	@GetMapping("/allevents")
	public String getevent(Model model) {
		List<CollegeDashboard> allevents = cs.eventList();
		model.addAttribute("cld", allevents);
		return "studentdashboard";
		
	}
}
