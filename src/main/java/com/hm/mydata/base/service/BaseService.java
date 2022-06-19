package com.hm.mydata.base.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.hm.mydata.base.vo.BaseMapper;

import reactor.core.publisher.Mono;

@Service
public class BaseService {
	private Logger log = LoggerFactory.getLogger(getClass());
	private WebClient wc = WebClient
			.builder()
			.baseUrl("http://localhost:8081")
			.build();
	
	@Autowired
	private BaseMapper map;
	
	public String getApiCall() {
		log.info("2.콜하기전_메소드안");
		 Mono<String> result = wc
	                .get()
	                .uri("/testapi")
	                .retrieve()
	                .bodyToMono(String.class);
		 
		 log.info("3.콜후 subscri");
		 result.subscribe(response -> {
			  	log.info("레스폰수~ " + response);
	        }, e -> {
	        	 log.info("error message : " + e.getMessage());
	        });
		 return "SERVICE_CALL_STRING";
	}
	
	public String test() {
		return map.getTest();
	}
	
}
