package com.example.demo.base.controller;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.base.service.BaseService;
import com.example.demo.base.vo.ReturnVO;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class BaseController {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private BaseService baseService;

	@GetMapping("/test")
	public String getEmpInfo() {
		log.info("1.콜하기전");
		String result = baseService.getApiCall();
		log.info("4.콜후");
		log.info("서비스 리턴 스트링 :" + result);
		String testdb = baseService.test();
		log.info("testdb : " + testdb);
		return "LAST_CALL";
	}

	
	
	
	@GetMapping("/flux")
	Flux<String> hello() {
		return Flux.just("geee");
	}

	@GetMapping("/api-call")
	Mono<String> apicall() {
		return this.callApi();
	}

	public Mono<String> callApi() {
		WebClient wc = WebClient.builder().baseUrl("http://localhost:8081").build();
		return wc.get().uri("/testapi").accept(MediaType.APPLICATION_JSON_UTF8).header("Autorization", "Bearer " + "dd")
				.retrieve().bodyToMono(String.class).timeout(Duration.ofMillis(300));
	}

}
