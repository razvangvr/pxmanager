package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class UsersBean extends GenericBean{

    public static final String key="UsersBean";

	
    private static String[] fieldsName = {"username","userpassword","usertype","name","address1","address2","city","country","phone","email","lastLogin","chatuserid","id_clasa"};


	public static final int username_FIELD = 0;
	public static final int userpassword_FIELD = 1;
	public static final int usertype_FIELD = 2;
	public static final int name_FIELD = 3;
	public static final int address1_FIELD = 4;
	public static final int address2_FIELD = 5;
	public static final int city_FIELD = 6;
	public static final int country_FIELD = 7;
	public static final int phone_FIELD = 8;
	public static final int email_FIELD = 9;
	public static final int lastLogin_FIELD = 10;
	public static final int chatuserid_FIELD = 11;
	public static final int id_clasa_FIELD = 12;

	private String username;
	private String userpassword;
	private String usertype;
	private String name;
	private String address1;
	private String address2;
	private String city;
	private String country;
	private String phone;
	private String email;
	private Timestamp lastLogin;
	private int chatuserid;
	private long id_clasa;

	/**
	 * Empty constructor 
	 */
	public UsersBean() { 
	}//end UsersBean()

	 
	public String getUsername() { 
		return  username;
	}//end getUsername()

	public void setUsername(String pusername) { 
		username = pusername;
	}//end setUsername()
	public String getUserpassword() { 
		return  userpassword;
	}//end getUserpassword()

	public void setUserpassword(String puserpassword) { 
		userpassword = puserpassword;
	}//end setUserpassword()
	public String getUsertype() { 
		return  usertype;
	}//end getUsertype()

	public void setUsertype(String pusertype) { 
		usertype = pusertype;
	}//end setUsertype()
	public String getName() { 
		return  name;
	}//end getName()

	public void setName(String pname) { 
		name = pname;
	}//end setName()
	public String getAddress1() { 
		return  address1;
	}//end getAddress1()

	public void setAddress1(String paddress1) { 
		address1 = paddress1;
	}//end setAddress1()
	public String getAddress2() { 
		return  address2;
	}//end getAddress2()

	public void setAddress2(String paddress2) { 
		address2 = paddress2;
	}//end setAddress2()
	public String getCity() { 
		return  city;
	}//end getCity()

	public void setCity(String pcity) { 
		city = pcity;
	}//end setCity()
	public String getCountry() { 
		return  country;
	}//end getCountry()

	public void setCountry(String pcountry) { 
		country = pcountry;
	}//end setCountry()
	public String getPhone() { 
		return  phone;
	}//end getPhone()

	public void setPhone(String pphone) { 
		phone = pphone;
	}//end setPhone()
	public String getEmail() { 
		return  email;
	}//end getEmail()

	public void setEmail(String pemail) { 
		email = pemail;
	}//end setEmail()
	public Timestamp getLastLogin() { 
		return  lastLogin;
	}//end getLastLogin()

	public void setLastLogin(Timestamp plastLogin) { 
		lastLogin = plastLogin;
	}//end setLastLogin()
	public int getChatuserid() { 
		return  chatuserid;
	}//end getChatuserid()

	public void setChatuserid(int pchatuserid) { 
		chatuserid = pchatuserid;
	}//end setChatuserid()
	public long getId_clasa() { 
		return  id_clasa;
	}//end getId_clasa()

	public void setId_clasa(long pid_clasa) { 
		id_clasa = pid_clasa;
	}//end setId_clasa()


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