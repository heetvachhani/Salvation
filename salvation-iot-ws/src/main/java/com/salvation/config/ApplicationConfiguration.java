package com.salvation.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.salvation.interceptor.LoggingRequestInterceptor;

@Configuration
public class ApplicationConfiguration {

	// Default Read Timeout
	private Integer readTimeout = 60000;

	// Default Connection Timeout
	private Integer connectionTimeout = 30000;

	@Bean
	@Primary
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(getClientHttpRequestFactory());
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		// Add Request Response Logging Interceptor
		interceptors.add(new LoggingRequestInterceptor());
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	/**
	 * Get ClientHttpRequestFactory object with the configured readTimeout and
	 * connectionTimeout values.
	 * <p>
	 * 
	 * @return an instance of {@link ClientHttpRequestFactory}
	 */
	private ClientHttpRequestFactory getClientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setReadTimeout(readTimeout);
		factory.setConnectTimeout(connectionTimeout);
		return factory;
	}

}
