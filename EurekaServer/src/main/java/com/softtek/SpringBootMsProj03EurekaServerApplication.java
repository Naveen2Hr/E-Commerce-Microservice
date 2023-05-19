package com.softtek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringBootMsProj03EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMsProj03EurekaServerApplication.class, args);
	}

}
