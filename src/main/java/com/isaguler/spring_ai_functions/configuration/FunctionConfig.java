package com.isaguler.spring_ai_functions.configuration;

import com.isaguler.spring_ai_functions.service.WeatherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

@Configuration
public class FunctionConfig {

    private final WeatherConfigProps weatherConfigProps;

    public FunctionConfig(WeatherConfigProps weatherConfigProps) {
        this.weatherConfigProps = weatherConfigProps;
    }

    @Bean
    @Description("Get the weather in city")
    public Function<WeatherService.WeatherRequest, WeatherService.Response> currentWeatherFunction() {
        return new WeatherService(weatherConfigProps);
    }
}
