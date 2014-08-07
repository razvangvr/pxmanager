package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class AsocieriBean extends GenericBean{

    public static final String key="AsocieriBean";

	
    private static String[] fieldsName = {"idsqldata","idjdata"};


	public static final int idsqldata_FIELD = 0;
	public static final int idjdata_FIELD = 1;

	private int idsqldata;
	private int idjdata;

	/**
	 * Empty constructor 
	 */
	public AsocieriBean() { 
	}//end AsocieriBean()

	 
	public int getIdsqldata() { 
		return  idsqldata;
	}//end getIdsqldata()

	public void setIdsqldata(int pidsqldata) { 
		idsqldata = pidsqldata;
	}//end setIdsqldata()
	public int getIdjdata() { 
		return  idjdata;
	}//end getIdjdata()

	public void setIdjdata(int pidjdata) { 
		idjdata = pidjdata;
	}//end setIdjdata()


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