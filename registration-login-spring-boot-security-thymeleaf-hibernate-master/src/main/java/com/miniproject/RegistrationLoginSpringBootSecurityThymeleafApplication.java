package com.miniproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@SpringBootApplication
public class RegistrationLoginSpringBootSecurityThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationLoginSpringBootSecurityThymeleafApplication.class, args);
	}

}
*/

@SpringBootApplication(scanBasePackages = {"com.miniproject", "com.miniproject.web"})
public class RegistrationLoginSpringBootSecurityThymeleafApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegistrationLoginSpringBootSecurityThymeleafApplication.class, args);
    }
}
