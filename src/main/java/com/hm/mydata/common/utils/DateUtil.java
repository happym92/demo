package com.hm.mydata.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hm.mydata.common.constants.CommonConstant;


/**
 * 1. ClassName :
 * 2. FileName  : DateUtil.java
 * 3. Package   : kmds.com.framework.common.utils
 * 4. Comment   :
 * @author      : User
 * @version     : 2021. 12. 28. �삤�썑 4:57:57
 */
public final class DateUtil {

	private static final Logger LOG = LoggerFactory.getLogger(DateUtil.class);

	/**
	 * 1. MethodName  : DateUtil
	 * 2. ClassName   : DateUtil
	 * 3. Comment     :
	 * @author        : User
	 * @version       : 2021. 12. 28. �삤�썑 4:56:25
	 */
	private DateUtil() {
		throw new AssertionError();
	}

	/**
	 * �쁽�옱 �궇吏� 援ы븯湲�
	 *
	 * @param format
	 * @return
	 */
	public static String getToday(String formatStr) {

		String format = formatStr;
		if (format == null || format.equals("")) {
			format = CommonConstant.DATE_FORMAT_YYYYMMDD;
		}

		Date date = new Date();
		SimpleDateFormat sdate = new SimpleDateFormat(format);

		return sdate.format(date);
	}

	/**
	 * �쁽�옱 �궇吏� �떆媛� 援ы븯湲�
	 *
	 * @param format
	 * @return
	 */
	public static String getTodayDateTime(String formatStr) {

		String format = formatStr;
		if (format == null || format.equals("")) {
			format = CommonConstant.DATE_FORMAT_YYYYMMDDHHMMSS;
		}
		Date date = new Date();
		SimpleDateFormat sdate = new SimpleDateFormat(format);

		return sdate.format(date);
	}

    /**
     * �쁽�옱 Millisecond 援ы븯湲�
     *
     * @param format
     * @return
     */
    public static String getMillisecond(){
        return getFmtDateString(new Date(System.currentTimeMillis()), "yyyyMMddHHmmssSSS");
    }

    /**
     * �떆�뒪�뀥 �궇吏� (Calendar.YEAR)
     *
     * @param
     * @return
     */
    public static String getSysYear() {
        return Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
    }

    /**
     * �떆�뒪�뀥 �궇吏� - 2�옄由� �몴�쁽 �썡 (MM)
     *
     * @param
     * @return
     */
    public static String getSysTwoDigitMonth() {
        return getFmtDateString(new Date(), "MM");
    }

	/**
	 * Date瑜� Format 臾몄옄�뿴濡� 諛붽씀湲�
	 *
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getFmtDateString(Date date, String format) {
		SimpleDateFormat sdate = new SimpleDateFormat(format);

		return sdate.format(date);
	}

	/**
	 * Date瑜� Format 臾몄옄�뿴濡� 諛붽씀湲�
	 *
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getFmtDateString(String date, String format) {
		Date todate = toDate(date);

		return getFmtDateString(todate, format);
	}

	/**
	 * 援щ텇�옄媛� 異붽��맂 �궇吏� �뒪�듃留�
	 *
	 * @param date
	 * @param delim
	 * @return
	 */
	public static String getDelimDateString(String date, String delim) {
		String strDate = "";

		if (date != null) {
			strDate = date.trim();
		}

		if (strDate.length() != 8) {
			return "";
		}

		for (int inx = 0; inx < strDate.length(); inx++) {
//			System.out.println(Character.isLetter(strDate.charAt(inx)));
			if (Character.isLetter(strDate.charAt(inx)) || strDate.charAt(inx) == ' ') {
				return "";
			}
		}

		String unFmtDate = getUnFmtDateString(date);

		StringBuilder buf = new StringBuilder();

		buf.append(unFmtDate.substring(0, 4));
		buf.append(delim);
		buf.append(unFmtDate.substring(4, 6));
		buf.append(delim);
		buf.append(unFmtDate.substring(6, 8));

		return buf.toString();
	}

	/**
	 * 1. MethodName        : checkDateCorrect
	 * 2. ClassName         : DateUtil
	 * 3. Comment           :
	 * @author              : User
	 * @version             : 2021. 12. 28. �삤�썑 4:58:09
	 * @return String
	 * @param fmtDate
	 * @return
	 */
	private static String checkDateCorrect(String fmtDate) {
		String strDate = "";

		if (fmtDate != null) {
			strDate = fmtDate.trim();
		}

		for (int inx = 0; inx < strDate.length(); inx++) {
			if (Character.isLetter(strDate.charAt(inx)) || strDate.charAt(inx) == ' ') {
				strDate = "";
				break;
			}
		}
		return strDate;
	}

	/**
	 * 1. MethodName        : removeDivDateNot8
	 * 2. ClassName         : DateUtil
	 * 3. Comment           :
	 * @author              : User
	 * @version             : 2021. 12. 28. �삤�썑 4:58:13
	 * @return String
	 * @param strDate
	 * @return
	 */
	private static String removeDivDateNot8(String strDate) {
		String date = "";
		String result = "";

		if (strDate.length() != 6 && strDate.length() != 10) {
			return "";
		}

		if (strDate.length() == 6) {
			if (Integer.parseInt(strDate.substring(0, 2)) > 50) {
				date = "19";
			} else {
				date = "20";
			}

			result = date + strDate;
		}

		if (strDate.length() == 10) {
			result = strDate.substring(0, 4) + strDate.substring(4, 8) + strDate.substring(8, 10);
		}
		return result;
	}

	/**
	 * 1. MethodName        : removeDivDate
	 * 2. ClassName         : DateUtil
	 * 3. Comment           :
	 * @author              : User
	 * @version             : 2021. 12. 28. �삤�썑 4:58:18
	 * @return String
	 * @param strDate
	 * @return
	 */
	private static String removeDivDate(String strDate) {
		boolean isCharater = false;
		String date = "";
		String result = "";

		try {
			Integer.parseInt(strDate);
		} catch (NumberFormatException ne) {
			LOG.error("error stack", ne);
			isCharater = true;
		}

		if (isCharater) {
			date = strDate.substring(0, 2) + strDate.substring(3, 5) + strDate.substring(6, 8);

			if (Integer.parseInt(strDate.substring(0, 2)) > 50) {
				result = "19" + date;
			} else {
				result = "20" + date;
			}
		} else {
			return strDate;
		}
		return result;
	}

	/**
	 * 援щ텇�옄媛� �젣嫄곕맂 �궇吏� �뒪�듃留�
	 *
	 * @param fmtDate
	 * @return
	 */
	public static String getUnFmtDateString(String fmtDate) {


		String result = "";

		String strDate = checkDateCorrect(fmtDate);

		if ("".equals(strDate)) {
			return "";
		}

		if (strDate.length() != 8) {
			result = removeDivDateNot8(strDate);
		} else {
			result = removeDivDate(strDate);
		}

		return result;
	}

	/**
	 * 二쇱뼱吏� date/time怨� year�뀈 month�썡 day�씪 李⑥씠�굹�뒗 �떆媛곸쓣 由ы꽩�븳�떎.
	 *
	 * <pre>
	 *  �궗�슜�삁)
	 *  //�쁽�옱濡쒕��꽣 10�씪 �쟾�쓽 date/time
	 *  Date newDate = DateUtil.shift(new Date(), 0,0,-10);
	 * </pre>
	 *
	 * @param date
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static Date getRelativeDate(Date date, int year, int month, int day) {
		Calendar cal = Calendar.getInstance();

		cal.setTime(date);

		cal.add(Calendar.YEAR, year);
		cal.add(Calendar.MONTH, month);
		cal.add(Calendar.DAY_OF_MONTH, day);

		return cal.getTime();
	}

	/**
	 * �뀈 �썡�쓣 �뜑�븳 �궇吏� 援ы븯湲�
	 *
	 * @param date
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getRelativeDate(Date date, int year, int month) {
		Calendar cal = Calendar.getInstance();

		cal.setTime(date);

		cal.add(Calendar.YEAR, year);
		cal.add(Calendar.MONTH, month);

		return cal.getTime();
	}

	/**
	 * �씪�쓣 �뜑�븳 �궇吏� 援ы븯湲�
	 *
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date getRelativeDate(Date date, int day) {
		Calendar cal = Calendar.getInstance();

		cal.setTime(date);

		cal.add(Calendar.DAY_OF_YEAR, day);

		return cal.getTime();
	}

	/**
	 * �쁽�옱 �떆媛곴낵 year�뀈 month�썡 day�씪 李⑥씠�굹�뒗 �떆媛곸쓣 由ы꽩�븳�떎.
	 * <p>
	 * 由ы꽩�릺�뒗 �룷留룹� 'yyyyMMdd' �씠�떎.
	 *
	 * <pre>
	 *  �궗�슜�삁)
	 *  //�쁽�옱 �떆媛곸씠 '20031001'�씠硫� 10�씪 �쟾 �떆媛곸씤 '20030921'�쓣 由ы꽩
	 *  String date = DateUtil.getRelativeDate(0,0,-10);
	 * </pre>
	 *
	 * @param date
	 * @param year
	 * @param month
	 * @param day
	 * @param format
	 * @return
	 */
	public static String getRelativeDateString(Date date, int year, int month, int day, String format) {
		Date relativeDate = getRelativeDate(date, year, month, day);

		return getFmtDateString(relativeDate, format);
	}

	/**
	 * �뀈/�썡/�씪/�떆/遺꾩쓣 �뜑�븳 �궇吏� 援ы븯湲�
	 *
	 * @param date
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @return
	 */
	public static Date getRelativeDate(Date date, int year, int month, int day, int hour, int minute) {
		Calendar cal = Calendar.getInstance();

		cal.setTime(date);

		cal.add(Calendar.YEAR, year);
		cal.add(Calendar.MONTH, month);
		cal.add(Calendar.DAY_OF_MONTH, day);
		cal.add(Calendar.HOUR_OF_DAY, hour);
		cal.add(Calendar.MINUTE, minute);

		return cal.getTime();
	}

	/**
	 * �쁽�옱 �떆媛곴낵 year�뀈 month�썡 day�씪 hour�떆 minute遺� 李⑥씠�굹�뒗 �떆媛곸쓣 由ы꽩�븳�떎.
	 * <p>
	 * 由ы꽩�릺�뒗 �룷留룹� 'yyyyMMddhh24mi' �씠�떎.s
	 *
	 * @param date
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @param format
	 * @return
	 */
	public static String getRelativeDateString(Date date, int year, int month, int day, int hour, int minute,
			String format) {
		Date relativeDate = getRelativeDate(date, year, month, day, hour, minute);

		return getFmtDateString(relativeDate, format);
	}

	/**
	 * �듅�젙�씪怨� year�뀈 month�썡 day�씪 hour�떆 minute遺� 李⑥씠�굹�뒗 �떆媛곸쓣 由ы꽩�븳�떎.
	 * <p>
	 * 由ы꽩�릺�뒗 �룷留룹� 'yyyyMMddhh24mi' �씠�떎.
	 *
	 * @param date
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @param format
	 * @return
	 */
	public static String getRelativeDateString(String date, int year, int month, int day, int hour, int minute,
			String format) {
		Calendar cal = toCalendar(date.substring(0, 8), Integer.parseInt(date.substring(8, 10)),
				Integer.parseInt(date.substring(10, 12)));

		cal.add(Calendar.YEAR, year);
		cal.add(Calendar.MONTH, month);
		cal.add(Calendar.DAY_OF_MONTH, day);
		cal.add(Calendar.HOUR_OF_DAY, hour);
		cal.add(Calendar.MINUTE, minute);

		SimpleDateFormat dateFormat = new SimpleDateFormat(format);

		return dateFormat.format(cal.getTime());
	}

	/**
	 * �씠�썑 �궇吏� 援ы븯湲�
	 *
	 * @param date
	 * @param days
	 * @param format
	 * @return
	 */
	public static String getNextDate(String date, int days, String formatStr) {
		if (days < 0) {
			return date;
		}

		String format = formatStr;
		if (format == null || format.equals("")) {
			format = CommonConstant.DATE_FORMAT_YYYYMMDD;
		}

		Calendar cal = toCalendar(date);

		cal.add(Calendar.DATE, days);

		SimpleDateFormat dateFormat = new SimpleDateFormat(format);

		return dateFormat.format(cal.getTime());
	}

	/**
	 * �씠�쟾 �궇吏� 援ы븯湲�(yyyymmdd �삎�떇�쑝濡� �엯�젰 �뙆�씪誘명꽣瑜� 諛쏆쓬)
	 *
	 * @param date
	 * @param days
	 * @param format
	 * @return
	 */
	public static String getPrevDate(String date, int days, String formatStr) {

		if (days < 0) {
			return date;
		}

		String format = formatStr;
		if (format == null || format.equals("")) {
			format = CommonConstant.DATE_FORMAT_YYYYMMDD;
		}

		java.util.Calendar cal = toCalendar(date);

		cal.add(Calendar.DATE, -(days));

		SimpleDateFormat dateFormat = new SimpleDateFormat(format);

		return dateFormat.format(cal.getTime());
	}

	/**
	 * �떎�쓬 二� �궇吏� 援ы븯湲�
	 *
	 * @param date
	 * @param weeks
	 * @param format
	 * @return
	 */
	public static String getNextWeekDate(String date, int weeks, String format) {
		if (weeks < 0) {
			return date;
		}

		java.util.Calendar cal = toCalendar(date);

		cal.add(Calendar.DATE, weeks * 7);

		SimpleDateFormat dateFormat = new SimpleDateFormat(format);

		return dateFormat.format(cal.getTime());
	}

	/**
	 * �씠�쟾 二� �궇吏� 援ы븯湲�
	 *
	 * @param date
	 * @param weeks
	 * @param format
	 * @return
	 */
	public static String getPrevWeekDate(String date, int weeks, String format) {
		if (weeks < 0) {
			return date;
		}

		java.util.Calendar cal = toCalendar(date);

		cal.add(Calendar.DATE, weeks * (-7));

		SimpleDateFormat dateFormat = new SimpleDateFormat(format);

		return dateFormat.format(cal.getTime());
	}

	/**
	 * �떎�쓬 �떖 �궇吏� 援ы븯湲�
	 *
	 * @param date
	 * @param months
	 * @param format
	 * @return
	 */
	public static String getNextMonthDate(String date, int months, String format) {
		if (months < 0) {
			return date;
		}

		java.util.Calendar cal = toCalendar(date);

		cal.add(Calendar.MONTH, months);

		SimpleDateFormat dateFormat = new SimpleDateFormat(format);

		return dateFormat.format(cal.getTime());
	}

	/**
	 * �씠�쟾 �떖 �궇吏� 援ы븯湲�
	 *
	 * @param date
	 * @param months
	 * @param format
	 * @return
	 */
	public static String getPrevMonthDate(String date, int months, String format) {
		if (months < 0) {
			return date;
		}

		java.util.Calendar cal = toCalendar(date);

		cal.add(Calendar.MONTH, -(months));

		SimpleDateFormat dateFormat = new SimpleDateFormat(format);

		return dateFormat.format(cal.getTime());
	}

	/**
	 * �엯�젰�맂 �씪�옄瑜� Calendar 媛앹껜濡� 諛섑솚�븳�떎.
	 *
	 * @param argDate 蹂��솚�븷 �씪�옄( 1998.01.02, 98.01.02, 19980102, 980102 �벑 )
	 * @return �빐�떦�씪�옄�뿉 �빐�떦�븯�뒗 Calendar
	 */
	public static Calendar toCalendar(String fmtDate) {
		String date = getUnFmtDateString(fmtDate);

		GregorianCalendar calendar = new GregorianCalendar();

		calendar.set(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)) - 1,
				Integer.parseInt(date.substring(6, 8)));

		return calendar;
	}

	/**
	 * �엯�젰�맂 �씪�떆瑜� Calendar 媛앹껜濡� 諛섑솚�븳�떎.
	 *
	 * @param argDate 蹂��솚�븷 �씪�옄( 1998.01.02, 98.01.02, 19980102, 980102 �벑 )
	 * @return �빐�떦�씪�옄�뿉 �빐�떦�븯�뒗 Calendar
	 */
	public static Calendar toCalendar(String fmtDate, int hour, int minute) {
		String date = getUnFmtDateString(fmtDate);

		GregorianCalendar calendar = new GregorianCalendar();

		calendar.set(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)) - 1,
				Integer.parseInt(date.substring(6, 8)), hour, minute);

		return calendar;
	}

	/**
	 * �엯�젰�맂 �씪�옄瑜� Date 媛앹껜濡� 諛섑솚�븳�떎.
	 *
	 * @param argDate 蹂��솚�븷 �씪�옄( 1998.01.02, 98.01.02, 19980102, 980102 �벑 )
	 * @return �빐�떦�씪�옄�뿉 �빐�떦�븯�뒗 Calendar
	 */
	public static Date toDate(String fmtDate) {
		return toCalendar(fmtDate).getTime();
	}

	/**
	 * �궇吏쒖� �슂�씪�쓣 �뙆�씪誘명꽣濡� 二쇨퀬 �궇吏� �냽�븯�뒗 二쇱쓽 �슂�씪�뿉 �빐�떦�븯�뒗 �궇吏쒕�� yyyyMMdd�삎�깭濡� 援ы븿
	 */
	public static String getWeekDay(String date, int order) {
		String returnDay = null;
		Calendar curr = Calendar.getInstance();
		curr.set(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)) - 1,
				Integer.parseInt(date.substring(6, 8)));
		int weekday = curr.get(Calendar.DAY_OF_WEEK);

		if (order == weekday) {
			returnDay = date;
		} else {
			curr.add(Calendar.DATE, order - weekday);
			SimpleDateFormat sdate = new SimpleDateFormat("yyyyMMdd");
			returnDay = sdate.format(curr.getTime());
		}
		return returnDay;
	}

	/**
	 * �슂�씪�쓽 �궇吏� 援ы븯湲�
	 *
	 * @param date
	 * @param order
	 * @return
	 */
	public static Date getWeekDay(Date date, int order) {
		Date returnDay;
		Calendar curr = Calendar.getInstance();
		curr.setTime(date);
		int weekday = curr.get(Calendar.DAY_OF_WEEK);

		if (order == weekday) {
			returnDay = date;
		} else {
			curr.add(Calendar.DATE, order - weekday);
			returnDay = curr.getTime();
		}
		return returnDay;
	}

	/**
	 * 媛� �떖�쓽 1�씪�쓽 �슂�씪�쓣 援ы븿
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getFirstDay(int year, int month) {
		int firstday = 0;

		Calendar curr = Calendar.getInstance();

		curr.set(year, month - 1, 1);

		firstday = curr.get(Calendar.DAY_OF_WEEK);
		return firstday;
	}

	/**
	 * 媛� �떖�쓽 留덉�留됰궇吏쒕�� 援ы븿
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getLastDate(int year, int month) {

		int yy = year;
		int mm = month;

		switch (mm) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;

		case 4:
		case 6:
		case 9:
		case 11:
			return 30;

		default:
			if (((yy % 4 == 0) && (yy % 100 != 0)) || (yy % 400 == 0)) {
				return (29);
			} else {
				return (28);
			}
		}
	}

	/**
	 * �빐�떦 �씪�쓽 �븳湲� �슂�씪�젙蹂대�� 媛��졇�샂
	 *
	 * @param strDate
	 * @return
	 */
	public static String getDayWeekKor(String strDate) {
		String[] arrWeekName = {"�씪","�썡","�솕","�닔","紐�","湲�","�넗"};
		int week = getWeekDayCount(strDate);
		return arrWeekName[week-1];
	}

	/**
	 * 洹몃궇�쓽 weekday瑜� 援ы븿
	 *
	 * @param date
	 * @return
	 */
	public static int getWeekDayCount(String date) {
		Calendar curr = Calendar.getInstance();
		curr.set(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)) - 1,
				Integer.parseInt(date.substring(6, 8)));

		return curr.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 洹� �궇�씠 洹� �떖�쓽 紐뉖쾲吏� week �닔�씤吏� 援ы븿
	 *
	 * @param day
	 * @return
	 */
	public static int getWeekCountMonth(int day) {
		int weekCount;
		int remainCount = day - (day / 7) * 7;

		if (remainCount > 0) {
			weekCount = (day / 7) + 1;
		} else {
			weekCount = (day / 7);
		}

		return weekCount;
	}

	/**
	 * 媛� �떖�쓽 week �닔瑜� 援ы븿
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getWeekCount(int year, int month) {
		Calendar curr = Calendar.getInstance();
		curr.set(year, month - 1, getLastDate(year, month));
		return curr.get(Calendar.WEEK_OF_MONTH);
	}

	/**
	 * �씪�쓣 �뜑�븳 �궇吏� 援ы븯湲�
	 *
	 * @param dateStr
	 * @param val
	 * @param format
	 * @return
	 */
	public static String calcDate(String dateStr, int val, String format) {

		String date = dateStr;
		Calendar curr = Calendar.getInstance();
		date = unFmtDate(date);
		curr.set(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)) - 1,
				Integer.parseInt(date.substring(6, 8)));
		curr.add(Calendar.DATE, val);
		SimpleDateFormat sdate = new SimpleDateFormat(format);
		return sdate.format(curr.getTime());
	}

	/**
	 * 遺꾩쓣 �뜑�븳 �궇吏� 援ы븯湲�
	 *
	 * @param dateTimeStr
	 * @param val
	 * @param format
	 * @return
	 */
	public static String calcDateTime(String dateTimeStr, int val, String format) {
		String dateTime = dateTimeStr;
		Calendar curr = Calendar.getInstance();
		dateTime = unFmtDate(dateTime);
		curr.set(Integer.parseInt(dateTime.substring(0, 4)), Integer.parseInt(dateTime.substring(4, 6)) - 1,
				Integer.parseInt(dateTime.substring(6, 8)), Integer.parseInt(dateTime.substring(8, 10)),
				Integer.parseInt(dateTime.substring(10, 12)));
		curr.add(Calendar.MINUTE, val);
		SimpleDateFormat sdate = new SimpleDateFormat(format);
		return sdate.format(curr.getTime());
	}

	/**
	 * �룷硫㏃쓣 �젣嫄고븳 �궇吏� 援ы븯湲�
	 *
	 * @param fmtdate
	 * @return
	 */
	public static String unFmtDate(String fmtdate) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < fmtdate.length(); i++) {
			if (fmtdate.charAt(i) != '-') {
				buf.append(fmtdate.charAt(i));
			}
		}
		return buf.toString();
	}

	/**
	 * �씪二쇱씪�쓽 泥� �궇吏�(yyyyMMdd)瑜� �뙆�씪誘명꽣濡� 二쇨퀬 �빐�떦 二쇱씪�쓽 �궇吏쒕�� String[]�쑝濡� 諛쏆쓬.
	 *
	 * @param firstday
	 * @param format
	 * @return
	 */
	public static String[] getDatesInWeek(String firstday, String format) {
		String[] weekdays = new String[7];
		for (int i = 0; i < 7; i++) {
			weekdays[i] = calcDate(firstday, i, format);
		}
		return weekdays;
	}

	/**
	 * �듅�젙 湲곌컙�븞�쓽 �궇吏쒕━�뒪�듃 援ы븯湲�
	 *
	 * @param startDate
	 * @param endDate
	 * @param format
	 * @return
	 */
	public static String[] getDatesInPeriod(String startDate, String endDate, String format) {
		int dateDiffCount = getTwoDatesDifference(startDate, endDate);

		String[] days = new String[dateDiffCount + 1];

		for (int i = 0; i < dateDiffCount + 1; i++) {
			days[i] = calcDate(startDate, i, format);
		}

		return days;
	}

	/**
	 * �듅�젙 湲곌컙�븞�쓽 �떆媛꾨━�뒪�듃 援ы븯湲�
	 *
	 * @param startDateTime
	 * @param endDateTime
	 * @param format
	 * @return
	 */
	public static String[] getDateTimesInPeriod(String startDateTime, String endDateTime, String format) {
		int dateTimeDiffCount = getTwoDateTimesDifference(startDateTime, endDateTime);

		String[] dateTimes = new String[dateTimeDiffCount + 1];

		for (int i = 0; i < dateTimes.length; i++) {
			dateTimes[i] = calcDateTime(startDateTime, i * 30, format);
		}

		return dateTimes;
	}

	/**
	 * �몢�궇吏� �궗�씠�쓽 �씪�닔 援ы븯湲�
	 *
	 * @param strDate
	 * @param strComp
	 * @return
	 */
	public static int getTwoDatesDifference(String strDate, String strComp) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();

		int year = Integer.parseInt(strDate.substring(0, 4));
		int month = Integer.parseInt(strDate.substring(4, 6));
		int day = Integer.parseInt(strDate.substring(6, 8));

		int compYear = Integer.parseInt(strComp.substring(0, 4));
		int compMonth = Integer.parseInt(strComp.substring(4, 6));
		int compDay = Integer.parseInt(strComp.substring(6, 8));

		cal1.set(year, month - 1, day);
		cal2.set(compYear, compMonth - 1, compDay);
		long cal1sec = cal1.getTime().getTime();
		long cal2sec = cal2.getTime().getTime();
		long gap = cal2sec - cal1sec;

		return Integer.parseInt(String.valueOf((gap / 86400) / 1000));
	}

	/**
	 * �몢�궇吏� �궗�씠�쓽 �씪�닔 援ы븯湲�
	 *
	 * @param strDate
	 * @param strComp
	 * @return
	 */
//	public static long getTwoDateDiff(Date date, Date compareDate, String type) {
//		if (date == null) {
//			throw new IllegalArgumentException("date is null");
//		}
//		if (compareDate == null) {
//			throw new IllegalArgumentException("compareDate is null");
//		}
//
//		Long compared = date.getTime() - compareDate.getTime();
//
//		if (StringUtils.equals(type, "S")) {
//			return compared / 1000;
//
//		} else if (StringUtils.equals(type, "M")) {
//			return compared / (60 * 1000);
//
//		} else if (StringUtils.equals(type, "H")) {
//			return compared / (60 * 60 * 1000);
//
//		} else if (StringUtils.equals(type, "D")) {
//			return compared / (24 * 60 * 60 * 1000);
//
//		} else {
//			throw new IllegalArgumentException("type is allowed S, M, H, D");
//		}
//
//	}

	/**
	 * �몢�궇吏� �궗�씠�쓽 �떆媛꾩닔 援ы븯湲�
	 *
	 * @param strDateTime
	 * @param strCompTime
	 * @return
	 */
	public static int getTwoDateTimesDifference(String strDateTime, String strCompTime) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();

		int year = Integer.parseInt(strDateTime.substring(0, 4));
		int month = Integer.parseInt(strDateTime.substring(4, 6));
		int day = Integer.parseInt(strDateTime.substring(6, 8));
		int hour = Integer.parseInt(strDateTime.substring(8, 10));
		int minute = Integer.parseInt(strDateTime.substring(10, 12));

		int compYear = Integer.parseInt(strCompTime.substring(0, 4));
		int compMonth = Integer.parseInt(strCompTime.substring(4, 6));
		int compDay = Integer.parseInt(strCompTime.substring(6, 8));
		int compHour = Integer.parseInt(strCompTime.substring(8, 10));
		int compMinute = Integer.parseInt(strCompTime.substring(10, 12));

		cal1.set(year, month - 1, day, hour, minute);
		cal2.set(compYear, compMonth - 1, compDay, compHour, compMinute);
		long cal1sec = cal1.getTime().getTime();
		long cal2sec = cal2.getTime().getTime();
		long gap = cal2sec - cal1sec;

		return Integer.parseInt(String.valueOf((gap / 3600) / 1000));
	}

	/**
	 * 1. MethodName        : getTimeInterval
	 * 2. ClassName         : DateUtil
	 * 3. Comment           :
	 * @author              : hyun-wook, Kim
	 * @version             : 2021. 12. 28. �삤�썑 4:59:47
	 * @return String
	 * @param sDate
	 * @param locale
	 * @return
	 */
	public static String getTimeInterval(Date sDate, String locale) {
		return getTimeInterval(sDate, new Date(), locale);
	}

	/**
	 * 1. MethodName        : getLocaleTimeYear
	 * 2. ClassName         : DateUtil
	 * 3. Comment           :
	 * @author              : User
	 * @version             : 2021. 12. 28. �삤�썑 4:59:50
	 * @return String
	 * @param locale
	 * @param diff
	 * @return
	 */
	private static String getLocaleTimeYear(String locale, String diff) {
		String diffStr = "";
		if (locale.equals("ko")) {
			diffStr = diff + " �뀈�쟾";
		} else {
			diffStr = diff + " year ago";
		}
		return diffStr;
	}

	/**
	 * 1. MethodName        : getLocaleTimeMonth
	 * 2. ClassName         : DateUtil
	 * 3. Comment           :
	 * @author              : User
	 * @version             : 2021. 12. 28. �삤�썑 4:59:54
	 * @return String
	 * @param locale
	 * @param diff
	 * @return
	 */
	private static String getLocaleTimeMonth(String locale, String diff) {
		String diffStr = "";
		if (locale.equals("ko")) {
			diffStr = diff + " �떖�쟾";
		} else {
			diffStr = diff + " month ago";
		}
		return diffStr;
	}

	/**
	 * 1. MethodName        : getLocaleTimeDay
	 * 2. ClassName         : DateUtil
	 * 3. Comment           :
	 * @author              : User
	 * @version             : 2021. 12. 28. �삤�썑 4:59:59
	 * @return String
	 * @param locale
	 * @param diff
	 * @return
	 */
	private static String getLocaleTimeDay(String locale, String diff) {
		String diffStr = "";
		if (locale.equals("ko")) {
			diffStr = diff + " �씪�쟾";
		} else {
			diffStr = diff + " day ago";
		}
		return diffStr;
	}

	/**
	 * 1. MethodName        : getLocaleTimeHour
	 * 2. ClassName         : DateUtil
	 * 3. Comment           :
	 * @author              : User
	 * @version             : 2021. 12. 28. �삤�썑 5:00:03
	 * @return String
	 * @param locale
	 * @param diff
	 * @return
	 */
	private static String getLocaleTimeHour(String locale, String diff) {
		String diffStr = "";
		if (locale.equals("ko")) {
			diffStr = diff + " �떆媛꾩쟾";
		} else {
			diffStr = diff + " hour ago";
		}
		return diffStr;
	}

	/**
	 * 1. MethodName        : getLocaleTimeMin
	 * 2. ClassName         : DateUtil
	 * 3. Comment           :
	 * @author              : User
	 * @version             : 2021. 12. 28. �삤�썑 5:00:06
	 * @return String
	 * @param locale
	 * @param diff
	 * @return
	 */
	private static String getLocaleTimeMin(String locale, String diff) {
		String diffStr = "";
		if (locale.equals("ko")) {
			diffStr = diff + " 遺꾩쟾";
		} else {
			diffStr = diff + " minute ago";
		}
		return diffStr;
	}

	/**
	 * 1. MethodName        : getLocaleTimeSec
	 * 2. ClassName         : DateUtil
	 * 3. Comment           :
	 * @author              : User
	 * @version             : 2021. 12. 28. �삤�썑 5:00:09
	 * @return String
	 * @param locale
	 * @return
	 */
	private static String getLocaleTimeSec(String locale) {
		String diffStr = "";
		if (locale.equals("ko")) {
			diffStr = "1 遺꾩쟾";
		} else {
			diffStr = "1 second ago";
		}
		return diffStr;
	}

	/**
	 * �떆媛� �궗�씠�쓽 媛꾧꺽�쓣 援ы븿. �듃�쐞�꽣 �벑�뿉�꽌 �떆媛꾩쓣 �몴�떆�븷�븣 �궗�슜�븿
	 *
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	public static String getTimeInterval(Date sDate, Date eDate, String localeStr) {

		String diffStr = "";
		long diff = 0;

		String locale = localeStr;
		if (StringUtil.isEmpty(locale)) {
			locale = "en";
		}

		long duration = (eDate.getTime() - sDate.getTime()) / 1000;

		if (duration > (60 * 60 * 24 * 30 * 12)) {
			diff = duration / (60 * 60 * 24 * 30 * 12);
			diffStr = getLocaleTimeYear(locale, diff + "");
		} else if (duration > (60 * 60 * 24 * 30)) {
			diff = duration / (60 * 60 * 24 * 30);
			diffStr = getLocaleTimeMonth(locale, diff + "");
		} else if (duration > (60 * 60 * 24)) {
			diff = duration / (60 * 60 * 24);
			diffStr = getLocaleTimeDay(locale, diff + "");
		} else if (duration > (60 * 60)) {
			diff = duration / (60 * 60);
			diffStr = getLocaleTimeHour(locale, diff + "");
		} else if (duration > (60)) {
			diff = duration / (60);
			diffStr = getLocaleTimeMin(locale, diff + "");
		} else {
			diffStr = getLocaleTimeSec(locale);
		}

		return diffStr;
	}

	/**
	 * 1. MethodName        : getDateParameter
	 * 2. ClassName         : DateUtil
	 * 3. Comment           :
	 * @author              : User
	 * @version             : 2021. 12. 28. �삤�썑 5:00:15
	 * @return String
	 * @param yyyymmdd
	 * @return
	 */
//	private static String getDateParameter(String yyyymmdd) {
//		if (yyyymmdd == null) {
//			return "";
//		}
//
//		String date = yyyymmdd.trim();
//		if (date.length() != 8) {
//			if (date.length() == 4) {
//				date = date + "0101";
//			} else if (date.length() == 6) {
//				date = date + "01";
//			} else if (date.length() > 8) {
//				date = date.substring(0, 8);
//			} else {
//				return "";
//			}
//		}
//		return date;
//	}

	/**
	 * 1. MethodName        : getDateFormat
	 * 2. ClassName         : DateUtil
	 * 3. Comment           :
	 * @author              : User
	 * @version             : 2021. 12. 28. �삤�썑 5:00:19
	 * @return String
	 * @param y
	 * @param m
	 * @param d
	 * @return
	 */
//	private static String getDateFormat(int y, int m, int d) {
//		StringBuilder ret = new StringBuilder();
//		if (y < 1000) {
//			ret.append("0");
//		} else if (y < 100) {
//			ret.append("00");
//		} else if (y < 10) {
//			ret.append("000");
//		}
//		ret.append(y);
//
//		if (m < 10) {
//			ret.append("0");
//		}
//		ret.append(m);
//
//		if (d < 10) {
//			ret.append("0");
//		}
//		ret.append(d);
//
//		return ret.toString();
//	}

	/**
	 * Date �뒪�듃留곸쓽 �쑀�슚�뿬遺�瑜� 泥댄겕�븯怨� �쑀�슚�븳 Date �뒪�듃留곸쓣 諛섑솚
	 *
	 * @param yyyymmdd
	 * @return
	 */
	public static String getValidDate(String yyyymmdd) {
		String strYear = "";
		String strMonth = "";
		String strDay = "";
		int validMonthDay = 0;
		String validDate = "";

		if (yyyymmdd.length() == 8) {
			strYear = yyyymmdd.substring(0, 4);
			strMonth = yyyymmdd.substring(4, 6);
			strDay = yyyymmdd.substring(6, 8);

			validMonthDay = getLastDate(Integer.parseInt(strYear), Integer.parseInt(strMonth));

			if (Integer.parseInt(strDay) <= validMonthDay) {
				validDate = yyyymmdd;
			} else {
				validDate = strYear + strMonth + String.valueOf(validMonthDay);
			}

			return validDate;
		} else {
			return "";
		}
	}

}
