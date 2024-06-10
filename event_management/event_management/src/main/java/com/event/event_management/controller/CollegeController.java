package com.event.event_management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.event.event_management.module.College;
import com.event.event_management.module.CollegeLogin;
import com.event.event_management.services.CollegeServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CollegeController {

    @Autowired
    private CollegeServices cs;

    @GetMapping("/registercollege")
    public String getregiClg(Model model) {
        model.addAttribute("college", new College());
        return "collegeregistration";
    }

    @PostMapping("/collegeregistrationStatus")
    public String getStatus(@Valid @ModelAttribute("college") College college, BindingResult br) {
        if (br.hasErrors()) {
            return "collegeregistration";
        }
        cs.saveCollege(college);
        return "redirect:/collegelogin";
    }

    @GetMapping("/collegelogin")
    public String getlogin(Model model) {
        model.addAttribute("collegelogin", new CollegeLogin());
        return "collegelogin";
    }

    @PostMapping("/collegeloginstatus")
    public String getloginStatus(@Valid @ModelAttribute("collegelogin") CollegeLogin collegelogin, BindingResult br, Model model, HttpSession session) {
        if (br.hasErrors()) {
            return "collegelogin";
        }
        
        List<College> dbCollege = cs.collegeList();
        for (College cl : dbCollege) {
            if (cl.getUsername().equals(collegelogin.getUsername()) && cl.getPassword().equals(collegelogin.getPassword())) {
                session.setAttribute("loggedCollege", cl);
                return "collegedashboard";
            }
        }
        model.addAttribute("error", "Incorrect username or password");
        return "collegelogin";
    }

}
