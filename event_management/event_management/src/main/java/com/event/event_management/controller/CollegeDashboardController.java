package com.event.event_management.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.event.event_management.module.CollegeDashboard;
import com.event.event_management.module.College;
import com.event.event_management.services.CollegeDashboardServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CollegeDashboardController {

    @Autowired
    private CollegeDashboardServices cd;

    @GetMapping("/addevent")
    public String addevent(Model model) {
        model.addAttribute("cld", new CollegeDashboard());
        return "eventform";
    }

    @PostMapping("/addeventStatus")
    public String getStatus(@Valid @ModelAttribute("cld") CollegeDashboard cld, BindingResult br, @RequestPart("eventposter") MultipartFile imgFile, HttpSession session) {
//        if (br.hasErrors()) {
//            return "eventform";
//        }
        if (!imgFile.isEmpty()) {
            try {
                cld.setEventposter(imgFile.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
                return "eventform";
            }
        }
        College loggedCollege = (College) session.getAttribute("loggedCollege");
        cld.setCollege(loggedCollege);
        cd.saveEvent(cld);
        return "collegedashboard";
    }
    
    @GetMapping("/eventlist")
    public String getAllEvents(Model model, HttpSession session) {
        College loggedCollege = (College) session.getAttribute("loggedCollege");
        List<CollegeDashboard> eventList = cd.findByCollege(loggedCollege);
        model.addAttribute("cld", eventList);
        return "eventlist";
    }

    @GetMapping("/show/eventposter/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> getEventPoster(@PathVariable int id) {
        CollegeDashboard event = cd.findById(id);
        byte[] eventPoster = event.getEventposter();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(eventPoster, header, HttpStatus.OK);
    }

    @PostMapping("/eventlist/delete")
    public String deleteEvent(@RequestParam("id") int id) {
        cd.deleteById(id);
        return "redirect:/eventlist";
    }

    @GetMapping("/eventList/edit")
    public String getEditForm(@RequestParam("id") int id, Model model) {
        CollegeDashboard findEvent = cd.findById(id);
        model.addAttribute("cld", findEvent);
        return "eventupdateform";
    }

    @PostMapping("/eventsaveupdate")
    public String getUpdate(@Valid @ModelAttribute("cld") CollegeDashboard cld, BindingResult br, @RequestParam("eventposter") MultipartFile imgFile) {
        if (br.hasErrors()) {
            return "eventupdateform";
        }
        if (!imgFile.isEmpty()) {
            try {
                cld.setEventposter(imgFile.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
                return "eventupdateform";
            }
        }
        cd.updateEvent(cld);
        return "redirect:/eventlist";
    }
}
