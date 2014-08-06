package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class UfieldFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			UfieldBean realBean = (UfieldBean)bean;
			switch (fieldId) {
				case UfieldBean.id_FIELD:
					statement.setInt(index, realBean.getId() );
					break;
				case UfieldBean.name_FIELD:
					statement.setString(index, realBean.getName() );
					break;
				case UfieldBean.dbDataType_FIELD:
					statement.setString(index, realBean.getDbDataType() );
					break;
				case UfieldBean.dbNull_FIELD:
					statement.setString(index, realBean.getDbNull() );
					break;
				case UfieldBean.dbDefault_FIELD:
					statement.setString(index, realBean.getDbDefault() );
					break;
				case UfieldBean.dbExtra_FIELD:
					statement.setString(index, realBean.getDbExtra() );
					break;
				case UfieldBean.keyName_FIELD:
					statement.setString(index, realBean.getKeyName() );
					break;
				case UfieldBean.size_FIELD:
					statement.setInt(index, realBean.getSize() );
					break;
				case UfieldBean.autoincrement_FIELD:
					statement.setString(index, realBean.getAutoincrement() );
					break;
				case UfieldBean.signed_FIELD:
					statement.setString(index, realBean.getSigned() );
					break;
				case UfieldBean.dbPrimaryKey_FIELD:
					statement.setString(index, realBean.getDbPrimaryKey() );
					break;
				case UfieldBean.javaDefaultDataType_FIELD:
					statement.setString(index, realBean.getJavaDefaultDataType() );
					break;
				case UfieldBean.userForeignField_FIELD:
					statement.setInt(index, realBean.getUserForeignField() );
					break;
				case UfieldBean.userDefaultValue_FIELD:
					statement.setString(index, realBean.getUserDefaultValue() );
					break;
				case UfieldBean.userJavaDataType_FIELD:
					statement.setString(index, realBean.getUserJavaDataType() );
					break;
				case UfieldBean.userName_FIELD:
					statement.setString(index, realBean.getUserName() );
					break;
				case UfieldBean.userForeignKey_FIELD:
					statement.setString(index, realBean.getUserForeignKey() );
					break;
				case UfieldBean.userPrimaryKey_FIELD:
					statement.setString(index, realBean.getUserPrimaryKey() );
					break;
				case UfieldBean.tableId_FIELD:
					statement.setInt(index, realBean.getTableId() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			UfieldBean realBean = (UfieldBean)bean;
			switch (fieldId) {
				case UfieldBean.id_FIELD:
					realBean.setId(result.getInt(index));
					break;
				case UfieldBean.name_FIELD:
					realBean.setName(result.getString(index));
					break;
				case UfieldBean.dbDataType_FIELD:
					realBean.setDbDataType(result.getString(index));
					break;
				case UfieldBean.dbNull_FIELD:
					realBean.setDbNull(result.getString(index));
					break;
				case UfieldBean.dbDefault_FIELD:
					realBean.setDbDefault(result.getString(index));
					break;
				case UfieldBean.dbExtra_FIELD:
					realBean.setDbExtra(result.getString(index));
					break;
				case UfieldBean.keyName_FIELD:
					realBean.setKeyName(result.getString(index));
					break;
				case UfieldBean.size_FIELD:
					realBean.setSize(result.getInt(index));
					break;
				case UfieldBean.autoincrement_FIELD:
					realBean.setAutoincrement(result.getString(index));
					break;
				case UfieldBean.signed_FIELD:
					realBean.setSigned(result.getString(index));
					break;
				case UfieldBean.dbPrimaryKey_FIELD:
					realBean.setDbPrimaryKey(result.getString(index));
					break;
				case UfieldBean.javaDefaultDataType_FIELD:
					realBean.setJavaDefaultDataType(result.getString(index));
					break;
				case UfieldBean.userForeignField_FIELD:
					realBean.setUserForeignField(result.getInt(index));
					break;
				case UfieldBean.userDefaultValue_FIELD:
					realBean.setUserDefaultValue(result.getString(index));
					break;
				case UfieldBean.userJavaDataType_FIELD:
					realBean.setUserJavaDataType(result.getString(index));
					break;
				case UfieldBean.userName_FIELD:
					realBean.setUserName(result.getString(index));
					break;
				case UfieldBean.userForeignKey_FIELD:
					realBean.setUserForeignKey(result.getString(index));
					break;
				case UfieldBean.userPrimaryKey_FIELD:
					realBean.setUserPrimaryKey(result.getString(index));
					break;
				case UfieldBean.tableId_FIELD:
					realBean.setTableId(result.getInt(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			UfieldBean bean = new UfieldBean();
			int index = -1;
			if ((index = table.columnIndex( UfieldBean.id_FIELD)) != 0) {
				bean.setId(result.getInt(index));
			}
			if ((index = table.columnIndex( UfieldBean.name_FIELD)) != 0) {
				bean.setName(result.getString(index));
			}
			if ((index = table.columnIndex( UfieldBean.dbDataType_FIELD)) != 0) {
				bean.setDbDataType(result.getString(index));
			}
			if ((index = table.columnIndex( UfieldBean.dbNull_FIELD)) != 0) {
				bean.setDbNull(result.getString(index));
			}
			if ((index = table.columnIndex( UfieldBean.dbDefault_FIELD)) != 0) {
				bean.setDbDefault(result.getString(index));
			}
			if ((index = table.columnIndex( UfieldBean.dbExtra_FIELD)) != 0) {
				bean.setDbExtra(result.getString(index));
			}
			if ((index = table.columnIndex( UfieldBean.keyName_FIELD)) != 0) {
				bean.setKeyName(result.getString(index));
			}
			if ((index = table.columnIndex( UfieldBean.size_FIELD)) != 0) {
				bean.setSize(result.getInt(index));
			}
			if ((index = table.columnIndex( UfieldBean.autoincrement_FIELD)) != 0) {
				bean.setAutoincrement(result.getString(index));
			}
			if ((index = table.columnIndex( UfieldBean.signed_FIELD)) != 0) {
				bean.setSigned(result.getString(index));
			}
			if ((index = table.columnIndex( UfieldBean.dbPrimaryKey_FIELD)) != 0) {
				bean.setDbPrimaryKey(result.getString(index));
			}
			if ((index = table.columnIndex( UfieldBean.javaDefaultDataType_FIELD)) != 0) {
				bean.setJavaDefaultDataType(result.getString(index));
			}
			if ((index = table.columnIndex( UfieldBean.userForeignField_FIELD)) != 0) {
				bean.setUserForeignField(result.getInt(index));
			}
			if ((index = table.columnIndex( UfieldBean.userDefaultValue_FIELD)) != 0) {
				bean.setUserDefaultValue(result.getString(index));
			}
			if ((index = table.columnIndex( UfieldBean.userJavaDataType_FIELD)) != 0) {
				bean.setUserJavaDataType(result.getString(index));
			}
			if ((index = table.columnIndex( UfieldBean.userName_FIELD)) != 0) {
				bean.setUserName(result.getString(index));
			}
			if ((index = table.columnIndex( UfieldBean.userForeignKey_FIELD)) != 0) {
				bean.setUserForeignKey(result.getString(index));
			}
			if ((index = table.columnIndex( UfieldBean.userPrimaryKey_FIELD)) != 0) {
				bean.setUserPrimaryKey(result.getString(index));
			}
			if ((index = table.columnIndex( UfieldBean.tableId_FIELD)) != 0) {
				bean.setTableId(result.getInt(index));
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
			((UfieldBean)bean).setId(result.getInt(1));
		}
	

}//end class CustomerFiller