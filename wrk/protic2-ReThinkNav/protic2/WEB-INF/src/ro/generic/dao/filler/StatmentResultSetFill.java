package ro.generic.dao.filler;

import ro.auto.beans.GenericBean;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * This class implements ...
 *
 * @version 1.0, Apr 5, 2005
 */
public interface StatmentResultSetFill {

    public void fillStatement (PreparedStatement statement, int index, ro.auto.beans.GenericBean bean, int fieldId) throws SQLException;
    public void fillBean (ro.auto.beans.GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException;

    public void fillKeys (ResultSet result, ro.auto.beans.GenericBean bean) throws SQLException;

}
