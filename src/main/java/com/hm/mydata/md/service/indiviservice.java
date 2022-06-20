package com.hm.mydata.md.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.hm.mydata.base.service.BaseService;
import com.hm.mydata.common.constants.CommonConstant;
import com.hm.mydata.common.utils.DateUtil;
import com.hm.mydata.md.vo.MdB003IncaAthnAthzcodeReqVO;
import com.hm.mydata.md.vo.MdB003IncaAthnAthzcodeResVO;
import com.hm.mydata.md.vo.MdB003IncaAthnTokenReqVO;
import com.hm.mydata.md.vo.MdB003IncaAthnTokenResVO;
import com.hm.mydata.md.vo.MdB003Mapper;
import com.hm.mydata.md.vo.MdB003ModLnknStatusResVO;
import com.hm.mydata.md.vo.MdB003TokenResVO;
import com.hm.mydata.md.vo.MdB003TrnmReqCommonVO;
import com.hm.mydata.md.vo.MdB003TrnmReqCommonVO.InstVO;
import com.hm.mydata.md.vo.MdB003TrnmReqDetailResVO;
import com.hm.mydata.md.vo.MdB003TrnmReqResVO;
import com.hm.mydata.md.vo.MdBMD0101MS;
import com.hm.mydata.md.vo.MdBMD0102DL;
import com.hm.mydata.md.vo.MdBMD0103DL;
import com.hm.mydata.md.vo.MdBMD0105RL;
import com.hm.mydata.md.vo.MdBMD1101DS;
import com.hm.mydata.md.vo.MdBMD1111MS;
import com.hm.mydata.md.vo.MdBMD5002TR;
import com.hm.mydata.md.vo.MyDataUtil;
import com.hm.mydata.md.vo.MzD001ReqVO.InstCodeVO;
import com.hm.mydata.md.vo.MzD001TargetInfoVO;
import com.hm.mydata.md.vo.MzDMD1115TR;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 1. ClassName : MdB003ServiceImpl
 * 2. FileName : MdB003ServiceImpl.java
 * 3. Package : kmds.md.b.service
 * 4. Comment : �������� ���� ����
 * @author : Kyeong-min, Kim
 * @version : 2022. 1. 21. ���� 5:55:01
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class indiviservice extends BaseService {

	private String baseUrl;
	private String kyoboMydtInstCode;
	private String kyoboRedirectUrl;
	private String kyoboAppScheme;
	private String tbdTargetDomain;
	private String sReq;
	private String tbdClientId;
	private String tbdClientSecret;
	
	@Autowired
	private MdB003Mapper mdB003Mapper;
	
	/**
	* 3. Comment           : ��������-001
	*/
	public MdB003IncaAthnAthzcodeResVO mdB003GetIncaAthnAthzcode(MdB003IncaAthnAthzcodeReqVO reqVO)
			throws JSONException {
		String csno = reqVO.getCsno();
		String mydtInstCode = reqVO.getMydtInstCode();
		String userCi = CommonConstant.STRING_FORMAT_SPACE;
		String xApiTranId = CommonConstant.STRING_FORMAT_SPACE;
		String mydtApiDsticCode = CommonConstant.API_DISTIC_CODE_IDIVI_001;
		String clientId = CommonConstant.STRING_FORMAT_SPACE;
		String targetDomain = CommonConstant.STRING_FORMAT_SPACE;
		String ciCntn = CommonConstant.STRING_FORMAT_SPACE;
		String state =""; 
				//commonService.getState(mydtInstCode);
		final String url = "/oauth/2.0/authorize";

		MdB003IncaAthnAthzcodeResVO resVO = new MdB003IncaAthnAthzcodeResVO(); // ��������-001 ����
		MdBMD0105RL inMD0105RL = new MdBMD0105RL(); // MD_�����������ǰ���
		MdBMD0102DL inMD0102DL = new MdBMD0102DL(); // MD_���ۿ䱸��

		inMD0102DL.setCsno(csno);
		inMD0102DL.setMydtInstCode(mydtInstCode);

		// 3.1-1_MAX ���ۿ䱸�Ϸù�ȣ ��ȸ
		String trnmReqSrno = mdB003Mapper.mdbMD0102DLPS001(inMD0102DL);

		for (int i = 0; i < reqVO.getInfrTrnmCnstList().size(); i++) {

			inMD0105RL = new MdBMD0105RL();
			inMD0105RL.setCsno(csno);
			inMD0105RL.setMydtInstCode(mydtInstCode);
			inMD0105RL.setTrnmReqSrno(trnmReqSrno);
			inMD0105RL.setStplId(reqVO.getInfrTrnmCnstList().get(i).getStplId());
			inMD0105RL.setStplVrsnName(reqVO.getInfrTrnmCnstList().get(i).getStplVrsnName());
			inMD0105RL.setCnstYn(reqVO.getInfrTrnmCnstList().get(i).getCnstYn());
			inMD0105RL.setRgsnId(CommonConstant.CODE_STRING_NFTF);
			// 3.1-2_�������ǰ��� ����
			mdB003Mapper.mdbMD0105RLPI001(inMD0105RL);
		}

		inMD0102DL.setVrfcStsCntn(state);
		inMD0102DL.setTrnmReqSrno(trnmReqSrno);
		mdB003Mapper.mdbMD0102DLPU005(inMD0102DL);

		MzDMD1115TR inMD1115TR = new MzDMD1115TR();
		xApiTranId = MyDataUtil.getXapiTranId("����ڱ���ڵ�", CommonConstant.KYOBO_TYPE_CODE);
		inMD1115TR.setCsno(csno);
		inMD1115TR.setMydtInstCode(mydtInstCode);
		inMD1115TR.setMapiDtcd(mydtApiDsticCode);
		inMD1115TR.setStstTrnmCyclDtcd("2");
		inMD1115TR.setInfrOfrVrsnName("v1");
		inMD1115TR.setMydtTrnsUnqNo(xApiTranId);
		inMD1115TR.setRgsnId(CommonConstant.CODE_STRING_NFTF);
		/*********************************************
		 * ��û�� ����
		 *********************************************/
		Map<String, String> reqHeaders = new LinkedHashMap<String, String>();
		Map<String, String> reqParams = new LinkedHashMap<String, String>();

		Map<String, String> reqTargetDivInfo = new HashMap<String, String>();
		MzD001TargetInfoVO targetInfo = null;
		/*********************************************
		 * �������, ����ڵ忡 ���� ��û���� �б�
		 *********************************************/
		log.info("mydtInstCode > > " + mydtInstCode);
		reqTargetDivInfo.put("mydtInstCode", mydtInstCode);
//		targetInfo = commonService.getServerDivValue(reqTargetDivInfo);
		if (null != targetInfo) {
			targetDomain = targetInfo.getTargetDomain();
			clientId = targetInfo.getClientId();
		}
		// target �׽�Ʈ������ ���
		if ("tbdTargetDomain".equals(targetDomain)) {
			reqHeaders.put(CommonConstant.CODE_STRING_X_FSI_UTCT_TYPE, CommonConstant.CODE_STRING_TGC00002);

			if ("test".equals("�������")) {
				if ("MA00000114".equals(csno)) {
					userCi = "QfUskK5d0O8YFFbAU4erjmnZ4eySRoIx"; // �׽�Ʈ���� �����ΰ��� x-user-ci
				} else if ("MA00000045".equals(csno)) {
					userCi = "HCrvrwdrOl4uWRYiSxwxh7spuGuS6E7a"; // �׽�Ʈ���� ���¿����� x-user-ci
				} else {
					userCi = "l4mvTOet1YQynDfu2oXzy5hkWghdFnzW"; // �׽�Ʈ���� ���ΰ��� x-user-ci
				}
			} else {
				if ("MA00000296".equals(csno)) {
					userCi = "QfUskK5d0O8YFFbAU4erjmnZ4eySRoIx"; // �׽�Ʈ���� �����ΰ��� x-user-ci
				} else if ("MA00000276".equals(csno)) {
					userCi = "HCrvrwdrOl4uWRYiSxwxh7spuGuS6E7a"; // �׽�Ʈ���� ���¿����� x-user-ci
				} else {
					userCi = "l4mvTOet1YQynDfu2oXzy5hkWghdFnzW"; // �׽�Ʈ���� ���ΰ��� x-user-ci
				}
			}
		} else {
			// Ÿ�� �׽�Ʈ���� �ƴҶ�,

			if ("MA00000053".equals(csno)) {
				// ���϶�
				ciCntn = mdB003Mapper.mdbMA1000MSPS002(csno);
				if (null != ciCntn && !"".equals(ciCntn)) {
					userCi = ciCntn;
				} else {
					userCi = "NLyyQE6kulIwOpAcJGe4n+54VJRRl/fUbIUCkugcNMpM4F2y2MTV9gfficNZFZnCnIJluVL6Yzv+KtvaumsJqA==";
				}

			} else if("MA00000178".equals(csno)) {
				// ���϶�,
				userCi = "KaBnrquWgvmkw6AeoTJb6DCSHwdK3O/UDEg7QoTp65uzwR6Gg+xA8m5wl/q7sG4MFZKVPMIZk8eNY4Endy5NIA==";

		    } else {
		    	// ��κ� �б�, �׽�Ʈ���� �ƴҶ� ��ӵ� �׽�Ʈ�� CI
				if ("test".equals("�������") || "dev".equals("�������") || "local".equals("�������")) {
					userCi = "AzIKF2YtFDSpnNTK2kaO4AyIYJluz5TALZTPfB8QQSA2Y5KKZ89xHqkmOGY/Y8uySF9T0jIOcwDIz3ZlFQOH0w==";
					//userCi = "SZTycPRg5prrXjqUeGs9pBh1haa87zCxNn9iaDVYNAoxQ8N3rBpNTwk90uw7tK3+CcNo9fWd0VGiD9dSBNSk0Q==";
					//userCi = "lFj/KPlHP9KmPbRZHeevatHKd8pSHNVqhiedr861T0UzTt4DJXt2aWMesU4SCzUNR8GsxoXHiuuY/o4F1SpZlg==";
				} else {
					ciCntn = mdB003Mapper.mdbMA1000MSPS002(csno);
					if (null != ciCntn && !"".equals(ciCntn)) {
						userCi = ciCntn;
					}
				}
			}
		}
		/*********************************************
		 * ���� ��û�� ����
		 *********************************************/
		reqHeaders.put("gtw-custom-url", targetDomain);
		reqHeaders.put("x-api-tran-id", xApiTranId);
		reqHeaders.put("x-user-ci", userCi);

		reqParams.put(CommonConstant.CODE_STRING_RESPONSE_TYPE, CommonConstant.CODE_STRING_CODE);
		reqParams.put("org_code", mydtInstCode);
		reqParams.put("client_id", clientId);
		reqParams.put("redirect_uri", kyoboRedirectUrl);
		reqParams.put("app_scheme", kyoboAppScheme);
		reqParams.put("state", state);

		// ȣ��
		HttpHeaders reqHeader = new HttpHeaders();
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl + url);
		HttpEntity<Map<String, String>> entity = null;

		// Resttemplate 302 auto redirect false ����
//		CloseableHttpClient httpClient = HttpClientBuilder.create().setRedirectStrategy(new DefaultRedirectStrategy() {
//			@Override
//			public boolean isRedirected(HttpRequest request, HttpResponse response, HttpContext context)
//					throws org.apache.http.ProtocolException {
//
//				return false;
//			}
//		}).build();
		HttpComponentsClientHttpRequestFactory reqFact = new HttpComponentsClientHttpRequestFactory();
		reqFact.setConnectTimeout(22); // ����Ÿ�Ӿƿ�
		reqFact.setReadTimeout(22); // �б�Ÿ�Ӿƿ�
		RestTemplate rt = new RestTemplate(reqFact);
		// ����� ��
		reqHeader.setAll(reqHeaders);
		entity = new HttpEntity<>(reqHeader);

		// map�� ������ �����Ķ����� �ִ´�
		reqParams.forEach((key, value) -> {
			builder.queryParam(key, value);
		});

		// ���� �ƿ� URL
		URI finalUri = builder.build().toUri();

		// APIM ȣ��
		String respDttm = CommonConstant.STRING_FORMAT_SPACE;
		String dmndDttm = DateUtil.getMillisecond();
		inMD1115TR.setDmndDttm(dmndDttm);
		log.info("reqData > > " + entity.toString());

		/*******************************************************
		 * ��������-001 �����ڵ�(����)
		 * 400(Bad Request) : invalid_client_id
		 *                    invalid_redirection
		 * 302(Found) : invalid_request
		 *              unauthorized_client
		 *              access_denied
		 *              unsupported_response_type
		 *              server_error
		 *              temporarily_unavailable
		 *              unauthorized_user
		 *******************************************************/
		ResponseEntity<String> rtnEntity = null;
		try {
			rtnEntity = rt.exchange(finalUri,         // ��û�� �ּ�
					HttpMethod.GET,   // ��û ���
					entity,           // ��û�Ҷ� ���� ������
					String.class);
			respDttm = DateUtil.getMillisecond();
			inMD1115TR.setRespDttm(respDttm);

		} catch (RestClientResponseException e) {
			log.info("��������-001 err > > "+ e.getClass().getSimpleName() + "\n" + e.getMessage());
			/*******************************************************
			 * ��������-001 ���� �޽��� ��
			 * Content-Type : application/json; charset=UTF-8
			 *
			 *  error : �����ڵ�
			 *  error_description : �����޽���
			 *  state : ���°�
			 *  api_tran_id : �ŷ�������ȣ
			 *******************************************************/

			String errMsg = CommonConstant.STRING_FORMAT_SPACE;
			JSONObject errJsonBody;
			try {
				errJsonBody = new JSONObject(e.getResponseBodyAsString());

				if (!errJsonBody.isNull("error")) {
					errMsg = errJsonBody.getString("error")  + "::";
				}

				if (!errJsonBody.isNull("error_description")) {
					errMsg += errJsonBody.getString("error_description");
				}

//				if (!errJsonBody.isNull("state")) {
//					errMsg += errJsonBody.getString("state");
//				}
			} catch (JSONException e1) {
				log.info("��������-001 err json ��ȯ�� ���� :" + e1.getMessage());
			}

			// ���۳��� ����
			inMD1115TR.setInfrOfrRespCode(Integer.toString(e.getRawStatusCode()));
			inMD1115TR.setMapiRespMsgCntn(errMsg);
			inMD1115TR.setMapiDmndMsgCntn(entity.toString() + reqParams.toString());
//			commonService.regGatheringLog(inMD1115TR);

			resVO.setInfrOfrUrl(null);
			resVO.setRespMsg(errMsg);
			resVO.setRespCode(Integer.toString(e.getRawStatusCode()));
			return resVO;
		}

		// 302 ����� ����
		if(null != rtnEntity) {
			if (HttpStatus.FOUND.equals(rtnEntity.getStatusCode())) {
//				log.info("302##################################################################");
				resVO.setRespCode("302");
				resVO.setRespMsg("����� ���������� �����ϴ� ����Դϴ�.");
				resVO.setInfrOfrUrl(rtnEntity.getHeaders().getLocation().toString());
				if (null != rtnEntity.getHeaders().getLocation()) {
					log.info("��������-001 : ����� ���� ::" + rtnEntity.getHeaders().getLocation().toString());
				}
				// ���۳��� ����
				inMD1115TR.setInfrOfrRespCode("302");
				if (!rtnEntity.getHeaders().getLocation().toString().isEmpty()) {
					inMD1115TR.setMapiRespMsgCntn(rtnEntity.getHeaders().getLocation().toString());
				} else {
					inMD1115TR.setMapiRespMsgCntn(rtnEntity.getHeaders().toString());
				}
				inMD1115TR.setMapiDmndMsgCntn(entity.toString() + reqParams.toString());
//				commonService.regGatheringLog(inMD1115TR);

				// 200 �۹�� ����
			} else if (HttpStatus.OK.equals(rtnEntity.getStatusCode())) {
//				log.info("200##################################################################");
				resVO.setRespCode("200");
				resVO.setRespMsg("�۹�� ���������� �����ϴ� ����Դϴ�.");

				JSONObject infrOfrAppInfo;
				try {
					infrOfrAppInfo = new JSONObject(rtnEntity.getBody());

					if (!infrOfrAppInfo.isNull("org_code")) {
						resVO.setOrgCode(infrOfrAppInfo.getString("org_code"));
					}

					if (!infrOfrAppInfo.isNull("app_scheme_iOS")) {
						resVO.setAppSchemeIos(infrOfrAppInfo.getString("app_scheme_iOS"));
					}

					if (!infrOfrAppInfo.isNull("install_url_iOS")) {
						resVO.setInstallUrlIos(infrOfrAppInfo.getString("install_url_iOS"));
					}

					if (!infrOfrAppInfo.isNull("app_scheme_android")) {
						resVO.setAppSchemeAndroid(infrOfrAppInfo.getString("app_scheme_android"));
					}

					if (!infrOfrAppInfo.isNull("install_url_android")) {
						resVO.setInstallUrlAndroid(infrOfrAppInfo.getString("install_url_android"));
					}

				} catch (JSONException e2) {
					log.info("��������-001 infrOfrAppInfo json ��ȯ�� ���� :" + e2.getMessage());
				}

				// ���۳��� ����
				inMD1115TR.setInfrOfrRespCode("200");
				inMD1115TR.setMapiRespMsgCntn(rtnEntity.getBody().toString());
				inMD1115TR.setMapiDmndMsgCntn(entity.toString() + reqParams.toString());
//				commonService.regGatheringLog(inMD1115TR);

			} else if (HttpStatus.BAD_REQUEST.equals(rtnEntity.getStatusCode())) {
//				log.info("400##################################################################");

				resVO.setRespCode("400");
				resVO.setRespMsg("����");

				// ���۳��� ����
				inMD1115TR.setInfrOfrRespCode("400");
				inMD1115TR.setMapiRespMsgCntn(rtnEntity.getBody().toString());
				inMD1115TR.setMapiDmndMsgCntn(entity.toString() + reqParams.toString());
//				commonService.regGatheringLog(inMD1115TR);
			}

		}

		return resVO;
	}

	/**
	* 1. MethodName        : mdB003GetIncaAthnToken
	* 2. ClassName         : MdB003ServiceImpl
	* 3. Comment           : ��������-002
	* @SQLID               : mdbMD0102DLPU001, mdbMD1101DSPU001, mdbMD0102DLPU003, mdbMD1101DSPI001, mdbMD5002TRPI001
	* @APIM                : oauth-002
	* @author              : kyeong-min, Kim
	* @version             : 2022. 4. 12. ���� 4:31:06
	* @param
	* @return MdB003IncaAthnTokenResVO
	* @throws Exception
	*/
	public MdB003IncaAthnTokenResVO mdB003GetIncaAthnToken(MdB003IncaAthnTokenReqVO reqVO) throws Exception {

		/*******************************************************
		 * ��������-002 ���μ��� 1. �ΰ��ڵ�/���°�/(�ŷ�������ȣ) ���� 2. �ŷ�������ȣ ä�� 3. ��û �׸� ���� 4. ���ۿ䱸 �Ϸù�ȣ
		 * ��ȸ 5. ��������-002(������ū �߱�) ���� 5-1. ��������-002 ���� ���� �� �߱��� ��ū���� ����-002 ȣ�� 6.
		 * ��������-002/����-002 ��� ���� ���� �� MD1101DS ��ȿ���� UPDATE : N 7. MD1101DS : �߱޹��� ������ū
		 * ���� MD5002TR : ���ۿ䱸���� ���� 8. MD0102DL : ���ۿ䱸�� ������Ʈ : ���ۿ䱸���� / ���������� - ���� ��
		 * MD0102DL : ���ۿ䱸�� ������Ʈ
		 *******************************************************/

		String csno = CommonConstant.STRING_FORMAT_SPACE;
		String mydtInstCode = CommonConstant.STRING_FORMAT_SPACE;
		String mydtInstName = CommonConstant.STRING_FORMAT_SPACE;
		String mydtApiDsticCode = CommonConstant.API_DISTIC_CODE_IDIVI_002; // ���̵�����API�����ڵ�
		String clientId = CommonConstant.STRING_FORMAT_SPACE;
		String clientSecret = CommonConstant.STRING_FORMAT_SPACE;
		String targetDomain = CommonConstant.STRING_FORMAT_SPACE;
		String xApiTranId = CommonConstant.STRING_FORMAT_SPACE;
		String trnmReqSrno = CommonConstant.STRING_FORMAT_SPACE;
		String code = reqVO.getCode();

		MdB003IncaAthnTokenResVO resVO = new MdB003IncaAthnTokenResVO();
		final String url = this.baseUrl + "/oauth/2.0/token";

		MzDMD1115TR inMD1115TR = new MzDMD1115TR();
		MdBMD1101DS inMD1101DS = new MdBMD1101DS();
		MdBMD5002TR inMD5002TR = new MdBMD5002TR();
		MdBMD0102DL inMD0102DL = new MdBMD0102DL();
		inMD0102DL = this.getStateVerifyInfo(reqVO.getState());

		csno = inMD0102DL.getCsno();
		mydtInstCode = inMD0102DL.getMydtInstCode();
		trnmReqSrno = inMD0102DL.getTrnmReqSrno();

		/*******************************************************
		 * �ŷ�������ȣ ä��
		 *******************************************************/
		xApiTranId = MyDataUtil.getXapiTranId(kyoboMydtInstCode, CommonConstant.KYOBO_TYPE_CODE);

		inMD1115TR.setCsno(csno);
		inMD1115TR.setMydtInstCode(mydtInstCode);
		inMD1115TR.setMapiDtcd(mydtApiDsticCode);
		inMD1115TR.setStstTrnmCyclDtcd("2");
		inMD1115TR.setInfrOfrVrsnName("v1");
		inMD1115TR.setMydtTrnsUnqNo(xApiTranId);
		inMD1115TR.setRgsnId(CommonConstant.CODE_STRING_NFTF);


		/*********************************************
		 * ��û�� ����
		 *********************************************/
		HttpHeaders reqHeaders = new HttpHeaders();
		MultiValueMap<String, String> reqParam = new LinkedMultiValueMap<String, String>();

		Map<String, String> reqTargetDivInfo = new HashMap<String, String>();
		MzD001TargetInfoVO targetInfo = null;
		/*********************************************
		 * �������, ����ڵ忡 ���� ��û���� �б�
		 *********************************************/
		log.info("������� > > " + "�������");
		log.info("mydtInstCode > > " + mydtInstCode);
		reqTargetDivInfo.put("�������", "�������");
		reqTargetDivInfo.put("mydtInstCode", mydtInstCode);
//		targetInfo = commonService.getServerDivValue(reqTargetDivInfo);
		if (null != targetInfo) {
			targetDomain = targetInfo.getTargetDomain();
			clientId = targetInfo.getClientId();
			clientSecret = targetInfo.getClientSecret();
			mydtInstName = targetInfo.getMydtInstName();

		}

		resVO.setMydtInstName(mydtInstName);

		// target �׽�Ʈ������ ���
		if (tbdTargetDomain.equals(targetDomain)) {
			reqHeaders.add(CommonConstant.CODE_STRING_X_FSI_UTCT_TYPE, "TGC00002");
			reqHeaders.add("X-FSI-SVC-DATA-KEY", "Y");
		}
		reqHeaders.add("x-api-tran-id", xApiTranId);
		reqHeaders.add("Content-Type", "application/x-www-form-urlencoded");
		reqHeaders.add("gtw-custom-url", targetDomain);

		reqParam.add("org_code", mydtInstCode);
		reqParam.add(CommonConstant.CODE_STRING_GRANT_TYPE, CommonConstant.GRANT_TYPE);
		reqParam.add("code", code);
		reqParam.add("client_id", clientId);
		reqParam.add("client_secret", clientSecret);
		reqParam.add("redirect_uri", kyoboRedirectUrl);

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(reqParam,
				reqHeaders);
		UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build(false);

		String dmndDttm = DateUtil.getMillisecond();
		String respDttm = CommonConstant.STRING_FORMAT_SPACE;
		ResponseEntity<String> rtnEntity = null;
		try {
			/*******************************************************
			 * 5. ��������-002(������ū �߱�) ����
			 *******************************************************/
			rtnEntity = restTemplate.exchange(uri.toString(), HttpMethod.POST, entity, String.class);
			// ���� : �����Ͻ�
			respDttm = DateUtil.getMillisecond();

		} catch (RuntimeException e) {

			// ���� : �����Ͻ�
			respDttm = DateUtil.getMillisecond();
			// ��û,�����Ͻ�
			inMD1115TR.setDmndDttm(dmndDttm);
			inMD1115TR.setRespDttm(respDttm);

			// ���ۿ䱸�� ������Ʈ : ��������-002 ���� ��
			inMD0102DL.setInstLnknStcd("02");
			mdB003Mapper.mdbMD0102DLPU001(inMD0102DL);

			inMD1115TR.setInfrOfrRespCode(e.getMessage() == null ? "50001" : e.getMessage().substring(0, 3));
			inMD1115TR.setMapiRespMsgCntn(e.getMessage() == null ? "��������-002 API ȣ�� ����" : e.getMessage());
			inMD1115TR.setMapiDmndMsgCntn(reqParam.toString() + entity.toString());
//			commonService.regGatheringLog(inMD1115TR);

			resVO.setMydtInstCode(mydtInstCode);
			resVO.setRespCode(e.getMessage() == null ? "50001" : e.getMessage().substring(0, 3));
			resVO.setRespMsg("��������-002 API ȣ�� ����");
			resVO.setInstLnknStcd("02"); // TODO �����ڵ� Ȯ��
			return resVO;
		}

		// ��û,�����Ͻ�
		inMD1115TR.setDmndDttm(dmndDttm);
		inMD1115TR.setRespDttm(respDttm);
		// ���۳��� ����
		inMD1115TR.setInfrOfrRespCode("00000");
		inMD1115TR.setMapiRespMsgCntn(rtnEntity.getBody());
		inMD1115TR.setMapiDmndMsgCntn(reqParam.toString() + entity.toString());
//		commonService.regGatheringLog(inMD1115TR);

		// �������� ��

		if(null != rtnEntity) {
			if (HttpStatus.OK.equals(rtnEntity.getStatusCode())) {

				// ��������-002 �� ��ȯ
				String resData = (String) rtnEntity.getBody();
//				Gson gson = new Gson();
//				MdB003TokenResVO tokenVO = gson.fromJson(resData, MdB003TokenResVO.class);
				MdB003TokenResVO tokenVO = new MdB003TokenResVO();

				// ����-002 ����
				MdB003TrnmReqResVO trnmResVO = this.mdB003GetTrnmReq(csno, mydtInstCode, tokenVO);

				if ("00000".equals(trnmResVO.getRsp_code())) {
					/*******************************************************
					 * 6. ��������-002/����-002 ��� ���� ���� ��
					 *******************************************************/
					log.info("����-002 �������� ���μ��� : ��ū �� ���ۿ䱸���� ����");
					inMD1101DS.setCsno(csno);
					inMD1101DS.setMydtInstCode(mydtInstCode);
					inMD1101DS.setTokenVldYn("N");
					/*******************************************************
					 * 6. MD1101DS ��ȿ���� UPDATE : N
					 *******************************************************/
					// ��&����� ��ū�� �� �� ��ū ����ó��
					mdB003Mapper.mdbMD1101DSPU001(inMD1101DS);
					/*******************************************************
					 * 6-1. MD0102DL ���ۿ䱸����(91) : ���� UPDATE : 91
					 * >> ��&����� MAX�Ϸù�ȣ �̿��� 10&20�� ���ۿ䱸���� ����ó���Ѵ�
					 *******************************************************/
					mdB003Mapper.mdbMD0102DLPU003(inMD0102DL);

					// ��ū����
					inMD1101DS.setTrnmReqSrno(trnmReqSrno);
					inMD1101DS.setTrnmReqPtcd("1");
					inMD1101DS.setAcesTokenPtrnName(tokenVO.getToken_type());
					inMD1101DS.setAcesTokenTlms(tokenVO.getAccess_token());
					inMD1101DS.setAcesTokenVldTerm(tokenVO.getExpires_in());
					inMD1101DS.setRfrsTokenTlms(tokenVO.getRefresh_token());
					inMD1101DS.setRfrsTokenVldTerm(tokenVO.getRefresh_token_expires_in());
					if (tokenVO.getScope().length() > 199) {
						// �ӽ� �б�ó��
						if ("A1AAER0000".equals(mydtInstCode)) {
							inMD1101DS.setAthrRngTlms("bank.list bank.deposit bank.loan bank.irp");
						} else if ("B1AAAI0000".equals(mydtInstCode)) {
							inMD1101DS.setAthrRngTlms("insu.list insu.insurance insu.loan insu.irp");
						} else if ("B4AADL0000".equals(mydtInstCode)) {
							inMD1101DS.setAthrRngTlms("ginsu.list ginsu.insurance");
						} else if ("C1AAEY0000".equals(mydtInstCode)) {
							inMD1101DS.setAthrRngTlms("invest.list invest.irp invest.account");
						} else if ("D1AAEV0000".equals(mydtInstCode)) {
							inMD1101DS.setAthrRngTlms("card.list card.card card.point card.bill card.loan card.prepaid");
						} else if ("D3AABY0000".equals(mydtInstCode)) {
							inMD1101DS.setAthrRngTlms("capital.list capital.loan");
						} else if ("E1AAAX0000".equals(mydtInstCode)) {
							inMD1101DS.setAthrRngTlms("efin.list efin.prepaid efin.paid");
						} else if ("F1AAAU0000".equals(mydtInstCode)) {
							inMD1101DS.setAthrRngTlms("telecom.list telecom.mgmt");
						} else if ("P1PPPI0000".equals(mydtInstCode)) {
							inMD1101DS.setAthrRngTlms("p2p.list p2p.lending");
						} else if ("R1RRRV0000".equals(mydtInstCode)) {
							inMD1101DS.setAthrRngTlms("bond.bond bond.list");
						} else if ("X1XXXV0000".equals(mydtInstCode)) {
							inMD1101DS.setAthrRngTlms("usury.list usury.bond");
						}
					} else {
						inMD1101DS.setAthrRngTlms(tokenVO.getScope());
					}

					inMD1101DS.setTokenVldYn("Y");
					inMD1101DS.setRgsnId(CommonConstant.CODE_STRING_NFTF);
					/*******************************************************
					 * 7. MD1101DS : �߱޹��� ������ū ����
					 *******************************************************/
					mdB003Mapper.mdbMD1101DSPI001(inMD1101DS);

					inMD5002TR.setCsno(csno);
					inMD5002TR.setMydtInstCode(mydtInstCode);
					inMD5002TR.setTrnmReqSrno(trnmReqSrno);
					if ("true".equals(trnmResVO.getIs_scheduled())) {
						inMD5002TR.setPrdcTrnmYn("Y");
					} else {
						inMD5002TR.setPrdcTrnmYn("N");
					}
					inMD5002TR.setTrnmReqObjcCntn(trnmResVO.getPurpose());
					inMD5002TR.setBascInfrTrnmCyclCntn(trnmResVO.getFnd_cycle());
					inMD5002TR.setAddInfrTrnmCyclCntn(trnmResVO.getAdd_cycle());
					inMD5002TR.setTrnmEndDate(trnmResVO.getEnd_date());
					inMD5002TR.setIndvCrdtInfrHoldDate(trnmResVO.getPeriod());

					if ("true".equals(trnmResVO.getIs_consent_trans_memo())) {
						inMD5002TR.setTrnsMemoTrnmReqYn("Y");
					} else {
						inMD5002TR.setTrnsMemoTrnmReqYn("N");
					}

					if ("true".equals(trnmResVO.getIs_consent_merchant_name_regno())) {
						inMD5002TR.setAfstNameTrnmReqYn("Y");
					} else {
						inMD5002TR.setAfstNameTrnmReqYn("N");
					}

					if ("true".equals(trnmResVO.getIs_consent_trans_category())) {
						inMD5002TR.setPrdtClsfTrnmReqYn("Y");
					} else {
						inMD5002TR.setPrdtClsfTrnmReqYn("N");
					}
					inMD5002TR.setRgsnId(CommonConstant.CODE_STRING_NFTF);
					/*******************************************************
					 * 7. MD5002TR : ���ۿ䱸���� ����
					 *******************************************************/
					mdB003Mapper.mdbMD5002TRPI001(inMD5002TR);

					// ���Ἲ�� ����
					inMD0102DL.setInstLnknStcd("10");
					inMD0102DL.setTrnmReqStcd("20"); // 20 : ������
					/*******************************************************
					 * 8. MD0102DL : ���ۿ䱸�� ������Ʈ : ���ۿ䱸���� / ����������
					 *******************************************************/
					mdB003Mapper.mdbMD0102DLPU001(inMD0102DL);

					resVO.setRespCode("00000");
					resVO.setRespMsg("���Ἲ��");
					resVO.setMydtInstCode(mydtInstCode);
					resVO.setInstLnknStcd("10");

					// ���� API ��û�� ����
					List<InstCodeVO> mydtInstCodeList = new ArrayList<>();
					InstCodeVO instVO = new InstCodeVO();
					instVO.setMydtInstCode(mydtInstCode);
					mydtInstCodeList.add(instVO);
//					sReq.setCsno(csno);
//					sReq.setMydtInstCodeList(mydtInstCodeList);
//					sReq.setApiType("user-consent");

				} else {
					// ���ۿ䱸�� ������Ʈ : ����-002 ���� ��
					inMD0102DL.setInstLnknStcd("02");
					mdB003Mapper.mdbMD0102DLPU001(inMD0102DL);
					resVO.setRespCode(trnmResVO.getRsp_code());
					resVO.setRespMsg(trnmResVO.getRsp_msg());
					resVO.setInstLnknStcd("02");
					return resVO;
				}

			} else {
				// ���ۿ䱸�� ������Ʈ : ��������-002 ���� ��
				inMD0102DL.setInstLnknStcd("02");
				mdB003Mapper.mdbMD0102DLPU001(inMD0102DL);
				resVO.setMydtInstCode(mydtInstCode);
				resVO.setRespCode(Integer.toString(rtnEntity.getStatusCodeValue()));
				resVO.setRespMsg(rtnEntity.getBody());
				resVO.setInstLnknStcd("02"); // TODO �����ڵ� Ȯ��

				return resVO;
			}
		}
		return resVO;
	}

	/**
	* 1. MethodName        : getStateVerifyInfo
	* 2. ClassName         : MdB003ServiceImpl
	* 3. Comment           : NONE
	* @SQLID               : NONE
	* @APIM                : NONE
	* @author              : NONE
	* @version             : 2022. 4. 12. ���� 4:31:06
	* @param String state
	* @return MdBMD0102DL
	* @throws NONE
	*/
	private MdBMD0102DL getStateVerifyInfo(String state) {
		// �̻�� ����Ʈ ���� ���� Map<String, String> verifyInfoMap = new HashMap<String, String>();
		MdBMD0102DL MD0102DL = new MdBMD0102DL();
		MD0102DL.setVrfcStsCntn(state);
		MD0102DL = mdB003Mapper.mdbMD0102DLPS003(MD0102DL);

		if(null == MD0102DL.getCsno() || null == MD0102DL.getMydtInstCode() || null == MD0102DL.getTrnmReqSrno()) {
//			throw new CustomException("���°� ������ �����߽��ϴ�.", ErrorCode.HTTP_ERROR_40001);
		}

		return MD0102DL;
	}

	/**
	* 1. MethodName        : mdB003GetTrnmReq
	* 2. ClassName         : MdB003ServiceImpl
	* 3. Comment           : ����-002
	* @SQLID               : mdbMD1111MSPS001
	* @APIM                : [industry]-consent
	* @author              : kyeong-min, Kim
	* @version             : 2022. 4. 12. ���� 4:31:06
	* @param
	* @return MdB003TrnmReqResVO
	* @throws Exception
	*/
	public MdB003TrnmReqResVO mdB003GetTrnmReq(String csno, String mydtInstCode, MdB003TokenResVO tokenVO) {
		MdB003TrnmReqResVO trnmResVO = new MdB003TrnmReqResVO();

		String infrOfrTobCode = CommonConstant.STRING_FORMAT_SPACE;
		String mydtApiDsticCode = CommonConstant.API_DISTIC_CODE_COMMON_002;
		String clientId = CommonConstant.STRING_FORMAT_SPACE;
		String clientSecret = CommonConstant.STRING_FORMAT_SPACE;
		String targetDomain = CommonConstant.STRING_FORMAT_SPACE;
		MdBMD1111MS rtnTobCode = new MdBMD1111MS();
		MzDMD1115TR inMD1115TR = new MzDMD1115TR();

		// �����ڵ� ��ȸ( ex) invest
		rtnTobCode = mdB003Mapper.mdbMD1111MSPS001(mydtInstCode);
		infrOfrTobCode = rtnTobCode.getInfrOfrTobCode();

		final String url = this.baseUrl + "/v1_" + infrOfrTobCode + "/consents";
		log.info("����-002 ���� url : " + url);
		String xApiTranId = MyDataUtil.getXapiTranId(kyoboMydtInstCode, CommonConstant.KYOBO_TYPE_CODE);

		inMD1115TR.setCsno(csno);
		inMD1115TR.setMydtInstCode(mydtInstCode);
		inMD1115TR.setMapiDtcd(mydtApiDsticCode);
		inMD1115TR.setStstTrnmCyclDtcd("2");
		inMD1115TR.setInfrOfrVrsnName("v1");
		inMD1115TR.setMydtTrnsUnqNo(xApiTranId);
		inMD1115TR.setRgsnId(CommonConstant.CODE_STRING_NFTF);

		HttpHeaders reqHeaders = new HttpHeaders();

		Map<String, String> reqTargetDivInfo = new HashMap<String, String>();
		MzD001TargetInfoVO targetInfo = null;
		/*********************************************
		 * �������, ����ڵ忡 ���� ��û���� �б�
		 *********************************************/
		log.info("������� > > " + "�������");
		log.info("mydtInstCode > > " + mydtInstCode);
		reqTargetDivInfo.put("�������", "�������");
		reqTargetDivInfo.put("mydtInstCode", mydtInstCode);
//		targetInfo = commonService.getServerDivValue(reqTargetDivInfo);
		if (null != targetInfo) {
			targetDomain = targetInfo.getTargetDomain();
			clientId = targetInfo.getClientId();
			clientSecret = targetInfo.getClientSecret();
		}

		// target �׽�Ʈ������ ���
		if (tbdTargetDomain.equals(targetDomain)) {
			reqHeaders.add(CommonConstant.CODE_STRING_X_FSI_UTCT_TYPE, "TGC00002");
			reqHeaders.add("X-FSI-SVC-DATA-KEY", "Y");
		}

		reqHeaders.add("gtw-custom-url", targetDomain);
		reqHeaders.add("Authorization", "Bearer " + tokenVO.getAccess_token());
		reqHeaders.add("x-api-tran-id", xApiTranId); // �ŷ�������ȣ(25)
		reqHeaders.add("x-api-type", "user-consent"); // x-user-ci(������ü������, ���ƴ� �� ���� ��)

		HttpEntity<?> requestEntity = new HttpEntity<>(reqHeaders);
		RestTemplate restTemplate = new RestTemplate();
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("org_code", mydtInstCode).build();

		String dmndDttm = DateUtil.getMillisecond();
		inMD1115TR.setDmndDttm(dmndDttm);
		String respDttm = CommonConstant.STRING_FORMAT_SPACE;
		ResponseEntity<String> rtnEntity = null;
		try {

			rtnEntity = restTemplate.exchange(builder.toUriString(), // ��û�� �ּ�
					HttpMethod.GET, // ��û ���
					requestEntity, // ��û�Ҷ� ���� ������
					String.class);

			// �������� : ����ð� ����
			respDttm = DateUtil.getMillisecond();
			inMD1115TR.setRespDttm(respDttm);
		} catch (RuntimeException e) {
			log.info("����-002 FAIL > >");
			log.debug("getMessage" + e.getMessage());
			// �������� : ����ð� ����
			respDttm = DateUtil.getMillisecond();
			inMD1115TR.setRespDttm(respDttm);
			// �������� ����
			inMD1115TR.setInfrOfrRespCode(e.getMessage().substring(0, 3));
			inMD1115TR.setMapiRespMsgCntn(e.getMessage().toString());
			inMD1115TR.setMapiDmndMsgCntn(reqHeaders.toString());
			// ���۳��� ����
//			commonService.regGatheringLog(inMD1115TR);

			// �������� ����
			trnmResVO.setRsp_code(e.getMessage().substring(0, 3));
			trnmResVO.setRsp_msg(e.getMessage().toString());
			return trnmResVO;

		}
		// �������� : ���۳��� ����
		inMD1115TR.setInfrOfrRespCode(Integer.toString(rtnEntity.getStatusCodeValue()));
		inMD1115TR.setMapiRespMsgCntn(rtnEntity.getBody());
		inMD1115TR.setMapiDmndMsgCntn(reqHeaders.toString());
//		commonService.regGatheringLog(inMD1115TR);

		log.debug("getBody : " + rtnEntity.getBody());

		// ���������� ��� �� ����
		if (HttpStatus.OK.equals(rtnEntity.getStatusCode())) {
			String resData = (String) rtnEntity.getBody();
//			Gson gson = new Gson();
//			trnmResVO = gson.fromJson(resData, MdB003TrnmReqResVO.class);
		}

		return trnmResVO;
	}

	/**
	* 1. MethodName        : mdb003InsertTrnmReqBascDetail
	* 2. ClassName         : MdB003ServiceImpl
	* 3. Comment           : ���ۿ䱸�⺻ �� ���ۿ䱸�� ����
	* @SQLID               : mdbMD0101MSPS001, mdbMD0101MSPI001, mdbMD0102DLPI001, mdbMD0103DLPI001, mdbMD0103DLPI001
	* @APIM                : NONE
	* @author              : kyeong-min, Kim
	* @version             : 2022. 4. 12. ���� 4:31:06
	* @param
	* @return Map
	* @throws Exception
	*/
	public Map<String, Object> mdb003InsertTrnmReqBascDetail(MdB003TrnmReqCommonVO reqVO) {
		Map<String, Object> params = new HashMap<String, Object>();
		List<String> pInstList = new ArrayList<String>();
		MdBMD0103DL inMD0103DL = new MdBMD0103DL();
		MdBMD0101MS inMD0101MS = new MdBMD0101MS();
		MdBMD0102DL inMD0102DL = new MdBMD0102DL();
		MdBMD1101DS inMD1101DS = new MdBMD1101DS();
		inMD0101MS.setCsno(reqVO.getCsno());
		/*
		 * �����������������ڵ�
		 * 01 : ��������
		 * 02 : ��������
		 */
		inMD0101MS.setInfrOfrAthnDtcd(reqVO.getInfrOfrAthnDtcd());
		log.debug("1. ���ۿ䱸�⺻ ���� : �����Ϸù�ȣ ä��");
		// ���ۿ䱸 �Ϸù�ȣ ä��
		String trnmReqSrno = mdB003Mapper.mdbMD0101MSPS001(inMD0101MS);
		inMD0101MS.setTrnmReqSrno(trnmReqSrno);
		inMD0101MS.setRgsnId(CommonConstant.CODE_STRING_NFTF);
		inMD0101MS.setScrnPrgsDtcd(reqVO.getMode());
		mdB003Mapper.mdbMD0101MSPI001(inMD0101MS);

		List<InstVO> mydtInstCodeList = reqVO.getMydtInstCodeList();

		if (!mydtInstCodeList.isEmpty()) {
			log.debug("2. ���ۿ䱸�⺻ ���� : �����Ϸù�ȣ ä��");
			for (int i = 0; i < mydtInstCodeList.size(); i++) {
				/*
				 * ���ۿ䱸�����ڵ�
				 * 10 : ���Ի�ǰ���ۿ䱸��û
				 * 20 : ���������ۿ䱸��û(������)
				 * 90 : ���̵�����öȸ
				 * 91 : ���̵�����öȸ(����)
				 * 92 : ���ۿ䱸�Ⱓ����
				 */
				inMD0102DL.setCsno(reqVO.getCsno());
				inMD0102DL.setTrnmReqSrno(trnmReqSrno);
				inMD0102DL.setMydtInstCode(mydtInstCodeList.get(i).getMydtInstCode());
				if (("P".equals(reqVO.getMode()) || "U".equals(reqVO.getMode()))
						&& "02".equals(reqVO.getInfrOfrAthnDtcd())) {
					pInstList.add(mydtInstCodeList.get(i).getMydtInstCode());
				}
				inMD0102DL.setTrnmReqStcd("10"); // �������� : ���ۿ䱸�����ڵ� ����
				inMD0102DL.setInstLnknStcd("01"); // �������� : ������(01)
				inMD0102DL.setAstCtlgTrnmReqDttm(null); // �ڻ������ۿ䱸�Ͻ�
				inMD0102DL.setDtlInfrTrnmReqDttm(null); // ���������ۿ䱸�Ͻ�
				inMD0102DL.setTrnmReqRclDttm(null); // ���ۿ䱸öȸ�Ͻ�
				inMD0102DL.setVrfcStsCntn(null);
				inMD0102DL.setTrnmReqRclYn("N");
				inMD0102DL.setMydtDelYn("N");
				inMD0102DL.setRgsnId(CommonConstant.CODE_STRING_NFTF);
				mdB003Mapper.mdbMD0102DLPI001(inMD0102DL);

			}

			// ���� ���μ����� ���, ������ ����� �ڻ����� ���ο� �Ϸù�ȣ�� ����
			if (("P".equals(reqVO.getMode()) || "U".equals(reqVO.getMode()))
					&& "02".equals(reqVO.getInfrOfrAthnDtcd())) {
				log.debug("��� ::" + reqVO.getMode());
				inMD0103DL.setCsno(reqVO.getCsno());
				inMD0103DL.setTrnmReqSrno(trnmReqSrno);
				inMD0103DL.setRgsnId(CommonConstant.CODE_STRING_NFTF);
				inMD0103DL.setMydtInstCodeList(pInstList);
				mdB003Mapper.mdbMD0103DLPI001(inMD0103DL);

				inMD1101DS.setCsno(reqVO.getCsno());
				inMD1101DS.setTrnmReqSrno(trnmReqSrno);
				inMD1101DS.setRgsnId(CommonConstant.CODE_STRING_NFTF);
				inMD1101DS.setMydtInstCodeList(pInstList);
				mdB003Mapper.mdbMD1101DSPI002(inMD1101DS);

			}

		}

		params.put(CommonConstant.CODE_STRING_RESP_CODE, CommonConstant.CODE_STRING_RESP_CODE_00000);
		params.put(CommonConstant.CODE_STRING_RESP_MSG, CommonConstant.CODE_STRING_RESP_CODE_MSG);
		params.put("trnmReqSrno", trnmReqSrno);
		return params;
	}

	/**
	* 1. MethodName        : mdB003GetTrnmReqDetail
	* 2. ClassName         : MdB003ServiceImpl
	* 3. Comment           : ��� ���������ȸ : ���ۿ䱸��
	* @SQLID               : mdbMD0102DLVS001
	* @APIM                : NONE
	* @author              : kyeong-min, Kim
	* @version             : 2022. 4. 12. ���� 4:31:06
	* @param
	* @return MdB003TrnmReqDetailResVO
	* @throws Exception
	*/
	public MdB003TrnmReqDetailResVO mdB003GetTrnmReqDetail(MdB003TrnmReqCommonVO reqVO) {
		MdB003TrnmReqDetailResVO resVO = new MdB003TrnmReqDetailResVO();

		MdB003TrnmReqDetailResVO.InstLnknStVO innerVO = new MdB003TrnmReqDetailResVO.InstLnknStVO();
		List<MdB003TrnmReqDetailResVO.InstLnknStVO> innerList = new ArrayList<MdB003TrnmReqDetailResVO.InstLnknStVO>();
		List<MdBMD0102DL> rtnMD0102DLList = new ArrayList<MdBMD0102DL>();
		rtnMD0102DLList = mdB003Mapper.mdbMD0102DLVS001(reqVO);

		if (rtnMD0102DLList.isEmpty()) {
			resVO.setRespCode("40001");
			resVO.setRespMsg("����� ����� �����ϴ�.");
		} else {
			for (int i = 0; i < rtnMD0102DLList.size(); i++) {
				innerVO = new MdB003TrnmReqDetailResVO.InstLnknStVO();
				innerVO.setMydtInstCode(rtnMD0102DLList.get(i).getMydtInstCode());
				innerVO.setMydtInstName(rtnMD0102DLList.get(i).getMydtInstName());
				innerVO.setInfrOfrTobCode(rtnMD0102DLList.get(i).getInfrOfrTobCode());
				innerVO.setInfrOfrTobName(rtnMD0102DLList.get(i).getInfrOfrTobName());

				if (null != rtnMD0102DLList.get(i).getInstImgRoutName()) {
					innerVO.setImgRoutCntn(rtnMD0102DLList.get(i).getInstImgRoutName());
				} else {
					innerVO.setImgRoutCntn("����ڵ� ��Ī�Ǵ� �̹��� ������ ����");
				}
				innerVO.setInstLnknStcd(rtnMD0102DLList.get(i).getInstLnknStcd());
				innerList.add(innerVO);
			}
			resVO.setRespCode("00000");
			resVO.setRespMsg("����");
			resVO.setMode(rtnMD0102DLList.get(0).getScrnPrgsDtcd());
			resVO.setInstLnknStList(innerList);
		}
		return resVO;
	}

	/**
	* 1. MethodName        : mdB003ModLnknStatus
	* 2. ClassName         : MdB003ServiceImpl
	* 3. Comment           : �������� ���� ����
	* @SQLID               : mdbMD0102DLPU004
	* @APIM                : NONE
	* @author              : kyeong-min, Kim
	* @version             : 2022. 4. 12. ���� 4:31:06
	* @param
	* @return MdB003ModLnknStatusResVO
	* @throws Exception
	*/
	public MdB003ModLnknStatusResVO mdB003ModLnknStatus(MdB003TrnmReqCommonVO reqVO) {
		MdB003ModLnknStatusResVO resVO = new MdB003ModLnknStatusResVO();
		mdB003Mapper.mdbMD0102DLPU004(reqVO);
		resVO.setRespCode("00000");
		resVO.setRespMsg("����");
		return resVO;
	}

	/**
	* 1. MethodName        : mdB003GetMydataAPI
	* 2. ClassName         : MdB003ServiceImpl
	* 3. Comment           : �� ���̵����ͼ���
	* @SQLID               : NONE
	* @APIM                : NONE
	* @author              : kyeong-min, Kim
	* @version             : 2022. 4. 12. ���� 4:31:06
	* @param
	* @return MdB001MydtSrvcResVO
	* @throws Exception
	*/
	public MdB003IncaAthnTokenResVO mdB003GetMydataAPI() throws Exception {
		log.debug(sReq.toString());
		MdB003IncaAthnTokenResVO resVO = new MdB003IncaAthnTokenResVO();
		try {
//			commonService.excuteMydtApiCall(sReq);
		} catch (Exception e) {
			log.debug(e.getMessage());
			resVO.setRespCode("40401");
			resVO.setRespMsg("���� ����, ���� API ȣ�� ���� ���μ��� ����");
		}
		return resVO;
	}

	/**
	* 1. MethodName        : MdB003ServiceImpl
	* 2. ClassName         : MdB003ServiceImpl
	* 3. Comment           : �������� ���̿�, ���� ���� ����
	* @SQLID               : NONE
	* @APIM                : NONE
	* @author              : kyeong-min, Kim
	* @version             : 2022. 4. 12. ���� 4:31:06
	 * @param mydtInstCode2
	* @param
	* @return JSONObject
	* @throws Exception
	*/
	public JSONObject testTokenSet(String mydtInstCode) throws Exception {
		JSONObject jo = new JSONObject();

		// url ����
		final String url = this.baseUrl + "/oauth/2.0/token";
		String xApiTranId = CommonConstant.STRING_FORMAT_SPACE; // �� ���� �� �ŷ�������ȣ�ʱ�ȭ
		xApiTranId = MyDataUtil.getXapiTranId(kyoboMydtInstCode, CommonConstant.KYOBO_TYPE_CODE);

		// ��û ��� ����
		/*******************************************************
		 * 3. ��û �׸� ����
		 *******************************************************/
		HttpHeaders reqHeaders = new HttpHeaders();
		reqHeaders.add("x-api-tran-id", xApiTranId); // �ŷ�������ȣ(25)
		reqHeaders.add("Content-Type", "application/x-www-form-urlencoded"); // �ŷ�������ȣ(25)
		reqHeaders.add(CommonConstant.CODE_STRING_X_FSI_UTCT_TYPE, "TGC00001"); // ������ū("Bearer" ������ ���)
		reqHeaders.add("X-FSI-SVC-DATA-KEY", "Y"); // ������ū("Bearer" ������ ���)

		RestTemplate restTemplate = new RestTemplate();

		MultiValueMap<String, String> reqParam = new LinkedMultiValueMap<String, String>();
		reqParam.add("org_code", mydtInstCode);
		reqParam.add(CommonConstant.CODE_STRING_GRANT_TYPE, CommonConstant.GRANT_TYPE);
		reqParam.add("code", "0000017f-0c0e-da87-0000-017f0c0eda88");
		reqParam.add("client_id", tbdClientId);
		reqParam.add("client_secret", tbdClientSecret);
		reqParam.add("redirect_uri", kyoboRedirectUrl);

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(reqParam,
				reqHeaders);

		UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build(false);

		ResponseEntity<String> rtnEntity = restTemplate.exchange(uri.toString(), // ��û�� �ּ�
				HttpMethod.POST, // ��û ���
				entity, // ��û�Ҷ� ���� ������
				String.class);

		if (HttpStatus.OK.equals(rtnEntity.getStatusCode())) {
			String resData = (String) rtnEntity.getBody();
			jo = new JSONObject(resData);
			log.debug("jo :::::::::" + jo.toString());
		}
		return jo;
	}
}
