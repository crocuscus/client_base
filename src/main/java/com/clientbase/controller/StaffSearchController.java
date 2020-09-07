package com.clientbase.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clientbase.dao.EmployeeRepository;
import com.clientbase.model.Employee;

@Controller
public class StaffSearchController {

	@Autowired EmployeeRepository empRep;
	
	@GetMapping("/staff")
	public String serviceList(
		@RequestParam(name="searchString", required=false, defaultValue="") Optional<String> searchString,
		Model model
	) {
		if (searchString.isEmpty()) {
			return "staffSearch";
		}
		if (!searchString.get().isBlank()) {
			model.addAttribute("empList", List.of());
			model.addAttribute("isSearchEmpty", true);
		}
		
		List<Employee> empList = empRep.findByFullname(searchString.get());
		model.addAttribute("empList", empList);
		model.addAttribute("isSearchEmpty", false);
	
		return "staffSearch";
	}
}
