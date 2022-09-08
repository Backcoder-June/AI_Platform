package com.example.naverai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan(basePackages = "chatbot")
@ComponentScan(basePackages = "chatbot")
@ComponentScan(basePackages = "mapchat")
@ComponentScan(basePackages = "ocr")
@ComponentScan(basePackages = "tts")
@ComponentScan(basePackages = "stt")
@ComponentScan(basePackages = "object")
@ComponentScan(basePackages = "pose")
@ComponentScan(basePackages = "cfr")
@ComponentScan
@SpringBootApplication
public class NaveraiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaveraiApplication.class, args);
	}

}
