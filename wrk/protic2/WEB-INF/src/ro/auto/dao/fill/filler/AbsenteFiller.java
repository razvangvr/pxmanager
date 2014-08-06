package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class AbsenteFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			AbsenteBean realBean = (AbsenteBean)bean;
			switch (fieldId) {
				case AbsenteBean.id_FIELD:
					statement.setLong(index, realBean.getId() );
					break;
				case AbsenteBean.id_elev_FIELD:
					statement.setLong(index, realBean.getId_elev() );
					break;
				case AbsenteBean.id_an_FIELD:
					statement.setLong(index, realBean.getId_an() );
					break;
				case AbsenteBean.motivat_FIELD:
					statement.setInt(index, realBean.getMotivat() );
					break;
				case AbsenteBean.nemotivat_FIELD:
					statement.setInt(index, realBean.getNemotivat() );
					break;
				case AbsenteBean.semestru_FIELD:
					statement.setString(index, realBean.getSemestru() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			AbsenteBean realBean = (AbsenteBean)bean;
			switch (fieldId) {
				case AbsenteBean.id_FIELD:
					realBean.setId(result.getLong(index));
					break;
				case AbsenteBean.id_elev_FIELD:
					realBean.setId_elev(result.getLong(index));
					break;
				case AbsenteBean.id_an_FIELD:
					realBean.setId_an(result.getLong(index));
					break;
				case AbsenteBean.motivat_FIELD:
					realBean.setMotivat(result.getInt(index));
					break;
				case AbsenteBean.nemotivat_FIELD:
					realBean.setNemotivat(result.getInt(index));
					break;
				case AbsenteBean.semestru_FIELD:
					realBean.setSemestru(result.getString(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			AbsenteBean bean = new AbsenteBean();
			int index = -1;
			if ((index = table.columnIndex( AbsenteBean.id_FIELD)) != 0) {
				bean.setId(result.getLong(index));
			}
			if ((index = table.columnIndex( AbsenteBean.id_elev_FIELD)) != 0) {
				bean.setId_elev(result.getLong(index));
			}
			if ((index = table.columnIndex( AbsenteBean.id_an_FIELD)) != 0) {
				bean.setId_an(result.getLong(index));
			}
			if ((index = table.columnIndex( AbsenteBean.motivat_FIELD)) != 0) {
				bean.setMotivat(result.getInt(index));
			}
			if ((index = table.columnIndex( AbsenteBean.nemotivat_FIELD)) != 0) {
				bean.setNemotivat(result.getInt(index));
			}
			if ((index = table.columnIndex( AbsenteBean.semestru_FIELD)) != 0) {
				bean.setSemestru(result.getString(index));
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
			((AbsenteBean)bean).setId(result.getLong(1));
		}
	

}//end class CustomerFiller