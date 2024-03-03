package com.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@SpringBootApplication(scanBasePackages = {"com.report", "com.report.controller"})
//@SpringBootApplication(scanBasePackages = {"controller","service","entity", "repo"})
@EnableJpaRepositories("com.report.repo")
//@ComponentScan(basePackages = { "com.report.entity" })
@EntityScan("com.report.entity") 
//@SpringBootApplication
//@EntityScan("com.report.entity")
//@ComponentScan(basePackages = {"com.report"})
//@Configuration
//@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.report.controller" })
//@ComponentScan(basePackages = { "com.report.service" })
//
//@ComponentScan(basePackages = { "com.report.repo" })

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
