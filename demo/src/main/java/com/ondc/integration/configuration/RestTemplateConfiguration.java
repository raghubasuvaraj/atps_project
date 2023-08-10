package com.ondc.integration.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.web.client.AsyncRestTemplate;


@SuppressWarnings("deprecation")
@Configuration
public class RestTemplateConfiguration {
    
    @Bean
    public AsyncRestTemplate asyncRestTemplate() {
        return new AsyncRestTemplate(new HttpComponentsAsyncClientHttpRequestFactory());
    }
}
