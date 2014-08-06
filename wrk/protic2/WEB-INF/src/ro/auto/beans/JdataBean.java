package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class JdataBean extends GenericBean{

    public static final String key="JdataBean";

	
    private static String[] fieldsName = {"id","name","rsstring","stmtstring"};


	public static final int id_FIELD = 0;
	public static final int name_FIELD = 1;
	public static final int rsstring_FIELD = 2;
	public static final int stmtstring_FIELD = 3;

	private int id;
	private String name;
	private String rsstring;
	private String stmtstring;

	/**
	 * Empty constructor 
	 */
	public JdataBean() { 
	}//end JdataBean()

	 
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
	public String getRsstring() { 
		return  rsstring;
	}//end getRsstring()

	public void setRsstring(String prsstring) { 
		rsstring = prsstring;
	}//end setRsstring()
	public String getStmtstring() { 
		return  stmtstring;
	}//end getStmtstring()

	public void setStmtstring(String pstmtstring) { 
		stmtstring = pstmtstring;
	}//end setStmtstring()


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