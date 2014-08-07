package ro.dirigentie.dao;

import ro.generic.dao.GenericDAO;
import ro.auto.beans.GenericBean;
import ro.db.DatabaseManager;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;

/**
 * Created by IntelliJ IDEA.
 * User: Scoala
 * Date: 20.07.2008
 * Time: 08:59:25
 * To change this template use Options | File Templates.
 */
  public class PaginiDAO extends GenericDAO{
    private static List elements = null;

   	private static final String INSERT_SQL = "INSERT INTO pagini ( id, continut, grupa, id_disciplineprofesori) " +
			"VALUES ( ?,?,?,?)";

	private static final String UPDATE_SQL = "UPDATE pagini SET  continut=?, id_disciplineprofesori=?, grupa=? WHERE " +
			" id=? ";

	private static final String SELECT_SQL = "SELECT * FROM pagini";

	private static final String SELECT_BY_PK_SQL = "SELECT * FROM pagini WHERE " +
			" id=? ";
    private static final String SELECT_BY_AN_SQL = "SELECT * FROM pagini, clasa WHERE " +
			" id_an=? and id_disciplineprofesori=clasa.id";

    private static final String SELECT_BY_GRUPA_DISCPROF_SQL = "SELECT * FROM pagini WHERE " +
			" grupa=? and id_disciplineprofesori=?";

    private static final String DELETE = "DELETE FROM pagini WHERE " +
            " id=? ";
//    int[] a = new int[23];


   /* private static final String SELECT_LOGIN_SQL = "SELECT * FROM elev where username=? and userpassword=? ";  */

    private static final String COUNT_SQL = "SELECT count(*) FROM pagini";


    private static final String DELETE_BY_PK_SQL = "DELETE FROM pagini WHERE " +
            " id=? ";

    public void delete(long id) throws Exception {
        delete(id, DELETE);
    }

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

    public List getByAn(String idan){
        Object [] s = new Object[1];
        s[0] = idan;
        return executeQueryParsed(SELECT_BY_AN_SQL,s);
    }
    public List getByGrupa(String grupa, String idDiscProf){
        Object [] s = new Object[2];
        s[0] = grupa;
        s[1] = idDiscProf;
        return executeQueryParsed(SELECT_BY_GRUPA_DISCPROF_SQL,s);
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


   /* public List loginCheck(String u, String p){
        Object[] o = new Object[2];
        o[0] = u;
        o[1] = p;
        List l = executeQueryParsed(SELECT_LOGIN_SQL, o);

        return l;
    }
    */
  /*  public int deleteUser(String user) throws Exception {

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
*/
}
