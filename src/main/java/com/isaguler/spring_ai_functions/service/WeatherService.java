package com.isaguler.spring_ai_functions.service;

import com.isaguler.spring_ai_functions.configuration.WeatherConfigProps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClient;

import java.util.function.Function;

/*
   Weather API
   https://weatherstack.com/
*/
public class WeatherService implements Function<WeatherService.WeatherRequest, WeatherService.Response> {

    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);

    private final RestClient restClient;
    private final WeatherConfigProps weatherConfigProps;

    public WeatherService(WeatherConfigProps weatherConfigProps) {
        this.restClient = RestClient.create(weatherConfigProps.baseUrl());
        this.weatherConfigProps = weatherConfigProps;
    }

    @Override
    public Response apply(WeatherService.WeatherRequest weatherRequest) {
        log.info("Weather Request: {}", weatherRequest);
        Response response = restClient.get()
                .uri("/current?access_key={key}&query={query}", weatherConfigProps.apiKey(), weatherRequest.city())
                .retrieve()
                .body(Response.class);
        log.info("Weather API Response: {}", response);
        return response;
    }

    public record WeatherRequest(String city) {}
    public record Response(Request request, Location location, Current current) {}
    public record Request(String lang, String unit) {}
    public record Location(String name, String region, String country, String lat, String lon){}
    public record Current(String temperature, String wind_speed, String humidity) {}

}
