package com.hm.mydata.common.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.extern.slf4j.Slf4j;

/**
 * 1. ClassName :
 * 2. FileName  : StringUtil.java
 * 3. Package   : kmds.com.framework.common.utils
 * 4. Comment   :
 * @author      : User
 * @version     : 2021. 12. 28. 占쎌궎占쎌뜎 5:23:19
 */
@Slf4j
public class StringUtil {
	private static final Logger log = LogManager.getLogger(StringUtil.class);

	private static final String TAG_QUOT = "&quot;";
	private static final String TAG_AMP = "&amp;";
	private static final String TAG_LT = "&lt;";
	private static final String TAG_GT = "&gt;";
	private static final String TAG_BR = "<br>";

	/**
	 * �눧紐꾩쁽占쎈였占쎌벥 Empty or Null 筌ｋ똾寃�
	 *
	 * @param str
	 * @return
	 */
	/**
	 * 1. MethodName        : isEmpty
	 * 2. ClassName         : StringUtil
	 * 3. Comment           :
	 * @author              : User
	 * @version             : 2021. 12. 28. 占쎌궎占쎌뜎 5:23:23
	 * @return boolean
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return (str == null || str.trim().equals(""));
	}

    /**
     * �눧紐꾩쁽占쎈였占쎌벥 notEmpty or notNull 筌ｋ똾寃�
     *
     * @param str
     * @return
     */
	public static boolean isNotEmpty(String str) {
	    return !isEmpty(str);
	}

//    /**
//     * Object Empty or Null 筌ｋ똾寃�
//     *
//     * @param str
//     * @return
//     */
//	public static boolean isEmpty(Object obj) {
//	    return (obj == null || obj.toString().trim().equals(""));
//	}
//
//	/**
//	 * Object notEmpty or notNull 筌ｋ똾寃�
//	 *
//	 * @param str
//	 * @return
//	 */
//	public static boolean isNotEmpty(Object obj) {
//	    return !isEmpty(obj);
//	}

    /**
     * �눧紐꾩쁽占쎈였 Null 筌ｋ똾寃�
     *
     * @param str
     * @return
     */
	public static boolean isNull(String str) {
        return (str == null);
	}

    /**
     * �눧紐꾩쁽占쎈였 Null 筌ｋ똾寃�
     *
     * @param str
     * @return
     */
	public static boolean isNotNull(String str) {
	    return !isNull(str);
	}

    /**
     * Object Null 筌ｋ똾寃�
     *
     * @param str
     * @return
     */
	public static boolean isNull(Object obj) {
	    return (obj == null);
	}

    /**
     * Object Null 筌ｋ똾寃�
     *
     * @param str
     * @return
     */
	public static boolean isNotNull(Object obj) {
	    return !isNull(obj);
	}

	/**
	 * �눧紐꾩쁽占쎈였占쎌벥 Null 揶쏉옙 燁살꼹�넎
	 *
	 * @param str
	 * @param replacer
	 * @return
	 */
	public static String nvl(String str, String replacer) {
		if (str == null) {
			return replacer;
		} else {
			return str;
		}
	}

    /**
    * 占쎈퉸占쎈뼣 Object�몴占� String占쎌몵嚥∽옙 占쎌굨癰귨옙占쎌굨占쎈릭占쎈연 �뵳�뗪쉘占쎈립占쎈뼄.
    * <p>
    * @param    obj
    * @return
    */
    public static String nvl(Object obj){
        String str="";

        if(obj != null) {
        	try {
        		str = String.valueOf(obj);
        	} catch(Exception e) {
        		log.error("error stack", e);
        	}

        	if(str.equals("null") || (str.length() == 0)) {
        		str = "";
        	}
        }

        return str;
    }

	/**
	 * 1. MethodName        : getPostfixSize
	 * 2. ClassName         : StringUtil
	 * 3. Comment           :
	 * @author              : User
	 * @version             : 2021. 12. 28. 占쎌궎占쎌뜎 5:23:31
	 * @return int
	 * @param strPostfix
	 * @return
	 */
	private static int getPostfixSize(String strPostfix) {
		int postfixSize = 0;
		for (int i = 0; i < strPostfix.length(); i++) {
			if (strPostfix.charAt(i) < 256) {
				postfixSize += 1;
			} else {
				postfixSize += 2;
			}
		}
		return postfixSize;
	}

	/**
	 * �눧紐꾩쁽占쎈였占쎌뱽 占쎈뱟占쎌젟 占쎄쾿疫꿸퀡以� 占쎌삋占쎌뵬占쎄땋占쎈뼄.
	 *
	 * @param strSource
	 * @param cutByte
	 * @return
	 */
	public static String cutString(String strSourceStr, int cutByte, String strPostfixStr) {

		String strSource = strSourceStr;
		String strPostfix = strPostfixStr;

		if (strSource == null) {
			return "";
		}

		strPostfix = (strPostfix == null) ? "" : strPostfix;
		int postfixSize = getPostfixSize(strPostfix);

		if (postfixSize > cutByte) {
			return strSource;
		}

		strSource = strSource.trim();
		char[] charArray = strSource.toCharArray();

		int strIndex = 0;
		int byteLength = 0;
		for (; strIndex < strSource.length(); strIndex++) {

			int byteSize = 0;
			if (charArray[strIndex] < 256) {
				// 1byte character 占쎌뵠筌롳옙
				byteSize = 1;
			} else {
				// 2byte character 占쎌뵠筌롳옙
				byteSize = 2;
			}

			if ((byteLength + byteSize) > cutByte - postfixSize) {
				break;
			}

			byteLength += byteSize;
			// byteLength = byteLength += byteSize;
		}

		if (strIndex == strSource.length()) {
			strPostfix = "";
		} else {
			if ((byteLength + postfixSize) < cutByte) {
				strPostfix = " " + strPostfix;
			}
		}

		return strSource.substring(0, strIndex) + strPostfix;
	}

	/**
	 * delimeter嚥∽옙 占쎈��,占쎌뜞,占쎌뵬占쎌뱽 �뤃�됲뀋占쎈퉸占쎄퐣 占쎄돌占쎈듌占쎈뼄.
	 *
	 * @param value HHMMSS嚥∽옙 �뤃�딄쉐占쎈┷占쎈선 占쎌뿳占쎈뮉 String
	 * @return �뤃�됲뀋占쎌쁽嚥∽옙 �뤃�됲뀋占쎌뵠 占쎈쭆 野껉퀗�궢 揶쏉옙
	 */
	public static String formatDate(String str, String delimeter) {
		if (str == null || str.length() != 8) {
			return "";
		}

		StringBuilder buffer = new StringBuilder();

		buffer.append(str.substring(0, 4));
		buffer.append(delimeter);
		buffer.append(str.substring(4, 6));
		buffer.append(delimeter);
		buffer.append(str.substring(6, 8));

		return buffer.toString();
	}

	/**
	 * 1. MethodName        : formatDate
	 * 2. ClassName         : StringUtil
	 * 3. Comment           :
	 * @author              : User
	 * @version             : 2021. 12. 28. 占쎌궎占쎌뜎 5:23:37
	 * @return String
	 * @param str
	 * @return
	 */
	public static String formatDate(String str) {
		return formatDate(str, ".");
	}

	/**
	 * delimeter嚥∽옙 占쎈뻻,�겫占�,�룯占� 占쎌뱽 �뤃�됲뀋占쎈퉸占쎄퐣 占쎄돌占쎈듌占쎈뼄.
	 *
	 * @param value HHMMSS嚥∽옙 �뤃�딄쉐占쎈┷占쎈선 占쎌뿳占쎈뮉 String
	 * @return �뤃�됲뀋占쎌쁽嚥∽옙 �뤃�됲뀋占쎌뵠 占쎈쭆 野껉퀗�궢 揶쏉옙
	 */
	public static String formatTime(String str, String delimeter) {
		if (str == null || str.length() != 6) {
			return "";
		}

		StringBuilder buffer = new StringBuilder();

		buffer.append(str.substring(0, 2));
		buffer.append(delimeter);
		buffer.append(str.substring(2, 4));
		buffer.append(delimeter);
		buffer.append(str.substring(4, 6));

		return buffer.toString();
	}

	/**
	 * 1. MethodName        : formatTime
	 * 2. ClassName         : StringUtil
	 * 3. Comment           :
	 * @author              : User
	 * @version             : 2021. 12. 28. 占쎌궎占쎌뜎 5:23:41
	 * @return String
	 * @param str
	 * @return
	 */
	public static String formatTime(String str) {
		return formatTime(str, ":");
	}

	/**
	 * 占쎄퐜占쎈선占쎌궔 揶쏅�る퓠 占쎄쉭占쎌쁽�뵳�됱춳占쎈뼄 ','�몴占� 占쎄퐫占쎈선雅뚯눖�뮉 占쎈맙占쎈땾.
	 *
	 * @param value comma�몴占� �겫�늿肉э옙鍮� 占쎈┷占쎈뮉 占쎈떭占쎌쁽
	 * @return 占쎄쉭占쎌쁽�뵳占� 筌띾뜄�뼄 ,揶쏉옙 �겫�늿堉� 占쎌뿳占쎈뮉 String
	 */
	public static String formatNumber(int value) {
		return formatNumber(String.valueOf(value));
	}

	/**
	 * 占쎄퐜占쎈선占쎌궔 揶쏅�る퓠 占쎄쉭占쎌쁽�뵳�됱춳占쎈뼄 ','�몴占� 占쎄퐫占쎈선雅뚯눖�뮉 占쎈맙占쎈땾. 占쎈떭占쎌쁽占쎌뵥筌욑옙占쎈뮉 筌ｋ똾寃뺧옙釉�筌욑옙 占쎈륫占쎌벉.
	 *
	 * @param value comma�몴占� �겫�늿肉э옙鍮� 占쎈┷占쎈뮉 String
	 * @return 占쎄쉭占쎌쁽�뵳占� 筌띾뜄�뼄 ,揶쏉옙 �겫�늿堉� 占쎌뿳占쎈뮉 String
	 */
	public static String formatNumber(String str) {
		if (str == null || str.equals("")) {
			return "0";
		}

		if (str.length() <= 3) {
			return str;
		} else {
			String remainder = str.substring(str.length() - 3, str.length());

			return formatNumber(str.substring(0, str.length() - 3)) + "," + remainder;
		}
	}

	/**
	 * 999,999,999 占쎌굢占쎈뮉 999,999,999.99 format占쎌몵嚥∽옙 占쎈┷占쎈선占쎌뿳占쎈뮉 占쎌쁽�뙴�슢占쏙옙 ','揶쏉옙 占쎈씨占쎈뮉 占쎌굨占쎈뻼占쎌몵嚥∽옙 癰귨옙占쎌넎
	 *
	 * @param value String type占쎌벥 占쎈쑓占쎌뵠占쎄숲
	 * @return String 占쎈떭占쎌쁽 format占쎌몵嚥∽옙 癰귨옙占쎌넎占쎈쭆 占쎈쑓占쎌뵠占쎄숲
	 */
	public static String unformatNumber(String value) {
		if (value == null) {
			return "err-numberFormat(null)";
		}

		StringBuilder res = new StringBuilder();

		StringTokenizer st = new StringTokenizer(value, ",");

		while (st.hasMoreTokens()) {
			res.append(st.nextToken());
		}

		return res.toString();
	}

	/**
	 * 筌욑옙占쎈열甕곕뜇�깈占쎄돌 占쎈퉾占쎈굡占쎈？占쎌벥 占쎈꽰占쎈뻿占쎈씜占쎌쁽甕곕뜇�깈�몴占� 占쎈솁占쎈뼓(0占쎄텣占쎌젫)占쎈릭占쎈연 �뵳�뗪쉘占쎈립占쎈뼄.
	 *
	 * @param value 占쎈솁占쎈뼓占쎈막 甕곕뜇�깈 String
	 * @param gubun 筌욑옙占쎈열甕곕뜇�깈占쎌뵥筌욑옙 占쎈꽰占쎈뻿占쎈씜占쎌쁽甕곕뜇�깈占쎌뵥筌욑옙�몴占� �뤃�됲뀋占쎈릭占쎈뮉 �뤃�됲뀋占쎌쁽( R or H )
	 * @return 占쎈솁占쎈뼓占쎈쭆 野껉퀗�궢 揶쏉옙
	 */
	public static String formatTel1(String value, String gubun) {
		if (value == null || value.equals("") || value.length() != 4) {
			return "";
		} else if (gubun.equalsIgnoreCase("R") && value.equals("0002")) {
			return "02";
		} else {
			return value.substring(1);
		}
	}

	/**
	 * 占쎌읈占쎌넅甕곕뜇�깈�몴占� 占쎈솁占쎈뼓(0占쎄텣占쎌젫)占쎈릭占쎈연 �뵳�뗪쉘占쎈립占쎈뼄.
	 *
	 * @param value 占쎈솁占쎈뼓占쎈막 甕곕뜇�깈 String
	 * @return 占쎈솁占쎈뼓占쎈쭆 野껉퀗�궢 揶쏉옙
	 */
	public static String formatTel2(String value) {
		return formatTel2(value, null);
	}

	/**
	 * 占쎌읈占쎌넅甕곕뜇�깈�몴占� 占쎈솁占쎈뼓(0占쎄텣占쎌젫)占쎈릭占쎈연 �뵳�뗪쉘占쎈립占쎈뼄.
	 *
	 * @param value     占쎈솁占쎈뼓占쎈막 甕곕뜇�깈 String
	 * @param delimeter �뤃占썼린�뜃�궢 甕곕뜇�깈�몴占� �뤃�됲뀋占쎈릭占쎈뮉 �눧紐꾩쁽( eg. '-'...)
	 * @return value 占쎈솁占쎈뼓占쎈쭆 野껉퀗�궢 揶쏉옙
	 */
	public static String formatTel2(String valueStr, String delimeter) {

		String value = valueStr;
		if (value == null || value.equals("") || value.length() != 8) {
			return "";
		} else if (value.startsWith("0")) {
			if (delimeter != null) {
				value = value.substring(1, 4) + delimeter + value.substring(4);
			} else {
				value = value.substring(1);
			}

			return value;
		} else {
			if (delimeter != null) {
				value = value.substring(0, 4) + delimeter + value.substring(4);
			}

			return value;
		}
	}

	/**
	 * 占쎄퐜占쎈선占쎌궔 揶쏅�る퓠 占쎄퐬占쎌쁽�뵳�됱춳占쎈뼄 '-'�몴占� 占쎄퐫占쎈선雅뚯눖�뮉 占쎈맙占쎈땾.
	 *
	 * @param value 占쎈솁占쎈뼓占쎈막 甕곕뜇�깈 String
	 * @return 占쎈솁占쎈뼓占쎈쭆 野껉퀗�궢 揶쏉옙
	 */
	public static String formatCard(String value) {
		if (value == null || value.equals("") || value.length() != 16) {
			return value;
		} else {
			return value.substring(0, 4) + "-" + value.substring(4, 8) + "-" + value.substring(8, 12) + "-"
					+ value.substring(12, 16);
		}
	}

	/**
	 * �눧紐꾩쁽占쎈였占쎌벥 占쎈링占쎈퓠 占쎌뿳占쎈뮉 0占쎌뱽 占쎄텣占쎌젫占쎈릭占쎈연 �뵳�뗪쉘占쎈립占쎈뼄.
	 *
	 * @param value 占쎈솁占쎈뼓占쎈막 甕곕뜇�깈 String
	 * @return value 占쎈솁占쎈뼓占쎈쭆 野껉퀗�궢 揶쏉옙
	 */
	public static String firstZeroDel(String valueStr) {

		String value = valueStr;
		if (value == null || value.equals("")) {
			return "";
		}
		while (value.startsWith("0")) {
			value = value.substring(1);
		}

		return value;
	}

	/**
	 * 8859-1占쎌뱽 euc-kr嚥∽옙 獄쏅떽�뵒占쎈뼄.
	 *
	 * @param str 占쎌뵥�굜遺얜뎃占쎈막 �눧紐꾩쁽占쎈였 String
	 * @return 占쎌뵥�굜遺얜뎃占쎈쭆 野껉퀗�궢 揶쏉옙
	 */
	public static String toKorean(String value) {
		String str = value;
		try {
			if (str != null) {
				str = new String(str.getBytes(StandardCharsets.ISO_8859_1), "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			log.error("error stack", e);
			return "ENCORDING ERROR";
		}

		return str;
	}

	/**
	 * euc-kr占쎌뱽 8859-1嚥∽옙 獄쏅떽�뵒占쎈뼄.
	 *
	 * @param str 占쎌뵥�굜遺얜뎃占쎈막 �눧紐꾩쁽占쎈였 String
	 * @return 占쎌뵥�굜遺얜뎃占쎈쭆 野껉퀗�궢 揶쏉옙
	 */
	public static String toEnglish(String value) {
		String str = value;
		try {
			if (str != null) {
				str = new String(str.getBytes("utf-8"), StandardCharsets.ISO_8859_1);
			}
		} catch (UnsupportedEncodingException e) {
			log.error("error stack", e);
			return "ENCORDING ERROR";
		}

		return str;
	}

	/**
	 * lpad 占쎈맙占쎈땾
	 *
	 * @param str 占쏙옙占쎄맒�눧紐꾩쁽占쎈였, len 疫뀀챷�뵠, addStr 占쏙옙筌ｋ�揆占쎌쁽
	 * @return �눧紐꾩쁽占쎈였
	 */
	public static String lpad(String str, int len, String addStr) {
		String result = str;
		int templen = len - result.length();

		for (int i = 0; i < templen; i++) {
			result = addStr + result;
		}

		return result;
	}

	/**
	 * �눧紐꾩쁽占쎈였 燁살꼹�넎
	 * @param 占쎌뜚癰귨옙 String
	 * @param 甕곕뗄�맄 占쎈뻻占쎌삂 index
	 * @param 甕곕뗄�맄 �넫�굝利� index
	 * @param 癰귨옙野껋럥留� �눧紐꾩쁽
	 * @return
	 *
	 */
	public static String replace(String sourceStr, int startIndex , int endIndex, char changeChar) {
	    if(isEmpty(sourceStr)) {
	        return null;
	    }

	    boolean isTurn = false;
	    String nonTargetStr = sourceStr.substring(0,startIndex);

	    if(startIndex == 0) {
	        nonTargetStr = sourceStr.substring(endIndex,sourceStr.length());
	        isTurn = true;
	    }

	    String targetStr = sourceStr.substring(startIndex, endIndex);
	    char [] c = new char[targetStr.length()];
	    Arrays.fill(c, changeChar);

	    return isTurn ? String.valueOf(c).concat(nonTargetStr) : nonTargetStr.concat(String.valueOf(c));
	}

	/**
	 * �눧紐꾩쁽占쎈였占쎌뱽 燁살꼹�넎占쎈맙
	 *
	 * @param str
	 * @param sourceStr
	 * @param targetStr
	 * @return
	 */
	public static String replace(String value, String sourceStr, String targetStr) {

		String str = value;
		if (str == null || sourceStr == null || targetStr == null || str.length() == 0 || sourceStr.length() == 0) {
			return str;
		}

		int position = 0;
		int sourceStrLength = sourceStr.length();
		int targetStrLength = targetStr.length();

		while (true) {
			position = str.indexOf(sourceStr, position);
			if (position != -1) {
				if ((position + sourceStrLength) < str.length()) {
					str = str.substring(0, position) + targetStr + str.substring(position + sourceStrLength);
				} else {
					str = str.substring(0, position) + targetStr;
				}

				position = position + targetStrLength;

				if (position > str.length()) {
					position = str.length();
				}
			} else {
				break;
			}
		}

		return str;
	}

	/**
	 * �눧紐꾩쁽占쎈였占쎌벥 Null占쎌뱽 Empty嚥∽옙 燁살꼹�넎占쎈맙
	 *
	 * @param str
	 * @return
	 */
	public static String replaceNull(String str) {
		if (str != null) {
			return str;
		} else {
			return "";
		}
	}

	/**
	 * �눧紐꾩쁽占쎈였占쎌벥 \n占쎌뱽 <br>
	 * 嚥∽옙 燁살꼹�넎占쎈맙
	 *
	 * @param str
	 * @return
	 */
	public static String replaceHtmlString(String value) {
		String str = value;
		if (str != null && str.length() > 0) {
			str = replace(str, "\n", TAG_BR);
		}

		return str;
	}

	/**
	 * �눧紐꾩쁽占쎈였 燁살꼹�넎
	 *
	 * @param value
	 * @return
	 */
	public static String replaceContentString(String value) {
		String str = value;
		if (str != null && str.length() > 0) {
			str = replace(str, TAG_QUOT, "'");
			str = replace(str, TAG_AMP, "&");
			str = replace(str, "<!--<p>-->", "");
		}

		return str;
	}

	/**
	 * �눧紐꾩쁽占쎈였 燁살꼹�넎
	 *
	 * @param value
	 * @return
	 */
	public static String replaceScriptString(String value) {
		String str = value;
		if (str != null && str.length() > 0) {
			str = replace(str, "\\", "\\\\");
			str = replace(str, "'", "\\'");
			str = replace(str, "\"", "\\\"");
		}

		return str;
	}

	/**
	 * �눧紐꾩쁽占쎈였 燁살꼹�넎
	 *
	 * @param value
	 * @return
	 */
	public static String replaceQuot(String value) {
		String str = value;
		if (str != null && str.length() > 0) {
			str = replace(str, TAG_BR, " ");
			str = replace(str, "<br/>", " ");
			// str = replace(str, "<", "");
			// str = replace(str, ">", "");
			str = replace(str, "=", "");
			str = replace(str, "%", "");
			str = replace(str, "+", "");
			str = replace(str, "'", "");
			str = replace(str, "/", "");
			str = replace(str, "\"", "");
			str = replace(str, "\r", " ");
			str = replace(str, "\n", " ");
			str = replace(str, "\r\n", " ");
		}

		return str;
	}

	/**
	 * �눧紐꾩쁽占쎈였 燁살꼹�넎
	 *
	 * @param value
	 * @return
	 */
	public static String replaceSQLString(String value) {
		String str = value;
		if (str != null && str.length() > 0) {
			str = replace(str, "'", "''");
		}

		return str;
	}

	/**
	 * �눧紐꾩쁽占쎈였 燁살꼹�넎
	 *
	 * @param value
	 * @return
	 */
	public static String replaceContentString2(String value) {
		String str = value;
		if (str != null && str.length() > 0) {
			str = replace(str, TAG_AMP, "&");
			str = replace(str, "\"", TAG_QUOT);
			str = replace(str, "&", TAG_AMP);
			str = replace(str, "<", TAG_LT);
			str = replace(str, ">", TAG_GT);
		}

		return str;
	}

	/**
	 * �뤃�됲뀋占쎌쁽�몴占� 揶쏉옙筌욑옙 String占쎌뱽 獄쏆룇釉섓옙苑� List占쎌굨占쎄묶嚥∽옙 �뵳�뗪쉘占쎈맙
	 *
	 * @param str
	 * @param delim
	 * @return
	 */
	public static List<String> getTokens(String str, String delim) {
		if (str == null || delim == null || str.equals("") || delim.equals("")) {
			return Collections.emptyList();
		}

		List<String> list = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(str, delim);

		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}

		return list;
	}

	/**
	 * tring[] 占쎌뱽 獄쏆룇釉섓옙苑� List 占쎌굨占쎄묶嚥∽옙 �뵳�뗪쉘占쎈맙.
	 *
	 * @param str
	 * @return
	 */
	public static List<String> getList(String[] str) {
		List<String> list = new ArrayList<>();

		for (int i = 0; i < str.length; i++) {
			list.add(str[i]);
		}

		return list;
	}

	/**
	 * 占쎈솁占쎌뵬 占쎌넇占쎌삢占쎌쁽�몴占� �뵳�뗪쉘占쎈맙
	 *
	 * @param filename
	 * @return
	 */
	public static String getFileExtension(String filename) {
		String extension = null;

		if (filename != null && filename.lastIndexOf('.') > 0 && filename.length() >= 3) {
			extension = filename.substring(filename.lastIndexOf('.') + 1, filename.length());
		}

		return extension;
	}

	/**
	 * <pre>
	 * String[] items = { &quot;yellow&quot;, &quot;green&quot;, &quot;red&quot; };
	 * String[] numberItem = { &quot;1&quot;, &quot;2&quot;, &quot;3&quot; };
	 *
	 * assertEquals(&quot;'yellow','green','red'&quot;, StringUtil.makeSqlInStatement(items, true));
	 * assertEquals(&quot;1,2,3&quot;, StringUtil.makeSqlInStatement(numberItem, false));
	 * </pre>
	 *
	 * @param items in 鈺곌퀗援뷂옙肉� 占쎈굶占쎈선揶쏉옙 占쎈툡占쎌뵠占쎈�ο옙諭�
	 * @param quote 占쎌뵥占쎌뒠�겫占쏙옙�깈�몴占� �겫�늿�뵠占쎈뮉筌욑옙 占쎈연�겫占� true 筌롳옙 �겫�늿�뵥占쎈뼄
	 * @return 筌띾슢諭억옙堉깍쭪占� in 鈺곌퀗援붻눧占�
	 */
	public static String makeSqlInStatement(String[] items, boolean quote) {
		if (items == null || items.length == 0) {
			return "";
		}

		StringBuilder retStr = new StringBuilder("");
		for (int i = 0; i < items.length; i++) {
			retStr.append((!quote ? items[i] : "'" + items[i] + "'") + ",");
		}

		return retStr.toString().substring(0, retStr.length() - 1);
	}

	/**
	 * HTML占쎈퓠占쎄퐣 占쎄묶域밸챶占쏙옙 占쎌젫占쎌뇚占쎈립 �눧紐꾩쁽筌랃옙 �빊遺욱뀱占쎈릭占쎈뮉 占쎌�占쎈뼢筌롫뗄苑뚳옙諭�
	 *
	 * @param html the html
	 * @return the string
	 */
	public static String extractTextFormHTML(String html) {
		if (StringUtil.isEmpty(html)) {
			return "";
		}

		return html.replaceAll("(?:<!--.*?(?:--.*?--\\s*)*.*?-->)|(?:<(?:[^>'\"]*|\".*?\"|'.*?')+>)", "");

	}

	/**
	 * 揶쏉옙癰귨옙占쎌뵥占쎌쁽揶쏉옙(String)占쎌뱽 獄쏆룇釉섓옙苑� 占쎈릭占쎄돌占쎌벥 �눧紐꾩쁽占쎈였嚥∽옙 占쎈�燁삼옙
	 *
	 * @param str String (揶쏉옙癰귨옙占쎌뵥占쎌쁽)
	 * @return the string
	 */
	public static String appendStr(String ...str) {
		StringBuilder sumStr = new StringBuilder();
		for(String a:str) {
			sumStr.append(a);
		}
		return sumStr.toString();

	}

	 /**
     * �눧紐꾩쁽占쎈였 Null 占쎈툡占쎈빍筌롳옙 Trim 筌ｌ꼶�봺
     *
     * @param str
     * @return
     */
	public static String getStrTrim(String str) {
		if(str != null) {
			return str.trim();
		}
		return str;
	}


	/**
	 * 1. MethodName        : nullToStr
	 * 2. ClassName         : StringUtil
	 * 3. Comment           :
	 * @author              : User
	 * @version             : 2021. 12. 28. 占쎌궎占쎌뜎 5:24:11
	 * @return String
	 * @param paramStr
	 * @return
	 */
	public String nullToStr(String paramStr)	{

		if ( paramStr == null || paramStr.length() == 0 )
			return "";
		else
			return paramStr.trim();
	}

	/**
	 * 1. MethodName        : getValueFromMap
	 * 2. ClassName         : StringUtil
	 * 3. Comment           :
	 * @author              : User
	 * @version             : 2021. 12. 28. 占쎌궎占쎌뜎 5:24:17
	 * @return String
	 * @param obj
	 * @param keyName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getValueFromMap(Object obj, String keyName)	{

		Map<String, Object> paramMap = (Map<String, Object>)obj;

		String retVal	= "";

		if ( paramMap == null || paramMap.isEmpty() || ! paramMap.containsKey(keyName) || paramMap.get(keyName) == null )	{
			retVal	= "";
		}else{
			retVal	= (String) paramMap.get(keyName) == null ? "" : (String) paramMap.get(keyName);

			if ( retVal == null || retVal.length() ==0 )	{
				retVal	= "";
			}else	{
				retVal.trim();
			}
		}
		return retVal;
	}

	/**
	 * 1. MethodName        : getHanGulLengthMs949
	 * 2. ClassName         : StringUtil
	 * 3. Comment           : 占쎈립疫뀐옙 占쎌쁽�뵳�딅땾 揶쏉옙占쎌죬占쎌궎疫뀐옙
	 * @author              : hyun-wook, Kim
	 * @version             : 2022. 1. 26. 占쎌궎占쎌뜎 12:33:46
	 * @return int
	 * @param hangulStr
	 * @return
	 */
    public static int getHanGulLengthMs949(String hangulStr) {
        int iRet = 0;
    	if (hangulStr == null || "".equals(hangulStr)) {
        	return iRet;
        }

    	try {
			iRet = hangulStr.getBytes("MS949").length;
		} catch (UnsupportedEncodingException e) {
			log.error("StringUtil.getHanGulLengthMs949", e.getMessage());
		}

    	return iRet;
    }


	/**
	 * 1. MethodName        : makeAmtName
	 * 2. ClassName         : StringUtil
	 * 3. Comment           : 疫뀀뜆釉� 占쎌쁽�뵳�딅땾占쎈퓠 占쎈뎡�몴占� 占쎈떮占쎌쁽域뱀뮆�걟筌륅옙
	 * @author              : 筌띾뜄�쑓101
	 * @version             : 2022. 3. 22. 占쎌궎占쎌뜎 3:13:52
	 * @return String
	 * @param amt
	 * @return
	 */
	public static String makeAmtName(String amt) {

		String returnVal = amt;

		//占쎈섣占쎌뜚占쏙옙
		if( returnVal.length() >= 9 ) {
			if( 1 ==  returnVal.substring(0, returnVal.length()-8).length() ) {
				returnVal = returnVal.substring(0, returnVal.length()-8).concat("占쎈섣占쎌뜚");
			}else if( 3 == returnVal.substring(0, returnVal.length()-8).length() ){
				returnVal = returnVal.substring(0, returnVal.length()-10).concat("獄쏄퉮堉뀐옙�뜚");
			}else if( 4 >= returnVal.substring(0, returnVal.length()-8).length() ){
				returnVal = returnVal.substring(0, returnVal.length()-11).concat("筌ｌ뮇堉뀐옙�뜚");
			}

		}else if( 8 == returnVal.length() ) { //筌ｌ뮆彛뷂옙�뜚占쏙옙
			returnVal = returnVal.substring(0,1).concat("筌ｌ뮆彛뷂옙�뜚");
		}else if( 7 == returnVal.length() ) {// 占쎄돌�솒紐꾬옙 100筌띾슣�뜚占쏙옙
			returnVal = returnVal.substring(0,1).concat("獄쏄퉭彛뷂옙�뜚");
		}else if( 6 == returnVal.length()){//占쎈뼏筌띾슣�뜚占쏙옙
			returnVal = returnVal.substring(0,2).concat("筌띾슣�뜚");
		}else if( 5 == returnVal.length() ){//筌띾슣�뜚占쏙옙
			returnVal = returnVal.substring(0,1).concat("筌띾슣�뜚");
		}else if( "0".equals(amt)) {  //占쎌뵠占쎈릭
			returnVal = "占쎌뵠占쎈릭";
		}else if( "-1".equals(amt)) {  //占쎌뵠占쎄맒
			returnVal = "占쎌뵠占쎄맒";
		}

		return returnVal;

	}
	/**
	 * 1. MethodName        : tagFilter
	 * 2. ClassName         : StringUtil
	 * 3. Comment           : 占쎄묶域뱄옙 占쎈툡占쎄숲筌랃옙
	 * @author              : jjhan
	 * @version             : 2022. 03. 22. 占쎌궎占쎌뜎 5:28:17
	 * @return String
	 * @param String
	 * @param str
	 * @return
	 */
	public static String tagFilter( String str ) {
		if (null == str) return "";

		return str.replace( "&"   , "&amp;"  )
				  .replace( ">"   , "&gt;"   )
				  .replace( "<"   , "&lt;"   )
				  .replace( "'"   , "&apos;" )
				  .replace( "\""  , "&quot;" )
			;
	}

	/**
	 * 1. MethodName        : tagUnFilter
	 * 2. ClassName         : StringUtil
	 * 3. Comment           : 占쎈툡占쎄숲筌띻낮留� 占쎄묶域뱄옙 �눧紐꾩쁽 占쎌뜚癰귨옙
	 * @author              : jjhan
	 * @version             : 2022. 03. 22. 占쎌궎占쎌뜎 5:28:17
	 * @return String
	 * @param String
	 * @param str
	 * @return
	 */
	public static String tagUnFilter( String str ) {
		if (null == str) return "";

		return str.replace( "&gt;"   , ">"  )
				  .replace( "&lt;"   , "<"  )
				  .replace( "&apos;" , "'" )
				  .replace( "&quot;" , "\"" )
				  .replace( "&amp;"  , "&"  )
			;
	}
}
