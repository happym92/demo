package com.hm.mydata.common.config;

import java.util.List;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Configuration
public class WebClientConfig {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Value("${spring.gateway-url}")
	public String baseUrl;
	
	@Bean
	public WebClient stockApiClient(WebClient.Builder webClientBuilder) {
	   return webClientBuilder.baseUrl(baseUrl).build();
	}
	
	
	// 게이트웨이로 호출하는 기본 설정
	@Bean
	public WebClient apiClient(WebClient.Builder webClientBuilder) {
		MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<>();
		Consumer<HttpHeaders> headers = v -> v.addAll(headerMap);
		
		return webClientBuilder.baseUrl(baseUrl)
			                   .defaultHeaders(headers)
			                   .filter(logRequest())
			                   .filter(logResponse())
			  				   .build();
	}
	// commit
//	// 게이트웨이로 호출하는 기본 설정
//	@Bean
//	public WebClient apiClient(WebClient.Builder webClientBuilder, boolean isTestBedCall) {
//		return webClientBuilder.baseUrl(baseUrl)
//				.build();
//	}
	
	private ExchangeFilterFunction logRequest() {
	    return (clientRequest, next) -> {
	      log.info("Request: {} {}", clientRequest.method(), clientRequest.url());
	      log.info("--- Http Headers: ---");
	      clientRequest.headers().forEach(this::logHeader);
	      log.info("--- Http Cookies: ---");
	      clientRequest.cookies().forEach(this::logHeader);
	      return next.exchange(clientRequest);
	    };
	  }

	  private ExchangeFilterFunction logResponse() {
	    return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
	      log.info("Response: {}", clientResponse.statusCode());
	      clientResponse.headers().asHttpHeaders()
	        .forEach((name, values) -> values.forEach(value -> log.info("{}={}", name, value)));
	      return Mono.just(clientResponse);
	    });
	  }

	  private void logHeader(String name, List<String> values) {
	    values.forEach(value -> log.info("{}={}", name, value));
	  }
	
}
