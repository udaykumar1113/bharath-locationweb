package com.uday.location.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LocationController {

    @RequestMapping("/showCreate")
    public String showCreate(){
        System.out.println("in show create method");
        return "createLocation";
    }
}
