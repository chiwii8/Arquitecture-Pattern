package com.example.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplateConfig.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 11/02/2026
 */

@Configuration
public class RestTemplateConfig {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
