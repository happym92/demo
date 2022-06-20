package com.hm.mydata.md.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 1. ClassName :
 * 2. FileName  : MdBMD0101MS.java
 * 3. Package   : kmds.md.b.mapper
 * 4. Comment   : MD_�쟾�넚�슂援ъ긽�꽭
 * @author      :
 * @version     : 2022. 2. 18. �삤�쟾 10:55:01
 */
@Getter
@Setter
@ToString
public class MdBMD0102DL {
    private String csno;                            /* 怨좉컼踰덊샇 */
    private String trnmReqSrno;                     /* �쟾�넚�슂援ъ씪�젴踰덊샇 */
    private String mydtInstCode;                    /* 留덉씠�뜲�씠�꽣湲곌�肄붾뱶 */
    private String trnmReqStcd;                     /* �쟾�넚�슂援ъ긽�깭肄붾뱶 */
    private String instLnknStcd;                    /* 湲곌��뿰寃곗긽�깭肄붾뱶 */
    private String astCtlgTrnmReqDttm;              /* �옄�궛紐⑸줉�쟾�넚�슂援ъ씪�떆 */
    private String dtlInfrTrnmReqDttm;              /* �긽�꽭�젙蹂댁쟾�넚�슂援ъ씪�떆 */
    private String trnmReqRclDttm;                  /* �쟾�넚�슂援ъ쿋�쉶�씪�떆 */
    private String vrfcStsCntn;                     /* 寃�利앹긽�깭�궡�슜 */
    private String trnmReqRclYn;                    /* �쟾�넚�슂援ъ쿋�쉶�뿬遺� */
    private String mydtDelYn;                       /* 留덉씠�뜲�씠�꽣�궘�젣�뿬遺� */
    private String rgstOpunCode;                    /* �벑濡앸��젏肄붾뱶 */
    private String rgsnId;                          /* �벑濡앹옄ID */
    private String rgstTrno;                        /* �벑濡앸떒留먮쾲�샇 */
    private String revsOpunCode;                    /* �닔�젙遺��젏肄붾뱶 */
    private String edtrId;                          /* �닔�젙�옄ID */
    private String revsTrno;                        /* �닔�젙�떒留먮쾲�샇 */

    // MD1111MS
    private String mydtInstName;                    /* 留덉씠�뜲�씠�꽣湲곌�紐� */
    private String infrOfrTobCode;                  /* �젙蹂댁젣怨듭뾽沅뚯퐫�뱶 */
    private String infrOfrTobName;                  /* �젙蹂댁젣怨듭뾽沅뚮챸 */
    private String instLnknCnt;                  	/* 湲곌��닔*/
    private String lastLnknStcd;                  	/* 理쒖쥌�뿰寃곗긽�깭肄붾뱶*/
    private String statusCntn;                  	/* �긽�깭�궡�슜 �엫�떆*/

    //MD1114DS
    private String instImgRoutName;                  	/* �씠誘몄�寃쎈줈*/

    //MD0101MS
    private String scrnPrgsDtcd;                  	/* �솕硫댁쭊�뻾援щ텇肄붾뱶 */
    private String athnMsrDtcd;                  	/* �씤利앸갑�떇援щ텇肄붾뱶 */

    @Deprecated
    private String imgRoutCntn;                  	/* �씠誘몄�寃쎈줈*/

}
