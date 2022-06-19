package com.hm.mydata.md.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.hm.mydata.md.service.WebClientService;

@RestController
public class WebClientController {
	
	
	@Autowired
	private WebClientService wcService;
	
	@PostMapping("/idiviCertAuthorizeCode")
	public ResponseEntity<?> getIdiviCertAuthorizeCode(@RequestHeader HttpHeaders header,
			@RequestBody(required = false) Map<String, String> reqBody) throws Exception {
		Map<String, String> rtnMap = new HashMap<String, String>(); 
		rtnMap = wcService.개별인증001();
		return new ResponseEntity<>(rtnMap, HttpStatus.OK);
	}
	
}
