package com.hm.mydata.md.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * 1. ClassName : MjCommonController�몮�떎而ㅻ컠
 * 2. FileName  : MjCommonController.java
 * 3. Package   : kmds.mj.common.controller
 * 4. Comment   : 留덉씠�뜲�씠�꽣 �닔吏� 怨듯넻 而⑦듃濡ㅻ윭 22
 * @author      : kyeong-min, Kim
 * @version     : 2022. 4. 28. �삤�썑 4:48:25
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/mj")
public class MjCommonController{

//	@Autowired
//	private MjCommonServiceImpl commonService;
//
//	@Autowired
//	private MjA001ServiceImpl bankService;
//
//	@Autowired
//	private MjB001ServiceImpl cardService;
//
//	@Autowired
//	private MjC001ServiceImpl investService;
//
//	@Autowired
//	private MjD001ServiceImpl insuService;
//
//	@Autowired
//	private MjE001ServiceImpl efinService;
//
//	@Autowired
//	private MjF001ServiceImpl capitalService;
//
//	@Autowired
//	private MjG001ServiceImpl ginsuService;
//
//	@Autowired
//	private MjH001ServiceImpl telecomService;
//
//	@Autowired
//	private MjI001ServiceImpl p2pService;
//
//	@Autowired
//	private MjJ001ServiceImpl bondService;
//
//	@Autowired
//	private MjJ002ServiceImpl irpService;
//
//	@Autowired
//	private MjJ003ServiceImpl prepaidService;
//
//	@Autowired
//	private MjW001ServiceImpl mjW001ServiceImpl;
//
//	@Autowired
//	private MjY001ServiceImpl mjY001ServiceImpl;
//
//	/**
//	 * 1. MethodName        : mjCommonMydataGathering
//	 * 2. ClassName         : MjCommonController
//	 * 3. Comment           : 留덉씠�뜲�씠�꽣 �닔吏� �떎�뻾 �젣�뼱
//	 * @APIID               : MJA-API
//	 * @SQLID               : NONE
//	 * @APIM                : NONE
//	 * @author             : kyeong-min, Kim
//	 * @version             : 2022. 4. 28. �삤�썑 3:37:57
//	 * @return ResponseEntity<?>
//	 * @param reqParam
//	 * @return MjCommonResVO
//	 * @throws Exception
//	 */
//	@ApiOperation(value = "MJ-GATHERING", notes = "留덉씠�뜲�씠�꽣 �닔吏�")
//	@PostMapping("/get-mydata-gathering")
//	public ResponseEntity<?> mjCommonMydataGathering(@RequestBody MjCommonReqVO reqParam) throws Exception {
//		log.info("留덉씠�뜲�씠�꽣 �닔吏� : get-mydata-gathering Start");
//		MjCommonResVO resVO = new MjCommonResVO();
//		List<InstCodeVO> mydtInstCodeList = null;
//		// apiType 寃�利앷컪
//		final List<String> apiTypeArr = new ArrayList<String>(Arrays.asList("user-consent","user-refresh", "scheduled", "user-search"));
//		// refreshDiv 寃�利앷컪
//		final List<String> refreshDivArr = new ArrayList<String>(Arrays.asList("02","03"));
//
//		// �똿寃⑤궡湲�
//		if(null != reqParam.getApiType() && apiTypeArr.contains(reqParam.getApiType())) {
//			if("scheduled".equals(reqParam.getApiType())) {
//				// �젙湲곗쟾�넚 �떆 �븘�닔 媛� : csno / apiType / mydtInstCode
//				if("".equals(reqParam.getCsno()) || null == reqParam.getCsno() || null == reqParam.getMydtInstCode() || "".equals(reqParam.getMydtInstCode())){
//					resVO.setRespMsg("Invalid parameter : csno or mydtInstCode");
//					resVO.setRespCode("40001");
//					return new ResponseEntity<>(resVO, null, HttpStatus.BAD_REQUEST);
//				}
//
//			} else if("user-refresh".equals(reqParam.getApiType())){
//				// user-refresh div 泥댄겕
//				if(null != reqParam.getRefreshDiv()) {
//					if(!refreshDivArr.contains(reqParam.getRefreshDiv())) {
//						resVO.setRespMsg("Invalid parameter : refreshDiv, follow one of values :" + refreshDivArr.toString());
//						resVO.setRespCode("40001");
//						return new ResponseEntity<>(resVO, null, HttpStatus.BAD_REQUEST);
//					}
//				} else {
//					resVO.setRespMsg("Invalid parameter : In case of [user-refresh], refreshDiv[Not Null]");
//					resVO.setRespCode("40001");
//					return new ResponseEntity<>(resVO, null, HttpStatus.BAD_REQUEST);
//				}
//			}
//
//		} else {
//			resVO.setRespMsg("Invalid parameter : apiType[Not Null], follow one of values :" + apiTypeArr.toString());
//			resVO.setRespCode("40001");
//			return new ResponseEntity<>(resVO, null, HttpStatus.BAD_REQUEST);
//		}
//
//
//		if (null != reqParam.getMydtInstCodeList()) {
//			mydtInstCodeList = reqParam.getMydtInstCodeList();
//		} else {
//			mydtInstCodeList = new ArrayList<MjCommonReqVO.InstCodeVO>();
//		}
//
//		List<MjComMD1101DS> tokenList = null;
//		// �뙆�씪誘명꽣濡� 諛쏆� 湲곌�由ъ뒪�듃媛� �엳�떎硫� filter : �넻�빀�씤利�/媛쒕퀎�씤利앹슜 �쟾�넚�슂援ъ떆 �빐�떦 湲곌�留� �닔吏�
//		tokenList = commonService.mjComMD1101DSPS002(reqParam, mydtInstCodeList);
//		if (null != tokenList) {
//			log.debug("#### 1");
//			// �샇異쒓��뒫�븳 �넗�겙�씠 �엳�쓣 寃쎌슦
//			log.debug("# size " + Integer.toString(tokenList.size()));
//			for (int i = 0; i < tokenList.size(); i++) {
//				// �닔吏멇PI 怨듯넻 �뙆�씪誘명꽣�뿉 湲곌�肄붾뱶 �꽭�똿
//				reqParam.setMydtInstCode(tokenList.get(i).getMydtInstCode());
//				log.debug("#### 2");
//				// �닔吏묒떎�뻾�궡�뿭 �쟻�옱�슜 湲곕낯媛� �꽭�똿 S
//				MjComMD1400TR inMD1400TR = new MjComMD1400TR();
//				inMD1400TR.setCsno(reqParam.getCsno());
//				inMD1400TR.setMydtInstCode(tokenList.get(i).getMydtInstCode());
//				// �쟾�넚�쑀�삎�뿉 �뵲瑜� 肄붾뱶媛� 遺꾧린
//				if("user-consent".equals(reqParam.getApiType())) {
//					inMD1400TR.setMydtTrnmPtcd("01");
//				} else if("user-refresh".equals(reqParam.getApiType())) {
//					if("02".equals(reqParam.getRefreshDiv())) {
//						inMD1400TR.setMydtTrnmPtcd("02");
//					} else if("03".equals(reqParam.getRefreshDiv())) {
//						inMD1400TR.setMydtTrnmPtcd("03");
//					}
//				} else if("scheduled".equals(reqParam.getApiType())) {
//					inMD1400TR.setMydtTrnmPtcd("04");
//				} else if("user-search".equals(reqParam.getApiType())) {
//					inMD1400TR.setMydtTrnmPtcd("05");
//				}
//				// �닔吏묒떎�뻾�궡�뿭 �쟻�옱�슜 湲곕낯媛� �꽭�똿 E
//
//				// 沅뚰븳踰붿쐞�궡�슜�뿉 �뵲瑜� 怨듯넻�뾽沅�(IRP/�꽑遺�) �뿬遺� �꽕�젙 蹂��닔
//				boolean isIRP = false;
//				boolean isPrepaid = false;
//				String industry = CommonConstant.STRING_FORMAT_SPACE;   // �뾽沅�
//				String bondDiv = CommonConstant.STRING_FORMAT_SPACE;    // �씤�닔梨꾧텒/��遺��뾽沅� API �샇異� �떆 �뾽沅뚭뎄遺꾧컪(bond or usury)
//				String IRPDiv = CommonConstant.STRING_FORMAT_SPACE;     // IRP API �샇異� �떆 �뾽沅뚭뎄遺꾧컪(bank, insu, invest)
//				String prepaidDiv = CommonConstant.STRING_FORMAT_SPACE; // �꽑遺� API �샇異� �떆 �뾽沅뚭뎄遺꾧컪(bank, card)
//
//				// �넗�겙�뿉�꽌 沅뚰븳踰붿쐞�궡�슜 異붿텧
//				String scope = tokenList.get(i).getAthrRngTlms();
//				String[] scopeSplit = scope.split(" ");
//
//				// �넗�겙�쓽 �뒪肄뷀봽濡� 怨듯넻 �뾽沅� �샇異� �뿬遺� �꽕�젙, 怨듯넻 �뾽沅� �뾽沅뚭뎄遺꾧컪 �꽕�젙
//				for (String s : scopeSplit) {
//					// 遺덊븘�슂�븳 Scope pass
//					if ("manage".equals(s)) {
//						continue;
//					}
//					String[] a = s.split("\\.");
//					industry = a[0];
//					if ("irp".equals(a[1])) {
//						isIRP = true;
//						IRPDiv = a[0];
//					} else if ("card".equals(a[0]) && "prepaid".equals(a[1])) {
//						isPrepaid = true;
//						prepaidDiv = a[0];
//					} else if ("bond".equals(a[0]) || "usury".equals(a[0])) {
//						bondDiv = a[0];
//					}
//				}
//
//
//				/* �닔吏묒떎�뻾�궡�뿭 移댁슫�똿
//				 * mydtGthrPrgmId : 留덉씠�뜲�씠�꽣�닔吏묓봽濡쒓렇�옩ID
//				 *     - bank, insu, invest, card, ginsu, bond, usury, efin, capital, p2p, telecom, irp, prepaid
//				 * regMD1400TR 硫붿냼�뱶
//				 *     - MapiTrtmStcd = 02 : �닔吏묒쨷 �쟻�옱 �떆, �닔吏묓슏�닔 移댁슫�듃
//				 *     - MapiTrtmStcd = 01 : �닔吏묒셿猷� �쟻�옱 �떆, �닔吏묓슏�닔 移댁슫�듃 �븯吏��븡�쓬.
//				 */
//
//
//				/* �닔吏� API �샇異�
//				 * �뾽沅뚮퀎 紐⑸줉 API �꽦怨� �떆 �긽�꽭 API �닔吏�
//				 * �넻�빀�씤利� Scene1�� �긽�꽭 API �샇異쒗븯吏� �븡�쓬
//				 *
//				 */
//				if ("bank".equals(industry)) {
//					inMD1400TR.setMydtGthrPrgmId("bank");
//					inMD1400TR.setMapiTrtmStcd("02");
//					commonService.regMD1400TR(inMD1400TR); // �닔吏묒떆�옉 �븷�븣 (MAPI_TRTM_STCD = 02 �씪�븣) 1移댁슫�듃
//
//					String bankAccountRspCode = CommonConstant.STRING_FORMAT_SPACE;
//					try { bankAccountRspCode = bankService.mjA001GetBankAcct(reqParam);   } catch (RuntimeException e) {log.debug("mjA001GetBankAcct > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//
//					if("00000".equals(bankAccountRspCode) && !"0".equals(reqParam.getTrnmReqPtcd())) {
//						try { bankService.mjA001GetBankAcctDpstBasc(reqParam);            } catch (RuntimeException e) {log.debug("mjA001GetBankAcctDpstBasc > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { bankService.mjA001GetBankAcctDpstDtl(reqParam);             } catch (RuntimeException e) {log.debug("mjA001GetBankAcctDpstDtl > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { bankService.mjA001GetBankAcctDpstTrns(reqParam);            } catch (RuntimeException e) {log.debug("mjA001GetBankAcctDpstTrns > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { bankService.mjA001GetBankAcctInvtBasc(reqParam);            } catch (RuntimeException e) {log.debug("mjA001GetBankAcctInvtBasc > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { bankService.mjA001GetBankAcctInvtDtl(reqParam);             } catch (RuntimeException e) {log.debug("mjA001GetBankAcctInvtDtl > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { bankService.mjA001GetBankAcctInvtTrns(reqParam);            } catch (RuntimeException e) {log.debug("mjA001GetBankAcctInvtTrns > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { bankService.mjA001GetBankAcctLoanBasc(reqParam);            } catch (RuntimeException e) {log.debug("mjA001GetBankAcctLoanBasc > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { bankService.mjA001GetBankAcctLoanDtl(reqParam);             } catch (RuntimeException e) {log.debug("mjA001GetBankAcctLoanDtl > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { bankService.mjA001GetBankAcctLoanTrns(reqParam);            } catch (RuntimeException e) {log.debug("mjA001GetBankAcctLoanTrns > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					}
//
//					inMD1400TR.setMapiTrtmStcd("01");
//					commonService.regMD1400TR(inMD1400TR); // 醫낅즺�쟻�옱�떆 移댁슫�듃 �븯吏��븡�쓬
//
//				} else if ("insu".equals(industry)) {
//					inMD1400TR.setMydtGthrPrgmId("insu");
//					inMD1400TR.setMapiTrtmStcd("02");
//					commonService.regMD1400TR(inMD1400TR); // �닔吏묒떆�옉 �븷�븣 (MAPI_TRTM_STCD = 02 �씪�븣) 1移댁슫�듃
//
//					String insu001RspCode = CommonConstant.STRING_FORMAT_SPACE;
//					try { insu001RspCode = insuService.mjD001GetInsurances(reqParam);     } catch (RuntimeException e) {log.debug("mjD001GetInsurances > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					if("00000".equals(insu001RspCode)  && !"0".equals(reqParam.getTrnmReqPtcd())) {
//						try { insuService.mjD001GetInsurancesBasic(reqParam);             } catch (RuntimeException e) {log.debug("mjD001GetInsurancesBasic > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { insuService.mjD001GetInsurancesCar(reqParam);               } catch (RuntimeException e) {log.debug("mjD001GetInsurancesCar > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { insuService.mjD001GetInsurancesCarTransactions(reqParam);   } catch (RuntimeException e) {log.debug("mjD001GetInsurancesCarTransactions > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { insuService.mjD001GetInsurancesPayment(reqParam);           } catch (RuntimeException e) {log.debug("mjD001GetInsurancesPayment > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { insuService.mjD001GetInsurancesTransactions(reqParam);      } catch (RuntimeException e) {log.debug("mjD001GetInsurancesTransactions > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { insuService.mjD001GetInsurancesContracts(reqParam);         } catch (RuntimeException e) {log.debug("mjD001GetInsurancesContracts > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { insuService.mjD001GetInsurancesCoverages(reqParam);         } catch (RuntimeException e) {log.debug("mjD001GetInsurancesCoverages > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					}
//
//					String insu008RspCode = CommonConstant.STRING_FORMAT_SPACE;
//					try { insu008RspCode = insuService.mjD001GetLoans(reqParam);          } catch (RuntimeException e) {log.debug("mjD001GetLoans > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					if("00000".equals(insu008RspCode)  && !"0".equals(reqParam.getTrnmReqPtcd())) {
//						try { insuService.mjD001GetLoansBasic(reqParam);                  } catch (RuntimeException e) {log.debug("mjD001GetLoansBasic > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { insuService.mjD001GetLoansDetail(reqParam);                 } catch (RuntimeException e) {log.debug("mjD001GetLoansDetail > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { insuService.mjD001GetLoansTransactions(reqParam);           } catch (RuntimeException e) {log.debug("mjD001GetLoansTransactions > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					}
//
//					inMD1400TR.setMapiTrtmStcd("01");
//					commonService.regMD1400TR(inMD1400TR); // 醫낅즺�쟻�옱�떆 移댁슫�듃 �븯吏��븡�쓬
//
//				} else if ("card".equals(industry)) {
//					inMD1400TR.setMydtGthrPrgmId("card");
//					inMD1400TR.setMapiTrtmStcd("02");
//					commonService.regMD1400TR(inMD1400TR); // �닔吏묒떆�옉 �븷�븣 (MAPI_TRTM_STCD = 02 �씪�븣) 1移댁슫�듃
//
//					String card001RspCode = CommonConstant.STRING_FORMAT_SPACE;
//					try { card001RspCode = cardService.mjB001GetCard(reqParam);           } catch (RuntimeException e) {log.debug("mjB001GetCard > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					if("00000".equals(card001RspCode)  && !"0".equals(reqParam.getTrnmReqPtcd())) {
//						try { cardService.mjB001GetCardBasc(reqParam);                    } catch (RuntimeException e) {log.debug("mjB001GetCardBasc > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { cardService.mjB001GetCardPnt(reqParam);                     } catch (RuntimeException e) {log.debug("mjB001GetCardPnt > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { cardService.mjB001GetCardAsk(reqParam);                     } catch (RuntimeException e) {log.debug("mjB001GetCardAsk > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { cardService.mjB001GetCardAskDtl(reqParam);                  } catch (RuntimeException e) {log.debug("mjB001GetCardAskDtl > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { cardService.mjB001GetCardStlm(reqParam);                    } catch (RuntimeException e) {log.debug("mjB001GetCardStlm > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { cardService.mjB001GetCardRvlv(reqParam);                    } catch (RuntimeException e) {log.debug("mjB001GetCardRvlv > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { cardService.mjB001GetCardDmstAprv(reqParam);                } catch (RuntimeException e) {log.debug("mjB001GetCardDmstAprv > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { cardService.mjB001GetCardOvrsAprv(reqParam);                } catch (RuntimeException e) {log.debug("mjB001GetCardOvrsAprv > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { cardService.mjB001GetLoan(reqParam);                        } catch (RuntimeException e) {log.debug("mjB001GetLoan > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { cardService.mjB001GetLoanShtr(reqParam);                    } catch (RuntimeException e) {log.debug("mjB001GetLoanShtr > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { cardService.mjB001GetLoanLntr(reqParam);                    } catch (RuntimeException e) {log.debug("mjB001GetLoanLntr > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					}
//
//					inMD1400TR.setMapiTrtmStcd("01");
//					commonService.regMD1400TR(inMD1400TR); // 醫낅즺�쟻�옱�떆 移댁슫�듃 �븯吏��븡�쓬
//
//				} else if ("invest".equals(industry)) {
//					inMD1400TR.setMydtGthrPrgmId("invest");
//					inMD1400TR.setMapiTrtmStcd("02");
//					commonService.regMD1400TR(inMD1400TR); // �닔吏묒떆�옉 �븷�븣 (MAPI_TRTM_STCD = 02 �씪�븣) 1移댁슫�듃
//
//					String invest001RspCode = CommonConstant.STRING_FORMAT_SPACE;
//					try { invest001RspCode = investService.mjC001GetAccounts(reqParam);   } catch (RuntimeException e) {log.debug("mjC001GetAccounts > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					if("00000".equals(invest001RspCode)  && !"0".equals(reqParam.getTrnmReqPtcd())) {
//						try { investService.mjC001GetAccountsBasic(reqParam);             } catch (RuntimeException e) {log.debug("mjC001GetAccountsBasic > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { investService.mjC001GetAccountsTransactions(reqParam);      } catch (RuntimeException e) {log.debug("mjC001GetAccountsTransactions > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { investService.mjC001GetAccountsProducts(reqParam);          } catch (RuntimeException e) {log.debug("mjC001GetAccountsProducts > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { investService.mjC001GetAccountsPension(reqParam);           } catch (RuntimeException e) {log.debug("mjC001GetAccountsPension > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					}
//
//					inMD1400TR.setMapiTrtmStcd("01");
//					commonService.regMD1400TR(inMD1400TR); // 醫낅즺�쟻�옱�떆 移댁슫�듃 �븯吏��븡�쓬
//
//				} else if ("efin".equals(industry)) {
//					inMD1400TR.setMydtGthrPrgmId("efin");
//					inMD1400TR.setMapiTrtmStcd("02");
//					commonService.regMD1400TR(inMD1400TR); // �닔吏묒떆�옉 �븷�븣 (MAPI_TRTM_STCD = 02 �씪�븣) 1移댁슫�듃
//
//					String efin001RspCode = CommonConstant.STRING_FORMAT_SPACE;
//					try { efin001RspCode = efinService.mjE001GetPrepaid(reqParam);        } catch (RuntimeException e) {log.debug("mjE001GetPrepaid > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					if("00000".equals(efin001RspCode)  && !"0".equals(reqParam.getTrnmReqPtcd())) {
//						try { efinService.mjE001GetPrepaidBalance(reqParam);              } catch (RuntimeException e) {log.debug("mjE001GetPrepaidBalance > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { efinService.mjE001GetPrepaidCharge(reqParam);               } catch (RuntimeException e) {log.debug("mjE001GetPrepaidCharge > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { efinService.mjE001GetPrepaidTransactions(reqParam);         } catch (RuntimeException e) {log.debug("mjE001GetPrepaidTransactions > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					}
//
//					String efin101RspCode = CommonConstant.STRING_FORMAT_SPACE;
//					try { efin101RspCode = efinService.mjE001GetPaid(reqParam);           } catch (RuntimeException e) {log.debug("mjE001GetPaid > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//			    	if("00000".equals(efin101RspCode)  && !"0".equals(reqParam.getTrnmReqPtcd())) {
//			    		try { efinService.mjE001GetPaidMethod(reqParam);                  } catch (RuntimeException e) {log.debug("mjE001GetPaidMethod > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//			    		try { efinService.mjE001GetPaidTransactions(reqParam);            } catch (RuntimeException e) {log.debug("mjE001GetPaidTransactions > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//			    	}
//
//			    	inMD1400TR.setMapiTrtmStcd("01");
//					commonService.regMD1400TR(inMD1400TR); // 醫낅즺�쟻�옱�떆 移댁슫�듃 �븯吏��븡�쓬
//
//				} else if ("capital".equals(industry)) {
//					inMD1400TR.setMydtGthrPrgmId("capital");
//					inMD1400TR.setMapiTrtmStcd("02");
//					commonService.regMD1400TR(inMD1400TR); // �닔吏묒떆�옉 �븷�븣 (MAPI_TRTM_STCD = 02 �씪�븣) 1移댁슫�듃
//
//					String capital001RspCode = CommonConstant.STRING_FORMAT_SPACE;
//					try { capital001RspCode = capitalService.mjF001GetLoans(reqParam);    } catch (RuntimeException e) {log.debug("mjF001GetLoans > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					if("00000".equals(capital001RspCode)  && !"0".equals(reqParam.getTrnmReqPtcd())) {
//						try { capitalService.mjF001GetLoansBasic(reqParam);               } catch (RuntimeException e) {log.debug("mjF001GetLoansBasic > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { capitalService.mjF001GetLoansDetail(reqParam);              } catch (RuntimeException e) {log.debug("mjF001GetLoansDetail > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { capitalService.mjF001GetLoansAcnoTransactions(reqParam);    } catch (RuntimeException e) {log.debug("mjF001GetLoansAcnoTransactions > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { capitalService.mjF001GetLoansOpleaseBasic(reqParam);        } catch (RuntimeException e) {log.debug("mjF001GetLoansOpleaseBasic > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { capitalService.mjF001GetLoansOpleaseTransactions(reqParam); } catch (RuntimeException e) {log.debug("mjF001GetLoansOpleaseTransactions > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					}
//
//					inMD1400TR.setMapiTrtmStcd("01");
//					commonService.regMD1400TR(inMD1400TR); // 醫낅즺�쟻�옱�떆 移댁슫�듃 �븯吏��븡�쓬
//
//				} else if ("ginsu".equals(industry)) {
//					inMD1400TR.setMydtGthrPrgmId("ginsu");
//					inMD1400TR.setMapiTrtmStcd("02");
//					commonService.regMD1400TR(inMD1400TR); // �닔吏묒떆�옉 �븷�븣 (MAPI_TRTM_STCD = 02 �씪�븣) 1移댁슫�듃
//
//					String ginsu001RspCode = CommonConstant.STRING_FORMAT_SPACE;
//					try { ginsu001RspCode = ginsuService.mjG001GetGinsuInsu(reqParam);    } catch (RuntimeException e) {log.debug("mjG001GetGinsuInsu > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					if("00000".equals(ginsu001RspCode)  && !"0".equals(reqParam.getTrnmReqPtcd())) {
//						try { ginsuService.mjG001GetGinsuInsu(reqParam);                  } catch (RuntimeException e) {log.debug("mjG001GetGinsuInsu > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { ginsuService.mjG001GetGinsuInsuBasc(reqParam);              } catch (RuntimeException e) {log.debug("mjG001GetGinsuInsuBasc > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { ginsuService.mjG001GetGinsuInsuTr(reqParam);                } catch (RuntimeException e) {log.debug("mjG001GetGinsuInsuTr > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					}
//
//					inMD1400TR.setMapiTrtmStcd("01");
//					commonService.regMD1400TR(inMD1400TR); // 醫낅즺�쟻�옱�떆 移댁슫�듃 �븯吏��븡�쓬
//
//				} else if ("telecom".equals(industry)) {
//					inMD1400TR.setMydtGthrPrgmId("telecom");
//					inMD1400TR.setMapiTrtmStcd("02");
//					commonService.regMD1400TR(inMD1400TR); // �닔吏묒떆�옉 �븷�븣 (MAPI_TRTM_STCD = 02 �씪�븣) 1移댁슫�듃
//
//					String telecom001RspCode = CommonConstant.STRING_FORMAT_SPACE;
//					try { telecom001RspCode = telecomService.mjH001GetTelecoms(reqParam); } catch (RuntimeException e) {log.debug("mjH001GetTelecoms > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					if("00000".equals(telecom001RspCode)  && !"0".equals(reqParam.getTrnmReqPtcd())) {
//						try { telecomService.mjH001GetTelecomsBill(reqParam);             } catch (RuntimeException e) {log.debug("mjH001GetTelecomsBill > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { telecomService.mjH001GetTelecomsTransactions(reqParam);     } catch (RuntimeException e) {log.debug("mjH001GetTelecomsTransactions > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { telecomService.mjH001GetTelecomsPaidTransactions(reqParam); } catch (RuntimeException e) {log.debug("mjH001GetTelecomsPaidTransactions > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					}
//
//					inMD1400TR.setMapiTrtmStcd("01");
//					commonService.regMD1400TR(inMD1400TR); // 醫낅즺�쟻�옱�떆 移댁슫�듃 �븯吏��븡�쓬
//
//				} else if ("bond".equals(industry) || "usury".equals(industry)) {
//					inMD1400TR.setMydtGthrPrgmId("bond");
//					inMD1400TR.setMapiTrtmStcd("02");
//					commonService.regMD1400TR(inMD1400TR); // �닔吏묒떆�옉 �븷�븣 (MAPI_TRTM_STCD = 02 �씪�븣) 1移댁슫�듃
//
//					reqParam.setBondDiv(bondDiv);
//					String bond001RspCode = CommonConstant.STRING_FORMAT_SPACE;
//					try { bond001RspCode = bondService.mjJ001GetBonds(reqParam);          } catch (RuntimeException e) {log.debug("mjJ001GetBonds > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					if("00000".equals(bond001RspCode)  && !"0".equals(reqParam.getTrnmReqPtcd())) {
//						try { bondService.mjJ001GetBondsDetail(reqParam);                 } catch (RuntimeException e) {log.debug("mjJ001GetBondsDetail > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { bondService.mjJ001GetBondsTransactions(reqParam);           } catch (RuntimeException e) {log.debug("mjJ001GetBondsTransactions > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					}
//
//					inMD1400TR.setMapiTrtmStcd("01");
//					commonService.regMD1400TR(inMD1400TR); // 醫낅즺�쟻�옱�떆 移댁슫�듃 �븯吏��븡�쓬
//
//				} else if ("p2p".equals(industry)) {
//					inMD1400TR.setMydtGthrPrgmId("p2p");
//					inMD1400TR.setMapiTrtmStcd("02");
//					commonService.regMD1400TR(inMD1400TR); // �닔吏묒떆�옉 �븷�븣 (MAPI_TRTM_STCD = 02 �씪�븣) 1移댁슫�듃
//
//					String p2p001RspCode = CommonConstant.STRING_FORMAT_SPACE;
//					try { p2p001RspCode = p2pService.mjI001GetLendings(reqParam);         } catch (RuntimeException e) {log.debug("mjI001GetLendings > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					if("00000".equals(p2p001RspCode)  && !"0".equals(reqParam.getTrnmReqPtcd())) {
//						try { p2pService.mjI001GetLendingsBasic(reqParam);                } catch (RuntimeException e) {log.debug("mjI001GetLendingsBasic > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { p2pService.mjI001GetLendingsDetail(reqParam);               } catch (RuntimeException e) {log.debug("mjI001GetLendingsDetail > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { p2pService.mjI001GetLendingsTransactions(reqParam);         } catch (RuntimeException e) {log.debug("mjI001GetLendingsTransactions > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					}
//
//					inMD1400TR.setMapiTrtmStcd("01");
//					commonService.regMD1400TR(inMD1400TR); // 醫낅즺�쟻�옱�떆 移댁슫�듃 �븯吏��븡�쓬
//				}
//
//				// 2. 怨듯넻�뾽沅� �닔吏멇PI �샇異�_IRP
//				if (isIRP || ("0".equals(reqParam.getTrnmReqPtcd()) && (  "bank".equals(industry) || "insu".equals(industry) || "invest".equals(industry))) ) {
//					inMD1400TR.setMydtGthrPrgmId("irp");
//					inMD1400TR.setMapiTrtmStcd("02");
//					commonService.regMD1400TR(inMD1400TR); // �닔吏묒떆�옉 �븷�븣 (MAPI_TRTM_STCD = 02 �씪�븣) 1移댁슫�듃
//
//					if("0".equals(reqParam.getTrnmReqPtcd())) {
//						reqParam.setIRPDiv(industry);
//					} else {
//						reqParam.setIRPDiv(IRPDiv);
//					}
//
//					String irp001RspCode = CommonConstant.STRING_FORMAT_SPACE;
//					try { irp001RspCode = irpService.mjJ002GetIrps(reqParam);             } catch (RuntimeException e) {log.debug("mjJ002GetIrps > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					if("00000".equals(irp001RspCode)  && !"0".equals(reqParam.getTrnmReqPtcd())) {
//						try { irpService.mjJ002GetIrpsBasic(reqParam);                    } catch (RuntimeException e) {log.debug("mjJ002GetIrpsBasic > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { irpService.mjJ002GetIrpsDetail(reqParam);                   } catch (RuntimeException e) {log.debug("mjJ002GetIrpsDetail > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { irpService.mjJ002GetIrpsTransactions(reqParam);             } catch (RuntimeException e) {log.debug("mjJ002GetIrpsTransactions > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					}
//
//					inMD1400TR.setMapiTrtmStcd("01");
//					commonService.regMD1400TR(inMD1400TR); // 醫낅즺�쟻�옱�떆 移댁슫�듃 �븯吏��븡�쓬
//				}
//
//				// 2. 怨듯넻�뾽沅� �닔吏멇PI �샇異�_�꽑遺�
//				if (isPrepaid || ("0".equals(reqParam.getTrnmReqPtcd()) && (  "bank".equals(industry) || "card".equals(industry) ))  ) {
//					inMD1400TR.setMydtGthrPrgmId("prepaid");
//					inMD1400TR.setMapiTrtmStcd("02");
//					commonService.regMD1400TR(inMD1400TR); // �닔吏묒떆�옉 �븷�븣 (MAPI_TRTM_STCD = 02 �씪�븣) 1移댁슫�듃
//
//					String prepaid001RspCode = CommonConstant.STRING_FORMAT_SPACE;
//
//					if("0".equals(reqParam.getTrnmReqPtcd())) {
//						reqParam.setPrepaidDiv(industry);
//					} else {
//						reqParam.setPrepaidDiv(prepaidDiv);
//					}
//					try { prepaid001RspCode = prepaidService.mjJ003GetPrepaid(reqParam);  } catch (RuntimeException e) {log.debug("mjJ003GetPrepaid > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					if("00000".equals(prepaid001RspCode)  && !"0".equals(reqParam.getTrnmReqPtcd())) {
//						try { prepaidService.mjJ003GetPrepaidBalance(reqParam);           } catch (RuntimeException e) {log.debug("mjJ003GetPrepaidBalance > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { prepaidService.mjJ003GetPrepaidTransactions(reqParam);      } catch (RuntimeException e) {log.debug("mjJ003GetPrepaidTransactions > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//						try { prepaidService.mjJ003GetPrepaidApproval(reqParam);          } catch (RuntimeException e) {log.debug("mjJ003GetPrepaidApproval > > Exception : " + e.getClass().getName() + " : " + e.getMessage());}
//					}
//
//					inMD1400TR.setMapiTrtmStcd("01");
//					commonService.regMD1400TR(inMD1400TR); // 醫낅즺�쟻�옱�떆 移댁슫�듃 �븯吏��븡�쓬
//				}
//			}
//
//			resVO.setRespCode("00000");
//			resVO.setRespMsg("�꽦怨�");
//		} else {
//			// �샇異� 媛��뒫�븳 �넗�겙 �뾾�쓬
//			resVO.setRespCode("40001");
//			resVO.setRespMsg("�샇異쒓��뒫�븳 �넗�겙�씠 �뾾嫄곕굹 �씪�씪 �닔吏� �슏�닔 珥덇낵");
//		}
//
//		return new ResponseEntity<>(resVO, null, HttpStatus.OK);
//	}
//
//	/**
//	 * 1. MethodName        : mjCommonMydataAgrgApi
//	 * 2. ClassName         : MjCommonController
//	 * 3. Comment           : 留덉씠�뜲�씠�꽣 吏묎퀎 �떎�뻾
//	 * @APIID               : MJA-API
//	 * @SQLID               : NONE
//	 * @APIM                : NONE
//	 * @author              : kyeong-min, Kim
//	 * @version             : 2022. 6. 2. �삤�썑 2:37:57
//	 * @return ResponseEntity<?>
//	 * @param reqVO
//	 * @throws Exception
//	 */
//	@ApiOperation(value = "MJ-AGRG", notes = "留덉씠�뜲�씠�꽣 吏묎퀎 �떎�뻾")
//	@PostMapping("/reg-mydata-agrg")
//	public ResponseEntity<?> mjCommonMydataAgrgApi(@RequestBody MjCommonReqVO reqVO) throws Exception {
//		log.info("留덉씠�뜲�씠�꽣 吏묎퀎 : reg-mydata-agrg Start");
//
//		MjCommonResVO resVO = new MjCommonResVO();
//		Map<String, Object> requestParam = new HashMap<String, Object>();
//
//		if(null == reqVO.getCsno() || "".equals(reqVO.getCsno())) {
//			return new ResponseEntity<>("�븘�닔媛믪씠 �뾾�뒿�땲�떎.", null, HttpStatus.BAD_REQUEST);
//		}
//
//		requestParam.put("csno", reqVO.getCsno());
//
//		try {
//			// �옄�궛 : �옄�궛吏묎퀎紐낆꽭 �쟻�옱
//			log.info("�옄�궛吏묎퀎紐낆꽭 �쟻�옱");
//			mjY001ServiceImpl.mjY001InsAstAgrgDscr(requestParam);
//		} catch (RuntimeException e) {
//			log.debug("mjY001InsAstAgrgDscr > > Exception : " + e.getClass().getName() + " : " + e.getMessage());
//		}
//
//		try {
//			// 留ㅼ튂 : �닾�옄 �긽�뭹 �긽�꽭 �쟻�옱
//			log.info("留ㅼ튂 : �닾�옄 �긽�뭹 �긽�꽭 �쟻�옱");
//			mjW001ServiceImpl.mjW001RegInvestPrdtDtl(requestParam);
//		} catch (RuntimeException e) {
//			log.debug("mjW001RegInvestPrdtDtl > > Exception : " + e.getClass().getName() + " : " + e.getMessage());
//		}
//
//		try {
//			// 留ㅼ튂 : 怨좉컼 �깭洹� 遺��뿬
//			log.info("留ㅼ튂 : 怨좉컼 �깭洹� 遺��뿬");
//			mjW001ServiceImpl.mjW001RegMtchHstg(requestParam);
//		} catch (RuntimeException e) {
//			log.debug("mjW001RegMtchHstg > > Exception : " + e.getClass().getName() + " : " + e.getMessage());
//		}
//
//		return new ResponseEntity<>(resVO, null, HttpStatus.OK);
//	}

}
