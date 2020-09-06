package com.clientbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.clientbase.dao.ServiceRepository;

@Controller
public class ServiceController {
	
	@Autowired ServiceRepository serRepo;
	
	@GetMapping("/service")
	public String serviceList(Model model) {
		var serviceList = serRepo.getAllPrescence();
		
		System.out.print("serviceList -> serviceList.size()");
		System.out.println(serviceList.size());
		
		model.addAttribute("serviceList", serviceList);
		return "serviceList";
	}

}
