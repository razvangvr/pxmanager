package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class AbsenteBean extends GenericBean{

    public static final String key="AbsenteBean";

	
    private static String[] fieldsName = {"id","id_elev","id_an","motivat","nemotivat","semestru"};


	public static final int id_FIELD = 0;
	public static final int id_elev_FIELD = 1;
	public static final int id_an_FIELD = 2;
	public static final int motivat_FIELD = 3;
	public static final int nemotivat_FIELD = 4;
	public static final int semestru_FIELD = 5;

	private long id;
	private long id_elev;
	private long id_an;
	private int motivat;
	private int nemotivat;
	private String semestru;

	/**
	 * Empty constructor 
	 */
	public AbsenteBean() { 
	}//end AbsenteBean()

	 
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
	public long getId_an() { 
		return  id_an;
	}//end getId_an()

	public void setId_an(long pid_an) { 
		id_an = pid_an;
	}//end setId_an()
	public int getMotivat() { 
		return  motivat;
	}//end getMotivat()

	public void setMotivat(int pmotivat) { 
		motivat = pmotivat;
	}//end setMotivat()
	public int getNemotivat() { 
		return  nemotivat;
	}//end getNemotivat()

	public void setNemotivat(int pnemotivat) { 
		nemotivat = pnemotivat;
	}//end setNemotivat()
	public String getSemestru() { 
		return  semestru;
	}//end getSemestru()

	public void setSemestru(String psemestru) { 
		semestru = psemestru;
	}//end setSemestru()


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