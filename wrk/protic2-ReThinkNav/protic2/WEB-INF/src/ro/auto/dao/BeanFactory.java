package ro.auto.dao;


import ro.auto.beans.*;

/**
 * This class implements ...
 *
 * @author Giurca Daniel
 * @version 1.0, Apr 5, 2005
 */
public class BeanFactory {


    public static GenericBean getBean(int tableID){
        switch (tableID){	

            case Tables.TABLE_absente:
                 return  new AbsenteBean();
            case Tables.TABLE_anscolar:
                 return  new AnscolarBean();
            case Tables.TABLE_clasa:
                 return  new ClasaBean();
            case Tables.TABLE_diriginte:
                 return  new DiriginteBean();
            case Tables.TABLE_disciplina:
                 return  new DisciplinaBean();
            case Tables.TABLE_disciplineprofesori:
                 return  new DisciplineprofesoriBean();
            case Tables.TABLE_elev:
                 return  new ElevBean();
            case Tables.TABLE_eleviclasa:
                 return  new EleviclasaBean();
            case Tables.TABLE_elevigrupe:
                 return  new ElevigrupeBean();
            case Tables.TABLE_media:
                 return  new MediaBean();
            case Tables.TABLE_pagini:
                 return  new PaginiBean();
            case Tables.TABLE_parinte:
                 return  new ParinteBean();
            case Tables.TABLE_profesor:
                 return  new ProfesorBean();
            case Tables.TABLE_profil:
                 return  new ProfilBean();
            case Tables.TABLE_specializare:
                 return  new SpecializareBean();
            case Tables.TABLE_users:
                 return  new UsersBean();
            case Tables.TABLE_usersgrupe:
                 return  new UsersgrupeBean();

        }
        return null;
    }

    public static int getFielIndex(int tableID,String fieldName){
        switch (tableID){	
	   case Tables.TABLE_absente:
                 return  AbsenteBean.getFieldIndex(fieldName);
	   case Tables.TABLE_anscolar:
                 return  AnscolarBean.getFieldIndex(fieldName);
	   case Tables.TABLE_clasa:
                 return  ClasaBean.getFieldIndex(fieldName);
	   case Tables.TABLE_diriginte:
                 return  DiriginteBean.getFieldIndex(fieldName);
	   case Tables.TABLE_disciplina:
                 return  DisciplinaBean.getFieldIndex(fieldName);
	   case Tables.TABLE_disciplineprofesori:
                 return  DisciplineprofesoriBean.getFieldIndex(fieldName);
	   case Tables.TABLE_elev:
                 return  ElevBean.getFieldIndex(fieldName);
	   case Tables.TABLE_eleviclasa:
                 return  EleviclasaBean.getFieldIndex(fieldName);
	   case Tables.TABLE_elevigrupe:
                 return  ElevigrupeBean.getFieldIndex(fieldName);
	   case Tables.TABLE_media:
                 return  MediaBean.getFieldIndex(fieldName);
	   case Tables.TABLE_pagini:
                 return  PaginiBean.getFieldIndex(fieldName);
	   case Tables.TABLE_parinte:
                 return  ParinteBean.getFieldIndex(fieldName);
	   case Tables.TABLE_profesor:
                 return  ProfesorBean.getFieldIndex(fieldName);
	   case Tables.TABLE_profil:
                 return  ProfilBean.getFieldIndex(fieldName);
	   case Tables.TABLE_specializare:
                 return  SpecializareBean.getFieldIndex(fieldName);
	   case Tables.TABLE_users:
                 return  UsersBean.getFieldIndex(fieldName);
	   case Tables.TABLE_usersgrupe:
                 return  UsersgrupeBean.getFieldIndex(fieldName);
	}
        
        return -2;
    }
    public static int getFielsNumber(int tableID){
        switch (tableID){	
	   case Tables.TABLE_absente:
                 return  AbsenteBean.getFieldsNumber();
	   case Tables.TABLE_anscolar:
                 return  AnscolarBean.getFieldsNumber();
	   case Tables.TABLE_clasa:
                 return  ClasaBean.getFieldsNumber();
	   case Tables.TABLE_diriginte:
                 return  DiriginteBean.getFieldsNumber();
	   case Tables.TABLE_disciplina:
                 return  DisciplinaBean.getFieldsNumber();
	   case Tables.TABLE_disciplineprofesori:
                 return  DisciplineprofesoriBean.getFieldsNumber();
	   case Tables.TABLE_elev:
                 return  ElevBean.getFieldsNumber();
	   case Tables.TABLE_eleviclasa:
                 return  EleviclasaBean.getFieldsNumber();
	   case Tables.TABLE_elevigrupe:
                 return  ElevigrupeBean.getFieldsNumber();
	   case Tables.TABLE_media:
                 return  MediaBean.getFieldsNumber();
	   case Tables.TABLE_pagini:
                 return  PaginiBean.getFieldsNumber();
	   case Tables.TABLE_parinte:
                 return  ParinteBean.getFieldsNumber();
	   case Tables.TABLE_profesor:
                 return  ProfesorBean.getFieldsNumber();
	   case Tables.TABLE_profil:
                 return  ProfilBean.getFieldsNumber();
	   case Tables.TABLE_specializare:
                 return  SpecializareBean.getFieldsNumber();
	   case Tables.TABLE_users:
                 return  UsersBean.getFieldsNumber();
	   case Tables.TABLE_usersgrupe:
                 return  UsersgrupeBean.getFieldsNumber();
	}
        
        return -2;
    }
    


}

