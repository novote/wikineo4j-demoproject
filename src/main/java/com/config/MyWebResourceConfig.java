package com.config;


/*
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.GzipResourceResolver;

@Configuration
@EnableWebMvc
public class MyWebResourceConfig implements WebMvcConfigurer{
	
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        System.out.println("WebMvcConfigurer - addResourceHandlers() function get loaded...");
	        registry.addResourceHandler("/resources/static/**")
	                .addResourceLocations("/resources/");

	        registry
	            .addResourceHandler("/js/**")
	            .addResourceLocations("/js/")
	            .setCachePeriod(3600)
	            .resourceChain(true)
	            .addResolver(new GzipResourceResolver())
	            .addResolver(new PathResourceResolver());
	    }



}
*/