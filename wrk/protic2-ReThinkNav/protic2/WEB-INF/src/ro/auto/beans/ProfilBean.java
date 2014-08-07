package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class ProfilBean extends GenericBean{

    public static final String key="ProfilBean";

	
    private static String[] fieldsName = {"Id","den"};


	public static final int Id_FIELD = 0;
	public static final int den_FIELD = 1;

	private int Id;
	private String den;

	/**
	 * Empty constructor 
	 */
	public ProfilBean() { 
	}//end ProfilBean()

	 
	public int getId() { 
		return  Id;
	}//end getId()

	public void setId(int pId) { 
		Id = pId;
	}//end setId()
	public String getDen() { 
		return  den;
	}//end getDen()

	public void setDen(String pden) { 
		den = pden;
	}//end setDen()


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