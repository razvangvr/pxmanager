package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class AuthorsBean extends GenericBean{

    public static final String key="AuthorsBean";

	
    private static String[] fieldsName = {"id","name"};


	public static final int id_FIELD = 0;
	public static final int name_FIELD = 1;

	private int id;
	private String name;

	/**
	 * Empty constructor 
	 */
	public AuthorsBean() { 
	}//end AuthorsBean()

	 
	public int getId() { 
		return  id;
	}//end getId()

	public void setId(int pid) { 
		id = pid;
	}//end setId()
	public String getName() { 
		return  name;
	}//end getName()

	public void setName(String pname) { 
		name = pname;
	}//end setName()


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