package com.learning;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.learning.entity.OrderDetailsEntity;
import com.learning.repository.OrderDetailsRepo;
@ComponentScan("com.learning")
//custom
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ct=SpringApplication.run(Application.class, args);
		OrderDetailsRepo bean=ct.getBean(OrderDetailsRepo.class);
		OrderDetailsEntity entity=new OrderDetailsEntity();
		entity.setOrderPlacedDate(new Date());
		entity.setOrderBy("Miller");
		OrderDetailsEntity save=bean.save(entity);
		System.out.println(save);

//		entit
		ct.close();
		
	}

}
