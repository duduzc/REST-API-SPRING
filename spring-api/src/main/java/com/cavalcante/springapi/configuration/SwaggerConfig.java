package com.cavalcante.springapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Paulo Eduardo
 * @date 16/04/20
 * @version 0.0.1
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	 @Bean
	 public Docket api() {
		 return new Docket(DocumentationType.SWAGGER_2)  
	        .select()                             
	        .apis(RequestHandlerSelectors.any())              
	        .paths(PathSelectors.any())                          
	        .build()
	        .apiInfo(apiInfo())
	        .useDefaultResponseMessages(false);
	 }
	 
	 private ApiInfo apiInfo() {
		 ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		 apiInfoBuilder.title("Generic REST API");
		 apiInfoBuilder.description("Simple REST API Generation");
		 apiInfoBuilder.version("0.0.1-SNAPSHOT");
		 apiInfoBuilder.contact(new Contact("Paulo Eduardo", null, "educavalcantedev@gmail.com"));
		 apiInfoBuilder.license("GNU GENERAL PUBLIC LICENSE, Version 1.0.0");
		 
		 return apiInfoBuilder.build();
	 }
}