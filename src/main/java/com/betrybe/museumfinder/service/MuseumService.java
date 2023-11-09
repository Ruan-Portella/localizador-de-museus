package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.CoordinateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * MuseumService.
 */

@Service
public class MuseumService implements MuseumServiceInterface {
  public MuseumFakeDatabase database;

  /**
   * MuseumService Methods.
   */

  @Autowired
  public MuseumService(MuseumFakeDatabase database) {
    this.database = database;
  }

  @Override
  public Museum createMuseum(Museum museum) {
    Coordinate coordinate = museum.getCoordinate();
    boolean verifyCoordinate = CoordinateUtil.isCoordinateValid(coordinates);
    if (verifyCoordinate) {
      return this.database.saveMuseum(museum);
    } else {
      throw new InvalidCoordinateException();
    }
  }
}
