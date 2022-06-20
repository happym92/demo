package com.hm.mydata.md.vo;

import java.lang.reflect.Field;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import com.hm.mydata.common.utils.DateUtil;
import com.hm.mydata.common.utils.StringUtil;


/**
 * 1. Comment : MainClass
 * @author      : NONE
 * @version     : 2025.05. 24. �삤�쟾 12:00:00
 */
public class MyDataUtil {

	/**
	 * 留덉씠�뜲�씠�꽣 x-api-tran-id 梨꾨쾲
	 *
	 * @param String mydtInstCode, String typeCode
	 * @return 梨꾨쾲 �븘�씠�뵒 Ex) 嫄곕옒怨좎쑀踰덊샇 = 湲곌�肄붾뱶(10�옄由�) + �깮�꽦二쇱껜援щ텇肄붾뱶(1�옄由�) + 遺��뿬踰덊샇(14�옄由�)
	 */
	public static String getXapiTranId(String mydtInstCode, String typeCode) {

		SecureRandom rnd = new SecureRandom();
		int inum = rnd.nextInt(99999);

		//return ex ) B1AAAI0000 (10)+ M (1) + 144123815 (9) + 24075 (5)
		return mydtInstCode + typeCode + DateUtil.getFmtDateString(new Date(), "HHmmssSSS") + StringUtil.lpad( Integer.toString(inum), 5, "0");
	}

	public static Map<String, Object> convertToMap(Object obj) throws IllegalAccessException {
		Map<String, Object> convertedMap =  new HashMap<String, Object>();

		Field[] fds = obj.getClass().getDeclaredFields();
		for(Field fd : fds) {
			fd.setAccessible(true);
			convertedMap.put(fd.getName(), fd.get(obj));
		}
		return convertedMap;

	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}


}
