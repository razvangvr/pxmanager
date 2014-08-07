package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class QuotesBean extends GenericBean{

    public static final String key="QuotesBean";

	
    private static String[] fieldsName = {"id","quote","authorid"};


	public static final int id_FIELD = 0;
	public static final int quote_FIELD = 1;
	public static final int authorid_FIELD = 2;

	private int id;
	private String quote;
	private int authorid;

	/**
	 * Empty constructor 
	 */
	public QuotesBean() { 
	}//end QuotesBean()

	 
	public int getId() { 
		return  id;
	}//end getId()

	public void setId(int pid) { 
		id = pid;
	}//end setId()
	public String getQuote() { 
		return  quote;
	}//end getQuote()

	public void setQuote(String pquote) { 
		quote = pquote;
	}//end setQuote()
	public int getAuthorid() { 
		return  authorid;
	}//end getAuthorid()

	public void setAuthorid(int pauthorid) { 
		authorid = pauthorid;
	}//end setAuthorid()


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