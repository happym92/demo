package com.hm.mydata.md.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 1. ClassName : MdB003IncaAthnAthzcodeResVO
 * 2. FileName  : MdB003IncaAthnAthzcodeResVO.java
 * 3. Package   : kmds.md.b.vo
 * 4. Comment   : 媛쒕퀎�씤利�-001 �쓳�떟 媛앹껜
 * @author      : Kyeong-min, Kim
 * @version     : 2022. 2. 18. �삤�쟾 10:55:01
 */

@Getter
@Setter
public class MdB003IncaAthnAthzcodeResVO {
	private String respCode;          // �쓳�떟肄붾뱶
	private String respMsg;           // �쓳�떟硫붿떆吏�

	// �쎒諛⑹떇 �쓳�떟
	private String infrOfrUrl;        // �쎒諛⑹떇URL

	// �빋諛⑹떇 �쓳�떟
	private String orgCode;           // �젙蹂댁젣怨듭옄湲곌�肄붾뱶
	private String appSchemeIos;      // iOS �빋 URL �뒪�궡
	private String installUrlIos;     // iOS �빋�꽕移� URL
	private String appSchemeAndroid;  // �븞�뱶濡쒖씠�뱶 �빋 URL �뒪�궡
	private String installUrlAndroid; // �븞�뱶濡쒖씠�뱶 �빋�꽕移� URL
}
