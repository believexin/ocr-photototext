package com.believexin.baiduapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BaiduApiApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(BaiduApiApplication.class, args);
	}
/*	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(BaiduApiApplication.class);
    }*/
}
