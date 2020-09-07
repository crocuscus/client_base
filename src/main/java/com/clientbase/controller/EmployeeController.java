package com.clientbase.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clientbase.dao.EmployeeRepository;
import com.clientbase.model.Employee;

@Controller
public class EmployeeController {

	@Autowired EmployeeRepository empRep;
	
	@GetMapping("/employee")
	public String serviceList(
		@RequestParam(name="id", required=false, defaultValue="") String empoleeIDString,
		@RequestParam(name="edit", required=false, defaultValue="false") String editString,
		
		@RequestParam(name="first_name", required=false, defaultValue="") String first_name,
		@RequestParam(name="second_name", required=false, defaultValue="") String second_name,
		@RequestParam(name="surname", required=false, defaultValue="") String surname,
		@RequestParam(name="passport", required=false, defaultValue="") String passport,
		@RequestParam(name="passport_date", required=false, defaultValue="") String passport_date,
		@RequestParam(name="passport_from_whom", required=false, defaultValue="") String passport_from_whom,
		Model model
	) 
	{
		if (empoleeIDString.isBlank() || empoleeIDString.isEmpty()) {
			return "redurect:staffSearch";	
		}
		
		Integer employeeID = Integer.decode(empoleeIDString);
		Boolean edit = Boolean.parseBoolean(editString);
		
		System.out.println("Employee id:");
		System.out.println(employeeID);
		
		// case NO SUCH ID in DB
		Optional<Employee> possibleEmployee = empRep.findById(employeeID);
		if (possibleEmployee.isEmpty()) {
			model.addAttribute("isEmpty", true);
			return "employee";
		}
		model.addAttribute("isEmpty", false);
		
		if (!edit) {
			model.addAttribute("employee", possibleEmployee.get());
			model.addAttribute("wasEdit", false);
			return "employee";
		}
		model.addAttribute("wasEdit", true);
		
		// last case - update information and get OR new version of employee OR fail flag and fail reason
		
		Employee empl = possibleEmployee.get();
		
		Pair<Optional<Employee>, String> updateResult = empRep.addOrUpdateEmployee(
			empl.getEmployeeId(), 
			empl.getEmployeeStatus(), 
			Map.of(
				"first_name", first_name,
				"second_name", second_name,
				"surname", surname,
				"passport", passport, 
				"passport_date", passport_date, 
				"passport_from_whom", passport_from_whom
			)
		);
		
		if (updateResult.getFirst().isEmpty()) {
			model.addAttribute("isUpdateFailed", true);
			model.addAttribute("updateFailReason", updateResult.getSecond());
			model.addAttribute("employee", possibleEmployee.get());
		
			return "employee";
		}
		model.addAttribute("isUpdateFailed", false);
		model.addAttribute("employee", updateResult.getFirst().get());
	
		return "employee";
	}
}
