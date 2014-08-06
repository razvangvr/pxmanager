package ro.dirigentie.dao;

import ro.generic.dao.GenericDAO;
import ro.auto.beans.GenericBean;
import ro.auto.beans.EleviclasaBean;
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
  public class EleviclaseDAO extends GenericDAO{
    private static List elements = null;

   	private static final String INSERT_SQL = "INSERT INTO eleviclasa ( id, id_clasa, id_elev) " +
			"VALUES ( ?, ?, ?)";

	private static final String UPDATE_SQL = "UPDATE eleviclasa SET  id=?, id_clasa=?, id_elev=? WHERE " +
			" id=? ";

	private static final String SELECT_SQL = "SELECT * FROM eleviclasa";

	private static final String SELECT_BY_PK_SQL = "SELECT * FROM eleviclasa WHERE " +
			" id=? ";

    private static final String DELETE = "DELETE FROM eleviclasa WHERE " +
            " id=? ";

    private static final String SELECT_BY_CLASA_PK_SQL = "SELECT * FROM eleviclasa WHERE " +
            " id_clasa=? ";
    private static final String DELETE_BY_CLASA_PK_SQL = "DELETE FROM eleviclasa WHERE " +
            " id_clasa=? ";
    private static final String SELECT_BY_ELEV_AND_AN_SQL = "SELECT * FROM eleviclasa, clasa WHERE " +
            " id_elev=? and eleviclasa.id_clasa=clasa.id and id_an=?";

    private static final String SELECT_BY_AN_SQL = "SELECT * FROM eleviclasa, clasa WHERE " +
            " id_an=? and eleviclasa.id_clasa=clasa.id ";

//    int[] a = new int[23];


   /* private static final String SELECT_LOGIN_SQL = "SELECT * FROM elev where username=? and userpassword=? ";  */

    private static final String COUNT_SQL = "SELECT count(*) FROM eleviclasa";


    private static final String DELETE_BY_PK_SQL = "DELETE FROM eleviclasa WHERE " +
            " id=? ";


    public List getByClasa(String id){
        Object [] s = new Object[1];
        s[0] = id;
        return executeQueryParsed(SELECT_BY_CLASA_PK_SQL,s);
    }


    public int deleteAllClasa(String id) throws Exception {
//        EleviclasaBean eb = new EleviclasaBean();
//        eb.setId(new Integer(id).intValue());
//        return updateParsed(eb, DELETE_BY_CLASA_PK_SQL);
          return delete(new Integer(id).intValue(), DELETE_BY_CLASA_PK_SQL);
    }

    public List getByElevAn(String ide, String idan){
       Object [] s = new Object[2];
        s[0] = ide;
        s[1] = idan;
       return executeQueryParsed(SELECT_BY_ELEV_AND_AN_SQL,s);
   }

    public List getByAn( String idan){
       Object [] s = new Object[1];
        s[0] = idan;
       return executeQueryParsed(SELECT_BY_AN_SQL,s);
   }

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
