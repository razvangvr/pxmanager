package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class AlternativesBean extends GenericBean{

    public static final String key="AlternativesBean";

	
    private static String[] fieldsName = {"jdataid","jdataaltid"};


	public static final int jdataid_FIELD = 0;
	public static final int jdataaltid_FIELD = 1;

	private int jdataid;
	private int jdataaltid;

	/**
	 * Empty constructor 
	 */
	public AlternativesBean() { 
	}//end AlternativesBean()

	 
	public int getJdataid() { 
		return  jdataid;
	}//end getJdataid()

	public void setJdataid(int pjdataid) { 
		jdataid = pjdataid;
	}//end setJdataid()
	public int getJdataaltid() { 
		return  jdataaltid;
	}//end getJdataaltid()

	public void setJdataaltid(int pjdataaltid) { 
		jdataaltid = pjdataaltid;
	}//end setJdataaltid()


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