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
 * @version     : 2021. 12. 28. �삤�썑 5:23:19
 */
@Slf4j
public class StringUtil {
	private static final Logger LOG = LogManager.getLogger(StringUtil.class);

	private static final String TAG_QUOT = "&quot;";
	private static final String TAG_AMP = "&amp;";
	private static final String TAG_LT = "&lt;";
	private static final String TAG_GT = "&gt;";
	private static final String TAG_BR = "<br>";

	/**
	 * 臾몄옄�뿴�쓽 Empty or Null 泥댄겕
	 *
	 * @param str
	 * @return
	 */
	/**
	 * 1. MethodName        : isEmpty
	 * 2. ClassName         : StringUtil
	 * 3. Comment           :
	 * @author              : User
	 * @version             : 2021. 12. 28. �삤�썑 5:23:23
	 * @return boolean
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return (str == null || str.trim().equals(""));
	}

    /**
     * 臾몄옄�뿴�쓽 notEmpty or notNull 泥댄겕
     *
     * @param str
     * @return
     */
	public static boolean isNotEmpty(String str) {
	    return !isEmpty(str);
	}

//    /**
//     * Object Empty or Null 泥댄겕
//     *
//     * @param str
//     * @return
//     */
//	public static boolean isEmpty(Object obj) {
//	    return (obj == null || obj.toString().trim().equals(""));
//	}
//
//	/**
//	 * Object notEmpty or notNull 泥댄겕
//	 *
//	 * @param str
//	 * @return
//	 */
//	public static boolean isNotEmpty(Object obj) {
//	    return !isEmpty(obj);
//	}

    /**
     * 臾몄옄�뿴 Null 泥댄겕
     *
     * @param str
     * @return
     */
	public static boolean isNull(String str) {
        return (str == null);
	}

    /**
     * 臾몄옄�뿴 Null 泥댄겕
     *
     * @param str
     * @return
     */
	public static boolean isNotNull(String str) {
	    return !isNull(str);
	}

    /**
     * Object Null 泥댄겕
     *
     * @param str
     * @return
     */
	public static boolean isNull(Object obj) {
	    return (obj == null);
	}

    /**
     * Object Null 泥댄겕
     *
     * @param str
     * @return
     */
	public static boolean isNotNull(Object obj) {
	    return !isNull(obj);
	}

	/**
	 * 臾몄옄�뿴�쓽 Null 媛� 移섑솚
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
    * �빐�떦 Object瑜� String�쑝濡� �삎蹂��삎�븯�뿬 由ы꽩�븳�떎.
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
        		LOG.error("error stack", e);
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
	 * @version             : 2021. 12. 28. �삤�썑 5:23:31
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
	 * 臾몄옄�뿴�쓣 �듅�젙 �겕湲곕줈 �옒�씪�궦�떎.
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
				// 1byte character �씠硫�
				byteSize = 1;
			} else {
				// 2byte character �씠硫�
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
	 * delimeter濡� �뀈,�썡,�씪�쓣 援щ텇�빐�꽌 �굹�늿�떎.
	 *
	 * @param value HHMMSS濡� 援ъ꽦�릺�뼱 �엳�뒗 String
	 * @return 援щ텇�옄濡� 援щ텇�씠 �맂 寃곌낵 媛�
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
	 * @version             : 2021. 12. 28. �삤�썑 5:23:37
	 * @return String
	 * @param str
	 * @return
	 */
	public static String formatDate(String str) {
		return formatDate(str, ".");
	}

	/**
	 * delimeter濡� �떆,遺�,珥� �쓣 援щ텇�빐�꽌 �굹�늿�떎.
	 *
	 * @param value HHMMSS濡� 援ъ꽦�릺�뼱 �엳�뒗 String
	 * @return 援щ텇�옄濡� 援щ텇�씠 �맂 寃곌낵 媛�
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
	 * @version             : 2021. 12. 28. �삤�썑 5:23:41
	 * @return String
	 * @param str
	 * @return
	 */
	public static String formatTime(String str) {
		return formatTime(str, ":");
	}

	/**
	 * �꽆�뼱�삩 媛믪뿉 �꽭�옄由щ쭏�떎 ','瑜� �꽔�뼱二쇰뒗 �븿�닔.
	 *
	 * @param value comma瑜� 遺숈뿬�빞 �릺�뒗 �닽�옄
	 * @return �꽭�옄由� 留덈떎 ,媛� 遺숈뼱 �엳�뒗 String
	 */
	public static String formatNumber(int value) {
		return formatNumber(String.valueOf(value));
	}

	/**
	 * �꽆�뼱�삩 媛믪뿉 �꽭�옄由щ쭏�떎 ','瑜� �꽔�뼱二쇰뒗 �븿�닔. �닽�옄�씤吏��뒗 泥댄겕�븯吏� �븡�쓬.
	 *
	 * @param value comma瑜� 遺숈뿬�빞 �릺�뒗 String
	 * @return �꽭�옄由� 留덈떎 ,媛� 遺숈뼱 �엳�뒗 String
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
	 * 999,999,999 �삉�뒗 999,999,999.99 format�쑝濡� �릺�뼱�엳�뒗 �옄猷뚮�� ','媛� �뾾�뒗 �삎�떇�쑝濡� 蹂��솚
	 *
	 * @param value String type�쓽 �뜲�씠�꽣
	 * @return String �닽�옄 format�쑝濡� 蹂��솚�맂 �뜲�씠�꽣
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
	 * 吏��뿭踰덊샇�굹 �빖�뱶�룿�쓽 �넻�떊�뾽�옄踰덊샇瑜� �뙆�떛(0�궘�젣)�븯�뿬 由ы꽩�븳�떎.
	 *
	 * @param value �뙆�떛�븷 踰덊샇 String
	 * @param gubun 吏��뿭踰덊샇�씤吏� �넻�떊�뾽�옄踰덊샇�씤吏�瑜� 援щ텇�븯�뒗 援щ텇�옄( R or H )
	 * @return �뙆�떛�맂 寃곌낵 媛�
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
	 * �쟾�솕踰덊샇瑜� �뙆�떛(0�궘�젣)�븯�뿬 由ы꽩�븳�떎.
	 *
	 * @param value �뙆�떛�븷 踰덊샇 String
	 * @return �뙆�떛�맂 寃곌낵 媛�
	 */
	public static String formatTel2(String value) {
		return formatTel2(value, null);
	}

	/**
	 * �쟾�솕踰덊샇瑜� �뙆�떛(0�궘�젣)�븯�뿬 由ы꽩�븳�떎.
	 *
	 * @param value     �뙆�떛�븷 踰덊샇 String
	 * @param delimeter 援�踰덇낵 踰덊샇瑜� 援щ텇�븯�뒗 臾몄옄( eg. '-'...)
	 * @return value �뙆�떛�맂 寃곌낵 媛�
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
	 * �꽆�뼱�삩 媛믪뿉 �꽕�옄由щ쭏�떎 '-'瑜� �꽔�뼱二쇰뒗 �븿�닔.
	 *
	 * @param value �뙆�떛�븷 踰덊샇 String
	 * @return �뙆�떛�맂 寃곌낵 媛�
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
	 * 臾몄옄�뿴�쓽 �븵�뿉 �엳�뒗 0�쓣 �궘�젣�븯�뿬 由ы꽩�븳�떎.
	 *
	 * @param value �뙆�떛�븷 踰덊샇 String
	 * @return value �뙆�떛�맂 寃곌낵 媛�
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
	 * 8859-1�쓣 euc-kr濡� 諛붽씔�떎.
	 *
	 * @param str �씤肄붾뵫�븷 臾몄옄�뿴 String
	 * @return �씤肄붾뵫�맂 寃곌낵 媛�
	 */
	public static String toKorean(String value) {
		String str = value;
		try {
			if (str != null) {
				str = new String(str.getBytes(StandardCharsets.ISO_8859_1), "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			LOG.error("error stack", e);
			return "ENCORDING ERROR";
		}

		return str;
	}

	/**
	 * euc-kr�쓣 8859-1濡� 諛붽씔�떎.
	 *
	 * @param str �씤肄붾뵫�븷 臾몄옄�뿴 String
	 * @return �씤肄붾뵫�맂 寃곌낵 媛�
	 */
	public static String toEnglish(String value) {
		String str = value;
		try {
			if (str != null) {
				str = new String(str.getBytes("utf-8"), StandardCharsets.ISO_8859_1);
			}
		} catch (UnsupportedEncodingException e) {
			LOG.error("error stack", e);
			return "ENCORDING ERROR";
		}

		return str;
	}

	/**
	 * lpad �븿�닔
	 *
	 * @param str ���긽臾몄옄�뿴, len 湲몄씠, addStr ��泥대Ц�옄
	 * @return 臾몄옄�뿴
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
	 * 臾몄옄�뿴 移섑솚
	 * @param �썝蹂� String
	 * @param 踰붿쐞 �떆�옉 index
	 * @param 踰붿쐞 醫낅즺 index
	 * @param 蹂�寃쎈맆 臾몄옄
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
	 * 臾몄옄�뿴�쓣 移섑솚�븿
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
	 * 臾몄옄�뿴�쓽 Null�쓣 Empty濡� 移섑솚�븿
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
	 * 臾몄옄�뿴�쓽 \n�쓣 <br>
	 * 濡� 移섑솚�븿
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
	 * 臾몄옄�뿴 移섑솚
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
	 * 臾몄옄�뿴 移섑솚
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
	 * 臾몄옄�뿴 移섑솚
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
	 * 臾몄옄�뿴 移섑솚
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
	 * 臾몄옄�뿴 移섑솚
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
	 * 援щ텇�옄瑜� 媛�吏� String�쓣 諛쏆븘�꽌 List�삎�깭濡� 由ы꽩�븿
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
	 * tring[] �쓣 諛쏆븘�꽌 List �삎�깭濡� 由ы꽩�븿.
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
	 * �뙆�씪 �솗�옣�옄瑜� 由ы꽩�븿
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
	 * @param items in 議곌굔�뿉 �뱾�뼱媛� �븘�씠�뀥�뱾
	 * @param quote �씤�슜遺��샇瑜� 遺숈씠�뒗吏� �뿬遺� true 硫� 遺숈씤�떎
	 * @return 留뚮뱾�뼱吏� in 議곌굔臾�
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
	 * HTML�뿉�꽌 �깭洹몃�� �젣�쇅�븳 臾몄옄留� 異붿텧�븯�뒗 �쑀�떥硫붿꽌�뱶
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
	 * 媛�蹂��씤�옄媛�(String)�쓣 諛쏆븘�꽌 �븯�굹�쓽 臾몄옄�뿴濡� �빀移�
	 *
	 * @param str String (媛�蹂��씤�옄)
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
     * 臾몄옄�뿴 Null �븘�땲硫� Trim 泥섎━
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
	 * @version             : 2021. 12. 28. �삤�썑 5:24:11
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
	 * @version             : 2021. 12. 28. �삤�썑 5:24:17
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
	 * 3. Comment           : �븳湲� �옄由ъ닔 媛��졇�삤湲�
	 * @author              : hyun-wook, Kim
	 * @version             : 2022. 1. 26. �삤�썑 12:33:46
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
	 * 3. Comment           : 湲덉븸 �옄由ъ닔�뿉 �뵲瑜� �닾�옄洹쒕え紐�
	 * @author              : 留덈뜲101
	 * @version             : 2022. 3. 22. �삤�썑 3:13:52
	 * @return String
	 * @param amt
	 * @return
	 */
	public static String makeAmtName(String amt) {

		String returnVal = amt;

		//�뼲�썝��
		if( returnVal.length() >= 9 ) {
			if( 1 ==  returnVal.substring(0, returnVal.length()-8).length() ) {
				returnVal = returnVal.substring(0, returnVal.length()-8).concat("�뼲�썝");
			}else if( 3 == returnVal.substring(0, returnVal.length()-8).length() ){
				returnVal = returnVal.substring(0, returnVal.length()-10).concat("諛깆뼲�썝");
			}else if( 4 >= returnVal.substring(0, returnVal.length()-8).length() ){
				returnVal = returnVal.substring(0, returnVal.length()-11).concat("泥쒖뼲�썝");
			}

		}else if( 8 == returnVal.length() ) { //泥쒕쭔�썝��
			returnVal = returnVal.substring(0,1).concat("泥쒕쭔�썝");
		}else if( 7 == returnVal.length() ) {// �굹癒몄� 100留뚯썝��
			returnVal = returnVal.substring(0,1).concat("諛깅쭔�썝");
		}else if( 6 == returnVal.length()){//�떗留뚯썝��
			returnVal = returnVal.substring(0,2).concat("留뚯썝");
		}else if( 5 == returnVal.length() ){//留뚯썝��
			returnVal = returnVal.substring(0,1).concat("留뚯썝");
		}else if( "0".equals(amt)) {  //�씠�븯
			returnVal = "�씠�븯";
		}else if( "-1".equals(amt)) {  //�씠�긽
			returnVal = "�씠�긽";
		}

		return returnVal;

	}
	/**
	 * 1. MethodName        : tagFilter
	 * 2. ClassName         : StringUtil
	 * 3. Comment           : �깭洹� �븘�꽣留�
	 * @author              : jjhan
	 * @version             : 2022. 03. 22. �삤�썑 5:28:17
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
	 * 3. Comment           : �븘�꽣留곷맂 �깭洹� 臾몄옄 �썝蹂�
	 * @author              : jjhan
	 * @version             : 2022. 03. 22. �삤�썑 5:28:17
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
