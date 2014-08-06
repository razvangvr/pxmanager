package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class MediaFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			MediaBean realBean = (MediaBean)bean;
			switch (fieldId) {
				case MediaBean.id_FIELD:
					statement.setLong(index, realBean.getId() );
					break;
				case MediaBean.id_elev_FIELD:
					statement.setLong(index, realBean.getId_elev() );
					break;
				case MediaBean.id_disc_FIELD:
					statement.setLong(index, realBean.getId_disc() );
					break;
				case MediaBean.id_an_FIELD:
					statement.setLong(index, realBean.getId_an() );
					break;
				case MediaBean.media_FIELD:
					statement.setBigDecimal(index, realBean.getMedia() );
					break;
				case MediaBean.semestru_FIELD:
					statement.setString(index, realBean.getSemestru() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			MediaBean realBean = (MediaBean)bean;
			switch (fieldId) {
				case MediaBean.id_FIELD:
					realBean.setId(result.getLong(index));
					break;
				case MediaBean.id_elev_FIELD:
					realBean.setId_elev(result.getLong(index));
					break;
				case MediaBean.id_disc_FIELD:
					realBean.setId_disc(result.getLong(index));
					break;
				case MediaBean.id_an_FIELD:
					realBean.setId_an(result.getLong(index));
					break;
				case MediaBean.media_FIELD:
					realBean.setMedia(result.getBigDecimal(index));
					break;
				case MediaBean.semestru_FIELD:
					realBean.setSemestru(result.getString(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			MediaBean bean = new MediaBean();
			int index = -1;
			if ((index = table.columnIndex( MediaBean.id_FIELD)) != 0) {
				bean.setId(result.getLong(index));
			}
			if ((index = table.columnIndex( MediaBean.id_elev_FIELD)) != 0) {
				bean.setId_elev(result.getLong(index));
			}
			if ((index = table.columnIndex( MediaBean.id_disc_FIELD)) != 0) {
				bean.setId_disc(result.getLong(index));
			}
			if ((index = table.columnIndex( MediaBean.id_an_FIELD)) != 0) {
				bean.setId_an(result.getLong(index));
			}
			if ((index = table.columnIndex( MediaBean.media_FIELD)) != 0) {
				bean.setMedia(result.getBigDecimal(index));
			}
			if ((index = table.columnIndex( MediaBean.semestru_FIELD)) != 0) {
				bean.setSemestru(result.getString(index));
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
			((MediaBean)bean).setId(result.getLong(1));
		}
	

}//end class CustomerFiller