package com.hm.mydata.md.service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;

import com.hm.mydata.common.config.WebClientConfig;
import com.hm.mydata.common.utils.DateUtil;
import com.hm.mydata.common.utils.StringUtil;
import com.hm.mydata.md.vo.CertResVO;


@Service
public class WebClientService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WebClientConfig wcc;
	
	public Map<String, String> 개별인증001() throws JSONException {
		Map<String, String> rtnMap = new HashMap<String, String>();
		
		String apiDtcdCode = "AU01";
		String apiUri = "/oauth/2.0/authorize";
		String userCi = "1234";
		String targetDomain = "";
		String xApiTranId = "";
		String mydtInstCode = "";
		String clientId = "";
		String kyoboRedirectUrl = "";
		String kyoboAppScheme = "";
		String state = "";
		
		// 상태값 생성
		SecureRandom rnd = new SecureRandom();
		int fnum = rnd.nextInt(9999);
		int snum = rnd.nextInt(99999);
		String Dttm = DateUtil.getMillisecond();
		String fLpad = StringUtil.lpad( Integer.toString(fnum), 4, "0");
		String sLpad = StringUtil.lpad( Integer.toString(snum), 5, "0");
//		return mydtInstCode + "_" + Dttm + fLpad + sLpad;
		
		state = mydtInstCode + "_" + Dttm + fLpad + sLpad;
		
		MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<String, String>();
		headerMap.add("gtw-custom-url", targetDomain);
		headerMap.add("x-api-tran-id", xApiTranId);
		headerMap.add("x-user-ci", userCi);
		
		MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<String, String>();
		paramMap.add("response-type", "code");
		paramMap.add("org_code", mydtInstCode);
		paramMap.add("client_id", clientId);
		paramMap.add("redirect_uri", kyoboRedirectUrl);
		paramMap.add("app_scheme", kyoboAppScheme);
		paramMap.add("state", state);
		
		
		ResponseEntity<?> response = null;
		try {
			response = this.getApiCall(apiUri, headerMap, paramMap);
			
		} catch (WebClientRequestException e) {
			
			log.info("e.getMessage() ::" + e.getMessage());
			log.info("e.getHeaders() ::" + e.getHeaders());
			log.info("e.getMethod() :: " + e.getMethod());
			rtnMap.put("error", "서버에러"); 
			return rtnMap;
		}
		
		CertResVO resVO = new CertResVO();
		log.info("resVO" + response.getBody().toString());
		
		if(response.getStatusCode().is3xxRedirection()) {
			log.info("302");
			rtnMap.put("location", response.getHeaders().getLocation().toString());
			
		} else if (response.getStatusCode().is2xxSuccessful()){
			log.info("200");
			resVO = (CertResVO) response.getBody();
			rtnMap.put("org_code", resVO.getOrg_code());            
			rtnMap.put("install_url_android", resVO.getInstall_url_android());       
			rtnMap.put("app_scheme_android", resVO.getApp_scheme_android());       
			rtnMap.put("app_scheme_iOS", resVO.getApp_scheme_iOS());    
			rtnMap.put("install_url_iOS", resVO.getInstall_url_iOS()); 
		} else {
			resVO = (CertResVO) response.getBody();
			rtnMap.put("error", resVO.getError());            
			rtnMap.put("error_description", resVO.getError_description()); 
		}
			
		return rtnMap;
	}
	
	public ResponseEntity<?> getApiCall(String apiUri, MultiValueMap<String, String> headerMap, MultiValueMap<String, String> paramMap) {

		Consumer<HttpHeaders> headers = v -> v.addAll(headerMap);
		WebClient wc = wcc.apiClient(WebClient.builder());
		ResponseEntity<?> ress = wc.get()
				              .uri(ub -> ub.path("/oauth/2.0/authorize")
				                            .queryParams(paramMap).build())
				              .headers(headers)
				              .exchangeToMono(res -> {
				            	  if (res.statusCode().equals(HttpStatus.FOUND) || res.statusCode().equals(HttpStatus.OK)) {
				            		  log.info("302, 200 응답 웹방식 응답");
				            		  
				            		  return res.toEntity(CertResVO.class);
				            	  } else {
				            		  log.info("else :: " + res.headers().asHttpHeaders().toString());
				            		  return res.toEntity(CertResVO.class);
				            	  }
				              })
				              .onErrorResume(err -> {
				            	  log.info("ba!!");
				            	  log.info("onErrorResume ::" + err.getMessage());
				            	  throw new WebClientRequestException(err, null, null, null);
				              })
				              .block();
				               
		log.info("END");     
		return ress;
		
	}

	
}
