package com.example.naverai;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/upload/**").addResourceLocations("file:///c:/upload/");
	registry.addResourceHandler("/naverai/**").addResourceLocations("file:///"+ Ninf.path);
	}
// Handler 로 URL 맵핑 잡고,location 으로 local 에서 위치 잡고  
	
	
	
}
