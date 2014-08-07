package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class DisciplinaBean extends GenericBean{

    public static final String key="DisciplinaBean";

	
    private static String[] fieldsName = {"id","den"};


	public static final int id_FIELD = 0;
	public static final int den_FIELD = 1;

	private long id;
	private String den;

	/**
	 * Empty constructor 
	 */
	public DisciplinaBean() { 
	}//end DisciplinaBean()

	 
	public long getId() { 
		return  id;
	}//end getId()

	public void setId(long pid) { 
		id = pid;
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