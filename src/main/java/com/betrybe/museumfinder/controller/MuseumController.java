package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumService;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * MuseumController.
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {
  MuseumServiceInterface museumService;

  @Autowired
  public MuseumController(MuseumServiceInterface museumService) {
    this.museumService = museumService;
  }

  /**
   * MuseumController Methods.
   */

  @PostMapping
  public ResponseEntity<MuseumDto> createMuseum(@RequestBody MuseumCreationDto museum) {
    Museum museumDto = ModelDtoConverter.dtoToModel(museum);
    Museum create = this.museumService.createMuseum(museumDto);
    MuseumDto convertedMuseum = ModelDtoConverter.modelToDto(create);
    return ResponseEntity.status(HttpStatus.CREATED).body(convertedMuseum);
  }

  /**
   * MuseumController Methods.
   */

  @GetMapping("/closest")
  public ResponseEntity<MuseumDto> getClosestMuseum(
      @RequestParam(name = "lat") double lat,
      @RequestParam(name = "lng") double lng,
      @RequestParam(name = "max_dist_km") double distance
  ) {
    Coordinate coordinate = new Coordinate(lat, lng);
    Museum getMuseum = this.museumService.getClosestMuseum(coordinate, distance);
    MuseumDto convertedMuseum = ModelDtoConverter.modelToDto(getMuseum);
    return ResponseEntity.status(HttpStatus.OK).body(convertedMuseum);
  }
}
