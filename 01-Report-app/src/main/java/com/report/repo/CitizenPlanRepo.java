package com.report.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.report.entity.CitizenPlan;
@Repository
//@Component("CitizenPlanRepo")
public interface CitizenPlanRepo extends JpaRepository<CitizenPlan, Long> {

	@Query("select distinct(planName) from CitizenPlan")
	public List <String> getPlanNames();
	
	@Query("select distinct(planStatus) from CitizenPlan")
	public List<String> getPlanStatus();
	
}
