package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class SqldataBean extends GenericBean{

    public static final String key="SqldataBean";

	
    private static String[] fieldsName = {"id","name","jdataid"};


	public static final int id_FIELD = 0;
	public static final int name_FIELD = 1;
	public static final int jdataid_FIELD = 2;

	private int id;
	private String name;
	private int jdataid;

	/**
	 * Empty constructor 
	 */
	public SqldataBean() { 
	}//end SqldataBean()

	 
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
	public int getJdataid() { 
		return  jdataid;
	}//end getJdataid()

	public void setJdataid(int pjdataid) { 
		jdataid = pjdataid;
	}//end setJdataid()


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