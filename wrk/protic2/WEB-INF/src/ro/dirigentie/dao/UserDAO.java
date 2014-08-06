package ro.dirigentie.dao;

import ro.auto.beans.GenericBean;
import ro.generic.dao.GenericDAO;
import ro.db.DatabaseManager;
//import ro.sam.app.DatabaseManager;
//import ro.sam.app.LogManager;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: daniel
 * Date: Nov 5, 2005
 * Time: 6:45:30 PM
 * To change this template use Options | File Templates.
 */
public class UserDAO extends GenericDAO{
    private static List elements = null;


	private static final String INSERT_SQL = "INSERT INTO users (username, userpassword, usertype, name, address1, address2, city, country, phone, email, lastLogin, chatuserid,  id_clasa) " +
			"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String UPDATE_SQL = "UPDATE users SET username=?, userpassword=?, usertype=?, name=?, address1=?, address2=?, city=?, country=?, phone=?, email=?, lastLogin=?, chatuserid=?, id_clasa=? WHERE " +
			" username=? ";

	private static final String SELECT_SQL = "SELECT * FROM users";

    private static final String SELECT_BY_PK_SQL = "SELECT * FROM users WHERE " +
            " username=? ";
    private static final String SELECT_BY_TYPE_SQL = "SELECT * FROM users WHERE " +
            " usertype=? ";

    private static final String DELETE = "DELETE FROM users WHERE " +
            " username=? ";

    public void delete(int id) throws Exception {
        delete(id, DELETE);
    }


    private static final String SELECT_LOGIN_SQL = "SELECT * FROM users where username=? and userpassword=? ";
    private static final String COUNT_SQL = "SELECT count(*) FROM users";


    private static final String DELETE_BY_PK_SQL = "DELETE FROM users WHERE " +
            " userpassword=? ";

	public int insert(GenericBean bean) throws Exception{
		return insertParsed(bean, INSERT_SQL);
	}

	public int update(GenericBean bean) throws Exception{
		return updateParsed(bean, UPDATE_SQL);
	}

    public List getALL(){
        elements = executeQueryParsed(SELECT_SQL);
        return elements;
    }

    public List getALL(String whereAddon, Object[] params){
        String theSql = SELECT_SQL;
        if (whereAddon.length() > 0)
            theSql+=whereAddon;
        return executeQueryParsed(theSql,params);
    }


    public long getCount(){
        return getCount(COUNT_SQL);
    }

    public List getByPK(Object[] parameters){
        return executeQueryParsed(SELECT_BY_PK_SQL,parameters);
    }

    public List getByType(String type){
        Object[] o = new Object[1];
        o[0] = type;

        return executeQueryParsed(SELECT_BY_TYPE_SQL,o);
    }

	protected void fillInsertStatment(GenericBean bean, PreparedStatement stat) throws SQLException {
	}

	protected void fillUpdateStatment(GenericBean bean, PreparedStatement stat) throws SQLException {
	}

	protected GenericBean fillBean(ResultSet result) throws SQLException {
		return null;
	}

	protected String getINSERT_SQL() {
		return null;
	}

	protected String getUPDATE_SQL() {
		return null;
	}


    public List loginCheck(String u, String p){
        Object[] o = new Object[2];
        o[0] = u;
        o[1] = p;
        List l = executeQueryParsed(SELECT_LOGIN_SQL, o);

        return l;
    }

    public int deleteUser(String user) throws Exception {

        Connection con = null;
        PreparedStatement pstat = null;
        int SQL_ERR = -1;
        int value = SQL_ERR;
        try {
            con = DatabaseManager.getConnection();

            pstat = con.prepareStatement(DELETE);
            pstat.setString(1, user);
            value = pstat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            if (e.toString().indexOf("Delete exception") != -1) {
                value = -2;
            } else {
                throw e;
            }
            System.out.println(e.toString() + DELETE);
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
}
