package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class ElevigrupeBean extends GenericBean{

    public static final String key="ElevigrupeBean";

	
    private static String[] fieldsName = {"id","id_elev","id_disciplineprofesori","grupa"};


	public static final int id_FIELD = 0;
	public static final int id_elev_FIELD = 1;
	public static final int id_disciplineprofesori_FIELD = 2;
	public static final int grupa_FIELD = 3;

	private long id;
	private long id_elev;
	private int id_disciplineprofesori;
	private int grupa;

	/**
	 * Empty constructor 
	 */
	public ElevigrupeBean() { 
	}//end ElevigrupeBean()

	 
	public long getId() { 
		return  id;
	}//end getId()

	public void setId(long pid) { 
		id = pid;
	}//end setId()
	public long getId_elev() { 
		return  id_elev;
	}//end getId_elev()

	public void setId_elev(long pid_elev) { 
		id_elev = pid_elev;
	}//end setId_elev()
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