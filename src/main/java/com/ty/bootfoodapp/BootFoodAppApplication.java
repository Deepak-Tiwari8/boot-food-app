package com.ty.bootfoodapp;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BootFoodAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootFoodAppApplication.class, args);
	}

	List<VendorExtension> vendorExtensions = new ArrayList<VendorExtension>();
	Contact contact = new Contact("deepak","https://testYantra.com","deepaktiwari9226@gmail.com"); 
		
	
	
	ApiInfo apiInfo = new ApiInfo("TestYantra Food App.com", null, null, null, contact, null, null, vendorExtensions);
	@Bean
	public Docket myDocket()
	{
		return new Docket(DocumentationType.SWAGGER_2).select().build().apiInfo(apiInfo);
	}
}
