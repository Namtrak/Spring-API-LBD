package com.example.SpringRESTAPILBD;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringRestApiLbdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApiLbdApplication.class, args);
	}

	/*
	* UI localhost:8080/swagger-ui
	* Docks localhost:8080/v3/api-docs
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

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
