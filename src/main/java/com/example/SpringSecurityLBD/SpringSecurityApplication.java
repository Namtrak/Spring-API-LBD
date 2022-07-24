package com.example.SpringSecurityLBD;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	/*
	 * UI localhost:8080/swagger-ui
	 * Docs localhost:8080/v3/api-docs
	 * */

	@Bean
	public OpenAPI openApiConfig() {
		return new OpenAPI().info(apiInfo());
	}

	public Info apiInfo() {
		Info info = new Info();
		info.title("Spring REST API LBD")
				.description("I am here all and fine")
				.version("v1.0.0");

		return info;
	}
}
