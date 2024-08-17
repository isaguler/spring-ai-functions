package com.isaguler.spring_ai_functions.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "weather")
public record WeatherConfigProps(String apiKey, String baseUrl) {
}
