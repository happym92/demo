package com.hm.mydata.md.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * 1. ClassName : MjK001Controller
 * 2. FileName  : MjK001Controller.java
 * 3. Package   : kmds.mj.k.controller
 * 4. Comment   : 留덉씠�뜲�씠�꽣 吏��썝 API
 * @author      : kyeong-min, Kim
 * @version     : 2022. 4. 21. �삤�썑 5:28:25
 */
@RestController
@RequestMapping("/mj")
public class MjK001Controller{
//
//	@Autowired
//	private final MjK001ServiceImpl mjK001ServiceImpl;
//
//	/**
//	 * 1. MethodName        : mjK001GetSupportToken
//	 * 2. ClassName         : MjK001Controller
//	 * 3. Comment           : 吏��썝-001
//	 * @APIID               : MJK-0.1
//	 * @SQLID               : mjkMD1110MSPS001
//	 * @APIM                : support-001
//	 * @author              : kyeong-min, Kim
//	 * @version             : 2022. 4. 21. �삤�썑 5:41:37
//	 * @return ResponseEntity<?>
//	 * @throws Exception
//	 */
//	@ApiOperation(value = "MJK-0.1", notes = "吏��썝-001")
//	@PostMapping("/get-support-token")
//	public ResponseEntity<?> mjK001GetSupportToken() throws Exception {
//		Map<String, Object> rtnMap = new HashMap<String, Object>();
//
//		rtnMap = mjK001ServiceImpl.mjK001GetSupportToken();
//
//		rtnMap.put(CommonConstant.CODE_STRING_RESP_CODE, CommonConstant.CODE_STRING_RESP_CODE_VALUE_00000);
//		rtnMap.put(CommonConstant.CODE_STRING_RESP_MSG, CommonConstant.CODE_STRING_RESP_MSG_VALUE_OK);
//		return new ResponseEntity<>(rtnMap, null, HttpStatus.OK);
//	}
//
//	/**
//	 * 1. MethodName        : mjK001GetSupportToken
//	 * 2. ClassName         : MjK001Controller
//	 * 3. Comment           : 吏��썝-002
//	 * @APIID               : MJK-0.2
//	 * @SQLID               : mjkMD1113DLPD001, mjkMD1113DLPI001, mjkMD1111MSPD001, mjkMD1112DLPD001
//	 *                        mjkMD1111MSPI001
//	 * @APIM                : support-002
//	 * @author              : kyeong-min, Kim
//	 * @version             : 2022. 4. 28. �삤�썑 5:41:37
//	 * @return void
//	 * @throws Exception
//	 */
//	@ApiOperation(value = "MJK-0.2", notes = "吏��썝-002")
//	@PostMapping("/get-support-inst-list")
//	public ResponseEntity<?> mjK001GetInstList() throws Exception {
//		Map<String, Object> rtnMap = new HashMap<String, Object>();
//
//		rtnMap = mjK001ServiceImpl.mjK001GetInstList();
//
//		rtnMap.put(CommonConstant.CODE_STRING_RESP_CODE, CommonConstant.CODE_STRING_RESP_CODE_VALUE_00000);
//		rtnMap.put(CommonConstant.CODE_STRING_RESP_MSG, CommonConstant.CODE_STRING_RESP_MSG_VALUE_OK);
//		return new ResponseEntity<>(rtnMap, null, HttpStatus.OK);
//	}
//
//	/**
//	 * 1. MethodName        : mjK001GetSupportToken
//	 * 2. ClassName         : MjK001Controller
//	 * 3. Comment           : 吏��썝-004
//	 * @APIID               : MJK-0.4
//	 * @SQLID               : mjkMD1201TRPS001, mjkMD1202DLPS001
//	 * @APIM                : support-004
//	 * @author              : kyeong-min, Kim
//	 * @version             : 2022. 4. 28. �삤�썑 5:41:37
//	 * @return void
//	 * @throws Exception
//	 */
//	@ApiOperation(value = "MJK-0.4", notes = "吏��썝-004")
//	@PostMapping("/send-statistics-data")
//	public ResponseEntity<?> mjK001SendStatisticsData() throws Exception {
//		Map<String, Object> rtnMap = new HashMap<String, Object>();
//		MjK004ResVO test = mjK001ServiceImpl.mjK001SendStatisticsData();
//		if(test == null) {
//			test = new MjK004ResVO();
//		} else {
//			rtnMap = MyDataUtil.convertToMap(test);
//		}
//
//		return new ResponseEntity<>(rtnMap, null, HttpStatus.OK);
//	}
//
//	/**
//	 * 1. MethodName        : mjK001GetOfferApiList
//	 * 2. ClassName         : MjK001Controller
//	 * 3. Comment           : 怨듯넻-001
//	 * @APIID               : MJK-1.0
//	 * @SQLID               : NONE
//	 * @APIM                : apis-[]
//	 * @author              : kyeong-min, Kim
//	 * @version             : 2022. 5. 10. �삤�썑 5:41:37
//	 * @return void
//	 * @throws Exception
//	 */
//	@ApiOperation(value = "MJK-1.0", notes = "怨듯넻-001")
//	@PostMapping("/get-offer-api-list")
//	public ResponseEntity<?> mjK001GetOfferApiList() throws Exception {
//		Map<String, Object> rtnMap = new HashMap<String, Object>();
//		mjK001ServiceImpl.mjK001GetOfferApiList();
//
//		rtnMap.put(CommonConstant.CODE_STRING_RESP_CODE, CommonConstant.CODE_STRING_RESP_CODE_VALUE_00000);
//		rtnMap.put(CommonConstant.CODE_STRING_RESP_MSG, CommonConstant.CODE_STRING_RESP_MSG_VALUE_OK);
//		return new ResponseEntity<>(rtnMap, null, HttpStatus.OK);
//	}
//
//
//	/**
//	 * 1. MethodName        : mjK001ModToken
//	 * 2. ClassName         : MjK001Controller
//	 * 3. Comment           : 媛쒕퀎�씤利�-003
//	 * @APIID               : MJK-1.3
//	 * @SQLID               : mjkMD1101DSPU001
//	 * @APIM                : oauth-003
//	 * @author              : kyeong-min, Kim
//	 * @version             : 2022. 4. 28. �삤�썑 5:41:37
//	 * @return void
//	 * @throws Exception
//	 */
//	@ApiOperation(value = "MJK-1.3", notes = "媛쒕퀎�씤利�-003")
//	@PostMapping("/mod-token")
//	public ResponseEntity<?> mjK001ModToken() throws Exception {
//		Map<String, Object> rtnMap = new HashMap<String, Object>();
//		MjK005ResVO resVO = mjK001ServiceImpl.mjK001ModToken();
//		rtnMap = MyDataUtil.convertToMap(resVO);
//		return new ResponseEntity<>(rtnMap, null, HttpStatus.OK);
//	}

}
