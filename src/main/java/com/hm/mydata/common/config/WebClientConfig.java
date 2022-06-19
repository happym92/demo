package com.hm.mydata.common.config;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

	// Active Mode
//    @Value("${spring.profiles.active}")
//    public String serverMode;
	@Value("${spring.gateway-url}")
	public String baseUrl;
	
	@Bean
	public WebClient stockApiClient(WebClient.Builder webClientBuilder) {
	   return webClientBuilder.baseUrl(baseUrl).build();
	}
	
	
	// ����Ʈ���̷� ȣ���ϴ� �⺻ ����
	@Bean
	public WebClient apiClient(WebClient.Builder webClientBuilder) {
		MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<>();
		headerMap.add("x-api-tran-id", "�׽�Ʈ�ŷ�������ȣ");
		Consumer<HttpHeaders> headers = v -> v.addAll(headerMap);
		
		return webClientBuilder.baseUrl(baseUrl)
			                   .defaultHeaders(headers) 
			  				   .build();
	}
	
	// ����Ʈ���̷� ȣ���ϴ� �⺻ ����
	@Bean
	public WebClient apiClient(WebClient.Builder webClientBuilder, boolean isTestBedCall) {
		return webClientBuilder.baseUrl(baseUrl)
				.build();
	}
	
	
}
