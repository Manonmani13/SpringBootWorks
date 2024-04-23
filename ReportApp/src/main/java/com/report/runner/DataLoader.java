package com.report.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.report.entity.CitizenPlan;
import com.report.repository.CitizenPlanRepository;

@Component
public class DataLoader  implements ApplicationRunner{
	@Autowired(required=true)
	private CitizenPlanRepository citiRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		CitizenPlan cl=new CitizenPlan();
		cl.setCitizenName("mano");
		cl.setGender("Female");
		cl.setPlanName("cash");
		cl.setPlanStatus("Approved");
		cl.setPlanStartDate(LocalDate.now());
		cl.setPlanEndDate(LocalDate.now().plusMonths(6));
		cl.setBenefitAmt(5000.00);
		CitizenPlan c2=new CitizenPlan();
		c2.setCitizenName("pandu");
		c2.setGender("Male");
		c2.setPlanName("cash");
		c2.setPlanStatus("Denied");
		c2.setPlanStartDate(LocalDate.now());
		c2.setPlanEndDate(LocalDate.now().plusMonths(6));
		c2.setDenialReason("Rental income");
		CitizenPlan c3=new CitizenPlan();
		c3.setCitizenName("Simth");
		c3.setGender("Male");
		c3.setPlanName("cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now());
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenefitAmt(5000.00);
		c3.setTerminateDate(LocalDate.now());
		c3.setTerminationRsn("Employeed");
		CitizenPlan c4=new CitizenPlan();
		c4.setCitizenName("DAvid");
		c4.setGender("Male");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenefitAmt(4000.00);
		CitizenPlan c5=new CitizenPlan();
		c5.setCitizenName("Robert");
		c5.setGender("Male");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denied");
		c5.setPlanStartDate(LocalDate.now());
		c5.setPlanEndDate(LocalDate.now().plusMonths(6));
		c5.setDenialReason("Property Income");
		CitizenPlan c6=new CitizenPlan();
		c6.setCitizenName("Orlen");
		c6.setGender("Male");
		c6.setPlanName("Food");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(4));
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBenefitAmt(4000.00);
		c6.setTerminateDate(LocalDate.now());
		c6.setTerminationRsn("Employeed");

		CitizenPlan c7=new CitizenPlan();
		c7.setCitizenName("Roslin");
		c7.setGender("Female");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenefitAmt(4000.00);
		CitizenPlan c8=new CitizenPlan();
		c8.setCitizenName("Ravi");
		c8.setGender("Male");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Denied");
		c8.setPlanStartDate(LocalDate.now());
		c8.setPlanEndDate(LocalDate.now().plusMonths(6));
		c8.setDenialReason("Property Income");
		CitizenPlan c9=new CitizenPlan();
		c9.setCitizenName("vikram");
		c9.setGender("Male");
		c9.setPlanName("Medical");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.now().minusMonths(4));
		c9.setPlanEndDate(LocalDate.now().plusMonths(6));
		c9.setBenefitAmt(4000.00);
		c9.setTerminateDate(LocalDate.now());
		c9.setTerminationRsn("Employeed");
		CitizenPlan c12=new CitizenPlan();
		c12.setCitizenName("Kamachi");
		c12.setGender("Female");
		c12.setPlanName("Employment ");
		c12.setPlanStatus("Approved");
		c12.setPlanStartDate(LocalDate.now());
		c12.setPlanEndDate(LocalDate.now().plusMonths(6));
		c12.setBenefitAmt(4000.00);
		CitizenPlan c10=new CitizenPlan();
		c10.setCitizenName("Sakthi");
		c10.setGender("Male");
		c10.setPlanName("Employment");
		c10.setPlanStatus("Denied");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c10.setDenialReason("Property Income");
		CitizenPlan c11=new CitizenPlan();
		c11.setCitizenName("vikram");
		c11.setGender("Male");
		c11.setPlanName("Employement");
		c11.setPlanStatus("Terminated");
		c11.setPlanStartDate(LocalDate.now().minusMonths(4));
		c11.setPlanEndDate(LocalDate.now().plusMonths(6));
		c11.setBenefitAmt(4000.00);
		c11.setTerminateDate(LocalDate.now());
		c11.setTerminationRsn("Employeed");	
//		List<CitizenPlan> list= Arrays.asList(cl,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
//		citiRepo.saveAll(list);
	}
	
}
