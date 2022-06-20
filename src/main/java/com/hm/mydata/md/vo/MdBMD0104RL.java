package com.hm.mydata.md.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 1. ClassName : MdBMD0104RL
 * 2. FileName  : MdBMD0104RL.java
 * 3. Package   : kmds.md.b.mapper
 * 4. Comment   : MD_�넻�빀�뿰�룞�룞�쓽愿�怨�
 * @author      : hyun-wook, Kim
 * @version     : 2022. 3. 17. �삤�썑 3:13:32
 */
@Getter
@Setter
public class MdBMD0104RL {

	private String csno;         // 怨좉컼踰덊샇
	private String trnmReqSrno;  // �쟾�넚�슂援ъ씪�젴踰덊샇
	private String stplId;       // �빟愿�id
	private String stplVrsnName; // �빟愿�踰꾩쟾紐�
	private String cnstYn;       // �룞�쓽�뿬遺�
	private String stplCnstDttm; // �빟愿��룞�쓽�씪�떆
    private String rgstOpunCode; // �벑濡앸��젏肄붾뱶
    private String rgsnId;       // �벑濡앹옄ID
    private String rgstTrno;     // �벑濡앸떒留먮쾲�샇
    private String revsOpunCode; // �닔�젙遺��젏肄붾뱶
    private String edtrId;       // �닔�젙�옄ID
    private String revsTrno;     // �닔�젙�떒留먮쾲�샇

}
