package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.service.CollectionTypeService;
import com.betrybe.museumfinder.dto.CollectionTypeCount;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;

class CollectionTypeServiceTest {
  
  MuseumFakeDatabase database;
  CollectionTypeService service;
  
  @BeforeEach
  public void setUp() {
    database = mock(MuseumFakeDatabase.class);
    service = new CollectionTypeService(database);
  }

  @Test
  void testService() throws Exception {
    String typeList = "ruan";
    when(database.countByCollectionType("ruan")).thenReturn(19L);
    CollectionTypeCount collectionTypeCount = service.countByCollectionTypes(typeList);

    assertEquals(collectionTypeCount.count(), service.
        countByCollectionTypes(typeList).count());
    assertEquals(collectionTypeCount.collectionTypes()[0], service
        .countByCollectionTypes(typeList).collectionTypes()[0]);
  }
}