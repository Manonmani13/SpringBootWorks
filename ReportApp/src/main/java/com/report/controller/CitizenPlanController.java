package com.report.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.report.entity.CitizenPlan;
import com.report.request.SearchRequest;
import com.report.service.CitizenPlanServiceImpl;

import jakarta.servlet.http.HttpServletResponse;



@Controller

public class CitizenPlanController {
	@Autowired
	private  CitizenPlanServiceImpl citizenPlanService;
//	@GetMapping
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexPage(Model model)
	{
		init(model);

		return "index";
	}
	private void init(Model model) {
		model.addAttribute("searchObj",new SearchRequest());

		model.addAttribute("names",citizenPlanService.getPlanNames());
		model.addAttribute("status",citizenPlanService.getPlanStatus());
	}
	@PostMapping("search")
	public String handleSearch(@ModelAttribute("search") SearchRequest request,Model model)
	{
		System.out.println(request);
		List<CitizenPlan> plans=citizenPlanService.search(request);
		model.addAttribute("plans", plans);
		
		init(model);
		return "index";
	}
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response,Model model) throws Exception
	{
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename=plans.xlsx");
		citizenPlanService.exportExcel(response);
	
	}
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response,Model model) throws Exception
	{
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment;filename=plans.pdf");
		 citizenPlanService.exportPdf(response);
		
	}
}
