package com.event.event_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.event.event_management.module.CollegeDashboard;
import com.event.event_management.module.User;
import com.event.event_management.module.UserLogin;
import com.event.event_management.services.CollegeDashboardServices;
import com.event.event_management.services.UserServices;

import jakarta.validation.Valid;
import com.event.event_management.module.*;
@Controller
public class UserController {
	
	@Autowired
	private CollegeDashboardServices cs;
	

	@Autowired
	private UserServices userService;
	
	@GetMapping("/registeruser")
	public String getUser(Model model) {
		model.addAttribute("user", new User());
		return "userregistration";
		
	}
	
	@PostMapping("/status")
	public  String getStatus(@Valid @ModelAttribute("user") User user, BindingResult br){
		if(br.hasErrors()) {
			return "userregistration";
		}
		 userService.saveUser(user);
		return "redirect:/userlogin";
		
	}
	
	@GetMapping("/userlogin")
	public String getLogin(Model model) {
		model.addAttribute("userlogin", new UserLogin());
		return "userlogin";
		
	}
	
	@PostMapping("/userloginstatus")
	public String getloginStatus(@Valid @ModelAttribute("userlogin") UserLogin userlogin, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "userlogin";
			
		}
		
		List<User> dbUser = userService.userList();
		boolean found = false;
		for(User ur: dbUser) {
			if(ur.getUsername().equals(userlogin.getUsername())&& ur.getPassword().equals(userlogin.getPassword())) {
				found= true;
				break;
			}
		}
		if(found==true) {
			List<CollegeDashboard> allevents = cs.eventList();
			model.addAttribute("cld", allevents);
			return "studentdashboard";
		}
		else {
			model.addAttribute("error", "Incorrect username or password");
			return "userlogin";
		}
		
		
	}
	
	@GetMapping("/eventdetails/{id}")
    public String getEventDetails(@PathVariable("id") int id, Model model) {
        CollegeDashboard event = cs.findById(id);
        model.addAttribute("cld", event);
        return "eventdetails";
    }

	
}
