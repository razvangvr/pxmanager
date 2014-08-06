package ro.generic.parser;

import ro.generic.parser.objects.ParsedSql;
import ro.generic.parser.objects.SqlField;
import ro.generic.parser.objects.SqlTable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.auto.dao.fill.FillFactory;
import ro.generic.dao.filler.StatmentResultSetFill;
import ro.auto.dao.BeanFactory;
import ro.auto.beans.GenericBean;

/**
 * Created by IntelliJ IDEA.
 * User: dani
 * Date: Nov 22, 2005
 * Time: 10:56:08 AM
 * To change this template use Options | File Templates.
 */
public class FillBeans {

	public Object fillBean(ResultSet rs, ParsedSql psql) throws SQLException {
		ArrayList beans  = new ArrayList();
		ArrayList tables = new ArrayList();
		ArrayList fillers = new ArrayList();

		SqlField sqlf = (SqlField) psql.getFields().get(0);
		if (sqlf.getTable() == null && sqlf.getFieldName().equals("*")){
			/// all fieds required
			int index =0;
			for (int i = 0; i < psql.getTables().size(); i++) {
				SqlTable sqlTable = (SqlTable) psql.getTables().get(i);
				StatmentResultSetFill stsmt = getFiller(tables,sqlTable,fillers,beans);
				ro.auto.beans.GenericBean theBean = getBean(tables,sqlTable,beans);
				for (int j = 0; j < BeanFactory.getFielsNumber(sqlTable.getTableId()); j++) {
					stsmt.fillBean(theBean,rs,++index,j);
				}

			}
		} else {
		int index =0;
		for (int i = 0; i < psql.getFields().size(); i++) {
			  sqlf = (SqlField) psql.getFields().get(i);
			  if (sqlf.getFieldName().equals("*")){
				  StatmentResultSetFill stsmt = getFiller(tables,sqlf.getTable(),fillers,beans);
				  ro.auto.beans.GenericBean theBean = getBean(tables,sqlf.getTable(),beans);
				  for (int j = 0; j < BeanFactory.getFielsNumber(sqlf.getTable().getTableId()); j++) {
				    stsmt.fillBean(theBean,rs,++index,j);
				  }
			  } else {
				StatmentResultSetFill stsmt = getFiller(tables,sqlf.getTable(),fillers,beans);
				ro.auto.beans.GenericBean theBean = getBean(tables,sqlf.getTable(),beans);
				stsmt.fillBean(theBean,rs,++index,sqlf.getFieldIndex());
			  }
		}
		}
        if (beans.size() == 1) return beans.get(0);
		return beans;
	}
	public StatmentResultSetFill getFiller(ArrayList tables,SqlTable table,ArrayList fillers,ArrayList beans){
		if (!isInitializedTable(tables,table))
			initTable(tables,table,fillers,beans);
			return (StatmentResultSetFill)fillers.get(getLocalTableIndex(tables,table));
	}
	public void initTable(ArrayList tables,SqlTable table,ArrayList fillers,ArrayList beans){
		  tables.add(table);
		  fillers.add(FillFactory.getFiller(table.getTableId()));
		  beans.add(BeanFactory.getBean(table.getTableId()));
	}
	public boolean isInitializedTable(ArrayList tables,SqlTable table){
		for (int i = 0; i < tables.size(); i++) {
			if (((SqlTable) tables.get(i)).equals(table)) return true;
		}
		return false;
	}

	public ro.auto.beans.GenericBean getBean(ArrayList tables,SqlTable table, ArrayList beans){
		for (int i = 0; i < tables.size(); i++) {
			if (((SqlTable) tables.get(i)).equals(table))
				return (ro.auto.beans.GenericBean)beans.get(i);
		}
		return null;
	}

	public int getLocalTableIndex(ArrayList tables,SqlTable table){
		for (int i = 0; i < tables.size(); i++) {
			if (((SqlTable) tables.get(i)).equals(table)) return i;
		}
		return -1;
	}

}
