package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class AlternativesFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			AlternativesBean realBean = (AlternativesBean)bean;
			switch (fieldId) {
				case AlternativesBean.jdataid_FIELD:
					statement.setInt(index, realBean.getJdataid() );
					break;
				case AlternativesBean.jdataaltid_FIELD:
					statement.setInt(index, realBean.getJdataaltid() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			AlternativesBean realBean = (AlternativesBean)bean;
			switch (fieldId) {
				case AlternativesBean.jdataid_FIELD:
					realBean.setJdataid(result.getInt(index));
					break;
				case AlternativesBean.jdataaltid_FIELD:
					realBean.setJdataaltid(result.getInt(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			AlternativesBean bean = new AlternativesBean();
			int index = -1;
			if ((index = table.columnIndex( AlternativesBean.jdataid_FIELD)) != 0) {
				bean.setJdataid(result.getInt(index));
			}
			if ((index = table.columnIndex( AlternativesBean.jdataaltid_FIELD)) != 0) {
				bean.setJdataaltid(result.getInt(index));
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
			((AlternativesBean)bean).setJdataid(result.getInt(1));
		}
	

}//end class CustomerFiller