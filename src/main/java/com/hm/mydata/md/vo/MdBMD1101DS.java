package com.hm.mydata.md.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 1. ClassName : MdBMD1101DS
 * 2. FileName  : MdBMD1101DS.java
 * 3. Package   : kmds.md.b.mapper
 * 4. Comment   : MD_�젒洹쇳넗�겙紐낆꽭 (MD1101DS)
 * @author      : hyun-wook, Kim
 * @version     : 2022. 2. 18. �삤�쟾 10:55:01
 */
@Getter
@Setter
public class MdBMD1101DS {

    private String csno;              /* 怨좉컼踰덊샇 */
    private String trnmReqSrno;       /* �쟾�넚�슂援ъ씪�젴踰덊샇 */
    private String mydtInstCode;      /* 留덉씠�뜲�씠�꽣湲곌�肄붾뱶 */
    private String trnmReqPtcd;       /* �쟾�넚�슂援ъ쑀�삎肄붾뱶 */
    private String athnDttm;          /* �씤利앹씪�떆 */
    private String acesTokenPtrnName; /* �젒洹쇳넗�겙�쑀�삎紐� */
    private String acesTokenTlms;     /* �젒洹쇳넗�겙�쟾臾� */
    private String acesTokenVldTerm;  /* �젒洹쇳넗�겙�쑀�슚湲곌컙 */
    private String rfrsTokenTlms;     /* 由ы봽�젅�떆�넗�겙�쟾臾� */
    private String rfrsTokenVldTerm;  /* 由ы봽�젅�떆�넗�겙�쑀�슚湲곌컙 */
    private String athrRngTlms;       /* 沅뚰븳踰붿쐞�쟾臾� */
    private String tokenVldYn;        /* �넗�겙�쑀�슚�뿬遺� */
    private String rgstOpunCode;      /* �벑濡앸��젏肄붾뱶 */
    private String rgsnId;            /* �벑濡앹옄ID */
    private String rgstTrno;          /* �벑濡앸떒留먮쾲�샇 */
    private String revsOpunCode;      /* �닔�젙遺��젏肄붾뱶 */
    private String edtrId;            /* �닔�젙�옄ID */
    private String revsTrno;          /* �닔�젙�떒留먮쾲�샇 */

    private List<String> mydtInstCodeList;

}
