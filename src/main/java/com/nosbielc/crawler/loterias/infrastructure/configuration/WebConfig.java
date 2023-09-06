package com.nosbielc.crawler.loterias.infrastructure.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.mediaType("v1", MediaType.valueOf("application/vnd.company.app-v1+json"));
        configurer.mediaType("v2", MediaType.valueOf("application/vnd.company.app-v2+json"));
    }

}
