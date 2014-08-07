package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class ClasaBean extends GenericBean{

    public static final String key="ClasaBean";

	
    private static String[] fieldsName = {"id","id_an","id_profil","id_specializare","den"};


	public static final int id_FIELD = 0;
	public static final int id_an_FIELD = 1;
	public static final int id_profil_FIELD = 2;
	public static final int id_specializare_FIELD = 3;
	public static final int den_FIELD = 4;

	private long id;
	private long id_an;
	private long id_profil;
	private long id_specializare;
	private String den;

	/**
	 * Empty constructor 
	 */
	public ClasaBean() { 
	}//end ClasaBean()

	 
	public long getId() { 
		return  id;
	}//end getId()

	public void setId(long pid) { 
		id = pid;
	}//end setId()
	public long getId_an() { 
		return  id_an;
	}//end getId_an()

	public void setId_an(long pid_an) { 
		id_an = pid_an;
	}//end setId_an()
	public long getId_profil() { 
		return  id_profil;
	}//end getId_profil()

	public void setId_profil(long pid_profil) { 
		id_profil = pid_profil;
	}//end setId_profil()
	public long getId_specializare() { 
		return  id_specializare;
	}//end getId_specializare()

	public void setId_specializare(long pid_specializare) { 
		id_specializare = pid_specializare;
	}//end setId_specializare()
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