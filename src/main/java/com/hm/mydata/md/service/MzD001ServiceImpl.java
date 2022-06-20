package com.hm.mydata.md.service;

import org.springframework.stereotype.Service;

import com.hm.mydata.base.service.BaseService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 1. ClassName : MzD001ServiceImpl
 * 2. FileName  : MzD001ServiceImpl.java
 * 3. Package   : kmds.mz.d.service
 * 4. Comment   : 怨듯넻 �꽌鍮꾩뒪
 * @author      : hyun-wook, Kim
 * @version     : 2022. 4. 12. �삤�썑 1:18:51
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MzD001ServiceImpl extends BaseService {
/*
	@Autowired
	private final MzD001Mapper mzd001mapper;

	public MzD001ResVO excuteMydtApiCall(MzD001ReqVO reqParam) throws Exception {
		log.info("留덉씠�뜲�씠�꽣 �닔吏� : excuteMydtApiCall Start");
		MzD001ResVO resVO = new MzD001ResVO();

		// 濡쒓렇�씤 �떆, �삤�뒛 濡쒓렇�씤�떆 �닔吏� �떎�뻾�궡�뿭 �솗�씤
		// �떎�뻾 1�쉶 �븯���떎硫�, return

		// �닔吏묒꽌踰� �샇異�
		String targetUrl = this.gatherUrl;

		Map<String, Object> params = objectMapper.convertValue(reqParam, new TypeReference<Map<String, Object>>() {});
		Mono<String> result = this.callAsyncPostMethod(targetUrl, "/mj/get-mydata-gathering", params);
		result.subscribe(res -> {
			LocalDateTime asyncrestime = LocalDateTime.now();
			log.debug("1. �닔吏멇PI 鍮꾨룞湲� �쓳�떟�떆媛� : " + asyncrestime);
			log.info("1. �닔吏멇PI 鍮꾨룞湲� �쓳�떟 : " + res);
			JSONObject rtnJson = null;
			String rspCode = CommonConstant.STRING_FORMAT_SPACE;
			try {
				rtnJson = new JSONObject(res);
				rspCode = rtnJson.getString("respCode");
			} catch (JSONException e) {
				log.debug(e.getMessage());
			}

			// 鍮꾨룞湲� �쓳�떟 �씠�썑, �쟾�넚�슂援ъ쭅�썑�씤 �샇異쒖뿉 ���븳 泥섎━
			if (reqParam != null) {
				if ("user-consent".equals(reqParam.getApiType())) {
					commonService.modMbrStatus(reqParam.getCsno());

					// MD_�쟾�넚�슂援ш린蹂�(MD0101MS)
					if (reqParam.getTrnmReqPtcd() == null) {
						commonService.regTrnmCmplYn(reqParam.getCsno(), "1");
					} else {
						commonService.regTrnmCmplYn(reqParam.getCsno(), reqParam.getTrnmReqPtcd());
					}

				}
			}

			if("00000".equals(rspCode)) {
				// �넻�빀�씤利� s1�씠 �븘�땺�븣
				if (!"0".equals(reqParam.getTrnmReqPtcd())) {
					// �쟾泥댁쭛怨껦PI �샇異�
					Mono<String> astAgrgDscrCall = this.callAsyncPostMethod(targetUrl, "/mj/reg-mydata-agrg", params);
					astAgrgDscrCall.subscribe(astAgrgDscrCallRes -> {
						log.debug("1. 吏묎퀎API 鍮꾨룞湲� �쓳�떟�떆媛� : " + astAgrgDscrCallRes);
						log.info("吏묎퀎API �쓳�떟 :: " + astAgrgDscrCallRes.toString());
					});
				}
			}
		}, e -> {
			log.error("�뿉�윭�쓳�떟 : " + e.getMessage());
		});

		LocalDateTime apirestime = LocalDateTime.now();
		log.debug("api�쓳�떟�떆媛� : " + apirestime);
		resVO.setRespCode("00000");
		resVO.setRespMsg("怨좉컼 �닔吏� API �샇異� �꽦怨�");
		return resVO;
	}

	public int regTrnmCmplYn(String csno, String trnmReqPtcd) {
		int iRet = 0;

		if (csno != null) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("csno", csno);
			map.put("trnmReqPtcd", trnmReqPtcd);

			if ("0".equals(trnmReqPtcd)) {
				iRet += mzd001mapper.mzdMD0101MSPU001(map);
			} else {
				iRet += mzd001mapper.mzdMD0101MSPU002(map);
			}
		}

		return iRet;
	}

	public MdBMA1000MS modMbrStatus(String csno) {
		MdBMA1000MS rtnMA1000MS = null;
		rtnMA1000MS = mzd001mapper.mzdMA1000MSPS001(csno);

		if (StringUtil.isNull(rtnMA1000MS)) {
			log.error("�깉�눜�쉶�썝 �엯�땲�떎.");
			// �깉�눜�쉶�썝
		} else {

			if ("02".equals(rtnMA1000MS.getMydtMbrStcd()) && "10".equals(rtnMA1000MS.getMydtMbrDtcd())) {
				// 留덉씠�뜲�씠�꽣�꽌鍮꾩뒪 媛��엯�쉶�썝(02) �씠硫댁꽌 以��쉶�썝(10)�씤寃쎌슦, >> �젙�쉶�썝泥섎━ �봽濡쒖꽭�뒪
				String linkCnt = mzd001mapper.mzdMD0102DLPS001(csno);
				// �뿰寃곕맂 �옄�궛 議댁옱�븷 寃쎌슦
				if (!"0".equals(linkCnt)) {
					MdBMA1000MS req = new MdBMA1000MS();
					req.setEdtrId(CommonConstant.CODE_STRING_NFTF);
					req.setCsno(csno);
					req.setMydtMbrDtcd("20");
					mzd001mapper.mzdMA1000MSPU001(req);
				}


			} else if ("02".equals(rtnMA1000MS.getMydtMbrStcd()) && "20".equals(rtnMA1000MS.getMydtMbrDtcd())) {
				// 留덉씠�뜲�씠�꽣�꽌鍮꾩뒪 媛��엯�쉶�썝(02) �씠硫댁꽌 �젙�쉶�썝(20)�씤寃쎌슦,
				String linkCnt = mzd001mapper.mzdMD0102DLPS001(csno);
				// �뿰寃곕맂 �옄�궛 議댁옱�븯吏��븡�쓣 寃쎌슦
				if ("0".equals(linkCnt)) {
					MdBMA1000MS req = new MdBMA1000MS();
					req.setEdtrId(CommonConstant.CODE_STRING_NFTF);
					req.setCsno(csno);
					req.setMydtMbrDtcd("10");
					mzd001mapper.mzdMA1000MSPU002(req);
				}
			}
		}

		return rtnMA1000MS;
	}

	public String getSysdateYMDHMS() {
		String sysDate = mzd001mapper.mzdDUALPS001();
		return sysDate;
	}

	public void regGatheringLog(MzDMD1115TR inMD1115TR) {
		inMD1115TR.setInfrOfrVrsnName("v1");
		inMD1115TR.setRgsnId(CommonConstant.CODE_STRING_NFTF);
		inMD1115TR.setEdtrId(null);
		mzd001mapper.mzdMD1115TRPI001(inMD1115TR);
	}

	public void excuteRecvCall(String url, MzD001ReqVO reqVO) {
		RestTemplate restTemplate = new RestTemplate();
		log.debug("###############!!" + reqVO.getCsno());
		try {
			restTemplate.postForObject(url, reqVO, String.class);
		} catch (Exception e) {
			log.error("MzD001ServiceImpl.excuteRecvCall", e.getMessage());
		}
	}

	public MdBMD1111MS getTargetDomain(String mydtInstCode) {
		MdBMD1111MS rtnVO = mzd001mapper.mdbMD1111MSPS003(mydtInstCode);
		return rtnVO;

	}

	public MzD001TargetInfoVO getServerDivValue(Map<String, String> divInfo) {
		MzD001TargetInfoVO targetInfoVO = new MzD001TargetInfoVO();
		// reqValue
		String serverMode = CommonConstant.STRING_FORMAT_SPACE;
		String mydtInstCode = CommonConstant.STRING_FORMAT_SPACE;

		// resVariable
		String targetDomain = CommonConstant.STRING_FORMAT_SPACE;
		String clientId = CommonConstant.STRING_FORMAT_SPACE;
		String clientSecret = CommonConstant.STRING_FORMAT_SPACE;
		String mydtInstName = CommonConstant.STRING_FORMAT_SPACE;
		MdBMD1111MS rtnTarget = null;

		if(null != divInfo) {
			serverMode = divInfo.get("serverMode");
			mydtInstCode = divInfo.get("mydtInstCode");
		}

		rtnTarget = getTargetDomain(mydtInstCode);
		mydtInstName = rtnTarget.getMydtInstName();
		if("dev".equals(serverMode) || "local".equals(serverMode)) {
			if("C1AACS0000".equals(mydtInstCode)) {
				// 媛쒕컻�솚寃� 援먮낫利앷텒�씪 寃쎌슦
				targetDomain = rtnTarget.getMapiSrvrDomaName();
				clientId = kyoboMydtSrvcClotClientId;
				clientSecret = kyoboMydtSrvcClotClientSecret;
			} else {
				if(null != rtnTarget) {
					targetDomain = tbdTargetDomain;
					clientId = tbdClientId;
					clientSecret = tbdClientSecret;
				}
			}

		} else if("test".equals(serverMode)) {
			final List<String> tbdInstCodeList = new ArrayList<String>(Arrays.asList("A1AAER0000", "D1AAEV0000", "E1AAAX0000", "F1AAAU0000"
					                                                               , "G1AAFR0000", "L1AARR0000", "D3AADZ0000", "C1AAEY0000"
					                                                               , "E1AAPU0000", "A1AAEQ0000", "D1AAEQ0000", "D1AABJ0000"
					                                                               , "E1AAIA0000", "B1AAFP0000", "D1AAAF0000"));


			if(uatForceMode && tbdInstCodeList.contains(mydtInstCode)) {
				targetDomain = tbdTargetDomain;
				clientId = tbdClientId;
				clientSecret = tbdClientSecret;
			} else {
				if(null != rtnTarget) {
					targetDomain = rtnTarget.getMapiSrvrDomaName();
					clientId = kyoboMydtSrvcClotClientId;
					clientSecret = kyoboMydtSrvcClotClientSecret;
				}
			}

		} else {
			if(null != rtnTarget) {
				targetDomain = rtnTarget.getMapiSrvrDomaName();
				clientId = kyoboMydtSrvcClotClientId;
				clientSecret = kyoboMydtSrvcClotClientSecret;
			}
		}

		targetInfoVO.setClientId(clientId);
		targetInfoVO.setClientSecret(clientSecret);
		targetInfoVO.setTargetDomain(targetDomain);
		targetInfoVO.setMydtInstName(mydtInstName);
		return targetInfoVO;

	}

	public String getState(String mydtInstCode) {

		SecureRandom rnd = new SecureRandom();
		int fnum = rnd.nextInt(9999);
		int snum = rnd.nextInt(99999);

		String Dttm = DateUtil.getMillisecond();
		String fLpad = StringUtil.lpad( Integer.toString(fnum), 4, "0");
		String sLpad = StringUtil.lpad( Integer.toString(snum), 5, "0");

		return mydtInstCode + "_" + Dttm + fLpad + sLpad;
	}


*/
}
