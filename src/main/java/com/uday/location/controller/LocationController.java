package com.uday.location.controller;

import com.uday.location.entities.Location;
import com.uday.location.repository.LocationRepository;
import com.uday.location.service.LocationService;
import com.uday.location.utility.ReportUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.List;

@Controller
public class LocationController implements ServletContextAware{

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    LocationService locationService;

    @Autowired
    ReportUtility reportUtility;

    //@Value("${server.servlet.context-path}")
    //String contextPath;

    ServletContext ctx;

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

    @RequestMapping("/generateReport")
    public String generateReport(ModelMap modelMap){

        List<Object[]> data=locationRepository.getTypeAndCountType();
        System.out.println("servlet context "+ctx.getRealPath("/"));
        System.out.print("get context path value is: "+ctx.getContextPath());
        reportUtility.generatePieChart(ctx.getRealPath("/"),data);
        modelMap.addAttribute("contextPath",ctx.getRealPath("/"));
        return "report";
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        ctx=servletContext;
    }
}
