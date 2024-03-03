package com.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.report.service.ReportService;

@RestController
@RequestMapping(path = "/home")

public class ReportController {

	private  ReportService reportService;
	@Qualifier("ReportService")
	@Autowired(required=true)

	public void setReportService(ReportService reportService){
	    this.reportService=reportService;
	}
    @RequestMapping(value="/index",method=RequestMethod.GET)
    @ResponseBody
	public String indexPage()
	{
		
		return "index";
	}
	
}
