package ro.auto.dao.fill;

import ro.auto.dao.Tables;
import ro.auto.dao.fill.filler.*;
import ro.generic.dao.filler.StatmentResultSetFill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;


/**
 * This class implements ...
 *
 * @author Giurca Daniel
 * @version 1.0, Apr 5, 2005
 */
public class FillFactory {


    public static StatmentResultSetFill getFiller(int tableId){
        switch (tableId){	

            case Tables.TABLE_absente:
                 return  new AbsenteFiller();
            case Tables.TABLE_anscolar:
                 return  new AnscolarFiller();
            case Tables.TABLE_clasa:
                 return  new ClasaFiller();
            case Tables.TABLE_diriginte:
                 return  new DiriginteFiller();
            case Tables.TABLE_disciplina:
                 return  new DisciplinaFiller();
            case Tables.TABLE_disciplineprofesori:
                 return  new DisciplineprofesoriFiller();
            case Tables.TABLE_elev:
                 return  new ElevFiller();
            case Tables.TABLE_eleviclasa:
                 return  new EleviclasaFiller();
            case Tables.TABLE_elevigrupe:
                 return  new ElevigrupeFiller();
            case Tables.TABLE_media:
                 return  new MediaFiller();
            case Tables.TABLE_pagini:
                 return  new PaginiFiller();
            case Tables.TABLE_parinte:
                 return  new ParinteFiller();
            case Tables.TABLE_profesor:
                 return  new ProfesorFiller();
            case Tables.TABLE_profil:
                 return  new ProfilFiller();
            case Tables.TABLE_specializare:
                 return  new SpecializareFiller();
            case Tables.TABLE_users:
                 return  new UsersFiller();
            case Tables.TABLE_usersgrupe:
                 return  new UsersgrupeFiller();

        }
        return null;
    }


}

