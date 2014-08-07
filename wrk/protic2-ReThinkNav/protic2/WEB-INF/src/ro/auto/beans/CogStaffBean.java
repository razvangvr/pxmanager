package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class CogStaffBean extends GenericBean{

    public static final String key="CogStaffBean";

	
    private static String[] fieldsName = {"COG_STAFF_ID","DEPT_ID","EMPLOYEE_NUMBER","LAST_NAME","FIRST_NAME","MIDDLE_NAME","TITLE","EMPLOYEE_TYPE","SUPERVISOR","HIRING_DATE","LEFT_DATE"};


	public static final int COG_STAFF_ID_FIELD = 0;
	public static final int DEPT_ID_FIELD = 1;
	public static final int EMPLOYEE_NUMBER_FIELD = 2;
	public static final int LAST_NAME_FIELD = 3;
	public static final int FIRST_NAME_FIELD = 4;
	public static final int MIDDLE_NAME_FIELD = 5;
	public static final int TITLE_FIELD = 6;
	public static final int EMPLOYEE_TYPE_FIELD = 7;
	public static final int SUPERVISOR_FIELD = 8;
	public static final int HIRING_DATE_FIELD = 9;
	public static final int LEFT_DATE_FIELD = 10;

	private int COG_STAFF_ID;
	private int DEPT_ID;
	private int EMPLOYEE_NUMBER;
	private String LAST_NAME;
	private String FIRST_NAME;
	private String MIDDLE_NAME;
	private String TITLE;
	private String EMPLOYEE_TYPE;
	private int SUPERVISOR;
	private Date HIRING_DATE;
	private Date LEFT_DATE;

	/**
	 * Empty constructor 
	 */
	public CogStaffBean() { 
	}//end CogStaffBean()

	 
	public int getCOG_STAFF_ID() { 
		return  COG_STAFF_ID;
	}//end getCOG_STAFF_ID()

	public void setCOG_STAFF_ID(int pCOG_STAFF_ID) { 
		COG_STAFF_ID = pCOG_STAFF_ID;
	}//end setCOG_STAFF_ID()
	public int getDEPT_ID() { 
		return  DEPT_ID;
	}//end getDEPT_ID()

	public void setDEPT_ID(int pDEPT_ID) { 
		DEPT_ID = pDEPT_ID;
	}//end setDEPT_ID()
	public int getEMPLOYEE_NUMBER() { 
		return  EMPLOYEE_NUMBER;
	}//end getEMPLOYEE_NUMBER()

	public void setEMPLOYEE_NUMBER(int pEMPLOYEE_NUMBER) { 
		EMPLOYEE_NUMBER = pEMPLOYEE_NUMBER;
	}//end setEMPLOYEE_NUMBER()
	public String getLAST_NAME() { 
		return  LAST_NAME;
	}//end getLAST_NAME()

	public void setLAST_NAME(String pLAST_NAME) { 
		LAST_NAME = pLAST_NAME;
	}//end setLAST_NAME()
	public String getFIRST_NAME() { 
		return  FIRST_NAME;
	}//end getFIRST_NAME()

	public void setFIRST_NAME(String pFIRST_NAME) { 
		FIRST_NAME = pFIRST_NAME;
	}//end setFIRST_NAME()
	public String getMIDDLE_NAME() { 
		return  MIDDLE_NAME;
	}//end getMIDDLE_NAME()

	public void setMIDDLE_NAME(String pMIDDLE_NAME) { 
		MIDDLE_NAME = pMIDDLE_NAME;
	}//end setMIDDLE_NAME()
	public String getTITLE() { 
		return  TITLE;
	}//end getTITLE()

	public void setTITLE(String pTITLE) { 
		TITLE = pTITLE;
	}//end setTITLE()
	public String getEMPLOYEE_TYPE() { 
		return  EMPLOYEE_TYPE;
	}//end getEMPLOYEE_TYPE()

	public void setEMPLOYEE_TYPE(String pEMPLOYEE_TYPE) { 
		EMPLOYEE_TYPE = pEMPLOYEE_TYPE;
	}//end setEMPLOYEE_TYPE()
	public int getSUPERVISOR() { 
		return  SUPERVISOR;
	}//end getSUPERVISOR()

	public void setSUPERVISOR(int pSUPERVISOR) { 
		SUPERVISOR = pSUPERVISOR;
	}//end setSUPERVISOR()
	public Date getHIRING_DATE() { 
		return  HIRING_DATE;
	}//end getHIRING_DATE()

	public void setHIRING_DATE(Date pHIRING_DATE) { 
		HIRING_DATE = pHIRING_DATE;
	}//end setHIRING_DATE()
	public Date getLEFT_DATE() { 
		return  LEFT_DATE;
	}//end getLEFT_DATE()

	public void setLEFT_DATE(Date pLEFT_DATE) { 
		LEFT_DATE = pLEFT_DATE;
	}//end setLEFT_DATE()


  	public static int getFieldIndex(String name){
		if (fieldsName!=null)	
		for (int i = 0; i < fieldsName.length; i++) {
			String fieldName = fieldsName[i];
			if (fieldName.equalsIgnoreCase(name)) return i;
		}
		return -1;
	}
	public static int getFieldsNumber(){
		return fieldsName.length;
	}

}