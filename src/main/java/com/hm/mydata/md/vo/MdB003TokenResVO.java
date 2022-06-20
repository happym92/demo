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
public class MdB003TokenResVO {

	private String token_type;
	private String access_token;
	private String expires_in;
	private String refresh_token;
	private String refresh_token_expires_in;
	private String scope;

}
