package com.clientbase.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;



@SpringBootTest
public class OrderHistoryRepositoryTest extends AbstractTestNGSpringContextTests  {
  @Autowired OrderHistoryRepository orderRep;
  @Autowired ClientRepository clientRep;
  @Autowired EmployeeRepository empRep;
  @Autowired ServiceRepository servRep;
	
//  @Test
//  public void registerOrderTest() {
////	  var service = servRep.findById(1);
////	  var emp = empRep.findById(1);
////	  var client = clientRep.findById(1);
////	  
//  }

  @Test
  public void smartFilterHistoryTest() {
	  var request = orderRep.smartFilterHistory(null, clientRep, null, empRep, null, null, null, servRep);
	  assertTrue(request.getFirst().isPresent());
	  assertFalse(request.getFirst().get().isEmpty());
  }
}
