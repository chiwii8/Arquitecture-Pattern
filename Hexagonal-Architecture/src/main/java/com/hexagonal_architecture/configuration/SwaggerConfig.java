package com.hexagonal_architecture.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SwaggerConfig.java
 * <p>
 * Description: Configuration of the Swagger to test the example
 *
 * @author aleja
 * @since 15/06/2026
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Test API")
                        .version("1.0")
                        .description("Documentation of the API for user or "))
                .components(new Components());


    }

}