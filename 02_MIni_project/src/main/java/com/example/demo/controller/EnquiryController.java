package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class EnquiryController {

	@GetMapping("/dashboard")
	public String dashboardPage()		
	{

		return "dashboard";
	}
	
	@GetMapping("/enquiry")
	public String enquiryPage()		
	{

		return "add-enquiry";
	}
	@GetMapping("/enquiries")
	public String viewenquiryPage()		
	{

		return "view-enquiries";
	}
	
	
	

	
	
}
