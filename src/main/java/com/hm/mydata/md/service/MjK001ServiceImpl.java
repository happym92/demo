package com.hm.mydata.md.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 1. ClassName : MjK001ServiceImpl
 * 2. FileName  : MjK001ServiceImpl.java
 * 3. Package   : kmds.mj.k.service
 * 4. Comment   : 吏��썝愿��젴 API
 * @author      : kyeong-min, Kim
 * @version     : 2022. 4. 11. �삤�썑 4:12:12
 */
@Slf4j
@Service
public class MjK001ServiceImpl {
//
//	@Autowired
//	private final MjK001Mapper mjK001Mapper;
//	/**
//	 * 1. MethodName        : mjK001GetSupportToken
//	 * 2. ClassName         : MjK001ServiceImpl
//	 * 3. Comment           : 吏��썝-001
//	 * @SQLID               : mjkMD1110MSPS001
//	 * @APIM                : support-001
//	 * @author              : kyeong-min, Kim
//	 * @version             : 2022. 4. 21. �삤�썑 5:55:37
//	 * @return Map<String, Object>
//	 * @param
//	 * @throws Exception
//	 */
//	public Map<String, Object> mjK001GetSupportToken() throws Exception {
//
//		/*********************************************
//		 * 吏��썝-001 吏��썝API�슜 �젒洹쇳넗�겙 諛쒓툒
//		 * Target : 醫낇빀�룷�꽭
//		 * Content-Type[request] : application/x-www-form-urlencoded
//		 * Content-Type[response] : application/json; charset=UTF-8
//		 *********************************************/
//		Map<String, Object> rtnMap = new HashMap<String, Object>();                                   // API 由ы꽩留�
//		String url = "/mgmts/OAuthorization/2.0/token";                                               // APIM API Path
//		String tranId =  MyDataUtil.getXapiTranId(kyoboMydtInstCode, CommonConstant.KYOBO_TYPE_CODE); // 嫄곕옒怨좎쑀踰덊샇
//
//		/*********************************************
//		 * �슂泥�硫붿떆吏� �꽕�젙
//		 *********************************************/
//		Map<String, String> reqHeaders = new LinkedHashMap<String, String>();
//		reqHeaders.put("x-api-tran-id"   , tranId);                              // 嫄곕옒怨좎쑀踰덊샇
//		reqHeaders.put("gtw-custom-url"  , supportApiTargetUrl);                 // APIM Target Domain set
//
//		Map<String, Object> reqParams = new LinkedHashMap<String, Object>();
//		reqParams.put("grant_type",    CommonConstant.SUPPORT_GRANT_TYPE);       // 沅뚰븳遺��뿬諛⑹떇
//		reqParams.put("client_id",     supportApiClientId);                      // �겢�씪�씠�뼵�듃ID
//		reqParams.put("client_secret", supportApiClientSecret);                  // �겢�씪�씠�뼵�듃Secert
//		reqParams.put("scope",         CommonConstant.SUPPORT_SCOPE);            // 沅뚰븳踰붿쐞
//
//		/*********************************************
//		 * 吏��썝-001 API �샇異�
//		 *********************************************/
//		MjCommonResVO resData = super.httpPostSupportAPICall(url, reqHeaders, reqParams, "FORM", CommonConstant.SUPPORT_DTCD_001);
//
//		if (resData != null && !"".equals(resData.getResData())) {
//			// 由ы꽩諛쏆쓣 寃곌낵媛믪쓣 VO濡� 蹂��솚�븳�떎.
//			Gson gson = new Gson();
//			MjK001ResVO resVO = gson.fromJson(resData.getResData(), MjK001ResVO.class);
//
//			// �젙�긽�쓳�떟
//			MjKMD1110MS inMD1110MS = new MjKMD1110MS();
//			String srnoTlms = mjK001Mapper.mjkMD1110MSPS001();
//
//			inMD1110MS.setSprgMapiDtcd(CommonConstant.SUPPORT_DTCD_001); // 吏��썝-001 肄붾뱶媛� 怨좎젙
//			inMD1110MS.setSrnoTlms(srnoTlms);
//			inMD1110MS.setAcesTokenPtrnName(resVO.getToken_type());
//			inMD1110MS.setAcesTokenTlms(resVO.getAccess_token());
//			inMD1110MS.setAcesTokenVldTerm(resVO.getExpires_in());
//			inMD1110MS.setAthrRngTlms(resVO.getScope());
//			inMD1110MS.setRgsnId("NFTF");
//			inMD1110MS.setUseYn("Y");
//			mjK001Mapper.mjkMD1110MSPI001(inMD1110MS);
//
//			inMD1110MS.setSrnoTlms(srnoTlms);
//			inMD1110MS.setEdtrId("NFTF");
//			inMD1110MS.setUseYn("N");
//			mjK001Mapper.mjkMD1110MSPU001(inMD1110MS);
//		}
//		return rtnMap;
//	}
//
//	/**
//	 * 1. MethodName        : mjK001GetInstList
//	 * 2. ClassName         : MjK001ServiceImpl
//	 * 3. Comment           : 吏��썝-002
//	 * @SQLID               : mjkMD1113DLPD001, mjkMD1113DLPI001, mjkMD1111MSPD001, mjkMD1112DLPD001
//	 *                        mjkMD1111MSPI001
//	 * @APIM                : support-002
//	 * @author              : kyeong-min, Kim
//	 * @version             : 2022. 4. 25. �삤�썑 5:55:37
//	 * @param token
//	 * @return Map<String, Object>
//	 * @param
//	 * @throws Exception
//	 */
//	public Map<String, Object> mjK001GetInstList() throws Exception {
//		Map<String, Object> rtnMap = new HashMap<String, Object>();
//		MjKMD1110MS rtnToken = null;
//		String url = "/v1_mgmts/orgs";
//
//		//�넗�겙議고쉶 : �궗�슜�뿬遺� Y�씤 �넗�겙 �뾾�쓣 寃쎌슦 PASS
//		MjKMD1110MS inMD1110MS = new MjKMD1110MS();
//		rtnToken = mjK001Mapper.mjkMD1110MSPS002(inMD1110MS);
//		if(null != rtnToken) {
//			String tranId =  MyDataUtil.getXapiTranId(kyoboMydtInstCode, CommonConstant.KYOBO_TYPE_CODE); // 醫낇빀�룷�꽭 湲곌�肄붾뱶
//
//			// �뿤�뜑 SET
//			Map<String, String> reqHeaders = new LinkedHashMap<String, String>();
//			reqHeaders.put("Authorization"   , "Bearer " + rtnToken.getAcesTokenTlms());
//			reqHeaders.put("x-api-tran-id"   , tranId);
//			reqHeaders.put("gtw-custom-url"  , supportApiTargetUrl);
//
//			// BODY SET
//			Map<String, String> reqParams = new LinkedHashMap<String, String>();
//			reqParams.put(CommonConstant.CODE_STRING_SEARCH_TIMESTAMP, CommonConstant.NUMBER_FORMAT_ZERO);
//
//			MjCommonResVO resData = super.httpGetSupportAPICall(url, reqParams, reqHeaders, "JSON", CommonConstant.SUPPORT_DTCD_002);
//			if ( resData != null && !"".equals(resData.getResData())) {
//				// 由ы꽩諛쏆쓣 寃곌낵媛믪쓣 VO濡� 蹂��솚�븳�떎.
//				Gson gson = new Gson();
//				MjK002ResVO resVO = gson.fromJson(resData.getResData(), MjK002ResVO.class);
//
//				if("00000".equals(resVO.getRsp_code())){
//
//					for( OrgVO org : resVO.getOrg_list()) {
//						MjKMD1111MS inInstVO = new MjKMD1111MS();
//						MjKMD1112DL inIp01VO = new MjKMD1112DL();
//						MjKMD1112DL inIp02VO = new MjKMD1112DL();
//						MjKMD1113DL inNpVO = new MjKMD1113DL();
//
//						inInstVO.setMydtInstCode(org.getOrg_code());
//						inInstVO.setMydtInfrRgstDtcd(org.getOp_type());
//						inInstVO.setMydtInstName(org.getOrg_name());
//						inInstVO.setMydtInstDtcd(org.getOrg_type());
//						if("true".equals(org.getIs_rcv_org())) {
//							inInstVO.setInfrRecrYn("Y");
//						} else if("false".equals(org.getIs_rcv_org())){
//							inInstVO.setInfrRecrYn("N");
//						} else {
//							inInstVO.setInfrRecrYn(null);
//						}
//						inInstVO.setBrno(org.getOrg_regno());
//						inInstVO.setCgno(org.getCorp_regno());
//						inInstVO.setTlsAtshSrno(org.getSerial_num());
//						inInstVO.setMydtInstAddr(org.getAddress());
//						inInstVO.setMapiSrvrDomaName(org.getDomain());
//						inInstVO.setRlayMydtInstCode(org.getRelay_org_code());
//						inInstVO.setInfrOfrTobCode(org.getIndustry());
//						inInstVO.setInfrOfrAthnWayCode(org.getAuth_type());
//						inInstVO.setIntgAthnInstDn(org.getCert_issuer_dn());
//						inInstVO.setAlwnIntgAtshOid(org.getCert_oid());
//
//						if(!"0".equals(org.getNp_time_cnt()) && null != org.getNp_time_cnt()) {
//							inNpVO.setMydtInstCode(org.getOrg_code());
//							mjK001Mapper.mjkMD1113DLPD001(inNpVO);
//							for( NpTimeVO np : org.getNp_time_list()) {
//								inNpVO.setTrnmAbleHourTlms(np.getNp_time());
//								mjK001Mapper.mjkMD1113DLPI001(inNpVO);
//							}
//						}
//
//						if("D".equals(org.getOp_type())) {
//							/*
//							 * 湲곌��젙蹂댁쓽 �궘�젣嫄�
//							 * 1. �빐�떦 湲곌�肄붾뱶濡� DELETE : MD1111MS, MD1112DL, MD1113DL
//							 */
//							mjK001Mapper.mjkMD1111MSPD001(inInstVO);
//							inIp01VO.setMydtInstCode(org.getOrg_code());
//							mjK001Mapper.mjkMD1112DLPD001(inIp01VO);
//							inNpVO.setMydtInstCode(org.getOrg_code());
//							mjK001Mapper.mjkMD1113DLPD001(inNpVO);
//
//						} else if ("I".equals(org.getOp_type())) {
//							/*
//							 * 湲곌��젙蹂댁쓽 �떊洹쒓굔
//							 * 1. 湲곌�肄붾뱶濡� DELETE : MD1111MS, MD1112DL, MD1113DL
//							 * 2. 湲곌�肄붾뱶濡� INSERT : MD1111MS, MD1112DL, MD1113DL
//							 */
//
//							// MD1111MS �쟻�옱
//							mjK001Mapper.mjkMD1111MSPD001(inInstVO);
//							mjK001Mapper.mjkMD1111MSPI001(inInstVO);
//
//
//							if(!"0".equals(org.getDomain_ip_cnt()) && null != org.getDomain_ip_cnt()) {
//								inIp01VO.setMydtInstCode(org.getOrg_code());
//								inIp01VO.setMydtIpDtcd("01");
//								mjK001Mapper.mjkMD1112DLPD001(inIp01VO);
//								for( DomainVO domain : org.getDomain_ip_list()) {
//									inIp01VO.setIp(domain.getDomain_ip());
//									mjK001Mapper.mjkMD1112DLPI001(inIp01VO);
//								}
//							}
//
//							if(!"0".equals(org.getIp_cnt()) && null != org.getIp_cnt()) {
//								inIp02VO.setMydtInstCode(org.getOrg_code());
//								inIp02VO.setMydtIpDtcd("02");
//								mjK001Mapper.mjkMD1112DLPD001(inIp02VO);
//								for( IpVO ip : org.getIp_list()) {
//									inIp02VO.setIp(ip.getIp());
//									mjK001Mapper.mjkMD1112DLPI001(inIp02VO);
//								}
//							}
//
//						} else if ("M".equals(org.getOp_type())) {
//							log.debug("湲곌��젙蹂댁쓽 �닔�젙嫄�");
//							/*
//							 * 湲곌��젙蹂댁쓽 �닔�젙嫄�
//							 * 1. �빐�떦 湲곌�肄붾뱶濡� UPDATE : MD1111MS, MD1112DL, MD1113DL
//							 */
//						}
//					}
//				} else if ("00001".equals(resVO.getRsp_code())) {
//					log.debug("UP_TO_DATE");
//					log.error("UP_TO_DATE");
//					// UP_TO_DATE
//				}
//
//			}
//		}
//		return rtnMap;
//	}
////	/**//	 * 1. MethodName        : mjK001SendStatisticsData//	 * 2. ClassName         : MjK001ServiceImpl//	 * 3. Comment           : 留덉씠�뜲�씠�꽣 �궗�뾽�옄 �넻怨꾩옄猷� �쟾�넚//	 * @APIID               : MJK-0.4//	 * @SQLID               : mjkMD1201TRPS001, mjkMD1202DLPS001//	 * @APIM                : support-004//	 * @author              : Kyeong-min, Kim//	 * @version             : 2022. 5. 25. �삤�썑 14:00:00//	 * @return MjK004ResVO//	 * @param NONE//	 *///	public MjK004ResVO mjK001SendStatisticsData() throws Exception {
//		MjK004ResVO resVO = new MjK004ResVO();
//
//		MjK004ReqVO depth1 = new MjK004ReqVO();
//		StatDateVO depth2 = new StatDateVO();
//		OfferOrgVO depth3 = new OfferOrgVO();
//		ApiTypeVO depth4 = new ApiTypeVO();
//		TmSlotVO depth5 = new TmSlotVO();
//
//		List<StatDateVO> statDateList = new ArrayList<MjK004ReqVO.StatDateVO>();
//		List<OfferOrgVO> offerOrgList = new ArrayList<MjK004ReqVO.StatDateVO.OfferOrgVO>();
//		List<ApiTypeVO> apiTypeList = new ArrayList<MjK004ReqVO.StatDateVO.OfferOrgVO.ApiTypeVO>();
//		List<TmSlotVO> tmSlotList = new ArrayList<MjK004ReqVO.StatDateVO.OfferOrgVO.ApiTypeVO.TmSlotVO>();
//
//		List<String> typeList = new ArrayList<String>();
//		typeList.add("1");
//		typeList.add("2");
//
//		// 1. type�뿉 �뵲瑜� �넻怨꾩옄猷뚯쟾�넚
//		for(String type : typeList) {
//			log.debug("type ##" +type);
//			depth1 = new MjK004ReqVO();
//			statDateList = new ArrayList<MjK004ReqVO.StatDateVO>();
//			offerOrgList = new ArrayList<MjK004ReqVO.StatDateVO.OfferOrgVO>();
//			apiTypeList = new ArrayList<MjK004ReqVO.StatDateVO.OfferOrgVO.ApiTypeVO>();
//			tmSlotList = new ArrayList<MjK004ReqVO.StatDateVO.OfferOrgVO.ApiTypeVO.TmSlotVO>();
//
//			String inquiryDate = DateUtil.getToday("yyyyMMdd");
//			inquiryDate = "20220522";
//			MjKMD1202DL inMD1202DL = new MjKMD1202DL();
//			inMD1202DL.setType(type);
//			inMD1202DL.setInquiryDate(inquiryDate);
//
//
//			// 1201 議고쉶遺�
//			List<MjKMD1201TR> baseDataList = new ArrayList<MjKMD1201TR>();
//			List<MjKMD1201TR> offerStstList = mjK001Mapper.mjkMD1201TRPS001(inMD1202DL);
//			baseDataList = offerStstList.stream().filter(MyDataUtil.distinctByKey(o -> o.getBaseDate())).collect(Collectors.toList());
//
//			// 1202 議고쉶遺�
//			List<MjKMD1202DL> apiList = mjK001Mapper.mjkMD1202DLPS001(inMD1202DL);
//
//			// 2. 議고쉶�맂 �넻怨� �뜲�씠�꽣 1201/1202 �럞�뒪�뙆�떛
//			for (MjKMD1201TR out : baseDataList) {
//				depth2 = new StatDateVO();
//				offerOrgList = new ArrayList<MjK004ReqVO.StatDateVO.OfferOrgVO>();
//
//				depth2.setStat_date(out.getBaseDate()); // 湲곗�
//				depth2.setOrg_cnt(out.getInfoOfferCnt());
//
//				// �넻怨꾩씪�옄濡� �븘�꽣 �썑 媛� �넻怨꾩씪�옄蹂� vo濡� set
//				List<MjKMD1201TR> filterList = offerStstList.stream().filter(h -> h.getBaseDate().contains(out.getBaseDate())).collect(Collectors.toList());
//
//				for (MjKMD1201TR outf : filterList) {
//					apiTypeList = new ArrayList<MjK004ReqVO.StatDateVO.OfferOrgVO.ApiTypeVO>();
//					depth3 = new OfferOrgVO();
//					depth3.setOrg_code(outf.getMydtInstCode());
//					depth3.setConsent_new(outf.getTrnmReqDmndTmcn());
//					depth3.setConsent_revoke(outf.getTrnmReqRclTmcn());
//					depth3.setConsent_own(outf.getTrnmReqVldTmcn());
//
//					// �쁽�옱 1201 由ъ뒪�듃�쓽 湲곌�肄붾뱶瑜� 湲곗��쑝濡� 1202 �뜲�씠�꽣 留듯븨 ( ex, �뀒�뒪�듃 �뜲�씠�꽣�씤 �궗�쑀濡�? 1201�뿉�뒗 �엳�쑝硫�, 1202�뿉�뒗 �뾾�쓬. �젙�빀�꽦 �뙋�떒�븷 寃� )
//					List<MjKMD1202DL> instFilterList = apiList.stream()
//							                                  .filter(h -> h.getBaseDate().contains(out.getBaseDate()))
//							                                  .filter(h -> h.getMydtInstCode().contains(outf.getMydtInstCode()))
//							                                  .filter(MyDataUtil.distinctByKey(o -> o.getMydtInstCode()))
//							                                  .collect(Collectors.toList());
//
//					// 諛섎났臾� �븘�슂�쑀臾� �씪�옄-湲곌�-cnt �궎
//					for(MjKMD1202DL outApi : instFilterList) {
//						depth3.setApi_type_cnt(outApi.getMapiDtCnt());
//					}
//
//
//					// 4�럞�뒪
//					List<MjKMD1202DL> apiTypeFilterList = apiList.stream()
//							                                     .filter(h -> h.getBaseDate().contains(out.getBaseDate()))
//							                                     .filter(h -> h.getMydtInstCode().contains(outf.getMydtInstCode()))
//							                                     .filter(MyDataUtil.distinctByKey(o -> o.getMapiDtcd()))
//							                                     .collect(Collectors.toList());
//					log.debug("湲곌�i : " + outf.getMydtInstCode());
//					for(MjKMD1202DL outapi : apiTypeFilterList) {
//						depth4 = new ApiTypeVO();
//						tmSlotList = new ArrayList<MjK004ReqVO.StatDateVO.OfferOrgVO.ApiTypeVO.TmSlotVO>();
//						depth4.setApi_type(outapi.getMapiDtcd());
//						depth4.setTm_slot_cnt("2");
//
//						List<MjKMD1202DL> tmFilterList = apiList.stream()
//											                     .filter(h -> h.getBaseDate().contains(out.getBaseDate()))
//											                     .filter(h -> h.getMydtInstCode().contains(outf.getMydtInstCode()))
//											                     .filter(h -> h.getMapiDtcd().contains(outapi.getMapiDtcd()))
//											                     .collect(Collectors.toList());
//						for (MjKMD1202DL outtm : tmFilterList) {
//							depth5 = new TmSlotVO();
//							depth5.setTm_slot(outtm.getMydtStstHourDtcd());
//							depth5.setRsp_avg(outtm.getAvrgRespHour());
//							depth5.setRsp_total(outtm.getSumRespHour());
//							depth5.setRsp_stdev(outtm.getRespHourStdtIndx());
//							depth5.setSuccess_api_cnt(outtm.getMapiClotScsTmcn());
//							depth5.setFail_api_cnt(outtm.getMapiClotFalrTmcn());
//							tmSlotList.add(depth5);
//						}
//
//						depth4.setTm_slot_list(tmSlotList);
//						apiTypeList.add(depth4);
//
//					}
//
//					depth3.setApi_type_list(apiTypeList);
//
//					offerOrgList.add(depth3);
//				}
//
//				depth2.setOrg_list(offerOrgList);
//
//				// 理쒖쥌
//				statDateList.add(depth2);
//			}
//
//			depth1.setStat_date_list(statDateList);
//
//			log.debug("size    "  + depth1.getStat_date_list().size());
//			//�넗�겙議고쉶 : �궗�슜�뿬遺� Y�씤 �넗�겙 �뾾�쓣 寃쎌슦 PASS
//			MjKMD1110MS inMD1110MS = new MjKMD1110MS();
//			MjKMD1110MS rtnToken = mjK001Mapper.mjkMD1110MSPS002(inMD1110MS);
//
//			Map<String, Object> rtnMap = new HashMap<String, Object>();
//			String url = "/v1_mgmts/statistics/mydata";
//			String tranId =  MyDataUtil.getXapiTranId(kyoboMydtInstCode, CommonConstant.KYOBO_TYPE_CODE); // 醫낇빀�룷�꽭 湲곌�肄붾뱶
//
//			// �뿤�뜑 SET
//			Map<String, String> reqHeaders = new LinkedHashMap<String, String>();
//			reqHeaders.put("Authorization"   , "Bearer " + rtnToken.getAcesTokenTlms());
//			reqHeaders.put("x-api-tran-id"   , tranId);
//			reqHeaders.put("gtw-custom-url"  , supportApiTargetUrl);
//
//			// BODY SET
//			Map<String, Object> reqParams = new LinkedHashMap<String, Object>();
//			reqParams.put("client_id",     kyoboMydtSrvcClotClientId);
//			reqParams.put("type",          type);
//			reqParams.put("inquiry_date",  inquiryDate);
//			reqParams.put(CommonConstant.CODE_STRING_STAT_DATE_CNT,  CommonConstant.CODE_STRING_7);
//			reqParams.put("stat_date_list", depth1.getStat_date_list());
//
//			depth1.setClient_id(kyoboMydtSrvcClotClientId);
//			depth1.setType(type);
//			depth1.setInquiry_date(inquiryDate);
//			depth1.setStat_date_cnt("7");
//
//			Map<String, Object> params = objectMapper.convertValue(depth1,
//					new TypeReference<Map<String, Object>>() {
//			});
//
//			log.debug(params.toString());
//			MjCommonResVO resData = super.httpPostSupportAPICall(url, reqHeaders, params, "JSON", CommonConstant.SUPPORT_DTCD_004);
//
//			JSONObject resJson = new JSONObject(resData.getResData());
//			resVO.setRsp_code(resJson.getString("rsp_code"));
//			resVO.setRsp_msg(resJson.getString("rsp_msg"));
//		}
//
//		return resVO;
//	}
//
//    /**
//     * 1. MethodName        : mjK001GetOfferApiList
//     * 2. ClassName         : MjK001ServiceImpl
//     * 3. Comment           : 怨듯넻-001
//     * @APIID               : MJK-1.0
//     * @SQLID               : mjkMD1111MSPS001, mjkMD1111MSPU001, mjkMD1117DLPD001, mjkMD1117DLPI001
//     * @APIM                : apis-[]
//     * @author              : Kyeong-min, Kim
//     * @version             : 2022. 5. 25. �삤�썑 14:00:00
//     * @return MjK004ResVO
//     * @param NONE
//     */
//	public MjK004ResVO mjK001GetOfferApiList() throws Exception {
//		List<MjKMD1111MS> instList = null;
//		String clientId = CommonConstant.STRING_FORMAT_SPACE;
//		String targetDomain = CommonConstant.STRING_FORMAT_SPACE;
//		String mydtInstCode = CommonConstant.STRING_FORMAT_SPACE;
//
//		// 湲곌�紐⑸줉 議고쉶
//		instList = mjK001Mapper.mjkMD1111MSPS001();
//		if(null != instList) {
//			for(MjKMD1111MS outVO : instList) {
//				mydtInstCode = outVO.getMydtInstCode();
//				//�뀒�뒪�듃
//				if(!"C1AACS0000".equals(mydtInstCode) && !"B1AAAI0000".equals(mydtInstCode) &&
//				   !"A1AAEM0000".equals(mydtInstCode) && !"A1AAES0000".equals(mydtInstCode) &&
//				   !"A1AAII0000".equals(mydtInstCode)) {
//					continue;
//
//				}
//				log.debug("�넻怨�! " + mydtInstCode);
//
//				String url = "/apis/" + outVO.getInfrOfrTobCode();
//				String tranId =  MyDataUtil.getXapiTranId(kyoboMydtInstCode, CommonConstant.KYOBO_TYPE_CODE); // 醫낇빀�룷�꽭 湲곌�肄붾뱶
//				log.info("�샇異�!! " + mydtInstCode + "> > " + url);
//				Map<String, String> reqHeaders = new LinkedHashMap<String, String>();
//				Map<String, String> reqParams = new LinkedHashMap<String, String>();
//				Map<String, String> reqTargetDivInfo = new HashMap<String, String>();
//				MjComonTargetInfoVO targetInfo = null;
//				/*********************************************
//				 * �꽌踰꾨え�뱶, 湲곌�肄붾뱶�뿉 �뵲瑜� �슂泥��젙蹂� 遺꾧린
//				 *********************************************/
//				log.info("serverMode > > " + serverMode);
//				log.info("mydtInstCode > > " + mydtInstCode);
//				reqTargetDivInfo.put("serverMode", serverMode);
//				reqTargetDivInfo.put("mydtInstCode", mydtInstCode);
//				targetInfo = commonService.getServerDivValue(reqTargetDivInfo);
//				if(null != targetInfo) {
//					targetDomain = targetInfo.getTargetDomain();
//					clientId = targetInfo.getClientId();
//				}
//
//				// target �뀒�뒪�듃踰좊뱶�씪 寃쎌슦
//				if(tbdTargetDomain.equals(targetDomain)) {
//					reqHeaders.put(CommonConstant.CODE_STRING_X_FSI_SVC_DATA_KEY   , CommonConstant.CODE_STRING_Y);
//					reqHeaders.put(CommonConstant.CODE_STRING_X_FSI_UTCT_TYPE      , CommonConstant.CODE_STRING_TGC00002);
//				}
//				reqHeaders.put("x-api-tran-id"        , tranId);
//				reqHeaders.put("gtw-custom-url"       , targetDomain);
//
//				reqParams.put("org_code"  , mydtInstCode);
//				reqParams.put("client_id" , clientId);
//
//				MjCommonResVO resData = new MjCommonResVO();
//				try {
//					resData = super.httpGetCall(url, reqHeaders, reqParams, "JSON", null, null);
//				} catch (RuntimeException e) {
//					log.info(e.getMessage());
//					log.info("mjK001GetOfferApiList > > Exception : " + e.getClass().getName() + " : " + e.getMessage());
//					continue;
//				}
//
//				log.debug("resData.toString() : " +resData.toString());
//				Gson gson = new Gson();
//				MjK001ApisResVO resVO = gson.fromJson(resData.getResData(), MjK001ApisResVO.class);
//				if ("00000".equals(resVO.getRsp_code())) {
//					resVO.getRsp_code();
//
//					outVO.setMapiVrsnName(resVO.getVersion());
//					outVO.setMapiCmpbVrsnName(resVO.getMin_version());
//					mjK001Mapper.mjkMD1111MSPU001(outVO);
//
//					mjK001Mapper.mjkMD1117DLPD001(outVO);
//					for(ApiVO in : resVO.getApi_list()) {
//						MjKMD1117DL inMD1117DL = new MjKMD1117DL();
//						inMD1117DL.setMydtInstCode(outVO.getMydtInstCode());
//						inMD1117DL.setMapiDtcd(in.getApi_code());
//						inMD1117DL.setMapiRoutName(in.getApi_uri());
//						mjK001Mapper.mjkMD1117DLPI001(inMD1117DL);
//
//					}
//				}
//			}
//
//		}
//
//		return null;
//	}
////	/**//	 * 1. MethodName        : mjK001ModToken//	 * 2. ClassName         : MjK001ServiceImpl//	 * 3. Comment           : �젒�겙�넗�겙 媛깆떊//	 * @APIID               : MJK-1.3//	 * @SQLID               : mjkMD1101DSPU001//	 * @APIM                : oauth-003//	 * @author              : kyeong-min, Kim//	 * @version             : 2022. 5. 25. �삤�썑 14:00:00//	 * @return MjK005ResVO//	 * @param NONE//	 *///	public MjK005ResVO mjK001ModToken() throws Exception {
//		MjK005ResVO resVO = new MjK005ResVO();
//		/*
//		   1. �젒洹쇳넗�겙 留뚮즺���긽 議고쉶
//		   2. 留뚮즺���긽 湲곌�蹂� 媛쒕퀎�씤利�-003 �샇異�
//		   3. 媛깆떊
//		*/
//		Map<String, Object> rtnMap = new HashMap<String, Object>();
//		String url = "/oauth/2.0/token";
//		String mydtInstCode = CommonConstant.STRING_FORMAT_SPACE;
//		String clientId = CommonConstant.STRING_FORMAT_SPACE;
//		String targetDomain = CommonConstant.STRING_FORMAT_SPACE;
//		String clientSecret = CommonConstant.STRING_FORMAT_SPACE;
//		int sucessCnt = 0;
//		int errCnt = 0;
//		List<MjComMD1101DS> tokenList = mjK001Mapper.mjkMD1101DSPS001();
//		if(!tokenList.isEmpty()) {
//			for(MjComMD1101DS token : tokenList) {
//				String refreshToken = token.getRfrsTokenTlms();
//				mydtInstCode = token.getMydtInstCode();
//				token.setMapiDtcd(CommonConstant.API_DISTIC_CODE_IDIVI_003);
//				token.setApiType("user-consent");
//				// �뿤�뜑 SET
//				String tranId =  MyDataUtil.getXapiTranId(kyoboMydtInstCode, CommonConstant.KYOBO_TYPE_CODE); // 醫낇빀�룷�꽭 湲곌�肄붾뱶
//				String TrnmDttmTlms = commonService.getSysdateYMDHMS();
//				Map<String, String> reqTargetDivInfo = new HashMap<String, String>();
//				MjComonTargetInfoVO targetInfo = null;
//				/*********************************************
//				 * �꽌踰꾨え�뱶, 湲곌�肄붾뱶�뿉 �뵲瑜� �슂泥��젙蹂� 遺꾧린
//				 *********************************************/
//				log.info("serverMode > > " + serverMode);
//				log.info("mydtInstCode > > " + mydtInstCode);
//				reqTargetDivInfo.put("serverMode", serverMode);
//				reqTargetDivInfo.put("mydtInstCode", mydtInstCode);
//				targetInfo = commonService.getServerDivValue(reqTargetDivInfo);
//				if(null != targetInfo) {
//					targetDomain = targetInfo.getTargetDomain();
//					clientId = targetInfo.getClientId();
//					clientSecret = targetInfo.getClientSecret();
//				}
//
//				Map<String, String> reqHeaders = new LinkedHashMap<String, String>();
//				Map<String, String> reqParams = new LinkedHashMap<String, String>();
//
//				reqHeaders.put("x-api-tran-id"   , tranId);
//				reqHeaders.put("gtw-custom-url"  , targetDomain);
//
//				reqParams.put("org_code"        , mydtInstCode);
//				reqParams.put("client_id"       , clientId);
//				reqParams.put("client_secret"   , clientSecret);
//				reqParams.put(CommonConstant.CODE_STRING_GRANT_TYPE      , CommonConstant.CODE_STRING_REFRESH_TOKEN);
//				reqParams.put(CommonConstant.CODE_STRING_REFRESH_TOKEN   , refreshToken);
//
//				MjCommonResVO resData = super.httpPostCall(url, reqHeaders, reqParams, "FORM", token, TrnmDttmTlms);
//
//				if("200".equals(resData.getRespCode())) {
//					Gson gson = new Gson();
//					MjK001RefreshTokenResVO apiresVO = gson.fromJson(resData.getResData(), MjK001RefreshTokenResVO.class);
//					token.setAcesTokenTlms(apiresVO.getAccess_token());
//					token.setAcesTokenPtrnName(apiresVO.getToken_type());
//					token.setAcesTokenVldTerm(apiresVO.getExpires_in());
//					mjK001Mapper.mjkMD1101DSPU001(token);
//
//					sucessCnt++;
//				} else {
//					errCnt++;
//				}
//			}
//
//			resVO.setErrCnt(Integer.toString(errCnt));
//			resVO.setSucessCnt(Integer.toString(sucessCnt));
//			resVO.setTotalCnt(Integer.toString(tokenList.size()));
//			resVO.setRsp_code(CommonConstant.CODE_STRING_RESP_CODE_VALUE_00000);
//			resVO.setRsp_msg(CommonConstant.CODE_STRING_RESP_MSG_VALUE_OK);
//		} else {
//			// 媛깆떊���긽 �뾾�쓬
//			resVO.setRsp_code(CommonConstant.CODE_STRING_RESP_CODE_VALUE_UP_TO_DATE);
//			resVO.setRsp_msg(CommonConstant.CODE_STRING_RESP_MSG_UP_TO_DATE);
//		}
//		return resVO;
//
//
//	}
//

}
