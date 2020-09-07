package com.clientbase.controller;

import java.util.List;
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
		@RequestParam(name="isEditMode", required=false, defaultValue="false") String isEditModeString,
		@RequestParam(name="edit", required=false, defaultValue="false") String editString,
		@RequestParam(name="firstName", required=false, defaultValue="") String firstName,
		Model model
	) 
	{
		if (empoleeIDString.isBlank() || empoleeIDString.isEmpty()) {
			return "redurect:staffSearch";	
		}
		
		Integer employeeID = Integer.decode(empoleeIDString);
		
		System.out.println("Employee id:");
		System.out.println(employeeID);
		
		// case NO SUCH ID in DB
		Optional<Employee> possibleEmployee = empRep.findById(employeeID);
		if (possibleEmployee.isEmpty()) {
			model.addAttribute("isEmpty", true);
			return "employee";
		}
		
		// case - just give me information
		Boolean isEditMode = Boolean.parseBoolean(isEditModeString);
		Boolean edit = Boolean.parseBoolean(editString);
		if (!isEditMode || !edit) {
			model.addAttribute("isEmpty", false);
			model.addAttribute("isEditMode", false);
			model.addAttribute("employee", possibleEmployee.get());
			return "employee";
		}
		
		// last case - update information and get OR new version of employee OR fail flag and fail reason
		
		Employee empl = possibleEmployee.get();
		if (firstName.length() == 0) {
			firstName = empl.getFirstName();
		}
		
		Pair<Optional<Employee>, String> updateResult = empRep.addOrUpdateEmployee(
			empl.getEmployeeId(), 
			empl.getEmployeeStatus(), 
			Map.of("first_name", firstName)
		);
		if (updateResult.getFirst().isEmpty()) {
			model.addAttribute("isEmpty", false);
			model.addAttribute("isEditMode", true);
			model.addAttribute("isUpdateFailed", true);
			model.addAttribute("updateFailReason", updateResult.getSecond());
			model.addAttribute("employee", possibleEmployee.get());
		
			return "employee";
		}
		
		model.addAttribute("isEmpty", false);
		model.addAttribute("isEditMode", false);
		model.addAttribute("isUpdateFailed", false);
		model.addAttribute("employee", updateResult.getFirst().get());
	
		return "employee";
	}
}
