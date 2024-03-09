package com.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.report.service.CitizenPlanServiceImpl;

@Controller

public class CitizenPlanController {
	@Autowired
	private  CitizenPlanServiceImpl citizenPlanService;
//	@GetMapping
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexPage()
	{
		
		
		return "index";
	}
}
