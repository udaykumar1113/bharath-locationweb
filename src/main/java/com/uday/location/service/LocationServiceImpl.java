package com.uday.location.service;

import com.uday.location.entities.Location;
import com.uday.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{
    @Autowired
    LocationRepository locationRepository;
    @Override
    public Location getLocationById(int id) {
        Location location=locationRepository.getOne(id);
        return location;
    }
    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void deleteLocation(Location location) {
        locationRepository.delete(location);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
