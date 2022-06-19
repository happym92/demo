package com.hm.mydata.md.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class CertResVO {

	private String org_code;
	private String install_url_android;
	private String app_scheme_android;
	private String app_scheme_iOS;
	private String install_url_iOS;
	
	private String code;
	private String state;
	private String api_tran_id;
	
	private String error;
	private String error_description;
}
