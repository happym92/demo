package com.hm.mydata.md.vo;

import java.util.List;

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
public class MdB003TrnmReqDetailResVO {

	private String respCode;                        		// �꽭遺� �쓳�떟肄붾뱶
	private String respMsg;                         		// �꽭遺� �쓳�떟硫붿떆吏�
	private String mode;                         		    // �뿰寃곕え�뱶
	private List<InstLnknStVO> instLnknStList = null;		// �뿰寃� 留뚮즺 紐⑸줉

        /**
         * 1. Comment : innerClass
         * @author      : NONE
         * @version     : 2025.05. 24. �삤�쟾 12:00:00
         */
		@Getter
		@Setter
		@ToString
		public static class InstLnknStVO {
			private String mydtInstCode;            		// �젣怨듦린愿�肄붾뱶
			private String mydtInstName;            		// �젣怨듦린愿�紐�
			private String instLnknStcd;					// 湲곌��뿰寃곗긽�깭肄붾뱶
			private String infrOfrTobCode;					// �뾽沅뚭뎄遺꾩퐫�뱶
			private String infrOfrTobName;					// �뾽沅뚮챸
			private String imgRoutCntn;						// �씠誘몄�寃쎈줈
		}

}
