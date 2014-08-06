package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class AuthorsFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			AuthorsBean realBean = (AuthorsBean)bean;
			switch (fieldId) {
				case AuthorsBean.id_FIELD:
					statement.setInt(index, realBean.getId() );
					break;
				case AuthorsBean.name_FIELD:
					statement.setString(index, realBean.getName() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			AuthorsBean realBean = (AuthorsBean)bean;
			switch (fieldId) {
				case AuthorsBean.id_FIELD:
					realBean.setId(result.getInt(index));
					break;
				case AuthorsBean.name_FIELD:
					realBean.setName(result.getString(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			AuthorsBean bean = new AuthorsBean();
			int index = -1;
			if ((index = table.columnIndex( AuthorsBean.id_FIELD)) != 0) {
				bean.setId(result.getInt(index));
			}
			if ((index = table.columnIndex( AuthorsBean.name_FIELD)) != 0) {
				bean.setName(result.getString(index));
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
			((AuthorsBean)bean).setId(result.getInt(1));
		}
	

}//end class CustomerFiller