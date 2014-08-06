package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class DiriginteBean extends GenericBean{

    public static final String key="DiriginteBean";

	
    private static String[] fieldsName = {"id","id_profesor","id_clasa","obs","username"};


	public static final int id_FIELD = 0;
	public static final int id_profesor_FIELD = 1;
	public static final int id_clasa_FIELD = 2;
	public static final int obs_FIELD = 3;
	public static final int username_FIELD = 4;

	private long id;
	private long id_profesor;
	private long id_clasa;
	private String obs;
	private String username;

	/**
	 * Empty constructor 
	 */
	public DiriginteBean() { 
	}//end DiriginteBean()

	 
	public long getId() { 
		return  id;
	}//end getId()

	public void setId(long pid) { 
		id = pid;
	}//end setId()
	public long getId_profesor() { 
		return  id_profesor;
	}//end getId_profesor()

	public void setId_profesor(long pid_profesor) { 
		id_profesor = pid_profesor;
	}//end setId_profesor()
	public long getId_clasa() { 
		return  id_clasa;
	}//end getId_clasa()

	public void setId_clasa(long pid_clasa) { 
		id_clasa = pid_clasa;
	}//end setId_clasa()
	public String getObs() { 
		return  obs;
	}//end getObs()

	public void setObs(String pobs) { 
		obs = pobs;
	}//end setObs()
	public String getUsername() { 
		return  username;
	}//end getUsername()

	public void setUsername(String pusername) { 
		username = pusername;
	}//end setUsername()


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