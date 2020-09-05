package com.clientbase.dao;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest
public class EmployeeRepositoryTest extends AbstractTestNGSpringContextTests {
  @Autowired EmployeeRepository empRep;
  @Autowired EmployeeStatusRepository empStatRep;

  @Test
  public void addOrUpdateEmployeeTest() {
	  assertFalse(empRep.addOrUpdateEmployee(null, null, Map.of(
			    "a", "b",
			    "c", "d"	
			)).getFirst().isPresent());
	  // bad data
	  assertFalse(empRep.addOrUpdateEmployee(null, null, Map.of(
			  "surname", "Миллер",
			  "passport", "123456",
			  "passport_date", "11.11.1981",
			  "passport_from_whom", "Ленинград, РСФСР, СССР"	
			)).getFirst().isPresent());
	  // no required fields
	  assertFalse(empRep.addOrUpdateEmployee(null, null, Map.of(
			  "first_name", "Алексей",
			  "surname", "Миллер",
			  "passport", "123456",
			  "passport_date", "1981-11-11",
			  "passport_from_whom", "Ленинград, РСФСР, СССР"	
			)).getFirst().isPresent());
	  // bad date format
	  var new_emp = empRep.addOrUpdateEmployee(null, null, Map.of(
			  "first_name", "Алексей",
			  "surname", "Миллер",
			  "passport", "123456",
			  "passport_date", "11.11.1981",
			  "passport_from_whom", "Ленинград, РСФСР, СССР"));
	  assertTrue(new_emp.getFirst().isPresent());
	  empRep.delete(new_emp.getFirst().get());
	  // good new employee
	  
	  assertTrue(empRep.addOrUpdateEmployee(2, empStatRep.findById((short) 2).get(), Map.of(
			  "first_name", "Генри",
			  "surname", "Мюллер",
			  "passport", "5904523536",
			  "passport_date", "28.04.1914",
			  "passport_from_whom", "Мюнхен"
			)).getFirst().isPresent());
	  // update old employee
  }
  
  @Test
  public void removePersonalDataTest() {
	  var new_emp = empRep.addOrUpdateEmployee(null, null, Map.of(
			  "first_name", "Алексей",	
			  "surname", "Миллер",
			  "passport", "1234567",	
			  "passport_date", "11.11.1981",
			  "passport_from_whom", "Ленинград, РСФСР, СССР")).getFirst().get();
	  var id = new_emp.getEmployeeId();
	  empRep.removePersonalData(id);
	  var name = empRep.findById(id).get().getFirstName();
	  System.out.println(name);
	  assertTrue(name.equals("Сотрудник"));
	  empRep.deleteById(id);
  }
  
}
