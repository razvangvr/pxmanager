package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class UsersgrupeBean extends GenericBean{

    public static final String key="UsersgrupeBean";

	
    private static String[] fieldsName = {"id","username","id_disciplineprofesori","grupa"};


	public static final int id_FIELD = 0;
	public static final int username_FIELD = 1;
	public static final int id_disciplineprofesori_FIELD = 2;
	public static final int grupa_FIELD = 3;

	private long id;
	private String username;
	private int id_disciplineprofesori;
	private int grupa;

	/**
	 * Empty constructor 
	 */
	public UsersgrupeBean() { 
	}//end UsersgrupeBean()

	 
	public long getId() { 
		return  id;
	}//end getId()

	public void setId(long pid) { 
		id = pid;
	}//end setId()
	public String getUsername() { 
		return  username;
	}//end getUsername()

	public void setUsername(String pusername) { 
		username = pusername;
	}//end setUsername()
	public int getId_disciplineprofesori() { 
		return  id_disciplineprofesori;
	}//end getId_disciplineprofesori()

	public void setId_disciplineprofesori(int pid_disciplineprofesori) { 
		id_disciplineprofesori = pid_disciplineprofesori;
	}//end setId_disciplineprofesori()
	public int getGrupa() { 
		return  grupa;
	}//end getGrupa()

	public void setGrupa(int pgrupa) { 
		grupa = pgrupa;
	}//end setGrupa()


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