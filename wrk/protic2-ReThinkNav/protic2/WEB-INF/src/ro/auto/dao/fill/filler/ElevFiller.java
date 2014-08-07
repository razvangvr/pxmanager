package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ElevFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			ElevBean realBean = (ElevBean)bean;
			switch (fieldId) {
				case ElevBean.id_FIELD:
					statement.setLong(index, realBean.getId() );
					break;
				case ElevBean.matr_FIELD:
					statement.setLong(index, realBean.getMatr() );
					break;
				case ElevBean.nume_FIELD:
					statement.setString(index, realBean.getNume() );
					break;
				case ElevBean.datan_FIELD:
					statement.setDate(index, realBean.getDatan() );
					break;
				case ElevBean.sex_FIELD:
					statement.setString(index, realBean.getSex() );
					break;
				case ElevBean.adr_FIELD:
					statement.setString(index, realBean.getAdr() );
					break;
				case ElevBean.loc_FIELD:
					statement.setString(index, realBean.getLoc() );
					break;
				case ElevBean.jud_FIELD:
					statement.setString(index, realBean.getJud() );
					break;
				case ElevBean.codp_FIELD:
					statement.setInt(index, realBean.getCodp() );
					break;
				case ElevBean.tel_FIELD:
					statement.setString(index, realBean.getTel() );
					break;
				case ElevBean.email_FIELD:
					statement.setString(index, realBean.getEmail() );
					break;
				case ElevBean.statut_FIELD:
					statement.setString(index, realBean.getStatut() );
					break;
				case ElevBean.nat_FIELD:
					statement.setString(index, realBean.getNat() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			ElevBean realBean = (ElevBean)bean;
			switch (fieldId) {
				case ElevBean.id_FIELD:
					realBean.setId(result.getLong(index));
					break;
				case ElevBean.matr_FIELD:
					realBean.setMatr(result.getLong(index));
					break;
				case ElevBean.nume_FIELD:
					realBean.setNume(result.getString(index));
					break;
				case ElevBean.datan_FIELD:
					realBean.setDatan(result.getDate(index));
					break;
				case ElevBean.sex_FIELD:
					realBean.setSex(result.getString(index));
					break;
				case ElevBean.adr_FIELD:
					realBean.setAdr(result.getString(index));
					break;
				case ElevBean.loc_FIELD:
					realBean.setLoc(result.getString(index));
					break;
				case ElevBean.jud_FIELD:
					realBean.setJud(result.getString(index));
					break;
				case ElevBean.codp_FIELD:
					realBean.setCodp(result.getInt(index));
					break;
				case ElevBean.tel_FIELD:
					realBean.setTel(result.getString(index));
					break;
				case ElevBean.email_FIELD:
					realBean.setEmail(result.getString(index));
					break;
				case ElevBean.statut_FIELD:
					realBean.setStatut(result.getString(index));
					break;
				case ElevBean.nat_FIELD:
					realBean.setNat(result.getString(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			ElevBean bean = new ElevBean();
			int index = -1;
			if ((index = table.columnIndex( ElevBean.id_FIELD)) != 0) {
				bean.setId(result.getLong(index));
			}
			if ((index = table.columnIndex( ElevBean.matr_FIELD)) != 0) {
				bean.setMatr(result.getLong(index));
			}
			if ((index = table.columnIndex( ElevBean.nume_FIELD)) != 0) {
				bean.setNume(result.getString(index));
			}
			if ((index = table.columnIndex( ElevBean.datan_FIELD)) != 0) {
				bean.setDatan(result.getDate(index));
			}
			if ((index = table.columnIndex( ElevBean.sex_FIELD)) != 0) {
				bean.setSex(result.getString(index));
			}
			if ((index = table.columnIndex( ElevBean.adr_FIELD)) != 0) {
				bean.setAdr(result.getString(index));
			}
			if ((index = table.columnIndex( ElevBean.loc_FIELD)) != 0) {
				bean.setLoc(result.getString(index));
			}
			if ((index = table.columnIndex( ElevBean.jud_FIELD)) != 0) {
				bean.setJud(result.getString(index));
			}
			if ((index = table.columnIndex( ElevBean.codp_FIELD)) != 0) {
				bean.setCodp(result.getInt(index));
			}
			if ((index = table.columnIndex( ElevBean.tel_FIELD)) != 0) {
				bean.setTel(result.getString(index));
			}
			if ((index = table.columnIndex( ElevBean.email_FIELD)) != 0) {
				bean.setEmail(result.getString(index));
			}
			if ((index = table.columnIndex( ElevBean.statut_FIELD)) != 0) {
				bean.setStatut(result.getString(index));
			}
			if ((index = table.columnIndex( ElevBean.nat_FIELD)) != 0) {
				bean.setNat(result.getString(index));
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
			((ElevBean)bean).setId(result.getLong(1));
		}
	

}//end class CustomerFiller