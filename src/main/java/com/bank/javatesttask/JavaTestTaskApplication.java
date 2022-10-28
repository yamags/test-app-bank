package com.bank.javatesttask;

import io.swagger.v3.oas.models.OpenAPI;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@SpringBootApplication
public class JavaTestTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaTestTaskApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.base-url}") String baseUrl) {
        return new OpenAPI().addServersItem(new Server().url(baseUrl))
                .info(new Info().title("Bank Test API").version("V0"));
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
