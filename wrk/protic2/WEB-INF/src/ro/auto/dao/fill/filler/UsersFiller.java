package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class UsersFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			UsersBean realBean = (UsersBean)bean;
			switch (fieldId) {
				case UsersBean.username_FIELD:
					statement.setString(index, realBean.getUsername() );
					break;
				case UsersBean.userpassword_FIELD:
					statement.setString(index, realBean.getUserpassword() );
					break;
				case UsersBean.usertype_FIELD:
					statement.setString(index, realBean.getUsertype() );
					break;
				case UsersBean.name_FIELD:
					statement.setString(index, realBean.getName() );
					break;
				case UsersBean.address1_FIELD:
					statement.setString(index, realBean.getAddress1() );
					break;
				case UsersBean.address2_FIELD:
					statement.setString(index, realBean.getAddress2() );
					break;
				case UsersBean.city_FIELD:
					statement.setString(index, realBean.getCity() );
					break;
				case UsersBean.country_FIELD:
					statement.setString(index, realBean.getCountry() );
					break;
				case UsersBean.phone_FIELD:
					statement.setString(index, realBean.getPhone() );
					break;
				case UsersBean.email_FIELD:
					statement.setString(index, realBean.getEmail() );
					break;
				case UsersBean.lastLogin_FIELD:
					statement.setTimestamp(index, realBean.getLastLogin() );
					break;
				case UsersBean.chatuserid_FIELD:
					statement.setInt(index, realBean.getChatuserid() );
					break;
				case UsersBean.id_clasa_FIELD:
					statement.setLong(index, realBean.getId_clasa() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			UsersBean realBean = (UsersBean)bean;
			switch (fieldId) {
				case UsersBean.username_FIELD:
					realBean.setUsername(result.getString(index));
					break;
				case UsersBean.userpassword_FIELD:
					realBean.setUserpassword(result.getString(index));
					break;
				case UsersBean.usertype_FIELD:
					realBean.setUsertype(result.getString(index));
					break;
				case UsersBean.name_FIELD:
					realBean.setName(result.getString(index));
					break;
				case UsersBean.address1_FIELD:
					realBean.setAddress1(result.getString(index));
					break;
				case UsersBean.address2_FIELD:
					realBean.setAddress2(result.getString(index));
					break;
				case UsersBean.city_FIELD:
					realBean.setCity(result.getString(index));
					break;
				case UsersBean.country_FIELD:
					realBean.setCountry(result.getString(index));
					break;
				case UsersBean.phone_FIELD:
					realBean.setPhone(result.getString(index));
					break;
				case UsersBean.email_FIELD:
					realBean.setEmail(result.getString(index));
					break;
				case UsersBean.lastLogin_FIELD:
					realBean.setLastLogin(result.getTimestamp(index));
					break;
				case UsersBean.chatuserid_FIELD:
					realBean.setChatuserid(result.getInt(index));
					break;
				case UsersBean.id_clasa_FIELD:
					realBean.setId_clasa(result.getLong(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			UsersBean bean = new UsersBean();
			int index = -1;
			if ((index = table.columnIndex( UsersBean.username_FIELD)) != 0) {
				bean.setUsername(result.getString(index));
			}
			if ((index = table.columnIndex( UsersBean.userpassword_FIELD)) != 0) {
				bean.setUserpassword(result.getString(index));
			}
			if ((index = table.columnIndex( UsersBean.usertype_FIELD)) != 0) {
				bean.setUsertype(result.getString(index));
			}
			if ((index = table.columnIndex( UsersBean.name_FIELD)) != 0) {
				bean.setName(result.getString(index));
			}
			if ((index = table.columnIndex( UsersBean.address1_FIELD)) != 0) {
				bean.setAddress1(result.getString(index));
			}
			if ((index = table.columnIndex( UsersBean.address2_FIELD)) != 0) {
				bean.setAddress2(result.getString(index));
			}
			if ((index = table.columnIndex( UsersBean.city_FIELD)) != 0) {
				bean.setCity(result.getString(index));
			}
			if ((index = table.columnIndex( UsersBean.country_FIELD)) != 0) {
				bean.setCountry(result.getString(index));
			}
			if ((index = table.columnIndex( UsersBean.phone_FIELD)) != 0) {
				bean.setPhone(result.getString(index));
			}
			if ((index = table.columnIndex( UsersBean.email_FIELD)) != 0) {
				bean.setEmail(result.getString(index));
			}
			if ((index = table.columnIndex( UsersBean.lastLogin_FIELD)) != 0) {
				bean.setLastLogin(result.getTimestamp(index));
			}
			if ((index = table.columnIndex( UsersBean.chatuserid_FIELD)) != 0) {
				bean.setChatuserid(result.getInt(index));
			}
			if ((index = table.columnIndex( UsersBean.id_clasa_FIELD)) != 0) {
				bean.setId_clasa(result.getLong(index));
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
			((UsersBean)bean).setUsername(result.getString(1));
		}
	

}//end class CustomerFiller