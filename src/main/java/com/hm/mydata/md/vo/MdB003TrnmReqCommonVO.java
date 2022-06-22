package com.hm.mydata.md.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 1. ClassName :
 * 2. FileName  : MdB006BankAcctBascVO.java
 * 3. Package   : kmds.md.b.vo
 * 4. Comment   :
 * @author      :
 * @version     : 2022. 2. 18. �삤�쟾 10:55:01
 */

@Getter
@ToString
public class MdB003TrnmReqCommonVO {
	/**
	 * 怨좉컼踰덊샇
	 */
	private String csno;

	/**
	 * 留덉씠�뜲�씠�꽣湲곌�肄붾뱶
	 */
	private List<InstVO> mydtInstCodeList;

	/**
	 * �젙蹂댁젣怨듭씤利앸갑�떇援щ텇
	 */
	private String infrOfrAthnDtcd;


    /**
     * 1. Comment : innerClass
     * @author      : NONE
     * @version     : 2025.05. 24. �삤�쟾 12:00:00
     */
	@Getter
	@Setter
	@ToString
	public static class InstVO {
		private String mydtInstCode;
	}

	private String mode;

	private String errorInstCode;
	private String errorDescription;
	private String error;
}