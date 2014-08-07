package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class PaginiFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			PaginiBean realBean = (PaginiBean)bean;
			switch (fieldId) {
				case PaginiBean.Id_FIELD:
					statement.setInt(index, realBean.getId() );
					break;
				case PaginiBean.continut_FIELD:
					statement.setString(index, realBean.getContinut() );
					break;
				case PaginiBean.grupa_FIELD:
					statement.setInt(index, realBean.getGrupa() );
					break;
				case PaginiBean.id_disciplineprofesori_FIELD:
					statement.setInt(index, realBean.getId_disciplineprofesori() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			PaginiBean realBean = (PaginiBean)bean;
			switch (fieldId) {
				case PaginiBean.Id_FIELD:
					realBean.setId(result.getInt(index));
					break;
				case PaginiBean.continut_FIELD:
					realBean.setContinut(result.getString(index));
					break;
				case PaginiBean.grupa_FIELD:
					realBean.setGrupa(result.getInt(index));
					break;
				case PaginiBean.id_disciplineprofesori_FIELD:
					realBean.setId_disciplineprofesori(result.getInt(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			PaginiBean bean = new PaginiBean();
			int index = -1;
			if ((index = table.columnIndex( PaginiBean.Id_FIELD)) != 0) {
				bean.setId(result.getInt(index));
			}
			if ((index = table.columnIndex( PaginiBean.continut_FIELD)) != 0) {
				bean.setContinut(result.getString(index));
			}
			if ((index = table.columnIndex( PaginiBean.grupa_FIELD)) != 0) {
				bean.setGrupa(result.getInt(index));
			}
			if ((index = table.columnIndex( PaginiBean.id_disciplineprofesori_FIELD)) != 0) {
				bean.setId_disciplineprofesori(result.getInt(index));
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
			((PaginiBean)bean).setId(result.getInt(1));
		}
	

}//end class CustomerFiller