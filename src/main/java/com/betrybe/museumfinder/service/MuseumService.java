package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.CoordinateUtil;
import java.util.Optional;
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
    boolean verifyCoordinate = CoordinateUtil.isCoordinateValid(coordinate);
    if (verifyCoordinate) {
      return this.database.saveMuseum(museum);
    } else {
      throw new InvalidCoordinateException();
    }
  }

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double distance) {
    boolean verifyCoordinate = CoordinateUtil.isCoordinateValid(coordinate);
    if (verifyCoordinate) {
      Optional<Museum> getMuseum = this.database.getClosestMuseum(coordinate, distance);
      return getMuseum.orElseThrow(() -> new MuseumNotFoundException());
    } else {
      throw new InvalidCoordinateException();
    }
  }

  @Override
  public Museum getMuseum(Long id) {
    return this.database.getMuseum(id).orElseThrow(() -> new MuseumNotFoundException());
  }
}
