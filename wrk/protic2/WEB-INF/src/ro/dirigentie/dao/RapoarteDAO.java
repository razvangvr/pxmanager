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
  public class RapoarteDAO extends GenericDAO{
    private static List elements = null;


    private static final String SELECT_MEDII_BY_ELEV_SQL = "SELECT * FROM media WHERE " +
            " id_elev=? and semestru=? and id_an=? ";

    private static final String SELECT_ABSENTE_BY_ELEV_SQL = "SELECT * FROM absente WHERE " +
            " id_elev=? and semestru=? and id_an=?";


    private static final String DELETE = "DELETE FROM eleviclasa WHERE " +
            " eleviclasa.id_clasa=? and ";

    private static final String SELECT_MEDIA_BY_CLASA_SQL = "SELECT * FROM eleviclasa, medii WHERE " +
            " media.id_elev=eleviclasa.idelev and id_clasa=? and semestru=? and media>=? and media<? ";
    private static final String DELETE_BY_CLASA_PK_SQL = "DELETE FROM eleviclasa WHERE " +
            " id_clasa=? ";
    private static final String SELECT_BY_ELEV_AND_AN_SQL = "SELECT * FROM eleviclasa, clasa WHERE " +
            " id_elev=? and eleviclasa.id_clasa=clasa.id and id_an=?";
//    int[] a = new int[23];

   	private static final String INSERT_SQL = "INSERT INTO eleviclasa ( id, id_clasa, id_elev) " +
			"VALUES ( ?, ?, ?)";

	private static final String UPDATE_SQL = "UPDATE eleviclasa SET  id=?, id_clasa=?, id_elev=? WHERE " +
			" id=? ";

	private static final String SELECT_SQL = "SELECT * FROM eleviclasa";
   /* private static final String SELECT_LOGIN_SQL = "SELECT * FROM elev where username=? and userpassword=? ";  */

    private static final String COUNT_SQL = "SELECT count(*) FROM eleviclasa";


    private static final String DELETE_BY_PK_SQL = "DELETE FROM eleviclasa WHERE " +
            " id=? ";


    public List getMedii(String idel, String sem, String idan){
        Object [] s = new Object[3];
        s[0] = idel;
        s[1] = sem;
        s[2] = idan;
        return executeQueryParsed(SELECT_MEDII_BY_ELEV_SQL, s);
    }

    public List getAbsente(String idel, String sem, String idan){
        Object [] s = new Object[3];
        s[0] = idel;
        s[1] = sem;
        s[2] = idan;
        return executeQueryParsed(SELECT_ABSENTE_BY_ELEV_SQL, s);
    }


    public List getMediiDisc(String idel, String sem, String idan, String iddisc){
        Object [] s = new Object[4];
            s[0] = idel;
            s[1] = sem;
            s[2] = idan;
            s[3] = iddisc;
        return executeQueryParsed(SELECT_MEDII_BY_ELEV_SQL,s);
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
