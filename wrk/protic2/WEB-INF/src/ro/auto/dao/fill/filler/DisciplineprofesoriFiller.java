package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DisciplineprofesoriFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			DisciplineprofesoriBean realBean = (DisciplineprofesoriBean)bean;
			switch (fieldId) {
				case DisciplineprofesoriBean.id_FIELD:
					statement.setLong(index, realBean.getId() );
					break;
				case DisciplineprofesoriBean.id_clasa_FIELD:
					statement.setLong(index, realBean.getId_clasa() );
					break;
				case DisciplineprofesoriBean.id_disciplina_FIELD:
					statement.setInt(index, realBean.getId_disciplina() );
					break;
				case DisciplineprofesoriBean.id_profesor_FIELD:
					statement.setInt(index, realBean.getId_profesor() );
					break;
				case DisciplineprofesoriBean.ore_FIELD:
					statement.setLong(index, realBean.getOre() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			DisciplineprofesoriBean realBean = (DisciplineprofesoriBean)bean;
			switch (fieldId) {
				case DisciplineprofesoriBean.id_FIELD:
					realBean.setId(result.getLong(index));
					break;
				case DisciplineprofesoriBean.id_clasa_FIELD:
					realBean.setId_clasa(result.getLong(index));
					break;
				case DisciplineprofesoriBean.id_disciplina_FIELD:
					realBean.setId_disciplina(result.getInt(index));
					break;
				case DisciplineprofesoriBean.id_profesor_FIELD:
					realBean.setId_profesor(result.getInt(index));
					break;
				case DisciplineprofesoriBean.ore_FIELD:
					realBean.setOre(result.getLong(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			DisciplineprofesoriBean bean = new DisciplineprofesoriBean();
			int index = -1;
			if ((index = table.columnIndex( DisciplineprofesoriBean.id_FIELD)) != 0) {
				bean.setId(result.getLong(index));
			}
			if ((index = table.columnIndex( DisciplineprofesoriBean.id_clasa_FIELD)) != 0) {
				bean.setId_clasa(result.getLong(index));
			}
			if ((index = table.columnIndex( DisciplineprofesoriBean.id_disciplina_FIELD)) != 0) {
				bean.setId_disciplina(result.getInt(index));
			}
			if ((index = table.columnIndex( DisciplineprofesoriBean.id_profesor_FIELD)) != 0) {
				bean.setId_profesor(result.getInt(index));
			}
			if ((index = table.columnIndex( DisciplineprofesoriBean.ore_FIELD)) != 0) {
				bean.setOre(result.getLong(index));
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
			((DisciplineprofesoriBean)bean).setId(result.getLong(1));
		}
	

}//end class CustomerFiller