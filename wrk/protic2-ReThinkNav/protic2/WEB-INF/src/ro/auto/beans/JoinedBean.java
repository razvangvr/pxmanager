package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class JoinedBean extends GenericBean{

    public static final String key="JoinedBean";

	
    private static String[] fieldsName = {"id","tableId","joinId"};


	public static final int id_FIELD = 0;
	public static final int tableId_FIELD = 1;
	public static final int joinId_FIELD = 2;

	private int id;
	private int tableId;
	private int joinId;

	/**
	 * Empty constructor 
	 */
	public JoinedBean() { 
	}//end JoinedBean()

	 
	public int getId() { 
		return  id;
	}//end getId()

	public void setId(int pid) { 
		id = pid;
	}//end setId()
	public int getTableId() { 
		return  tableId;
	}//end getTableId()

	public void setTableId(int ptableId) { 
		tableId = ptableId;
	}//end setTableId()
	public int getJoinId() { 
		return  joinId;
	}//end getJoinId()

	public void setJoinId(int pjoinId) { 
		joinId = pjoinId;
	}//end setJoinId()


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