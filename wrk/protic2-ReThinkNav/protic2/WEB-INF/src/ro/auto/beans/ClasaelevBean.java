package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class ClasaelevBean extends GenericBean{

    public static final String key="ClasaelevBean";

	
    private static String[] fieldsName = {"Id"};


	public static final int Id_FIELD = 0;

	private int Id;

	/**
	 * Empty constructor 
	 */
	public ClasaelevBean() { 
	}//end ClasaelevBean()

	 
	public int getId() { 
		return  Id;
	}//end getId()

	public void setId(int pId) { 
		Id = pId;
	}//end setId()


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