package com.hm.mydata.common.constants;

/**
 * @Description	: CommonConstant
 * @Project		: KMDS
 * @FileName 	: CommonConstant.java
 * @Author		:
 * @Date		: 2021.09.08
 */
public class CommonConstant {

	public static final String[] PUBLIC_MATCHERS = {
			"/**/**.do",
			"/static/**",
			"/resources/**",
			"/swagger/**",
			"/swagger-resources/**",
			"/swagger-ui.html",
			"/configuration/ui",
			"/configuration/security",
			"/v2/api-docs",
			"/webjars",
			"/favicon.ico",
			"/",
			"/login",
			"/logout",
			"/testpage/login","/gather/v1/**"
	};

	public static final String[] MD_TEST_MATCHERS = {
			"/**/md/**"
	};

	/******** 臾몄옄�뿴 �룷留� 愿��젴 �긽�닔 ********/
	public static final String STRING_FORMAT_SPACE              = "";
	public static final String STRING_FORMAT_NULL_STRING        = " ";
	public static final String STRING_FORMAT_SLASH              = "/";
	public static final String STRING_FORMAT_MINUS              = "-";
	public static final String STRING_FORMAT_UNDER              = "_";
	public static final String STRING_FORMAT_APOSTROPHE         = "'";
	public static final String STRING_FORMAT_APOSTROPHE_COMMA   = "',";
	public static final String STRING_FORMAT_POINT              = ".";
	public static final String STRING_FORMAT_MULTIPLICATION     = "*";
	public static final String STRING_FORMAT_PERCENT            = "%";
	public static final String STRING_FORMAT_TAB                = "\t";


	/******** �궇吏� �룷留� 愿��젴 �긽�닔 ********/
	public static final String DATE_FORMAT_MMDD                 = "MM/Dd";
	public static final String DATE_FORMAT_YYYYMM               = "yyyy-MM";
	public static final String DATE_FORMAT_YYYYMMDD             = "yyyy-MM-dd";
	public static final String DATE_FORMAT_YYYYMMDDHHMMSS       = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_YYYYMMDDHH_MM        = "yyyy-MM-dd HH:mm";
	public static final String DATE_FORMAT_YYYYMMDDHHMM         = "yyyy-MM-dd HHmm";
	public static final String DATE_FORMAT_HAN_YYYYMD           = "yyyy�뀈M�썡d�씪";
	public static final String DATE_FORMAT_HAN_HM               = "H�떆媛꼖遺�";


	/******** �닽�옄 愿��젴 臾몄옄�뿴 �긽�닔 ********/
	public static final String NUMBER_FORMAT_ZERO               = "0";
	public static final String NUMBER_FORMAT_ONE                = "1";
	public static final String NUMBER_FORMAT_TWO                = "2";
	public static final String NUMBER_FORMAT_THREE              = "3";
	public static final String NUMBER_FORMAT_FOUR               = "4";
	public static final String NUMBER_FORMAT_FIVE               = "5";
	public static final String NUMBER_FORMAT_MINUS_ONE          = "-1";


	/******** DB愿��젴 愿��젴 �긽�닔 ********/
	public static final String STRING_YES                       = "Y";
	public static final String STRING_NO                        = "N";


	/******** �넻�떊 愿��젴 �긽�닔 ********/
	public static final String RESULT_MSG_SUCCESS               = "success";
	public static final String RESULT_MSG_FAIL                  = "fail";
	public static final String RESULT_MSG_90000                 = "90000";
	public static final String RESULT_MSG_90000_STRING          = "19�꽭 誘몃쭔�� 媛��엯�씠 遺덇��뒫 �빀�땲�떎.";

	/******** �뾽臾� 愿��젴 �긽�닔 ********/

	/** �뾽臾� 援щ텇肄붾뱶 - IPS */
	public static final String KMDS_WORK_IPS                    = "IPS";
	/** �뾽臾� 援щ텇肄붾뱶 - SPS */
	public static final String KMDS_WORK_SPS                    = "SPS";
	/** �뾽臾� 援щ텇肄붾뱶 - VISIBILITY */
	public static final String KMDS_WORK_VISIBILITY             = "VIS";
	/** �뾽臾� 援щ텇肄붾뱶 - SPS */
	public static final String KMDS_WORK_GQS                    = "GQS";

	/** LOG IN/OUT 援щ텇肄붾뱶 - IN (receive) */
	public static final String KMDS_TRANS_LOG_IN                = "IN";
	/** LOG IN/OUT 援щ텇肄붾뱶 - OUT (send) */
	public static final String KMDS_TRANS_LOG_OUT               = "OUT";

	/** LOG Request 援щ텇肄붾뱶 - HTTP */
	public static final String KMDS_TRANS_LOG_HTTP              = "HTTP";
	/** LOG Request 援щ텇肄붾뱶 - HTTPS */
	public static final String KMDS_TRANS_LOG_HTTPS             = "HTTPS";
	/** LOG Request 援щ텇肄붾뱶 - FTP */
	public static final String KMDS_TRANS_LOG_FTP               = "FTP";
	/** LOG Request 援щ텇肄붾뱶 - FTPS */
	public static final String KMDS_TRANS_LOG_FTPS              = "FTPS";


	/************************************************************************************************************
	 * 援먮낫 留덉씠�뜲�씠�꽣�궗�뾽�옄 �젙蹂� �깮�꽦二쇱껜援щ텇肄붾뱶 (1�옄由�)
	 ************************************************************************************************************/
	public static final String KYOBO_TYPE_CODE                  = "M";           // �깮�꽦二쇱껜援щ텇肄붾뱶 (1�옄由�)
	public static final String KYOBO_TRNM_CODE                  = "MD";          // �듃�옖�옲�뀡 ID �떇蹂꾩옄 (2�옄由�)

	/************************************************************************************************************
	 * �닔吏멇PI 援щ텇肄붾뱶 �긽�닔
	 ************************************************************************************************************/
	public static final String API_DISTIC_CODE_BANK_001         = "BA01";
	public static final String API_DISTIC_CODE_BANK_002         = "BA02";
	public static final String API_DISTIC_CODE_BANK_003         = "BA03";
	public static final String API_DISTIC_CODE_BANK_004         = "BA04";
	public static final String API_DISTIC_CODE_BANK_005         = "BA11";
	public static final String API_DISTIC_CODE_BANK_006         = "BA12";
	public static final String API_DISTIC_CODE_BANK_007         = "BA13";
	public static final String API_DISTIC_CODE_BANK_008         = "BA21";
	public static final String API_DISTIC_CODE_BANK_009         = "BA22";
	public static final String API_DISTIC_CODE_BANK_010         = "BA23";
	public static final String API_DISTIC_CODE_CARD_001         = "CD01";
	public static final String API_DISTIC_CODE_CARD_002         = "CD02";
	public static final String API_DISTIC_CODE_CARD_003         = "CD11";
	public static final String API_DISTIC_CODE_CARD_004         = "CD21";
	public static final String API_DISTIC_CODE_CARD_005         = "CD22";
	public static final String API_DISTIC_CODE_CARD_006         = "CD23";
	public static final String API_DISTIC_CODE_CARD_007         = "CD24";
	public static final String API_DISTIC_CODE_CARD_008         = "CD03";
	public static final String API_DISTIC_CODE_CARD_009         = "CD04";
	public static final String API_DISTIC_CODE_CARD_010         = "CD31";
	public static final String API_DISTIC_CODE_CARD_011         = "CD32";
	public static final String API_DISTIC_CODE_CARD_012         = "CD33";
	public static final String API_DISTIC_CODE_INVEST_001       = "IV01";
	public static final String API_DISTIC_CODE_INVEST_002       = "IV02";
	public static final String API_DISTIC_CODE_INVEST_003       = "IV03";
	public static final String API_DISTIC_CODE_INVEST_004       = "IV04";
	public static final String API_DISTIC_CODE_INVEST_005       = "IV05";
	public static final String API_DISTIC_CODE_INSU_001         = "IS01";
	public static final String API_DISTIC_CODE_INSU_002         = "IS02";
	public static final String API_DISTIC_CODE_INSU_003         = "IS03";
	public static final String API_DISTIC_CODE_INSU_004         = "IS04";
	public static final String API_DISTIC_CODE_INSU_005         = "IS05";
	public static final String API_DISTIC_CODE_INSU_006         = "IS06";
	public static final String API_DISTIC_CODE_INSU_007         = "IS07";
	public static final String API_DISTIC_CODE_INSU_008         = "IS11";
	public static final String API_DISTIC_CODE_INSU_009         = "IS12";
	public static final String API_DISTIC_CODE_INSU_010         = "IS13";
	public static final String API_DISTIC_CODE_INSU_011         = "IS14";
	public static final String API_DISTIC_CODE_INSU_012         = "IS08";
	public static final String API_DISTIC_CODE_EFIN_001         = "EF01";
	public static final String API_DISTIC_CODE_EFIN_002         = "EF02";
	public static final String API_DISTIC_CODE_EFIN_003         = "EF03";
	public static final String API_DISTIC_CODE_EFIN_004         = "EF04";
	public static final String API_DISTIC_CODE_EFIN_101         = "EF11";
	public static final String API_DISTIC_CODE_EFIN_102         = "EF12";
	public static final String API_DISTIC_CODE_EFIN_103         = "EF13";
	public static final String API_DISTIC_CODE_CAPITAL_001      = "CP01";
	public static final String API_DISTIC_CODE_CAPITAL_002      = "CP02";
	public static final String API_DISTIC_CODE_CAPITAL_003      = "CP03";
	public static final String API_DISTIC_CODE_CAPITAL_004      = "CP04";
	public static final String API_DISTIC_CODE_CAPITAL_005      = "CP05";
	public static final String API_DISTIC_CODE_CAPITAL_006      = "CP06";
	public static final String API_DISTIC_CODE_GINSU_001        = "GI01";
	public static final String API_DISTIC_CODE_GINSU_002        = "GI02";
	public static final String API_DISTIC_CODE_GINSU_003        = "GI03";
	public static final String API_DISTIC_CODE_TELECOM_001      = "TC01";
	public static final String API_DISTIC_CODE_TELECOM_002      = "TC02";
	public static final String API_DISTIC_CODE_TELECOM_003      = "TC03";
	public static final String API_DISTIC_CODE_TELECOM_004      = "TC04";
	public static final String API_DISTIC_CODE_P2P_001          = "LD01";
	public static final String API_DISTIC_CODE_P2P_002          = "LD02";
	public static final String API_DISTIC_CODE_P2P_003          = "LD03";
	public static final String API_DISTIC_CODE_P2P_004          = "LD04";
	public static final String API_DISTIC_CODE_IRP_001          = "IR01";
	public static final String API_DISTIC_CODE_IRP_002          = "IR02";
	public static final String API_DISTIC_CODE_IRP_003          = "IR03";
	public static final String API_DISTIC_CODE_IRP_004          = "IR04";
	public static final String API_DISTIC_CODE_PREPAY_001       = "PP01";
	public static final String API_DISTIC_CODE_PREPAY_002       = "PP02";
	public static final String API_DISTIC_CODE_PREPAY_003       = "PP03";
	public static final String API_DISTIC_CODE_PREPAY_004       = "PP04";
	public static final String API_DISTIC_CODE_BOND_001         = "BD01";
	public static final String API_DISTIC_CODE_BOND_002         = "BD02";
	public static final String API_DISTIC_CODE_BOND_003         = "BD03";
	public static final String API_DISTIC_CODE_COMMON_001       = "CM01";
	public static final String API_DISTIC_CODE_COMMON_002       = "CM02";

	/************************************************************************************************************
	 * �씤利쒪PI 援щ텇肄붾뱶 �긽�닔
	 ************************************************************************************************************/
	public static final String API_DISTIC_CODE_INTGRA           = "AU11";
	public static final String API_DISTIC_CODE_IDIVI_001        = "AU01";
	public static final String API_DISTIC_CODE_IDIVI_002        = "AU02";
	public static final String API_DISTIC_CODE_IDIVI_003        = "AU03";
	public static final String API_DISTIC_CODE_IDIVI_004        = "AU04";

	/************************************************************************************************************
	 * �궗�뾽�옄 �옄寃� 利앸챸 諛� 媛쒕퀎�씤利� �긽�닔
	 ************************************************************************************************************/
	public static final String GRANT_TYPE           			= "authorization_code";

	/************************************************************************************************************
	 * ���뻾�뾽沅� 怨꾩쥖援щ텇肄붾뱶
	 ************************************************************************************************************/
	public static final String[] BANK_DEPOSIT_CODE           	= {"1001", "1002", "1003", "1999"};
	public static final String[] BANK_INVEST_CODE           	= {"2001", "2002", "2003", "2999"};
	public static final String[] BANK_LOAN_CODE           		= {"3100", "3150", "3170", "3200",
																   "3210", "3220", "3230", "3240",
																   "3245", "3250", "3260", "3270",
																   "3271", "3290", "3400", "3500",
																   "3510", "3590", "3700", "3710",
																   "3999"};

	/************************************************************************************************************
	 * 留ㅼ튂 �꽌鍮꾩뒪 �씠�슜�빟愿� 遺꾨쪟 肄붾뱶
	 ************************************************************************************************************/
	public static final String MYDT_STPL_CLCD_31 = "31";
	public static final String MYDT_STPL_CLCD_32 = "32";

	/************************************************************************************************************
	 * 留ㅼ튂�룷�씤�듃蹂��룞援щ텇肄붾뱶
	 ************************************************************************************************************/
	public static final String MTCH_PNT_FLTN_DTCD_51 = "51";
	/************************************************************************************************************
	 * �빟愿�肄붾뱶
	 ************************************************************************************************************/
	public static final String STPL_ID_31 = "31";
	public static final String STPL_ID_32 = "32";
	public static final String STPL_ID_33 = "33";
	public static final String STPL_ID_40 = "40";
	public static final String STPL_ID_11 = "11";
	public static final String STPL_ID_13 = "13";


	/************************************************************************************************************
	 * 留덉씠�뜲�씠�꽣 �쉶�썝 援щ텇 肄붾뱶
	 ************************************************************************************************************/
	public static final String MYDT_MBR_DTCD_10 = "10";  // 以��쉶�썝
	public static final String MYDT_MBR_DTCD_20 = "20";  // �젙�쉶�썝


	/************************************************************************************************************
	 * 留덉씠�뜲�씠�꽣 �옄�궛 援щ텇 肄붾뱶
	 ************************************************************************************************************/
	public static final String MYDT_AST_DTCD_01 = "01";  // 珥앹옄�궛
	public static final String MYDT_AST_DTCD_02 = "02";  // �닚�옄�궛

	/************************************************************************************************************
	 * 留ㅼ튂 �씠誘몄� �뜽�꽕�씪 鍮꾩쑉
	 ************************************************************************************************************/
	public static final double THMB_IMG_RATO_1 = 2;  // �뜽�꽕�씪 �씠誘몄� 鍮꾩쑉
	public static final double THMB_IMG_RATO_2 = 4;  // �뜽�꽕�씪 �씠誘몄� 鍮꾩쑉

	/************************************************************************************************************
     * �냼鍮꾩�異쒕궡�뿭 �슂泥� 援щ텇肄붾뱶
     ************************************************************************************************************/
    public static final String EXPD_BRKD_HOME = "HOME";  // 吏�異쒕궡�뿭 �슂泥��솕硫�(�솃-硫붿씤) 援щ텇肄붾뱶, 5嫄� 異쒕젰
    public static final String EXPD_BRKD_CNSM = "CNSM";  // 吏�異쒕궡�뿭 �슂泥��솕硫�(�냼鍮�-硫붿씤) 援щ텇肄붾뱶, 20嫄� 異쒕젰

	/************************************************************************************************************
	 * String CODE
	 ************************************************************************************************************/
	public static final String CODE_STRING_BLINK = "";
	public static final String CODE_STRING_09 = "09";
	public static final String CODE_STRING_NFTF = "NFTF";
	public static final String CODE_STRING_GRANT_TYPE = "grant_type";
	public static final String CODE_STRING_GRANT_TYPE_CLIENT_CREDENTIALS = "client_credentials";
	public static final String CODE_STRING_PASSWORD = "password";
	public static final String CODE_STRING_AUTH_TYPE = "auth_type";
	public static final String CODE_STRING_AUTH_TYPE_0 = "0";
	public static final String CODE_STRING_AUTH_TYPE_1 = "1";
	public static final String CODE_STRING_CONSENT_TYPE = "consent_type";
	public static final String CODE_STRING_CONSENT_TYPE_0 = "0";
	public static final String CODE_STRING_CONSENT_TYPE_1 = "1";
	public static final String CODE_STRING_MODE = "mode";
	public static final String CODE_STRING_RESP_CODE = "respCode";
	public static final String CODE_STRING_RSP_CODE = "rsp_code";
	public static final String CODE_STRING_RSP_CODE_00000 = "00000";
	public static final String CODE_STRING_RSP_MSG = "rsp_msg";
	public static final String CODE_STRING_RESP_CODE_00000 = "00000";
	public static final String CODE_STRING_RESP_CODE_MSG = "�쟻�옱�꽦怨�";
	public static final String CODE_STRING_RESP_CODE_40101 = "40101";

	public static final String CODE_STRING_NULL_YYYYMM = "999912";
	public static final String CODE_STRING_NULL_YYYYMMDD = "99991231";

	public static final String CODE_STRING_RESP_CODE_40101_MSG = "諛쒓툒諛쏆� �젒�겙�넗�겙�씠 議댁옱�븯吏� �븡�뒿�땲�떎.";
	public static final String CODE_STRING_RSP_CODE_MSG = "�꽦怨�";
	public static final String CODE_STRING_RESP_MSG = "respMsg";
	public static final String CODE_STRING_RESP_MSG_OK = "�젙�긽";

	public static final String CODE_STRING_SCOPE = "scope";
	public static final String CODE_STRING_SCOPE_CA = "ca";

	public static final String CODE_STRING_REQUEST_TITLE = "request_title";
	public static final String CODE_STRING_REQUEST_TITLE_MSG_01 = "留덉씠�뜲�씠�꽣�쟾�옄�꽌紐�";
	public static final String CODE_STRING_XPLS_YN = "xplsYn";
	public static final String CODE_STRING_MTCH_STPL_CNST_YN = "mtchStplCnstYn";
	public static final String CODE_STRING_MTCH_STUP_CLAS_ID = "mtchStupClasId";
	public static final String CODE_STRING_MTCH_CNTP_GENR_CNT = "mtch.cntp.genr.cnt";
	public static final String CODE_STRING_MTCH_TTRL_INFC_CSNO = "mtch.ttrl.infc.csno";

	public static final String CODE_STRING_DEL_YN = "delYn";

	public static final String CODE_STRING_X_FSI_UTCT_TYPE = "X-FSI-UTCT-TYPE";
	public static final String CODE_STRING_TGC00002 = "TGC00002";

	public static final String CODE_STRING_RESPONSE_TYPE = "response_type";
	public static final String CODE_STRING_CODE = "code";

	public static final String CODE_STRING_Y = "Y";
	public static final String CODE_STRING_N = "N";
	public static final String CODE_STRING_IS_MEMBER = "is_member";
	public static final String CODE_STRING_FASLE = "false";
	public static final String CODE_STRING_TRUE = "true";
	public static final String CODE_STRING_SERVICE_CNT = "service_cnt";



//	0950     params.put("respCode", "00000");
//	0951     params.put("respMsg", "�쟻�옱�꽦怨�");





	/************************************************************************************************************
	 * EAI = NICE, FIDO 肄붾뱶
	 ************************************************************************************************************/
	public static final String EAI_BIZ_KEY_STRING = "_BIZ_KEY_STRING_";

}
