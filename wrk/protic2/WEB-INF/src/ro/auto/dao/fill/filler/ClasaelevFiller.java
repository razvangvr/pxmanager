package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ClasaelevFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			ClasaelevBean realBean = (ClasaelevBean)bean;
			switch (fieldId) {
				case ClasaelevBean.Id_FIELD:
					statement.setInt(index, realBean.getId() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			ClasaelevBean realBean = (ClasaelevBean)bean;
			switch (fieldId) {
				case ClasaelevBean.Id_FIELD:
					realBean.setId(result.getInt(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			ClasaelevBean bean = new ClasaelevBean();
			int index = -1;
			if ((index = table.columnIndex( ClasaelevBean.Id_FIELD)) != 0) {
				bean.setId(result.getInt(index));
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
			((ClasaelevBean)bean).setId(result.getInt(1));
		}
	

}//end class CustomerFiller