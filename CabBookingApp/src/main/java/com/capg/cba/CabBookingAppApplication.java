package com.capg.cba;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableJpaAuditing
@SpringBootApplication
@EnableSwagger2
public class CabBookingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabBookingAppApplication.class, args);
	}
  
	
//	@Bean
//	public Docket swaggerConfiguration() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.paths(PathSelectors.ant("/api/*"))
//				.apis(RequestHandlerSelectors.basePackage("com.cg.cba"))
//				.build()
//				.apiInfo(myApiInfo());
//		
//	}
//	
//  private ApiInfo myApiInfo() {
//		// TODO Auto-generated method stub
//		ApiInfo apiInfo=new ApiInfo(
//				"SPRING WITH SWAGGER API", 
//			     "API CREATION", 
//			     "1.0", 
//			     "Free to Use", 
//			     new Contact("Ramesh ","/api" ,"aryanbampa1201@gmail.com"),
//			     "API licence",
//			     "/api",
//			     Collections.emptyList());
//		return apiInfo;
//	}
}
