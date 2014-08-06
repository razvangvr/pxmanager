package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class EleviclasaFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			EleviclasaBean realBean = (EleviclasaBean)bean;
			switch (fieldId) {
				case EleviclasaBean.Id_FIELD:
					statement.setInt(index, realBean.getId() );
					break;
				case EleviclasaBean.id_clasa_FIELD:
					statement.setLong(index, realBean.getId_clasa() );
					break;
				case EleviclasaBean.id_elev_FIELD:
					statement.setLong(index, realBean.getId_elev() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			EleviclasaBean realBean = (EleviclasaBean)bean;
			switch (fieldId) {
				case EleviclasaBean.Id_FIELD:
					realBean.setId(result.getInt(index));
					break;
				case EleviclasaBean.id_clasa_FIELD:
					realBean.setId_clasa(result.getLong(index));
					break;
				case EleviclasaBean.id_elev_FIELD:
					realBean.setId_elev(result.getLong(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			EleviclasaBean bean = new EleviclasaBean();
			int index = -1;
			if ((index = table.columnIndex( EleviclasaBean.Id_FIELD)) != 0) {
				bean.setId(result.getInt(index));
			}
			if ((index = table.columnIndex( EleviclasaBean.id_clasa_FIELD)) != 0) {
				bean.setId_clasa(result.getLong(index));
			}
			if ((index = table.columnIndex( EleviclasaBean.id_elev_FIELD)) != 0) {
				bean.setId_elev(result.getLong(index));
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
			((EleviclasaBean)bean).setId(result.getInt(1));
		}
	

}//end class CustomerFiller