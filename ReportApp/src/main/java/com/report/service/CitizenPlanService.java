package com.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.entity.CitizenPlan;
import com.report.repository.CitizenPlanRepository;
import com.report.request.SearchRequest;
public interface CitizenPlanService {

	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean exportExcel();
	
	public boolean exportPdf();

}
