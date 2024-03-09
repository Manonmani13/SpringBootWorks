package com.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.entity.CitizenPlan;
import com.report.repository.CitizenPlanRepository;
import com.report.request.SearchRequest;
@Service

public class CitizenPlanServiceImpl implements CitizenPlanService {
	@Autowired
	 CitizenPlanRepository citizenPlanRepo;

	@Override
	public List<String> getPlanNames() {
		return citizenPlanRepo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		return citizenPlanRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		return citizenPlanRepo.findAll();
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
