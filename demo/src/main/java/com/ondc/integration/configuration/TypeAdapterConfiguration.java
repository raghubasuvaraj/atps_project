package com.ondc.integration.configuration;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class TypeAdapterConfiguration {
    @Bean
    public CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer configurer = new CustomEditorConfigurer();
        configurer.setCustomEditors(ImmutableMap.of(
                Duration.class, DurationEditorSupport.class));
        return configurer;
    }
}
