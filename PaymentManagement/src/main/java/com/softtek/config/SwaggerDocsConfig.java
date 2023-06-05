package com.softtek.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author shreelakshmi.ms
 *
 * @apiNote Swagger Configuration class for the swagger HTML page for the API
 *          Testing.
 */
@Configuration
@EnableSwagger2
public class SwaggerDocsConfig {
	
	@Bean
	Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.softtek.controller"))
				.build()
				.useDefaultResponseMessages(true).apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("Softtek", "https://www.softtek.com", "webmaster@softtek.com");
		return new ApiInfo("Payment API ", " Information About Online Shopping", "5.5.Release",
				"https://www.softtek.com", contact, "GNU Public", "http://apache.org/licence/gnu",
				Collections.emptyList());
	}

}
