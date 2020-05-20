package com.jrd;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport  {	
	@Override
      public void addResourceHandlers(ResourceHandlerRegistry registry) {
		    registry.addResourceHandler("swagger-ui.html")
		            .addResourceLocations("classpath:/META-INF/resources/");
		    registry.addResourceHandler("/webjars/**")
		            .addResourceLocations("classpath:/META-INF/resources/webjars/");
	
		}	
	   

	
	@Bean
	public Docket apiConfigDocs() {
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.jrd.controllers"))
					.paths(PathSelectors.any())
					.build()
					.apiInfo(infoDocs());
	}
	
	private ApiInfo infoDocs() {
		return new ApiInfo(
				"Rest API", 
				"API REST de cadastro de produtos",
				"1.0", "Terms of service",
				new Contact("Junior Domingos", "https://www.linkedin.com/in/jr-domingos/" , "domingoshot@hotmail.com"),
		 		 "Apache License", "Url", new ArrayList<VendorExtension>());
	}


}
