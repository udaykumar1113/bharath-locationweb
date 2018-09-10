package com.uday.location.controller;

import com.uday.location.entities.Location;
import com.uday.location.repository.LocationRepository;
import com.uday.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LocationController {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    LocationService locationService;

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

    @RequestMapping("/viewLocations")
    public String viewLocations(ModelMap modelMap){
        List<Location> locationsList=locationRepository.findAll();
        modelMap.addAttribute("locations",locationsList);
        return "viewLocations";
    }

    @RequestMapping("/deleteLocation/{id}")
    public String deleteLocation(@PathVariable("id") int id, ModelMap modelMap){
        System.out.println("Inside delete location with id: "+id);
        Location location=locationRepository.getOne(id);
        locationRepository.delete(location);
        List<Location> locationsList=locationRepository.findAll();
        modelMap.addAttribute("locations",locationsList);
        return "viewLocations";
    }

    @RequestMapping("/updateLocation/{id}")
    public String updateLocation(@PathVariable("id") int id, ModelMap modelMap){
        Location location=locationRepository.getOne(id);
        modelMap.addAttribute("editingLocation",location);
        return "editLocation";
    }

    @RequestMapping("/saveUpdateLoc")
    public String saveUpdatedLocation(@ModelAttribute("location") Location location, ModelMap modelMap){
        locationService.updateLocation(location);
        return "viewLocations";
    }
}
