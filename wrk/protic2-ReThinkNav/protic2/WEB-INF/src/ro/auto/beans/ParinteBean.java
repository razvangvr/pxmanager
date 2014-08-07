package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class ParinteBean extends GenericBean{

    public static final String key="ParinteBean";

	
    private static String[] fieldsName = {"id","id_elev","nume","profesie","loc_munca","adr","loc","jud","Codp","tel","email","obs","statut","intara"};


	public static final int id_FIELD = 0;
	public static final int id_elev_FIELD = 1;
	public static final int nume_FIELD = 2;
	public static final int profesie_FIELD = 3;
	public static final int loc_munca_FIELD = 4;
	public static final int adr_FIELD = 5;
	public static final int loc_FIELD = 6;
	public static final int jud_FIELD = 7;
	public static final int Codp_FIELD = 8;
	public static final int tel_FIELD = 9;
	public static final int email_FIELD = 10;
	public static final int obs_FIELD = 11;
	public static final int statut_FIELD = 12;
	public static final int intara_FIELD = 13;

	private long id;
	private long id_elev;
	private String nume;
	private String profesie;
	private String loc_munca;
	private String adr;
	private String loc;
	private String jud;
	private int Codp;
	private String tel;
	private String email;
	private String obs;
	private String statut;
	private String intara;

	/**
	 * Empty constructor 
	 */
	public ParinteBean() { 
	}//end ParinteBean()

	 
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
	public String getNume() { 
		return  nume;
	}//end getNume()

	public void setNume(String pnume) { 
		nume = pnume;
	}//end setNume()
	public String getProfesie() { 
		return  profesie;
	}//end getProfesie()

	public void setProfesie(String pprofesie) { 
		profesie = pprofesie;
	}//end setProfesie()
	public String getLoc_munca() { 
		return  loc_munca;
	}//end getLoc_munca()

	public void setLoc_munca(String ploc_munca) { 
		loc_munca = ploc_munca;
	}//end setLoc_munca()
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
		return  Codp;
	}//end getCodp()

	public void setCodp(int pCodp) { 
		Codp = pCodp;
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
	public String getObs() { 
		return  obs;
	}//end getObs()

	public void setObs(String pobs) { 
		obs = pobs;
	}//end setObs()
	public String getStatut() { 
		return  statut;
	}//end getStatut()

	public void setStatut(String pstatut) { 
		statut = pstatut;
	}//end setStatut()
	public String getIntara() { 
		return  intara;
	}//end getIntara()

	public void setIntara(String pintara) { 
		intara = pintara;
	}//end setIntara()


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