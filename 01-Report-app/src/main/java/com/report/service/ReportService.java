package com.report.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.report.entity.CitizenPlan;
import com.report.request.SearchRequest;
@Service("ReportService")
public interface ReportService {

	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean exportExcel();
	
	public boolean exportPdf();
}
