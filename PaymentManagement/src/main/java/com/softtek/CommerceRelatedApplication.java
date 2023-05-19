package com.softtek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories
@ComponentScan("com.softtek")
public class CommerceRelatedApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommerceRelatedApplication.class, args);
	}

}
