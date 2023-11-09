package com.betrybe.museumfinder.model;

import com.betrybe.museumfinder.model.Coordinate;

/**
 * Museum.
 */

public class Museum {
  Long id;
  String name;
  String description;
  String address;
  String collectionType;
  String subject;
  String url;
  Coordinate coordinate;
  Long legacyId;

  /**
   * Getters and Setters.
   */

  public Long getId() {
    return id;
  }

  public Museum setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Museum setName(String name) {
    this.name = name;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Museum setDescription(String description) {
    this.description = description;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public Museum setAddress(String address) {
    this.address = address;
    return this;
  }

  public String getCollectionType() {
    return collectionType;
  }

  public Museum setCollectionType(String collectionType) {
    this.collectionType = collectionType;
    return this;
  }

  public String getSubject() {
    return subject;
  }

  public Museum setSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public String getUrl() {
    return url;
  }

  public Museum setUrl(String url) {
    this.url = url;
    return this;
  }

  public Coordinate getCoordinate() {
    return coordinate;
  }

  public Museum setCoordinate(Coordinate coordinate) {
    this.coordinate = coordinate;
    return this;
  }

  public Long getLegacyId() {
    return legacyId;
  }

  public Museum setLegacyId(Long legacyId) {
    this.legacyId = legacyId;
    return this;
  }
}
