package com.hm.mydata.md.vo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


/**
 * 1. ClassName : MaA001Mapper
 * 2. FileName  : MaA001Mapper.java
 * 3. Package   : kmds.mz.d.mapper
 * 4. Comment   :
 * @author      : PSY
 * @version     : 2022. 1. 25. �삤�쟾 9:14:36
 */
@Mapper
public interface MzD001Mapper {

//	/**
//	 * 1. MethodName        : mzdDUALPS001
//	 * 2. ClassName         : MzD001Mapper
//	 * 3. Comment           : SYADATE TO STRING YYYYMMDHMS//	 * @SQLID               : mzdDUALPS001//	 * @USE_TABLE           : DUAL
//	 * @author              : hyun-wook, Kim
//	 * @version             : 2022. 4. 12. �삤�썑 1:46:04
//	 * @return String
//	 * @return
//	 */
//	public String mzdDUALPS001();
//
//	/**
//	 * 1. MethodName        : mzdMD0103DLPI001
//	 * 2. ClassName         : MzD001Mapper
//	 * 3. Comment           : �쟾�넚�슂援� �옄�궛�긽�꽭 �쟻�옱//	 * @SQLID               : mzdMD0103DLPI001//	 * @USE_TABLE           : MD0103DL
//	 * @author              : kyeong-min, kim
//	 * @version             : 2022. 4. 12. �삤�썑 1:45:11
//	 * @return void
//	 * @param inMD0103DL
//	 */
//	public void mzdMD0103DLPI001(MzDMD0103DL inMD0103DL);
//
//	/**
//	 * 1. MethodName        : mzdMD1115TRPI001
//	 * 2. ClassName         : MzD001Mapper
//	 * 3. Comment           : �쟾�넚�궡�뿭 �쟻�옱//	 * @SQLID               : mzdMD1115TRPI001//	 * @USE_TABLE           : MD1115TR
//	 * @author              : kyeong-min, kim
//	 * @version             : 2022. 4. 12. �삤�썑 1:44:50
//	 * @return void
//	 * @param reqVO
//	 */
//	public void mzdMD1115TRPI001(MzDMD1115TR reqVO);
//
//	/**
//	 * 1. MethodName        : mzdMD1101DSPS002
//	 * 2. ClassName         : MzD001Mapper
//	 * 3. Comment           : API�샇異� ���긽 議고쉶//	 * @SQLID               : mzdMD1101DSPS002//	 * @USE_TABLE           : MD1101DS, MD0102DL
//	 * @author              : kyeong-min, kim
//	 * @version             : 2022. 4. 12. �삤�썑 1:44:20
//	 * @return List<MjComMD1101DS>
//	 * @param reqParam
//	 * @return
//	 */
//	public List<MzDMD1101DS> mzdMD1101DSPS002(MzD001ReqVO reqParam);
//
//	/**
//	 * 1. MethodName        : mzdMA1000MSPS001
//	 * 2. ClassName         : MzD001Mapper
//	 * 3. Comment           : �쉶�썝 �긽�깭 議고쉶//	 * @SQLID               : mzdMA1000MSPS001//	 * @USE_TABLE           : MA1000MS
//	 * @author              : kyeong-min, kim
//	 * @version             : 2022. 4. 12. �삤�썑 1:43:54
//	 * @return MdBMA1000MS
//	 * @param csno
//	 * @return
//	 */
//	public MdBMA1000MS mzdMA1000MSPS001(String csno);
//
//	/**
//	 * 1. MethodName        : mzdMD0102DLPS001
//	 * 2. ClassName         : MzD001Mapper
//	 * 3. Comment           : �뿰寃곗쨷�씤 �옄�궛 移댁슫�듃//	 * @SQLID               : mzdMD0102DLPS001//	 * @USE_TABLE           : MD1111MS, MD0102DL, MD1101DS
//	 * @author              : kyeong-min, kim
//	 * @version             : 2022. 4. 12. �삤�썑 1:42:31
//	 * @return String
//	 * @param csno
//	 * @return
//	 */
//	public String mzdMD0102DLPS001(String csno);
//
//	/**
//	 * 1. MethodName        : mzdMA1000MSPU001
//	 * 2. ClassName         : MzD001Mapper
//	 * 3. Comment           : �쉶�썝 �긽�깭 蹂�寃�//	 * @SQLID               : mzdMA1000MSPU001//	 * @USE_TABLE           : MA1000MS
//	 * @author              : kyeong-min, kim
//	 * @version             : 2022. 4. 12. �삤�썑 1:42:50
//	 * @return void
//	 * @param req
//	 */
//	public void mzdMA1000MSPU001(MdBMA1000MS req);
//
//	/**
//	 * 1. MethodName        : mzdMA1000MSPU002
//	 * 2. ClassName         : MzD001Mapper
//	 * 3. Comment           : �쉶�썝 �긽�깭 蹂�寃�//	 * @SQLID               : mzdMA1000MSPU002//	 * @USE_TABLE           : MA1000MS
//	 * @author              : kyeong-min, kim
//	 * @version             : 2022. 4. 12. �삤�썑 1:42:50
//	 * @return void
//	 * @param req
//	 */
//	public void mzdMA1000MSPU002(MdBMA1000MS req);
//
//	/**
//	 * 1. MethodName        : mzdMD0101MSPU001
//	 * 2. ClassName         : MzD001Mapper
//	 * 3. Comment           : MD_�쟾�넚�슂援ш린蹂� : �옄�궛�쟾�넚�셿猷뚯뿬遺�//	 * @SQLID               : mzdMD0101MSPU001//	 * @USE_TABLE           : MD0101MS
//	 * @author              : hyun-wook, Kim
//	 * @version             : 2022. 5. 2. �삤�썑 4:35:29
//	 * @return int
//	 * @param map
//	 * @return
//	 */
//	public int mzdMD0101MSPU001(Map<String, String> map);
//
//	/**
//	 * 1. MethodName        : mzdMD0101MSPU002
//	 * 2. ClassName         : MzD001Mapper
//	 * 3. Comment           : MD_�쟾�넚�슂援ш린蹂� : �긽�꽭�쟾�넚�셿猷뚯뿬遺�//	 * @SQLID               : mzdMD0101MSPU002//	 * @USE_TABLE           : MD0101MS
//	 * @author              : hyun-wook, Kim
//	 * @version             : 2022. 5. 2. �삤�썑 4:36:07
//	 * @return int
//	 * @param map
//	 * @return
//	 */
//	public int mzdMD0101MSPU002(Map<String, String> map);
//
//	/**//	* 1. MethodName : mdbMD1111MSPS003//	* 2. ClassName  : MzD001Mapper.java//	* 3. Comment    : ��寃� 湲곌� �젙蹂� 議고쉶//	* @SQLID        : mdbMD1111MSPS003//	* @USE_TABLE    : MD1111MS//	* @author       : kyeong-min, kim//	* @version      : 2022-05-23 �삤�썑 03:28:55//	* @return MdBMD1111MS//	*///	public MdBMD1111MS mdbMD1111MSPS003(String mydtInstCode);

}
