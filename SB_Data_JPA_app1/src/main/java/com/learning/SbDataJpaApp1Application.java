package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.learning.entity.Employee;
import com.learning.repository.EmpRepository;

@SpringBootApplication
public class SbDataJpaApp1Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context=SpringApplication.run(SbDataJpaApp1Application.class, args);
		EmpRepository repo=context.getBean(EmpRepository.class);
		System.out.println(repo.getClass().getName());
		Employee emp=new Employee();
		emp.setEmpId(10);
		emp.setEmpName("Mano");
		emp.setEmpSal(140000.00);
		repo.save(emp);
		
	}

}
