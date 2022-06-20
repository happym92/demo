package com.hm.mydata.md.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 1. ClassName :
 * 2. FileName  : MdBMD1101DSVS001.java
 * 3. Package   : kmds.md.b.mapper
 * 4. Comment   : MD_�쟾�넚�슂援ъ옄�궛�긽�꽭
 * @author      :
 * @version     : 2022. 2. 18. �삤�쟾 10:55:01
 */
@Getter
@Setter
public class MdBMD0103DL {
    private String csno;                            /* 怨좉컼踰덊샇 */
    private String trnmReqSrno;                     /* �쟾�넚�슂援ъ씪�젴踰덊샇 */
    private String mydtInstCode;                    /* 留덉씠�뜲�씠�꽣湲곌�肄붾뱶 */
    private String athrRngTlms;                     /* 沅뚰븳踰붿쐞�쟾臾� */
    private String srnoTlms;                        /* �씪�젴踰덊샇�쟾臾� */
    private String mydtAstId;                       /* 留덉씠�뜲�씠�꽣�옄�궛ID */
    private String encrAcno;                        /* �븫�샇�솕怨꾩쥖踰덊샇 */
    private String mydtAstName;                     /* 留덉씠�뜲�씠�꽣�옄�궛紐� */
    private String acctRndNoTlms;                   /* 怨꾩쥖�쉶李⑤쾲�샇�쟾臾� */
    private String trnmReqYn;                       /* �쟾�넚�슂援ъ뿬遺� */
    private String rgstOpunCode;                    /* �벑濡앸��젏肄붾뱶 */
    private String rgsnId;                          /* �벑濡앹옄ID */
    private String rgstTrno;                        /* �벑濡앸떒留먮쾲�샇 */
    private String revsOpunCode;                    /* �닔�젙遺��젏肄붾뱶 */
    private String edtrId;                          /* �닔�젙�옄ID */
    private String revsTrno;                        /* �닔�젙�떒留먮쾲�샇 */

    private String mydtInstName;                    /* 留덉씠�뜲�씠�꽣湲곌�紐� */
    private String infrOfrAthnWayCode;              /* �젣怨듭씤利앸갑�떇援щ텇 */
	private String minsAgrmYn;       /* 留덉씠�꼫�뒪�빟�젙�뿬遺� */
	private String cardId;           /* 移대뱶�떇蹂꾩옄 */
	private String infrOfrTobCode;           /* 移대뱶�떇蹂꾩옄 */
	private String infrOfrTobName;           /* 移대뱶�떇蹂꾩옄 */
	private String instImgRoutName;           /* 移대뱶�떇蹂꾩옄 */
	private String allAthrRngTlms;           /* 移대뱶�떇蹂꾩옄 */
	private List<String> mydtInstCodeList;

}
