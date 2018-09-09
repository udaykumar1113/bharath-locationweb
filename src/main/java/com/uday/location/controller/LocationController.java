package com.uday.location.controller;

import com.uday.location.entities.Location;
import com.uday.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LocationController {

    @Autowired
    LocationRepository locationRepository;

    @RequestMapping("/showCreate")
    public String showCreate(){
        System.out.println("in show create method");
        return "createLocation";
    }

    @RequestMapping("/saveLoc")
    public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap){
        Location savedLocation=locationRepository.save(location);
        String msg="Location accessed for id: "+savedLocation.getId();
        modelMap.addAttribute("msg",msg);
        return "createLocation";
    }
}
