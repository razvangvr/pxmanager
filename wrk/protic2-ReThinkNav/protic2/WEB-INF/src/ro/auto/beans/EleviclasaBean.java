package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class EleviclasaBean extends GenericBean{

    public static final String key="EleviclasaBean";

	
    private static String[] fieldsName = {"Id","id_clasa","id_elev"};


	public static final int Id_FIELD = 0;
	public static final int id_clasa_FIELD = 1;
	public static final int id_elev_FIELD = 2;

	private int Id;
	private long id_clasa;
	private long id_elev;

	/**
	 * Empty constructor 
	 */
	public EleviclasaBean() { 
	}//end EleviclasaBean()

	 
	public int getId() { 
		return  Id;
	}//end getId()

	public void setId(int pId) { 
		Id = pId;
	}//end setId()
	public long getId_clasa() { 
		return  id_clasa;
	}//end getId_clasa()

	public void setId_clasa(long pid_clasa) { 
		id_clasa = pid_clasa;
	}//end setId_clasa()
	public long getId_elev() { 
		return  id_elev;
	}//end getId_elev()

	public void setId_elev(long pid_elev) { 
		id_elev = pid_elev;
	}//end setId_elev()


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