package com.trade.shipping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()    
          .paths(PathSelectors.any())                               
          .apis(RequestHandlerSelectors.any())   
          .paths(Predicates.not(PathSelectors.regex("/error.*")))
          .build().apiInfo(apiEndPointsInfo());                                           
    }
    
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Shipping Status Microservice")
            .description("Dockerize Shipping Status Microservice with Spring Boot")
            .contact(new Contact("Yalçın Kazan", "http://www.javasoftdev.com/", "yalcin@javasoftdev.com"))
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .version("1.0.0")
            .build();
    }
    
}