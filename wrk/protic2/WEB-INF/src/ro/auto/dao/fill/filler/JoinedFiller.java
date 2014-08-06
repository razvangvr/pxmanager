package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class JoinedFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			JoinedBean realBean = (JoinedBean)bean;
			switch (fieldId) {
				case JoinedBean.id_FIELD:
					statement.setInt(index, realBean.getId() );
					break;
				case JoinedBean.tableId_FIELD:
					statement.setInt(index, realBean.getTableId() );
					break;
				case JoinedBean.joinId_FIELD:
					statement.setInt(index, realBean.getJoinId() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			JoinedBean realBean = (JoinedBean)bean;
			switch (fieldId) {
				case JoinedBean.id_FIELD:
					realBean.setId(result.getInt(index));
					break;
				case JoinedBean.tableId_FIELD:
					realBean.setTableId(result.getInt(index));
					break;
				case JoinedBean.joinId_FIELD:
					realBean.setJoinId(result.getInt(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			JoinedBean bean = new JoinedBean();
			int index = -1;
			if ((index = table.columnIndex( JoinedBean.id_FIELD)) != 0) {
				bean.setId(result.getInt(index));
			}
			if ((index = table.columnIndex( JoinedBean.tableId_FIELD)) != 0) {
				bean.setTableId(result.getInt(index));
			}
			if ((index = table.columnIndex( JoinedBean.joinId_FIELD)) != 0) {
				bean.setJoinId(result.getInt(index));
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
			((JoinedBean)bean).setId(result.getInt(1));
		}
	

}//end class CustomerFiller