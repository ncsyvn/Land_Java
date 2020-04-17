//package com.nguyencongsy.utils;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//@EnableWebMvc
//public class CorsFilterConfig extends WebMvcConfigurerAdapter {
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//						.allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
//						.maxAge(3600L);
//	}
//
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
//		registry.addResourceHandler("/uploads/**").addResourceLocations("/uploads/");
//	}
//}
