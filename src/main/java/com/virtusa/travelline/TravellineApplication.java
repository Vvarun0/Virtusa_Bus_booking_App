package com.virtusa.travelline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages= {"com.virtusa.travelline.*"})
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages= {"com.virtusa.travelline.*"})
@EntityScan(basePackages= {"com.virtusa.travelline.*"})
public class TravellineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravellineApplication.class, args);
	}
/*
	public static void main(String[] args) {
		source
	}*/

}
