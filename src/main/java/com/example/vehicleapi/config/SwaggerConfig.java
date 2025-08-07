package com.example.vehicleapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
//import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Vehicle API")
                        .version("1.0.0")
                        .description("API for Vehicle Management System")
                        .contact(new Contact()
                                .name("Brad Harper")
                                .email("bradharperphotography@gmail.com")
                                .url("https://www.bradharperphotography.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

   /* @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("User APIs")
                .pathsToMatch("/api/users/**")
                .build();
    }

    @Bean
    public GroupedOpenApi vehicleApi() {
        return GroupedOpenApi.builder()
                .group("Vehicle APIs")
                .pathsToMatch("/api/vehicles/**")
                .build();
    }*/

    // Add more groups as needed, or a wildcard group for all APIs
}