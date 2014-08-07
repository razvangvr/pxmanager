package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class SqldataFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			SqldataBean realBean = (SqldataBean)bean;
			switch (fieldId) {
				case SqldataBean.id_FIELD:
					statement.setInt(index, realBean.getId() );
					break;
				case SqldataBean.name_FIELD:
					statement.setString(index, realBean.getName() );
					break;
				case SqldataBean.jdataid_FIELD:
					statement.setInt(index, realBean.getJdataid() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			SqldataBean realBean = (SqldataBean)bean;
			switch (fieldId) {
				case SqldataBean.id_FIELD:
					realBean.setId(result.getInt(index));
					break;
				case SqldataBean.name_FIELD:
					realBean.setName(result.getString(index));
					break;
				case SqldataBean.jdataid_FIELD:
					realBean.setJdataid(result.getInt(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			SqldataBean bean = new SqldataBean();
			int index = -1;
			if ((index = table.columnIndex( SqldataBean.id_FIELD)) != 0) {
				bean.setId(result.getInt(index));
			}
			if ((index = table.columnIndex( SqldataBean.name_FIELD)) != 0) {
				bean.setName(result.getString(index));
			}
			if ((index = table.columnIndex( SqldataBean.jdataid_FIELD)) != 0) {
				bean.setJdataid(result.getInt(index));
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
			((SqldataBean)bean).setId(result.getInt(1));
		}
	

}//end class CustomerFiller