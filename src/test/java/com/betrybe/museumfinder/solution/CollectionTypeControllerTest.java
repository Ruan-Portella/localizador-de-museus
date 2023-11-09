package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.service.CollectionTypeService;
import com.betrybe.museumfinder.controller.CollectionTypeController;
import org.springframework.test.web.servlet.MockMvc;
import com.betrybe.museumfinder.dto.CollectionTypeCount;
//import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CollectionTypeController.class)
class CollectionTypeControllerTest {
  
  @Autowired
  MockMvc mock;
  
  @MockBean
  private CollectionTypeService service;
  
  @BeforeEach
  public void setUp() {
    when(service.countByCollectionTypes("ruan"))
      .thenReturn(new CollectionTypeCount(new String[]{"ruan"}, 10));
    when(service.countByCollectionTypes("teste_ruan,ruan_test"))
      .thenReturn(new CollectionTypeCount(new String[]{"teste_ruan", "ruan_test"}, 4));
    when(service.countByCollectionTypes("unknown"))
      .thenReturn(new CollectionTypeCount(new String[]{"unknown"}, 0));
  }

  @Test
  void testCollectionsOne() throws Exception {
    mock.perform(get("/collections/count/{typesList}", "ruan")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }
  
  @Test
  void testCollectionDouble() throws Exception {
    mock.perform(get("/collections/count/{typesList}", "teste_ruan,ruan_test")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }
  
  @Test
  void testCollectionNoResult() throws Exception {
    mock.perform(get("/collections/count/{typesList}", "unknown")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }
}