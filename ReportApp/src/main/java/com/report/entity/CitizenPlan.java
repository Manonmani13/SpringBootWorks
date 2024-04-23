package com.report.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="citizen_plans_info")
@NoArgsConstructor

public class CitizenPlan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long citizenId;
	
	private String citizenName;
	private String gender;
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private String denialReason;
	private LocalDate terminateDate;
	private String terminationRsn;
	private Double benefitAmt;
	
	
}
