package ro.auto.dao;



public class Tables {

	
    private static String[] tablesNames = {"absente","anscolar","clasa","diriginte","disciplina","disciplineprofesori","elev","eleviclasa","elevigrupe","media","pagini","parinte","profesor","profil","specializare","users","usersgrupe"};

   public static final int TABLE_absente = 0;
   public static final int TABLE_anscolar = 1;
   public static final int TABLE_clasa = 2;
   public static final int TABLE_diriginte = 3;
   public static final int TABLE_disciplina = 4;
   public static final int TABLE_disciplineprofesori = 5;
   public static final int TABLE_elev = 6;
   public static final int TABLE_eleviclasa = 7;
   public static final int TABLE_elevigrupe = 8;
   public static final int TABLE_media = 9;
   public static final int TABLE_pagini = 10;
   public static final int TABLE_parinte = 11;
   public static final int TABLE_profesor = 12;
   public static final int TABLE_profil = 13;
   public static final int TABLE_specializare = 14;
   public static final int TABLE_users = 15;
   public static final int TABLE_usersgrupe = 16;

  	public static int getTableIndex(String name){
		if (tablesNames!=null)
		for (int i = 0; i < tablesNames.length; i++) {
			if (tablesNames[i].equalsIgnoreCase(name)) return i;
		}
		return -1;
	}
}
