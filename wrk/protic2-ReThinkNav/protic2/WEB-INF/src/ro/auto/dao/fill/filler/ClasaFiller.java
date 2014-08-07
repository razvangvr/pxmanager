package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ClasaFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			ClasaBean realBean = (ClasaBean)bean;
			switch (fieldId) {
				case ClasaBean.id_FIELD:
					statement.setLong(index, realBean.getId() );
					break;
				case ClasaBean.id_an_FIELD:
					statement.setLong(index, realBean.getId_an() );
					break;
				case ClasaBean.id_profil_FIELD:
					statement.setLong(index, realBean.getId_profil() );
					break;
				case ClasaBean.id_specializare_FIELD:
					statement.setLong(index, realBean.getId_specializare() );
					break;
				case ClasaBean.den_FIELD:
					statement.setString(index, realBean.getDen() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			ClasaBean realBean = (ClasaBean)bean;
			switch (fieldId) {
				case ClasaBean.id_FIELD:
					realBean.setId(result.getLong(index));
					break;
				case ClasaBean.id_an_FIELD:
					realBean.setId_an(result.getLong(index));
					break;
				case ClasaBean.id_profil_FIELD:
					realBean.setId_profil(result.getLong(index));
					break;
				case ClasaBean.id_specializare_FIELD:
					realBean.setId_specializare(result.getLong(index));
					break;
				case ClasaBean.den_FIELD:
					realBean.setDen(result.getString(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			ClasaBean bean = new ClasaBean();
			int index = -1;
			if ((index = table.columnIndex( ClasaBean.id_FIELD)) != 0) {
				bean.setId(result.getLong(index));
			}
			if ((index = table.columnIndex( ClasaBean.id_an_FIELD)) != 0) {
				bean.setId_an(result.getLong(index));
			}
			if ((index = table.columnIndex( ClasaBean.id_profil_FIELD)) != 0) {
				bean.setId_profil(result.getLong(index));
			}
			if ((index = table.columnIndex( ClasaBean.id_specializare_FIELD)) != 0) {
				bean.setId_specializare(result.getLong(index));
			}
			if ((index = table.columnIndex( ClasaBean.den_FIELD)) != 0) {
				bean.setDen(result.getString(index));
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
			((ClasaBean)bean).setId(result.getLong(1));
		}
	

}//end class CustomerFiller