package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class QuotesFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			QuotesBean realBean = (QuotesBean)bean;
			switch (fieldId) {
				case QuotesBean.id_FIELD:
					statement.setInt(index, realBean.getId() );
					break;
				case QuotesBean.quote_FIELD:
					statement.setString(index, realBean.getQuote() );
					break;
				case QuotesBean.authorid_FIELD:
					statement.setInt(index, realBean.getAuthorid() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			QuotesBean realBean = (QuotesBean)bean;
			switch (fieldId) {
				case QuotesBean.id_FIELD:
					realBean.setId(result.getInt(index));
					break;
				case QuotesBean.quote_FIELD:
					realBean.setQuote(result.getString(index));
					break;
				case QuotesBean.authorid_FIELD:
					realBean.setAuthorid(result.getInt(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			QuotesBean bean = new QuotesBean();
			int index = -1;
			if ((index = table.columnIndex( QuotesBean.id_FIELD)) != 0) {
				bean.setId(result.getInt(index));
			}
			if ((index = table.columnIndex( QuotesBean.quote_FIELD)) != 0) {
				bean.setQuote(result.getString(index));
			}
			if ((index = table.columnIndex( QuotesBean.authorid_FIELD)) != 0) {
				bean.setAuthorid(result.getInt(index));
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
			((QuotesBean)bean).setId(result.getInt(1));
		}
	

}//end class CustomerFiller