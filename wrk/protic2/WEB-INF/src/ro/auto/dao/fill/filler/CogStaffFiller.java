package ro.auto.dao.fill.filler;

import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.beans.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class CogStaffFiller implements StatmentResultSetFill {
	
		public void fillStatement (PreparedStatement statement, int index, GenericBean bean, int fieldId) throws SQLException {
			CogStaffBean realBean = (CogStaffBean)bean;
			switch (fieldId) {
				case CogStaffBean.COG_STAFF_ID_FIELD:
					statement.setInt(index, realBean.getCOG_STAFF_ID() );
					break;
				case CogStaffBean.DEPT_ID_FIELD:
					statement.setInt(index, realBean.getDEPT_ID() );
					break;
				case CogStaffBean.EMPLOYEE_NUMBER_FIELD:
					statement.setInt(index, realBean.getEMPLOYEE_NUMBER() );
					break;
				case CogStaffBean.LAST_NAME_FIELD:
					statement.setString(index, realBean.getLAST_NAME() );
					break;
				case CogStaffBean.FIRST_NAME_FIELD:
					statement.setString(index, realBean.getFIRST_NAME() );
					break;
				case CogStaffBean.MIDDLE_NAME_FIELD:
					statement.setString(index, realBean.getMIDDLE_NAME() );
					break;
				case CogStaffBean.TITLE_FIELD:
					statement.setString(index, realBean.getTITLE() );
					break;
				case CogStaffBean.EMPLOYEE_TYPE_FIELD:
					statement.setString(index, realBean.getEMPLOYEE_TYPE() );
					break;
				case CogStaffBean.SUPERVISOR_FIELD:
					statement.setInt(index, realBean.getSUPERVISOR() );
					break;
				case CogStaffBean.HIRING_DATE_FIELD:
					statement.setDate(index, realBean.getHIRING_DATE() );
					break;
				case CogStaffBean.LEFT_DATE_FIELD:
					statement.setDate(index, realBean.getLEFT_DATE() );
					break;
			}
		}

		public void fillBean (GenericBean bean, ResultSet result, int index, int fieldId) throws SQLException {
			CogStaffBean realBean = (CogStaffBean)bean;
			switch (fieldId) {
				case CogStaffBean.COG_STAFF_ID_FIELD:
					realBean.setCOG_STAFF_ID(result.getInt(index));
					break;
				case CogStaffBean.DEPT_ID_FIELD:
					realBean.setDEPT_ID(result.getInt(index));
					break;
				case CogStaffBean.EMPLOYEE_NUMBER_FIELD:
					realBean.setEMPLOYEE_NUMBER(result.getInt(index));
					break;
				case CogStaffBean.LAST_NAME_FIELD:
					realBean.setLAST_NAME(result.getString(index));
					break;
				case CogStaffBean.FIRST_NAME_FIELD:
					realBean.setFIRST_NAME(result.getString(index));
					break;
				case CogStaffBean.MIDDLE_NAME_FIELD:
					realBean.setMIDDLE_NAME(result.getString(index));
					break;
				case CogStaffBean.TITLE_FIELD:
					realBean.setTITLE(result.getString(index));
					break;
				case CogStaffBean.EMPLOYEE_TYPE_FIELD:
					realBean.setEMPLOYEE_TYPE(result.getString(index));
					break;
				case CogStaffBean.SUPERVISOR_FIELD:
					realBean.setSUPERVISOR(result.getInt(index));
					break;
				case CogStaffBean.HIRING_DATE_FIELD:
					realBean.setHIRING_DATE(result.getDate(index));
					break;
				case CogStaffBean.LEFT_DATE_FIELD:
					realBean.setLEFT_DATE(result.getDate(index));
					break;
			}
		}
/*
		public GenericBean fillBean (Table table,ResultSet result) throws SQLException {
			CogStaffBean bean = new CogStaffBean();
			int index = -1;
			if ((index = table.columnIndex( CogStaffBean.COG_STAFF_ID_FIELD)) != 0) {
				bean.setCOG_STAFF_ID(result.getInt(index));
			}
			if ((index = table.columnIndex( CogStaffBean.DEPT_ID_FIELD)) != 0) {
				bean.setDEPT_ID(result.getInt(index));
			}
			if ((index = table.columnIndex( CogStaffBean.EMPLOYEE_NUMBER_FIELD)) != 0) {
				bean.setEMPLOYEE_NUMBER(result.getInt(index));
			}
			if ((index = table.columnIndex( CogStaffBean.LAST_NAME_FIELD)) != 0) {
				bean.setLAST_NAME(result.getString(index));
			}
			if ((index = table.columnIndex( CogStaffBean.FIRST_NAME_FIELD)) != 0) {
				bean.setFIRST_NAME(result.getString(index));
			}
			if ((index = table.columnIndex( CogStaffBean.MIDDLE_NAME_FIELD)) != 0) {
				bean.setMIDDLE_NAME(result.getString(index));
			}
			if ((index = table.columnIndex( CogStaffBean.TITLE_FIELD)) != 0) {
				bean.setTITLE(result.getString(index));
			}
			if ((index = table.columnIndex( CogStaffBean.EMPLOYEE_TYPE_FIELD)) != 0) {
				bean.setEMPLOYEE_TYPE(result.getString(index));
			}
			if ((index = table.columnIndex( CogStaffBean.SUPERVISOR_FIELD)) != 0) {
				bean.setSUPERVISOR(result.getInt(index));
			}
			if ((index = table.columnIndex( CogStaffBean.HIRING_DATE_FIELD)) != 0) {
				bean.setHIRING_DATE(result.getDate(index));
			}
			if ((index = table.columnIndex( CogStaffBean.LEFT_DATE_FIELD)) != 0) {
				bean.setLEFT_DATE(result.getDate(index));
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
			((CogStaffBean)bean).setCOG_STAFF_ID(result.getInt(1));
		}
	

}//end class CustomerFiller