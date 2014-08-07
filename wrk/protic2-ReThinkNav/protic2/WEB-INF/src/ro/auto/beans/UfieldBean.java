package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class UfieldBean extends GenericBean{

    public static final String key="UfieldBean";

	
    private static String[] fieldsName = {"id","name","dbDataType","dbNull","dbDefault","dbExtra","keyName","size","autoincrement","signed","dbPrimaryKey","javaDefaultDataType","userForeignField","userDefaultValue","userJavaDataType","userName","userForeignKey","userPrimaryKey","tableId"};


	public static final int id_FIELD = 0;
	public static final int name_FIELD = 1;
	public static final int dbDataType_FIELD = 2;
	public static final int dbNull_FIELD = 3;
	public static final int dbDefault_FIELD = 4;
	public static final int dbExtra_FIELD = 5;
	public static final int keyName_FIELD = 6;
	public static final int size_FIELD = 7;
	public static final int autoincrement_FIELD = 8;
	public static final int signed_FIELD = 9;
	public static final int dbPrimaryKey_FIELD = 10;
	public static final int javaDefaultDataType_FIELD = 11;
	public static final int userForeignField_FIELD = 12;
	public static final int userDefaultValue_FIELD = 13;
	public static final int userJavaDataType_FIELD = 14;
	public static final int userName_FIELD = 15;
	public static final int userForeignKey_FIELD = 16;
	public static final int userPrimaryKey_FIELD = 17;
	public static final int tableId_FIELD = 18;

	private int id;
	private String name;
	private String dbDataType;
	private String dbNull;
	private String dbDefault;
	private String dbExtra;
	private String keyName;
	private int size;
	private String autoincrement;
	private String signed;
	private String dbPrimaryKey;
	private String javaDefaultDataType;
	private int userForeignField;
	private String userDefaultValue;
	private String userJavaDataType;
	private String userName;
	private String userForeignKey;
	private String userPrimaryKey;
	private int tableId;

	/**
	 * Empty constructor 
	 */
	public UfieldBean() { 
	}//end UfieldBean()

	 
	public int getId() { 
		return  id;
	}//end getId()

	public void setId(int pid) { 
		id = pid;
	}//end setId()
	public String getName() { 
		return  name;
	}//end getName()

	public void setName(String pname) { 
		name = pname;
	}//end setName()
	public String getDbDataType() { 
		return  dbDataType;
	}//end getDbDataType()

	public void setDbDataType(String pdbDataType) { 
		dbDataType = pdbDataType;
	}//end setDbDataType()
	public String getDbNull() { 
		return  dbNull;
	}//end getDbNull()

	public void setDbNull(String pdbNull) { 
		dbNull = pdbNull;
	}//end setDbNull()
	public String getDbDefault() { 
		return  dbDefault;
	}//end getDbDefault()

	public void setDbDefault(String pdbDefault) { 
		dbDefault = pdbDefault;
	}//end setDbDefault()
	public String getDbExtra() { 
		return  dbExtra;
	}//end getDbExtra()

	public void setDbExtra(String pdbExtra) { 
		dbExtra = pdbExtra;
	}//end setDbExtra()
	public String getKeyName() { 
		return  keyName;
	}//end getKeyName()

	public void setKeyName(String pkeyName) { 
		keyName = pkeyName;
	}//end setKeyName()
	public int getSize() { 
		return  size;
	}//end getSize()

	public void setSize(int psize) { 
		size = psize;
	}//end setSize()
	public String getAutoincrement() { 
		return  autoincrement;
	}//end getAutoincrement()

	public void setAutoincrement(String pautoincrement) { 
		autoincrement = pautoincrement;
	}//end setAutoincrement()
	public String getSigned() { 
		return  signed;
	}//end getSigned()

	public void setSigned(String psigned) { 
		signed = psigned;
	}//end setSigned()
	public String getDbPrimaryKey() { 
		return  dbPrimaryKey;
	}//end getDbPrimaryKey()

	public void setDbPrimaryKey(String pdbPrimaryKey) { 
		dbPrimaryKey = pdbPrimaryKey;
	}//end setDbPrimaryKey()
	public String getJavaDefaultDataType() { 
		return  javaDefaultDataType;
	}//end getJavaDefaultDataType()

	public void setJavaDefaultDataType(String pjavaDefaultDataType) { 
		javaDefaultDataType = pjavaDefaultDataType;
	}//end setJavaDefaultDataType()
	public int getUserForeignField() { 
		return  userForeignField;
	}//end getUserForeignField()

	public void setUserForeignField(int puserForeignField) { 
		userForeignField = puserForeignField;
	}//end setUserForeignField()
	public String getUserDefaultValue() { 
		return  userDefaultValue;
	}//end getUserDefaultValue()

	public void setUserDefaultValue(String puserDefaultValue) { 
		userDefaultValue = puserDefaultValue;
	}//end setUserDefaultValue()
	public String getUserJavaDataType() { 
		return  userJavaDataType;
	}//end getUserJavaDataType()

	public void setUserJavaDataType(String puserJavaDataType) { 
		userJavaDataType = puserJavaDataType;
	}//end setUserJavaDataType()
	public String getUserName() { 
		return  userName;
	}//end getUserName()

	public void setUserName(String puserName) { 
		userName = puserName;
	}//end setUserName()
	public String getUserForeignKey() { 
		return  userForeignKey;
	}//end getUserForeignKey()

	public void setUserForeignKey(String puserForeignKey) { 
		userForeignKey = puserForeignKey;
	}//end setUserForeignKey()
	public String getUserPrimaryKey() { 
		return  userPrimaryKey;
	}//end getUserPrimaryKey()

	public void setUserPrimaryKey(String puserPrimaryKey) { 
		userPrimaryKey = puserPrimaryKey;
	}//end setUserPrimaryKey()
	public int getTableId() { 
		return  tableId;
	}//end getTableId()

	public void setTableId(int ptableId) { 
		tableId = ptableId;
	}//end setTableId()


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