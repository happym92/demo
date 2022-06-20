package com.hm.mydata.md.vo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


/**
 * 1. ClassName : MdB003Mapper
 * 2. FileName  : MdB003Mapper.java
 * 3. Package   : kmds.md.b.mapper
 * 4. Comment   : 媛쒕퀎�씤利� 愿��젴 Mapper
 * @author      :
 * @version     : 2022. 1. 21. �삤�썑 5:55:01
 */

@Mapper
public interface MdB003Mapper {

	/**
     * 1. MethodName : mdbMD0102DLPS001
     * 2. ClassName  : MdB003Mapper.java
     * 3. Comment    : 3.1-1_MAX �쟾�넚�슂援ъ씪�젴踰덊샇 議고쉶
     * @SQLID        : mdbMD0102DLPS001
     * @USE_TABLE    : MD0102DL
     * @author       : kyeong-min, kim
     * @version      : 2022-04-12 �삤�썑 03:28:55
     * @return String
     */
	public String mdbMD0102DLPS001(MdBMD0102DL inMD0102DL);

	/**
     * 1. MethodName : mdbMD0105RLPI001
     * 2. ClassName  : MdB003Mapper.java
     * 3. Comment    : 3.1-2_媛쒕퀎�룞�쓽愿�怨� �쟻�옱
     * @SQLID        : mdbMD0105RLPI001
     * @USE_TABLE    : MD0105RL
     * @author       : kyeong-min, kim
     * @version      : 2022-04-12 �삤�썑 03:28:55
     * @return void
     */
	public void mdbMD0105RLPI001(MdBMD0105RL inMD0105RL);

	/**
     * 1. MethodName : mdbMA1000MSPS002
     * 2. ClassName  : MdB003Mapper.java
     * 3. Comment    : 3.1-3_怨좉컼CI議고쉶
     * @SQLID        : mdbMA1000MSPS002
     * @USE_TABLE    : MA1000MS
     * @author       : kyeong-min, kim
     * @version      : 2022-04-12 �삤�썑 03:28:55
     * @return String
     */
	public String mdbMA1000MSPS002(String csno);

	/**
     * 1. MethodName : mdbMD0102DLPU001
     * 2. ClassName  : MdB003Mapper.java
     * 3. Comment    : 3.2-1_�쟾�넚�슂援ъ긽�꽭 �긽�깭 �뾽�뜲�씠�듃
     * @SQLID        : mdbMD0102DLPU001
     * @USE_TABLE    : MD0102DL
     * @author       : kyeong-min, kim
     * @version      : 2022-04-12 �삤�썑 03:28:55
     * @return void
     */
	public void mdbMD0102DLPU001(MdBMD0102DL inMD0102DL);

	/**
     * 1. MethodName : mdbMD1101DSPU001
     * 2. ClassName  : MdB003Mapper.java
     * 3. Comment    : 3.2-2_�젒洹쇳넗�겙紐낆꽭 �뾽�뜲�씠�듃 Y/N
     * @SQLID        : mdbMD1101DSPU001
     * @USE_TABLE    : MD1101DS
     * @author       : kyeong-min, kim
     * @version      : 2022-04-12 �삤�썑 03:28:55
     * @return void
     */
	public void mdbMD1101DSPU001(MdBMD1101DS inMD1101DS);

	/**
     * 1. MethodName : mdbMD0102DLPU003
     * 2. ClassName  : MdB003Mapper.java
     * 3. Comment    : 3.2-3_�쟾�넚�슂援ъ긽�꽭 蹂�寃�(91)泥섎━
     * @SQLID        : mdbMD0102DLPU003
     * @USE_TABLE    : MD0102DL
     * @author       : kyeong-min, kim
     * @version      : 2022-04-12 �삤�썑 03:28:55
     * @return void
     */
	public void mdbMD0102DLPU003(MdBMD0102DL inMD0102DL);

	/**
     * 1. MethodName : mdbMD1101DSPI001
     * 2. ClassName  : MdB003Mapper.java
     * 3. Comment    : 3.2-4_�젒洹쇳넗�겙紐낆꽭 �쟻�옱
     * @SQLID        : mdbMD1101DSPI001
     * @USE_TABLE    : MD1101DS
     * @author       : kyeong-min, kim
     * @version      : 2022-04-12 �삤�썑 03:28:55
     * @return void
     */
	public void mdbMD1101DSPI001(MdBMD1101DS inMD1101DS);

	/**
     * 1. MethodName : mdbMD5002TRPI001
     * 2. ClassName  : MdB003Mapper.java
     * 3. Comment    : 3.2-5_�쟾�넚�슂援щ궡�뿭 �쟻�옱
     * @SQLID        : mdbMD5002TRPI001
     * @USE_TABLE    : MD5002TR
     * @author       : kyeong-min, kim
     * @version      : 2022-04-12 �삤�썑 03:28:55
     * @return void
     */
	public void mdbMD5002TRPI001(MdBMD5002TR inMD5002TR);

	/**
     * 1. MethodName : mdbMD1111MSPS001
     * 2. ClassName  : MdB003Mapper.java
     * 3. Comment    : 3.2-6_�뾽沅뚭뎄遺꾩퐫�뱶 議고쉶
     * @SQLID        : mdbMD1111MSPS001
     * @USE_TABLE    : MD1111MS
     * @author       : kyeong-min, kim
     * @version      : 2022-04-12 �삤�썑 03:28:55
     * @return MdBMD1111MS
     */
	public MdBMD1111MS mdbMD1111MSPS001(String mydtInstCode);

	/**
     * 1. MethodName : mdbMD0101MSPS001
     * 2. ClassName  : MdB003Mapper.java
     * 3. Comment    : 3.3-1_�쟾�넚�슂援ш린蹂� �씪�젴踰덊샇 梨꾨쾲
     * @SQLID        : mdbMD0101MSPS001
     * @USE_TABLE    : MD0101MS
     * @author       : kyeong-min, kim
     * @version      : 2022-04-12 �삤�썑 03:28:55
     * @return String
     */
	public String mdbMD0101MSPS001(MdBMD0101MS inMD0101MS);

	/**
     * 1. MethodName : mdbMD0101MSPI001
     * 2. ClassName  : MdB003Mapper.java
     * 3. Comment    : 3.3-2_�쟾�넚�슂援ш린蹂� �쟻�옱
     * @SQLID        : mdbMD0101MSPI001
     * @USE_TABLE    : MD0101MS
     * @author       : kyeong-min, kim
     * @version      : 2022-04-12 �삤�썑 03:28:55
     * @return void
     */
	public void mdbMD0101MSPI001(MdBMD0101MS inMD0101MS);

	/**
     * 1. MethodName : mdbMD0102DLPI001
     * 2. ClassName  : MdB003Mapper.java
     * 3. Comment    : 3.3-3_�쟾�넚�슂援ъ긽�꽭 �쟻�옱
     * @SQLID        : mdbMD0102DLPI001
     * @USE_TABLE    : MD0102DL
     * @author       : kyeong-min, kim
     * @version      : 2022-04-12 �삤�썑 03:28:55
     * @return void
     */
	public void mdbMD0102DLPI001(MdBMD0102DL inMD0102DL);

	/**
     * 1. MethodName : mdbMD0103DLPI001
     * 2. ClassName  : MdB003Mapper.java
     * 3. Comment    : 3.3-4_蹂�寃�&�뿰�옣 �옄�궛�긽�꽭 newSrno MERGE
     * @SQLID        : mdbMD0103DLPI001
     * @USE_TABLE    : MD0103DL
     * @author       : kyeong-min, kim
     * @version      : 2022-04-12 �삤�썑 03:28:55
     * @return void
     */
	public void mdbMD0103DLPI001(MdBMD0103DL inMD0103DL);

	/**
     * 1. MethodName : mdbMD1101DSPI002
     * 2. ClassName  : MdB003Mapper.java
     * 3. Comment    : 3.3-5_蹂�寃�&�뿰�옣 �넗�겙 newSrno MERGE
     * @SQLID        : mdbMD1101DSPI002
     * @USE_TABLE    : MD1101DS
     * @author       : kyeong-min, kim
     * @version      : 2022-04-12 �삤�썑 03:28:55
     * @return void
     */
	public void mdbMD1101DSPI002(MdBMD1101DS inMD1101DS);

	 /**
     * 1. MethodName : mdbMD0102DLVS001
     * 2. ClassName  : MdB003Mapper.java
     * 3. Comment    : 3.4-1_�뿰�룞�떆�룄 紐⑸줉
     * @SQLID        : mdbMD0102DLVS001
     * @USE_TABLE    : MD0102DL, MD0101MS, MD1111MS, MD1114DS
     * @author       : kyeong-min, kim
     * @version      : 2022-04-12 �삤�썑 03:28:55
     * @return List<MdBMD0102DL>
     */
	public List<MdBMD0102DL> mdbMD0102DLVS001(MdB003TrnmReqCommonVO reqVO);

	/**
     * 1. MethodName : mdbMD0102DLPU004
     * 2. ClassName  : MdB003Mapper.java
     * 3. Comment    : 3.5-1_媛쒕퀎�씤利� �긽�깭 �닔�젙
     * @SQLID        : mdbMD0102DLPU004
     * @USE_TABLE    : MD0102DL
     * @author       : kyeong-min, kim
     * @version      : 2022-04-12 �삤�썑 03:28:55
     * @return void
     */
	public void mdbMD0102DLPU004(MdB003TrnmReqCommonVO reqVO);

	/**
     * 1. MethodName : mdbMD0102DLPU005
     * 2. ClassName  : MdB003Mapper.java
     * 3. Comment    : 3.1-4_�긽�깭媛� �뾽�뜲�씠�듃
     * @SQLID        : mdbMD0102DLPU005
     * @USE_TABLE    : MD0102DL
     * @author       : kyeong-min, kim
     * @version      : 2022-06-09 �삤�썑 03:28:55
     * @return void
     */
	public void mdbMD0102DLPU005(MdBMD0102DL inMD0102DL);

	/**
     * 1. MethodName : mdbMD0102DLPS003
     * 2. ClassName  : MdB003Mapper.java
     * 3. Comment    : 3.2-6_�긽�깭媛믨�利�
     * @SQLID        : mdbMD0102DLPS003
     * @USE_TABLE    : MD0102DL
     * @author       : kyeong-min, kim
     * @version      : 2022-06-09 �삤�썑 03:28:55
     * @return void
     */
	public MdBMD0102DL mdbMD0102DLPS003(MdBMD0102DL mD0102DL);
}
