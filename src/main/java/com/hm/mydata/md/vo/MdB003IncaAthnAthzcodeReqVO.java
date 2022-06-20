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
@Setter
@ToString
public class MdB003IncaAthnAthzcodeReqVO {
	/**
	 * 怨좉컼踰덊샇
	 */
	private String csno;

	/**
	 * 留덉씠�뜲�씠�꽣湲곌�肄붾뱶
	 */
	private String mydtInstCode;

	private String apiType;

	/**
	 * userCi
	 */
	private String userCi;

	private List<InfrTrnmCnstVO> infrTrnmCnstList;

    /**
     * 1. Comment : innerClass
     * @author      : NONE
     * @version     : 2025.05. 24. �삤�쟾 12:00:00
     */
	@Getter
	@Setter
	@ToString
	public static class InfrTrnmCnstVO {
		private String mydtStplClcd;
		private String stplId;
		private String stplVrsnName;
		private String cnstYn;
	}

}
