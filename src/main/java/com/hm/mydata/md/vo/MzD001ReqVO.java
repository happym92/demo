package com.hm.mydata.md.vo;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 1. ClassName : MzD001ReqVO
 * 2. FileName  : MzD001ReqVO.java
 * 3. Package   : kmds.mz.d.vo
 * 4. Comment   : 怨듯넻 Request Parameter
 * @author      : hyun-wook, Kim
 * @version     : 2022. 2. 10. �삤�썑 5:42:49
 */
@Data
public class MzD001ReqVO {

	private String csno;

	private String mydtInstCode;

	private String apiType;

	private String mydtApiDsticCode;

	private String bondDiv;

	private String IRPDiv;

	private String prepaidDiv;

	private List<InstCodeVO> mydtInstCodeList;

	@Getter
	@Setter
	public static class InstCodeVO {
		private String mydtInstCode;  // 留덉씠�뜲�씠�꽣湲곌�肄붾뱶
	}

	/**
	 * �쟾�넚�슂援ъ쑀�삎肄붾뱶
	 */
	private String trnmReqPtcd;

	/**
	 * user-refresh 遺꾧린
	 */
	private String refreshDiv;

}
