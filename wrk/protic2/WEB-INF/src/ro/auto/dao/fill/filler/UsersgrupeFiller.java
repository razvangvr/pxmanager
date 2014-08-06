package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class UsersgrupeFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			UsersgrupeBean realBean = (UsersgrupeBean)bean;
			switch (fieldId) {
				case UsersgrupeBean.id_FIELD:
					statement.setLong(index, realBean.getId() );
					break;
				case UsersgrupeBean.username_FIELD:
					statement.setString(index, realBean.getUsername() );
					break;
				case UsersgrupeBean.id_disciplineprofesori_FIELD:
					statement.setInt(index, realBean.getId_disciplineprofesori() );
					break;
				case UsersgrupeBean.grupa_FIELD:
					statement.setInt(index, realBean.getGrupa() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			UsersgrupeBean realBean = (UsersgrupeBean)bean;
			switch (fieldId) {
				case UsersgrupeBean.id_FIELD:
					realBean.setId(result.getLong(index));
					break;
				case UsersgrupeBean.username_FIELD:
					realBean.setUsername(result.getString(index));
					break;
				case UsersgrupeBean.id_disciplineprofesori_FIELD:
					realBean.setId_disciplineprofesori(result.getInt(index));
					break;
				case UsersgrupeBean.grupa_FIELD:
					realBean.setGrupa(result.getInt(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			UsersgrupeBean bean = new UsersgrupeBean();
			int index = -1;
			if ((index = table.columnIndex( UsersgrupeBean.id_FIELD)) != 0) {
				bean.setId(result.getLong(index));
			}
			if ((index = table.columnIndex( UsersgrupeBean.username_FIELD)) != 0) {
				bean.setUsername(result.getString(index));
			}
			if ((index = table.columnIndex( UsersgrupeBean.id_disciplineprofesori_FIELD)) != 0) {
				bean.setId_disciplineprofesori(result.getInt(index));
			}
			if ((index = table.columnIndex( UsersgrupeBean.grupa_FIELD)) != 0) {
				bean.setGrupa(result.getInt(index));
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
			((UsersgrupeBean)bean).setId(result.getLong(1));
		}
	

}//end class CustomerFiller