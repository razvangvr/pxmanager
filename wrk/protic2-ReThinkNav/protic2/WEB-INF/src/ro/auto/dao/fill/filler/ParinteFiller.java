package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ParinteFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			ParinteBean realBean = (ParinteBean)bean;
			switch (fieldId) {
				case ParinteBean.id_FIELD:
					statement.setLong(index, realBean.getId() );
					break;
				case ParinteBean.id_elev_FIELD:
					statement.setLong(index, realBean.getId_elev() );
					break;
				case ParinteBean.nume_FIELD:
					statement.setString(index, realBean.getNume() );
					break;
				case ParinteBean.profesie_FIELD:
					statement.setString(index, realBean.getProfesie() );
					break;
				case ParinteBean.loc_munca_FIELD:
					statement.setString(index, realBean.getLoc_munca() );
					break;
				case ParinteBean.adr_FIELD:
					statement.setString(index, realBean.getAdr() );
					break;
				case ParinteBean.loc_FIELD:
					statement.setString(index, realBean.getLoc() );
					break;
				case ParinteBean.jud_FIELD:
					statement.setString(index, realBean.getJud() );
					break;
				case ParinteBean.Codp_FIELD:
					statement.setInt(index, realBean.getCodp() );
					break;
				case ParinteBean.tel_FIELD:
					statement.setString(index, realBean.getTel() );
					break;
				case ParinteBean.email_FIELD:
					statement.setString(index, realBean.getEmail() );
					break;
				case ParinteBean.obs_FIELD:
					statement.setString(index, realBean.getObs() );
					break;
				case ParinteBean.statut_FIELD:
					statement.setString(index, realBean.getStatut() );
					break;
				case ParinteBean.intara_FIELD:
					statement.setString(index, realBean.getIntara() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			ParinteBean realBean = (ParinteBean)bean;
			switch (fieldId) {
				case ParinteBean.id_FIELD:
					realBean.setId(result.getLong(index));
					break;
				case ParinteBean.id_elev_FIELD:
					realBean.setId_elev(result.getLong(index));
					break;
				case ParinteBean.nume_FIELD:
					realBean.setNume(result.getString(index));
					break;
				case ParinteBean.profesie_FIELD:
					realBean.setProfesie(result.getString(index));
					break;
				case ParinteBean.loc_munca_FIELD:
					realBean.setLoc_munca(result.getString(index));
					break;
				case ParinteBean.adr_FIELD:
					realBean.setAdr(result.getString(index));
					break;
				case ParinteBean.loc_FIELD:
					realBean.setLoc(result.getString(index));
					break;
				case ParinteBean.jud_FIELD:
					realBean.setJud(result.getString(index));
					break;
				case ParinteBean.Codp_FIELD:
					realBean.setCodp(result.getInt(index));
					break;
				case ParinteBean.tel_FIELD:
					realBean.setTel(result.getString(index));
					break;
				case ParinteBean.email_FIELD:
					realBean.setEmail(result.getString(index));
					break;
				case ParinteBean.obs_FIELD:
					realBean.setObs(result.getString(index));
					break;
				case ParinteBean.statut_FIELD:
					realBean.setStatut(result.getString(index));
					break;
				case ParinteBean.intara_FIELD:
					realBean.setIntara(result.getString(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			ParinteBean bean = new ParinteBean();
			int index = -1;
			if ((index = table.columnIndex( ParinteBean.id_FIELD)) != 0) {
				bean.setId(result.getLong(index));
			}
			if ((index = table.columnIndex( ParinteBean.id_elev_FIELD)) != 0) {
				bean.setId_elev(result.getLong(index));
			}
			if ((index = table.columnIndex( ParinteBean.nume_FIELD)) != 0) {
				bean.setNume(result.getString(index));
			}
			if ((index = table.columnIndex( ParinteBean.profesie_FIELD)) != 0) {
				bean.setProfesie(result.getString(index));
			}
			if ((index = table.columnIndex( ParinteBean.loc_munca_FIELD)) != 0) {
				bean.setLoc_munca(result.getString(index));
			}
			if ((index = table.columnIndex( ParinteBean.adr_FIELD)) != 0) {
				bean.setAdr(result.getString(index));
			}
			if ((index = table.columnIndex( ParinteBean.loc_FIELD)) != 0) {
				bean.setLoc(result.getString(index));
			}
			if ((index = table.columnIndex( ParinteBean.jud_FIELD)) != 0) {
				bean.setJud(result.getString(index));
			}
			if ((index = table.columnIndex( ParinteBean.Codp_FIELD)) != 0) {
				bean.setCodp(result.getInt(index));
			}
			if ((index = table.columnIndex( ParinteBean.tel_FIELD)) != 0) {
				bean.setTel(result.getString(index));
			}
			if ((index = table.columnIndex( ParinteBean.email_FIELD)) != 0) {
				bean.setEmail(result.getString(index));
			}
			if ((index = table.columnIndex( ParinteBean.obs_FIELD)) != 0) {
				bean.setObs(result.getString(index));
			}
			if ((index = table.columnIndex( ParinteBean.statut_FIELD)) != 0) {
				bean.setStatut(result.getString(index));
			}
			if ((index = table.columnIndex( ParinteBean.intara_FIELD)) != 0) {
				bean.setIntara(result.getString(index));
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
			((ParinteBean)bean).setId(result.getLong(1));
		}
	

}//end class CustomerFiller