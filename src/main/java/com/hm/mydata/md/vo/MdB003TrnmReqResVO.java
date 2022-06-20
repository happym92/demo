package com.hm.mydata.md.vo;

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
public class MdB003TrnmReqResVO {

	private String rsp_code;
	private String rsp_msg;
	private String is_scheduled;
	private String fnd_cycle;
	private String add_cycle;
	private String end_date;
	private String purpose;
	private String period;
	private String is_consent_trans_memo;
	private String is_consent_merchant_name_regno;
	private String is_consent_trans_category;

}
