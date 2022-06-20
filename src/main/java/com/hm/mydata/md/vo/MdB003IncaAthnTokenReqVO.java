package com.hm.mydata.md.vo;


import lombok.Getter;
import lombok.Setter;

/**
 * 1. ClassName :
 * 2. FileName  : MdB006BankAcctBascVO.java
 * 3. Package   : kmds.md.b.vo
 * 4. Comment   :
 * @author      :
 * @version     : 2022. 2. 18. �삤�쟾 10:55:01
 */

@Getter
@Setter
public class MdB003IncaAthnTokenReqVO {
	/**
	 * �씤媛�肄붾뱶
	 */
	private String code;

	/**
	 * �긽�깭媛�
	 */
	private String state;

	/**
	 * 留덉씠�뜲�씠�꽣嫄곕옒怨좎쑀踰덊샇
	 */
	private String apiTranId;

	private String csno;
}
