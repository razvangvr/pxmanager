package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class ProfesorBean extends GenericBean{

    public static final String key="ProfesorBean";

	
    private static String[] fieldsName = {"id","nume","loc","adr","tel","email","jud"};


	public static final int id_FIELD = 0;
	public static final int nume_FIELD = 1;
	public static final int loc_FIELD = 2;
	public static final int adr_FIELD = 3;
	public static final int tel_FIELD = 4;
	public static final int email_FIELD = 5;
	public static final int jud_FIELD = 6;

	private long id;
	private String nume;
	private String loc;
	private String adr;
	private String tel;
	private String email;
	private String jud;

	/**
	 * Empty constructor 
	 */
	public ProfesorBean() { 
	}//end ProfesorBean()

	 
	public long getId() { 
		return  id;
	}//end getId()

	public void setId(long pid) { 
		id = pid;
	}//end setId()
	public String getNume() { 
		return  nume;
	}//end getNume()

	public void setNume(String pnume) { 
		nume = pnume;
	}//end setNume()
	public String getLoc() { 
		return  loc;
	}//end getLoc()

	public void setLoc(String ploc) { 
		loc = ploc;
	}//end setLoc()
	public String getAdr() { 
		return  adr;
	}//end getAdr()

	public void setAdr(String padr) { 
		adr = padr;
	}//end setAdr()
	public String getTel() { 
		return  tel;
	}//end getTel()

	public void setTel(String ptel) { 
		tel = ptel;
	}//end setTel()
	public String getEmail() { 
		return  email;
	}//end getEmail()

	public void setEmail(String pemail) { 
		email = pemail;
	}//end setEmail()
	public String getJud() { 
		return  jud;
	}//end getJud()

	public void setJud(String pjud) { 
		jud = pjud;
	}//end setJud()


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