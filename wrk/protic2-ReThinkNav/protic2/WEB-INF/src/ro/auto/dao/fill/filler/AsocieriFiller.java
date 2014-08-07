package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class AsocieriFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			AsocieriBean realBean = (AsocieriBean)bean;
			switch (fieldId) {
				case AsocieriBean.idsqldata_FIELD:
					statement.setInt(index, realBean.getIdsqldata() );
					break;
				case AsocieriBean.idjdata_FIELD:
					statement.setInt(index, realBean.getIdjdata() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			AsocieriBean realBean = (AsocieriBean)bean;
			switch (fieldId) {
				case AsocieriBean.idsqldata_FIELD:
					realBean.setIdsqldata(result.getInt(index));
					break;
				case AsocieriBean.idjdata_FIELD:
					realBean.setIdjdata(result.getInt(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			AsocieriBean bean = new AsocieriBean();
			int index = -1;
			if ((index = table.columnIndex( AsocieriBean.idsqldata_FIELD)) != 0) {
				bean.setIdsqldata(result.getInt(index));
			}
			if ((index = table.columnIndex( AsocieriBean.idjdata_FIELD)) != 0) {
				bean.setIdjdata(result.getInt(index));
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
			((AsocieriBean)bean).setIdsqldata(result.getInt(1));
		}
	

}//end class CustomerFiller