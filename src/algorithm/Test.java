package algorithm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		String str = "ACCEPT_DM," + 
				"ACCT_TYPE," + 
				"ACT_NO," + 
				"ANNUAL_FEE," + 
				"APPLY_ID," + 
				"APPLY_ID_CODE," + 
				"APPLY_ID_ECODE," + 
				"APPLY_NO," + 
				"APPLY_SOURCE," + 
				"APR_DATE," + 
				"APR_USER," + 
				"BATCHNO," + 
				"BILL_APPLY_FLAG," + 
				"BIRTHDAY," + 
				"BRANCH," + 
				"BUSINESS_CODE," + 
				"CARD_NO," + 
				"CARD_REF_NUM," + 
				"CARD_TYPE," + 
				"CARDCAT," + 
				"CELLAR_PHONE," + 
				"CHI_NAME," + 
				"CLASS_CODE," + 
				"COMM_FLAG," + 
				"COMPANY_ADDR1," + 
				"COMPANY_ADDR2," + 
				"COMPANY_ADDR3," + 
				"COMPANY_ADDR4," + 
				"COMPANY_ADDR5," + 
				"COMPANY_NAME," + 
				"COMPANY_ZIP," + 
				"CORP_ACT_FLAG," + 
				"CORP_ASSURE_FLAG," + 
				"CORP_NO," + 
				"CORP_NO_ECODE," + 
				"CREDIT_FLAG," + 
				"CREDIT_LMT," + 
				"CRT_DATE," + 
				"CRT_USER," + 
				"CVV," + 
				"CVV2," + 
				"E_MAIL_ADDR," + 
				"E_NEWS," + 
				"EDUCATION," + 
				"EMBOSS_4TH_DATA," + 
				"ENG_NAME," + 
				"FEE_CODE," + 
				"FEE_REASON_CODE," + 
				"FINAL_FEE_CODE," + 
				"FORCE_FLAG," + 
				"GRADUATION_ELEMENTARTY," + 
				"GROUP_CODE," + 
				"HOME_AREA_CODE1," + 
				"HOME_AREA_CODE2," + 
				"HOME_TEL_EXT1," + 
				"HOME_TEL_EXT2," + 
				"HOME_TEL_NO1," + 
				"HOME_TEL_NO2," + 
				"IC_FLAG," + 
				"INDIV_CRD_LMT," + 
				"INTRODUCE_EMP_NO," + 
				"INTRODUCE_ID," + 
				"INTRODUCE_NAME," + 
				"INTRODUCE_NO," + 
				"JOB_POSITION," + 
				"MAIL_ADDR1," + 
				"MAIL_ADDR2," + 
				"MAIL_ADDR3," + 
				"MAIL_ADDR4," + 
				"MAIL_ADDR5," + 
				"MAIL_ATTACH1," + 
				"MAIL_ATTACH2," + 
				"MAIL_TYPE," + 
				"MAIL_ZIP," + 
				"MAJOR_CHG_FLAG," + 
				"MAJOR_VALID_FM," + 
				"MAJOR_VALID_TO," + 
				"MARRIAGE," + 
				"MEMBER_ID," + 
				"MOD_PGM," + 
				"MOD_SEQNO," + 
				"MOD_TIME," + 
				"MOD_USER," + 
				"NATION," + 
				"OFFICE_AREA_CODE1," + 
				"OFFICE_AREA_CODE2," + 
				"OFFICE_TEL_EXT1," + 
				"OFFICE_TEL_EXT2," + 
				"OFFICE_TEL_NO1," + 
				"OFFICE_TEL_NO2," + 
				"OLD_CARD_NO," + 
				"ONLINE_MARK," + 
				"ORG_INDIV_CRD_LMT," + 
				"OTHER_CNTRY_CODE," + 
				"PASSPORT_DATE," + 
				"PASSPORT_NO," + 
				"PM_BIRTHDAY," + 
				"PM_CASH," + 
				"PM_ID," + 
				"PM_ID_CODE," + 
				"PM_ID_ECODE," + 
				"POLICE_NO1," + 
				"POLICE_NO2," + 
				"POLICE_NO3," + 
				"PROMOTE_DEPT," + 
				"PROMOTE_EMP_NO," + 
				"PVKI," + 
				"PVV," + 
				"RECNO," + 
				"REG_BANK_NO," + 
				"REJECT_CODE," + 
				"REL_WITH_PM," + 
				"RESEND_NOTE," + 
				"RESIDENT_ADDR1," + 
				"RESIDENT_ADDR2," + 
				"RESIDENT_ADDR3," + 
				"RESIDENT_ADDR4," + 
				"RESIDENT_ADDR5," + 
				"RESIDENT_NO," + 
				"RESIDENT_NO_EXPIRE_DATE," + 
				"RESIDENT_ZIP," + 
				"RISK_BANK_NO," + 
				"SALARY," + 
				"SALARY_CODE," + 
				"SEQNO," + 
				"SERVICE_CODE," + 
				"SERVICE_YEAR," + 
				"SEX," + 
				"SON_CARD_FLAG," + 
				"SOURCE_CODE," + 
				"SPOUSE_BIRTHDAY," + 
				"SPOUSE_ID_NO," + 
				"SPOUSE_NAME," + 
				"STAFF_FLAG," + 
				"STANDARD_FEE," + 
				"STMT_CYCLE," + 
				"STUDENT," + 
				"SUP_BIRTHDAY," + 
				"SUP_CASH," + 
				"UNIT_CODE," + 
				"UR_FLAG," + 
				"VALID_FM," + 
				"VALID_TO," + 
				"VALUE," + 
				"VIP";
		str = str.toLowerCase();
		String[] strArr = str.split(",");
		
// //String[] aa_opt, aa_batchno, aa_recno,aa_apply_id,aa_birthday;
//		for(int i = 0; i < strArr.length; i++ ) {
//			System.out.println("String[] aa_"+strArr[i] + " = null ;");
//		}

////		aa_batchno = wp.item_buff("batchno");
//		for(int i = 0; i < strArr.length; i++ ) {
//			System.out.println("aa_" + strArr[i] + " = wp.item_buff(\"" + strArr[i] +"\"); " );
//		}
		
////		+ " batchno, "
////     + " recno, "
////     + " source, "
//		for(int i = 0; i < strArr.length; i++ ) {
//			System.out.println("+ \" " + strArr[i] + " , \"" );
//		}
		
//		<input type="hidden" name="card_no" value="${card_no}">
//		<input type="hidden" name="batchno" value="${batchno}">

//		for(int i = 0; i < strArr.length; i++ ) {
//		System.out.println(" <input type=\"hidden\" name=\"" +  strArr[i] + "\" value=\"${" +  strArr[i] +"}\">" );
//	}
//		
//		sp.ppss("return_type", wp.col_ss("return_type"));
		
//		for (int i = 0; i < strArr.length; i++) {
//			System.out.println("sp.ppss(\"" + strArr[i] + "\", wp.col_ss(\"" + strArr[i] + "\")); ");
//			if((i+1)%5 ==0) {
//				System.out.println("//" + (i+1));
//			}
//		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date1 = sdf.parse("20191031");
		Date date2 = sdf.parse("20191102");
		long diff = (date1.getTime() - date2.getTime());
		double db = new Double(diff);
		System.out.println(db/(1000*60*60*24) + " : " + diff/(1000*60*60*24) +"  "+date1.getTime() +" - " + date2.getTime() +"\n\n\n\n\nDIFFL(DAYS):" + diff/(1000*60*60*24));
		
	}

}
