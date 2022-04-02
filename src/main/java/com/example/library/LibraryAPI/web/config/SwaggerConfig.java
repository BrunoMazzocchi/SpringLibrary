package com.example.library.LibraryAPI.web.config;

import org.springframework.context.annotation.*;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.*;
import springfox.documentation.spring.web.plugins.*;
import springfox.documentation.swagger2.annotations.*;

import java.util.*;

@Configuration //Para habilitar swagger
@EnableSwagger2
public class SwaggerConfig {
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "My REST API for a library",
                "Rest API for a library using Spring Boot",
                "API 1",
                "Terms of service",
                new Contact("BrunoMazzocchi", "www.github.com/BrunoMazzocchi", "none"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }

    @Bean //
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.library.LibraryAPI.web.config.controller"))
                .build();
    }


}