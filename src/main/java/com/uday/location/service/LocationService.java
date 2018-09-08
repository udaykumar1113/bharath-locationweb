package com.uday.location.service;

import com.uday.location.entities.Location;

import java.util.List;

public interface LocationService {

    Location getLocationById(int id);

    Location saveLocation(Location location);

    Location updateLocation(Location location);

    void deleteLocation(Location location);

    List<Location> getAllLocations();
}
