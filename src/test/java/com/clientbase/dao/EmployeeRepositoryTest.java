package com.clientbase.dao;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.clientbase.model.Employee;

@SpringBootTest
public class EmployeeRepositoryTest extends AbstractTestNGSpringContextTests {
  @Autowired EmployeeRepository empRep;
  @Autowired EmployeeStatusRepository empStatRep;

  @Test
  public void findByFullnameTest() {
	  var new_emp = empRep.addOrUpdateEmployee(null, null, Map.of(
			  "first_name", "Intel",
			  "surname", "Миллер",
			  "passport", "2345",
			  "passport_date", "11.11.1981",
			  "passport_from_whom", "Ленинград, РСФСР, СССР"));
	 assertTrue(new_emp.getFirst().isPresent());
	 List<Employee> intel_search = empRep.findByFullname("Intel");
	 assertFalse(intel_search.isEmpty());
	 empRep.delete(new_emp.getFirst().get());
  }
  
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
	  // good new employee
	  Integer id = new_emp.getFirst().get().getEmployeeId();
	  
	  assertTrue(empRep.addOrUpdateEmployee(id, empStatRep.findById((short) 2).get(), Map.of(
			  "first_name", "Генри",
			  "surname", "Мюллер",
			  "passport", "5904523536",
			  "passport_date", "28.04.1914",
			  "passport_from_whom", "Мюнхен"
			)).getFirst().isPresent());
	  assertTrue(empRep.findById(id).get().getFirstName().equals("Генри"));
	  // update old employee
	  
	  empRep.delete(new_emp.getFirst().get());

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
	  assertTrue(name.equals("Сотрудник"));
	  empRep.deleteById(id);
  }
  
}
