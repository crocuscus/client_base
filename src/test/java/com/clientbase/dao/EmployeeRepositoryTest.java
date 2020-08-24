package com.clientbase.dao;

import static org.testng.Assert.assertFalse;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class EmployeeRepositoryTest {
  @Autowired EmployeeRepository empRep;
  @Autowired EmployeeStatusRepository empStatRep;
	
  @Test
  public void addOrUpdateEmployeeTest() {
	  System.out.println("bye");
	  assertFalse(empRep.addOrUpdateEmployee(1, empStatRep.findById((short) 1), Map.of(
			    "a", "b",
			    "c", "d"
			)).getFirst().isPresent());
  }
}
