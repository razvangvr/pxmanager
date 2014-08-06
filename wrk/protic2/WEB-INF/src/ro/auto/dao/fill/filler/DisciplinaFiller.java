package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DisciplinaFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			DisciplinaBean realBean = (DisciplinaBean)bean;
			switch (fieldId) {
				case DisciplinaBean.id_FIELD:
					statement.setLong(index, realBean.getId() );
					break;
				case DisciplinaBean.den_FIELD:
					statement.setString(index, realBean.getDen() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			DisciplinaBean realBean = (DisciplinaBean)bean;
			switch (fieldId) {
				case DisciplinaBean.id_FIELD:
					realBean.setId(result.getLong(index));
					break;
				case DisciplinaBean.den_FIELD:
					realBean.setDen(result.getString(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			DisciplinaBean bean = new DisciplinaBean();
			int index = -1;
			if ((index = table.columnIndex( DisciplinaBean.id_FIELD)) != 0) {
				bean.setId(result.getLong(index));
			}
			if ((index = table.columnIndex( DisciplinaBean.den_FIELD)) != 0) {
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
			((DisciplinaBean)bean).setId(result.getLong(1));
		}
	

}//end class CustomerFiller