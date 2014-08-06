package ro.auto.beans;

import java.math.*;
import java.sql.Date;
import java.sql.Timestamp;


public class DisciplineprofesoriBean extends GenericBean{

    public static final String key="DisciplineprofesoriBean";

	
    private static String[] fieldsName = {"id","id_clasa","id_disciplina","id_profesor","ore"};


	public static final int id_FIELD = 0;
	public static final int id_clasa_FIELD = 1;
	public static final int id_disciplina_FIELD = 2;
	public static final int id_profesor_FIELD = 3;
	public static final int ore_FIELD = 4;

	private long id;
	private long id_clasa;
	private int id_disciplina;
	private int id_profesor;
	private long ore;

	/**
	 * Empty constructor 
	 */
	public DisciplineprofesoriBean() { 
	}//end DisciplineprofesoriBean()

	 
	public long getId() { 
		return  id;
	}//end getId()

	public void setId(long pid) { 
		id = pid;
	}//end setId()
	public long getId_clasa() { 
		return  id_clasa;
	}//end getId_clasa()

	public void setId_clasa(long pid_clasa) { 
		id_clasa = pid_clasa;
	}//end setId_clasa()
	public int getId_disciplina() { 
		return  id_disciplina;
	}//end getId_disciplina()

	public void setId_disciplina(int pid_disciplina) { 
		id_disciplina = pid_disciplina;
	}//end setId_disciplina()
	public int getId_profesor() { 
		return  id_profesor;
	}//end getId_profesor()

	public void setId_profesor(int pid_profesor) { 
		id_profesor = pid_profesor;
	}//end setId_profesor()
	public long getOre() { 
		return  ore;
	}//end getOre()

	public void setOre(long pore) { 
		ore = pore;
	}//end setOre()


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