package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DiriginteFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			DiriginteBean realBean = (DiriginteBean)bean;
			switch (fieldId) {
				case DiriginteBean.id_FIELD:
					statement.setLong(index, realBean.getId() );
					break;
				case DiriginteBean.id_profesor_FIELD:
					statement.setLong(index, realBean.getId_profesor() );
					break;
				case DiriginteBean.id_clasa_FIELD:
					statement.setLong(index, realBean.getId_clasa() );
					break;
				case DiriginteBean.obs_FIELD:
					statement.setString(index, realBean.getObs() );
					break;
				case DiriginteBean.username_FIELD:
					statement.setString(index, realBean.getUsername() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			DiriginteBean realBean = (DiriginteBean)bean;
			switch (fieldId) {
				case DiriginteBean.id_FIELD:
					realBean.setId(result.getLong(index));
					break;
				case DiriginteBean.id_profesor_FIELD:
					realBean.setId_profesor(result.getLong(index));
					break;
				case DiriginteBean.id_clasa_FIELD:
					realBean.setId_clasa(result.getLong(index));
					break;
				case DiriginteBean.obs_FIELD:
					realBean.setObs(result.getString(index));
					break;
				case DiriginteBean.username_FIELD:
					realBean.setUsername(result.getString(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			DiriginteBean bean = new DiriginteBean();
			int index = -1;
			if ((index = table.columnIndex( DiriginteBean.id_FIELD)) != 0) {
				bean.setId(result.getLong(index));
			}
			if ((index = table.columnIndex( DiriginteBean.id_profesor_FIELD)) != 0) {
				bean.setId_profesor(result.getLong(index));
			}
			if ((index = table.columnIndex( DiriginteBean.id_clasa_FIELD)) != 0) {
				bean.setId_clasa(result.getLong(index));
			}
			if ((index = table.columnIndex( DiriginteBean.obs_FIELD)) != 0) {
				bean.setObs(result.getString(index));
			}
			if ((index = table.columnIndex( DiriginteBean.username_FIELD)) != 0) {
				bean.setUsername(result.getString(index));
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
			((DiriginteBean)bean).setId(result.getLong(1));
		}
	

}//end class CustomerFiller