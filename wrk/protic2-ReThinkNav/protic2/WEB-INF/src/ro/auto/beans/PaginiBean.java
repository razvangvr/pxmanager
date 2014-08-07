package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class PaginiBean extends GenericBean{

    public static final String key="PaginiBean";

	
    private static String[] fieldsName = {"Id","continut","grupa","id_disciplineprofesori"};


	public static final int Id_FIELD = 0;
	public static final int continut_FIELD = 1;
	public static final int grupa_FIELD = 2;
	public static final int id_disciplineprofesori_FIELD = 3;

	private int Id;
	private String continut;
	private int grupa;
	private int id_disciplineprofesori;

	/**
	 * Empty constructor 
	 */
	public PaginiBean() { 
	}//end PaginiBean()

	 
	public int getId() { 
		return  Id;
	}//end getId()

	public void setId(int pId) { 
		Id = pId;
	}//end setId()
	public String getContinut() { 
		return  continut;
	}//end getContinut()

	public void setContinut(String pcontinut) { 
		continut = pcontinut;
	}//end setContinut()
	public int getGrupa() { 
		return  grupa;
	}//end getGrupa()

	public void setGrupa(int pgrupa) { 
		grupa = pgrupa;
	}//end setGrupa()
	public int getId_disciplineprofesori() { 
		return  id_disciplineprofesori;
	}//end getId_disciplineprofesori()

	public void setId_disciplineprofesori(int pid_disciplineprofesori) { 
		id_disciplineprofesori = pid_disciplineprofesori;
	}//end setId_disciplineprofesori()


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