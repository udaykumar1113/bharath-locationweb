package com.uday.location.controller;

import com.uday.location.entities.Location;
import com.uday.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

    @Autowired
    LocationRepository locationRepository;

    public LocationRESTController(LocationRepository locationRepository) {
        this.locationRepository=locationRepository;
    }
    @GetMapping
    public List<Location> getLocations(){
        return locationRepository.findAll();
    }

    @PostMapping
    public Location putLocation(@RequestBody Location location){
        return locationRepository.save(location);
    }

    @PutMapping
    public Location updateLocation(@RequestBody Location location){
        return locationRepository.save(location);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable("id") int id){
        locationRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Location findLocation(@PathVariable("id") int id){
        //return locationRepository. (id);
        return locationRepository.getOne(id);
    }
}
