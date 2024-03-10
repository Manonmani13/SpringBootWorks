package com.report.service;

import java.util.List;

import jakarta.servlet.http.HttpServletResponse;

import com.report.entity.CitizenPlan;
import com.report.request.SearchRequest;

public interface CitizenPlanService {

	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean exportExcel(HttpServletResponse response) throws Exception;
	
	public boolean exportPdf(HttpServletResponse response) throws Exception;

}
