package com.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.report.entity.CitizenPlan;
import com.report.repo.CitizenPlanRepo;
import com.report.request.SearchRequest;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

//@Service("ReportService")
@Component
@RequiredArgsConstructor

public class ReportServiceImpl implements ReportService {
	@Autowired
	 CitizenPlanRepo citizenPlanRepo;
	 @Autowired
	@Qualifier("com.report.repo.CitizenPlanRepo")
	public void setCitizenPlanRepo(CitizenPlanRepo citizenPlanRepo){
	    this.citizenPlanRepo=citizenPlanRepo;
	}
	@Override
	public List<String> getPlanNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getPlanStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exportExcel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exportPdf() {
		// TODO Auto-generated method stub
		return false;
	}

}
