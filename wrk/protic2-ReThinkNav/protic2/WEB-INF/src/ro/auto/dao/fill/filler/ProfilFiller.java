package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ProfilFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			ProfilBean realBean = (ProfilBean)bean;
			switch (fieldId) {
				case ProfilBean.Id_FIELD:
					statement.setInt(index, realBean.getId() );
					break;
				case ProfilBean.den_FIELD:
					statement.setString(index, realBean.getDen() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			ProfilBean realBean = (ProfilBean)bean;
			switch (fieldId) {
				case ProfilBean.Id_FIELD:
					realBean.setId(result.getInt(index));
					break;
				case ProfilBean.den_FIELD:
					realBean.setDen(result.getString(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			ProfilBean bean = new ProfilBean();
			int index = -1;
			if ((index = table.columnIndex( ProfilBean.Id_FIELD)) != 0) {
				bean.setId(result.getInt(index));
			}
			if ((index = table.columnIndex( ProfilBean.den_FIELD)) != 0) {
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
			((ProfilBean)bean).setId(result.getInt(1));
		}
	

}//end class CustomerFiller