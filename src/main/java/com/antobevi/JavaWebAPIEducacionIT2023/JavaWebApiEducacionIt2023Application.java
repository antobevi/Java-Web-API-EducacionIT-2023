package com.antobevi.JavaWebAPIEducacionIT2023;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class JavaWebApiEducacionIt2023Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JavaWebApiEducacionIt2023Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(JavaWebApiEducacionIt2023Application.class, args);
	}

}
