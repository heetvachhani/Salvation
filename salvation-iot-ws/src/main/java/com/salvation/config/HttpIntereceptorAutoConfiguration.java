package com.salvation.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.salvation.interceptor.RequestResponseLoggingFilter;

/**
 * 
 * This is an HTTP request Interceptor to log request and response.
 * <p>
 * 
 * @author Harsh Bhavsar
 */
@Configuration
public class HttpIntereceptorAutoConfiguration extends WebMvcConfigurerAdapter {

	/**
	 * Request Response Logging Filter bean class Declaration.
	 * <p>
	 * 
	 * @return
	 */
	@Bean
	public RequestResponseLoggingFilter requestResponseLoggingFilter() {
		return new RequestResponseLoggingFilter();
	}

	/**
	 * Filter Registration Bean class to filter URI's starts with <b>version</b>.
	 * <p>
	 * 
	 * @return {@link FilterRegistrationBean}
	 */
	@Bean
	public FilterRegistrationBean loggingFilter() {
		FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
		filterRegBean.setFilter(requestResponseLoggingFilter());
		List<String> patterns = Arrays.asList("/*");
		filterRegBean.setUrlPatterns(patterns);
		String ignoreResponseMethods = "GET";
		filterRegBean.addInitParameter("ignoreResponseMethods", ignoreResponseMethods);
		return filterRegBean;
	}

}