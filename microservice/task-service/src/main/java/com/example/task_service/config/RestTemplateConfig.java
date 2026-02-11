package com.example.task_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplateConfig.java
 * <p>
 * Description: Configuration of the RestTemplates, RestTemplate perform HTTP request, exposing a simple, template method API over http clients
 *
 * @author aleja
 * @since 11/02/2026
 */

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(){

        ///Stablished a default timeout to the templates
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

        factory.setConnectTimeout(3000);
        factory.setReadTimeout(3000);

        return new RestTemplate(factory);
    }
}
