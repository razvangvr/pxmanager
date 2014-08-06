package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class ElevBean extends GenericBean{

    public static final String key="ElevBean";

	
    private static String[] fieldsName = {"id","matr","nume","datan","sex","adr","loc","jud","codp","tel","email","statut","nat"};


	public static final int id_FIELD = 0;
	public static final int matr_FIELD = 1;
	public static final int nume_FIELD = 2;
	public static final int datan_FIELD = 3;
	public static final int sex_FIELD = 4;
	public static final int adr_FIELD = 5;
	public static final int loc_FIELD = 6;
	public static final int jud_FIELD = 7;
	public static final int codp_FIELD = 8;
	public static final int tel_FIELD = 9;
	public static final int email_FIELD = 10;
	public static final int statut_FIELD = 11;
	public static final int nat_FIELD = 12;

	private long id;
	private long matr;
	private String nume;
	private Date datan;
	private String sex;
	private String adr;
	private String loc;
	private String jud;
	private int codp;
	private String tel;
	private String email;
	private String statut;
	private String nat;

	/**
	 * Empty constructor 
	 */
	public ElevBean() { 
	}//end ElevBean()

	 
	public long getId() { 
		return  id;
	}//end getId()

	public void setId(long pid) { 
		id = pid;
	}//end setId()
	public long getMatr() { 
		return  matr;
	}//end getMatr()

	public void setMatr(long pmatr) { 
		matr = pmatr;
	}//end setMatr()
	public String getNume() { 
		return  nume;
	}//end getNume()

	public void setNume(String pnume) { 
		nume = pnume;
	}//end setNume()
	public Date getDatan() { 
		return  datan;
	}//end getDatan()

	public void setDatan(Date pdatan) { 
		datan = pdatan;
	}//end setDatan()
	public String getSex() { 
		return  sex;
	}//end getSex()

	public void setSex(String psex) { 
		sex = psex;
	}//end setSex()
	public String getAdr() { 
		return  adr;
	}//end getAdr()

	public void setAdr(String padr) { 
		adr = padr;
	}//end setAdr()
	public String getLoc() { 
		return  loc;
	}//end getLoc()

	public void setLoc(String ploc) { 
		loc = ploc;
	}//end setLoc()
	public String getJud() { 
		return  jud;
	}//end getJud()

	public void setJud(String pjud) { 
		jud = pjud;
	}//end setJud()
	public int getCodp() { 
		return  codp;
	}//end getCodp()

	public void setCodp(int pcodp) { 
		codp = pcodp;
	}//end setCodp()
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
	public String getStatut() { 
		return  statut;
	}//end getStatut()

	public void setStatut(String pstatut) { 
		statut = pstatut;
	}//end setStatut()
	public String getNat() { 
		return  nat;
	}//end getNat()

	public void setNat(String pnat) { 
		nat = pnat;
	}//end setNat()


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