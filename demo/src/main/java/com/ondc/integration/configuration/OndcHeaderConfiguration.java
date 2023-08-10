package com.ondc.integration.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Configuration

public class OndcHeaderConfiguration {

	@Value("${ondcIntegration.ondc.apiKey}")
	private String apiKey;

	public MultiValueMap<String, String> getHeaders() {
		final MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		System.out.printf("apiKey", apiKey);
		headers.add("apikey",apiKey);
		return headers;
	}

}
