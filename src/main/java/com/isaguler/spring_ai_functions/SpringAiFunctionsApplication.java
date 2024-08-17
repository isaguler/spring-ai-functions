package com.isaguler.spring_ai_functions;

import com.isaguler.spring_ai_functions.configuration.WeatherConfigProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(WeatherConfigProps.class)
@SpringBootApplication
public class SpringAiFunctionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAiFunctionsApplication.class, args);
	}

}
