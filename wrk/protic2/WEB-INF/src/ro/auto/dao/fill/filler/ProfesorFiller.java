package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ProfesorFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			ProfesorBean realBean = (ProfesorBean)bean;
			switch (fieldId) {
				case ProfesorBean.id_FIELD:
					statement.setLong(index, realBean.getId() );
					break;
				case ProfesorBean.nume_FIELD:
					statement.setString(index, realBean.getNume() );
					break;
				case ProfesorBean.loc_FIELD:
					statement.setString(index, realBean.getLoc() );
					break;
				case ProfesorBean.adr_FIELD:
					statement.setString(index, realBean.getAdr() );
					break;
				case ProfesorBean.tel_FIELD:
					statement.setString(index, realBean.getTel() );
					break;
				case ProfesorBean.email_FIELD:
					statement.setString(index, realBean.getEmail() );
					break;
				case ProfesorBean.jud_FIELD:
					statement.setString(index, realBean.getJud() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			ProfesorBean realBean = (ProfesorBean)bean;
			switch (fieldId) {
				case ProfesorBean.id_FIELD:
					realBean.setId(result.getLong(index));
					break;
				case ProfesorBean.nume_FIELD:
					realBean.setNume(result.getString(index));
					break;
				case ProfesorBean.loc_FIELD:
					realBean.setLoc(result.getString(index));
					break;
				case ProfesorBean.adr_FIELD:
					realBean.setAdr(result.getString(index));
					break;
				case ProfesorBean.tel_FIELD:
					realBean.setTel(result.getString(index));
					break;
				case ProfesorBean.email_FIELD:
					realBean.setEmail(result.getString(index));
					break;
				case ProfesorBean.jud_FIELD:
					realBean.setJud(result.getString(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			ProfesorBean bean = new ProfesorBean();
			int index = -1;
			if ((index = table.columnIndex( ProfesorBean.id_FIELD)) != 0) {
				bean.setId(result.getLong(index));
			}
			if ((index = table.columnIndex( ProfesorBean.nume_FIELD)) != 0) {
				bean.setNume(result.getString(index));
			}
			if ((index = table.columnIndex( ProfesorBean.loc_FIELD)) != 0) {
				bean.setLoc(result.getString(index));
			}
			if ((index = table.columnIndex( ProfesorBean.adr_FIELD)) != 0) {
				bean.setAdr(result.getString(index));
			}
			if ((index = table.columnIndex( ProfesorBean.tel_FIELD)) != 0) {
				bean.setTel(result.getString(index));
			}
			if ((index = table.columnIndex( ProfesorBean.email_FIELD)) != 0) {
				bean.setEmail(result.getString(index));
			}
			if ((index = table.columnIndex( ProfesorBean.jud_FIELD)) != 0) {
				bean.setJud(result.getString(index));
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
			((ProfesorBean)bean).setId(result.getLong(1));
		}
	

}//end class CustomerFiller