package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class JdataFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			JdataBean realBean = (JdataBean)bean;
			switch (fieldId) {
				case JdataBean.id_FIELD:
					statement.setInt(index, realBean.getId() );
					break;
				case JdataBean.name_FIELD:
					statement.setString(index, realBean.getName() );
					break;
				case JdataBean.rsstring_FIELD:
					statement.setString(index, realBean.getRsstring() );
					break;
				case JdataBean.stmtstring_FIELD:
					statement.setString(index, realBean.getStmtstring() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			JdataBean realBean = (JdataBean)bean;
			switch (fieldId) {
				case JdataBean.id_FIELD:
					realBean.setId(result.getInt(index));
					break;
				case JdataBean.name_FIELD:
					realBean.setName(result.getString(index));
					break;
				case JdataBean.rsstring_FIELD:
					realBean.setRsstring(result.getString(index));
					break;
				case JdataBean.stmtstring_FIELD:
					realBean.setStmtstring(result.getString(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			JdataBean bean = new JdataBean();
			int index = -1;
			if ((index = table.columnIndex( JdataBean.id_FIELD)) != 0) {
				bean.setId(result.getInt(index));
			}
			if ((index = table.columnIndex( JdataBean.name_FIELD)) != 0) {
				bean.setName(result.getString(index));
			}
			if ((index = table.columnIndex( JdataBean.rsstring_FIELD)) != 0) {
				bean.setRsstring(result.getString(index));
			}
			if ((index = table.columnIndex( JdataBean.stmtstring_FIELD)) != 0) {
				bean.setStmtstring(result.getString(index));
			}
			return bean;
		}
*/
		/**
		 * Set the generated keys form the resoult set to the specified bean
		 *
		 * @param result result set to populate keys
		 * @param bean   to be populated
		 * @throws java.sql.SQLException
		 */
		public void fillKeys (ResultSet result, GenericBean bean) throws SQLException {
			((JdataBean)bean).setId(result.getInt(1));
		}
	

}//end class CustomerFiller