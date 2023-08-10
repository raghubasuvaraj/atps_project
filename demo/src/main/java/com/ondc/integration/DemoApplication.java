package com.ondc.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;



@EnableAsync
@SpringBootApplication(exclude = {
		SecurityAutoConfiguration.class})
@ComponentScan(basePackages= {"com.ondc", "com.ondc.integration"})
public class DemoApplication extends SpringBootServletInitializer{

	
	@Bean
	public ThreadPoolTaskExecutor asyncExecutor(@Value("${ondcIntegration.asyncThreads}") int threads) {
		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(threads);
		executor.setMaxPoolSize(threads);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("async-thread");
		executor.initialize();
		return executor;
	}
	/**
	 * Must override this method to deploy the project as an external WAR file.
	 * This is the main class that runs the application
	 *
	 * @param application
	 * @return	
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
