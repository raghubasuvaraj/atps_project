package com.ondc.integration.configuration;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@SuppressWarnings("deprecation")
@Configuration
@EnableAsync
public class AsyncConfiguration extends WebMvcConfigurerAdapter {
    @Value("${ondcIntegration.asyncTimeout}")
    private Duration timeout;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        System.out.printf("Set async request timeout {}", timeout);
        configurer.setDefaultTimeout(timeout.toMillis());
        configurer.setTaskExecutor(taskExecutor);
    }
}
