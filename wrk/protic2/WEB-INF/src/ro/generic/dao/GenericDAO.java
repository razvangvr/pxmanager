package ro.generic.dao;

import ro.db.DatabaseManager;
import ro.generic.parser.UpdateSqlParser;
import ro.generic.parser.InsertSqlParser;
import ro.generic.parser.SelectSqlParser;
import ro.generic.parser.FillBeans;
import ro.generic.parser.objects.ParsedSql;
import ro.generic.parser.objects.SqlTable;
import ro.generic.parser.objects.SqlField;
import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.dao.fill.FillFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: daniel
 * Date: Nov 5, 2005
 * Time: 6:54:48 PM
 * To change this template use Options | File Templates.
 */

public abstract class GenericDAO {

    protected static final int SQL_ERR = -1;
    private PreparedStatement insertStatement = null;
    public abstract int insert(ro.auto.beans.GenericBean bean) throws Exception;
    public abstract int update(ro.auto.beans.GenericBean bean) throws Exception;

//    public abstract int update(String sql) throws Exception;

    public int update(String sql) throws Exception{

        Connection con = null;
        PreparedStatement pstat = null;

        int value = SQL_ERR;
        try {
            con = DatabaseManager.getConnection();
            pstat = con.prepareStatement(sql);
            value = pstat.executeUpdate();

//	        if (LogManager.isDebugEnabled())
//	        LogManager.debug(this.getClass().getName() + "[update]->" +fill);
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        } finally {
            try {
                if (pstat != null) pstat.close();
            } catch (SQLException sqle1) {
            }
            try {
                if (con != null) con.close();
            } catch (SQLException sqle1) {
            }
        }
        return value;
    }

    public static long getCount(String sql){
        long returnValue = 0;

        Connection con = null;
        PreparedStatement pstat = null;

        try {
            con = DatabaseManager.getConnection();

            pstat = con.prepareStatement(sql);
            ResultSet r = pstat.executeQuery();
            if (r.next()){
                returnValue = r.getLong(1);
            }

                System.out.println("[DAO]->"  + sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstat != null) pstat.close();
            } catch (SQLException sqle1) {
            }
            try {
                if (con != null) con.close();
            } catch (SQLException sqle1) {
            }
        }
        return returnValue;
    }


//    protected abstract ro.auto.beans.GenericBean fillBean(ResultSet result) throws SQLException;
    protected abstract String getINSERT_SQL();
    protected abstract String getUPDATE_SQL();

////// /////////////////////////////////////                             PARSED
    public int updateParsed(ro.auto.beans.GenericBean bean,String sql) throws Exception{

        Connection con = null;
        PreparedStatement pstat = null;
        int SQL_ERR = -1;
        int value = SQL_ERR;
        try {
            con = DatabaseManager.getConnection();
            pstat = con.prepareStatement(sql);

            UpdateSqlParser updateSqlParser = new UpdateSqlParser();
            ParsedSql psql = updateSqlParser.parse(sql);

            StatmentResultSetFill statmentResultSetFill = null;
            if (psql.getFields()!=null){
                SqlTable sqlTable = (SqlTable) psql.getTables().get(0);
                statmentResultSetFill = FillFactory.getFiller(sqlTable.getTableId());
                for (int i = 0; i < psql.getFields().size(); i++) {
                    SqlField sqlField = (SqlField) psql.getFields().get(i);
                    statmentResultSetFill.fillStatement(pstat,i+1,bean,sqlField.getFieldIndex());
                }
            }

            value = pstat.executeUpdate();

//	        if (LogManager.isDebugEnabled())
//	        LogManager.debug(this.getClass().getName() + "[update]->" +fill);
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        } finally {
            try {
                if (pstat != null) pstat.close();
            } catch (SQLException sqle1) {
            }
            try {
                if (con != null) con.close();
            } catch (SQLException sqle1) {
            }
        }
        return value;
    }

    public int updateParsed(String sql,ro.auto.beans.GenericBean bean,Object[] params) throws Exception{

        Connection con = null;
        PreparedStatement pstat = null;
        int SQL_ERR = -1;
        int value = SQL_ERR;
        try {
            con = DatabaseManager.getConnection();
            pstat = con.prepareStatement(sql);

            UpdateSqlParser updateSqlParser = new UpdateSqlParser();
            ParsedSql psql = updateSqlParser.parse(sql);

            StatmentResultSetFill statmentResultSetFill = null;
            if (psql.getFields()!=null){
                SqlTable sqlTable = (SqlTable) psql.getTables().get(0);
                statmentResultSetFill = FillFactory.getFiller(sqlTable.getTableId());
                int parametersLength = params!=null?params.length:0;
                for (int i = 0; i < psql.getNoOfParameters() ; i++) {
                    if (psql.getNoOfParameters() - i >  parametersLength) {
                        SqlField sqlField = (SqlField) psql.getFields().get(i);
                        statmentResultSetFill.fillStatement(pstat,i+1,bean,sqlField.getFieldIndex());
                    } else {
                        int index = i - (psql.getNoOfParameters() - parametersLength);
                        System.out.println("index=" + index);
                        pstat.setObject(i+1,params[index]);
                    }
                }
            }
            value = pstat.executeUpdate();
//	        if (LogManager.isDebugEnabled())
//	        LogManager.debug(this.getClass().getName() + "[update]->" +fill);
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        } finally {
            try {
                if (pstat != null) pstat.close();
            } catch (SQLException sqle1) {
            }
            try {
                if (con != null) con.close();
            } catch (SQLException sqle1) {
            }
        }
        return value;
    }

    public int insertParsed(ro.auto.beans.GenericBean bean , String sql) throws Exception{

        Connection con = null;
        PreparedStatement pstat = null;
        int SQL_ERR = -1;
        int value = SQL_ERR;
        try {
            con = DatabaseManager.getConnection();

            pstat = con.prepareStatement(sql);
            StatmentResultSetFill statmentResultSetFill= null;
            InsertSqlParser insertSqlParser = new InsertSqlParser();
            ParsedSql psql = insertSqlParser.parse(sql);
            System.out.println("s               1");
            if (psql.getFields()!=null){
                System.out.println("s               2");
                SqlTable sqlTable = (SqlTable) psql.getTables().get(0);
                statmentResultSetFill = FillFactory.getFiller(sqlTable.getTableId());
                for (int i = 0; i < psql.getFields().size(); i++) {
                    SqlField sqlField = (SqlField) psql.getFields().get(i);
                    System.out.println("settttttting field "+ sqlField.getFieldName() +" from taaaable "+ sqlTable.getTableName());
                    statmentResultSetFill.fillStatement(pstat,i+1,bean,sqlField.getFieldIndex());
                }
            }
           System.out.println("s               3");


//            fillInsertStatment(bean,pstat);
            value = pstat.executeUpdate();
//            if (LogManager.isDebugEnabled())
//            LogManager.debug(this.getClass().getName() + "[insert]->" + bean.toString());
            ResultSet result = pstat.getGeneratedKeys();
            if (result.next()) {
                statmentResultSetFill.fillKeys(result,bean);
//                  System.out.println("-->>>"  + result.getObject(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
            if (e.toString().indexOf("Duplicate entry") != -1) {
                value = -2;
            } else {
                throw e;
            }
            System.out.println(e.toString() + sql);
        } finally {
            try {
                if (pstat != null) pstat.close();
            } catch (SQLException sqle1) {
            }
            try {
                if (con != null) con.close();
            } catch (SQLException sqle1) {
            }
        }
        return value;
    }

    public int delete(long id , String sql) throws Exception{

        Connection con = null;
        PreparedStatement pstat = null;
        int SQL_ERR = -1;
        int value = SQL_ERR;
        try {
            con = DatabaseManager.getConnection();

            pstat = con.prepareStatement(sql);
            pstat.setLong(1, id);
            value = pstat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            if (e.toString().indexOf("Delete exception") != -1) {
                value = -2;
            } else {
                throw e;
            }
            System.out.println(e.toString() + sql);
        } finally {
            try {
                if (pstat != null) pstat.close();
            } catch (SQLException sqle1) {
            }
            try {
                if (con != null) con.close();
            } catch (SQLException sqle1) {
            }
        }
        return value;
    }


    public List executeQueryParsed(String sql){
        return executeQueryParsed(sql,null);
//        ArrayList returnArray = new ArrayList();
//
//        Connection con = null;
//        PreparedStatement pstat = null;
//
//        try {
//            con = DatabaseManager.getConnection();
//            pstat = con.prepareStatement(fill);
////             Integer prCode = new Integer(10);
////             pstat.setObject(1,(Object) prCode);
//            ResultSet r = pstat.executeQuery();
//            SelectSqlParser selectParser = new SelectSqlParser();
//            ParsedSql psql = selectParser.parse(fill);
//            FillBeans fbeans = new FillBeans();
//
//            while (r.next()){
//                try{
//                    returnArray.add(fbeans.fillBean(r,psql));
//                }catch(Exception e){
//                    e.printStackTrace();
//                    LogManager.error(e.getMessage());}
//            }
//            if (LogManager.isDebugEnabled())
//                LogManager.debug("[DAO]->"  + fill );
//        } catch (Exception e) {
//            LogManager.error(e.toString());
//        } finally {
//            try {
//                if (pstat != null) pstat.close();
//            } catch (SQLException sqle1) {
//            }
//            try {
//                if (con != null) con.close();
//            } catch (SQLException sqle1) {
//            }
//        }
//        return returnArray;
    }

    public List executeQueryParsed(String sql, Object[] params) {

        System.out.println("################ [DAO]->"  + sql );
        ArrayList returnArray = new ArrayList();

        Connection con = null;
        PreparedStatement pstat = null;

        try {
            con = DatabaseManager.getConnection();
            pstat = con.prepareStatement(sql);
            if (params!=null)
                for (int i = 0; i < params.length; i++) {
                    pstat.setObject(i+1,params[i]);
                }

            ResultSet r = pstat.executeQuery();
            SelectSqlParser selectParser = new SelectSqlParser();
            ParsedSql psql = selectParser.parse(sql);
            FillBeans fbeans = new FillBeans();

            while (r.next()){
                try {
                    returnArray.add(fbeans.fillBean(r,psql));
                } catch(Exception e){
                    e.printStackTrace();
                    System.out.println(e.getMessage());}
            }

                System.out.println("[DAO]->"  + sql );
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        } finally {
            try {
                if (pstat != null) pstat.close();
            } catch (SQLException sqle1) {
                sqle1.printStackTrace();

            }
            try {
                if (con != null) con.close();
            } catch (SQLException sqle1) {
                sqle1.printStackTrace();
            }
        }

        return returnArray;

    }



}

