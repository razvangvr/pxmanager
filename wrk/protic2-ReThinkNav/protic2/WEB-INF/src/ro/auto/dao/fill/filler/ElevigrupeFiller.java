package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ElevigrupeFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			ElevigrupeBean realBean = (ElevigrupeBean)bean;
			switch (fieldId) {
				case ElevigrupeBean.id_FIELD:
					statement.setLong(index, realBean.getId() );
					break;
				case ElevigrupeBean.id_elev_FIELD:
					statement.setLong(index, realBean.getId_elev() );
					break;
				case ElevigrupeBean.id_disciplineprofesori_FIELD:
					statement.setInt(index, realBean.getId_disciplineprofesori() );
					break;
				case ElevigrupeBean.grupa_FIELD:
					statement.setInt(index, realBean.getGrupa() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			ElevigrupeBean realBean = (ElevigrupeBean)bean;
			switch (fieldId) {
				case ElevigrupeBean.id_FIELD:
					realBean.setId(result.getLong(index));
					break;
				case ElevigrupeBean.id_elev_FIELD:
					realBean.setId_elev(result.getLong(index));
					break;
				case ElevigrupeBean.id_disciplineprofesori_FIELD:
					realBean.setId_disciplineprofesori(result.getInt(index));
					break;
				case ElevigrupeBean.grupa_FIELD:
					realBean.setGrupa(result.getInt(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			ElevigrupeBean bean = new ElevigrupeBean();
			int index = -1;
			if ((index = table.columnIndex( ElevigrupeBean.id_FIELD)) != 0) {
				bean.setId(result.getLong(index));
			}
			if ((index = table.columnIndex( ElevigrupeBean.id_elev_FIELD)) != 0) {
				bean.setId_elev(result.getLong(index));
			}
			if ((index = table.columnIndex( ElevigrupeBean.id_disciplineprofesori_FIELD)) != 0) {
				bean.setId_disciplineprofesori(result.getInt(index));
			}
			if ((index = table.columnIndex( ElevigrupeBean.grupa_FIELD)) != 0) {
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
			((ElevigrupeBean)bean).setId(result.getLong(1));
		}
	

}//end class CustomerFiller