package ro.generic.parser.objects;

import ro.auto.dao.Tables;

/**
 * Created by IntelliJ IDEA.
 * User: daniel
 * Date: Nov 21, 2005
 * Time: 11:14:06 PM
 * To change this template use Options | File Templates.
 */
public class SqlTable {
    private String tableName = null;
    private String tableAlias = null;
	private int tableId = -1;

    public SqlTable(String tableName) {
        this.tableName = tableName;
	    tableId = Tables.getTableIndex(tableName);
    }
    public SqlTable(String tableName, String tableAlias) {
        this.tableName = tableName;
        this.tableAlias = tableAlias;
	    tableId = Tables.getTableIndex(tableName);
    }

    public String getTableName() {
        return tableName;
    }

    public String getTableAlias() {
        return tableAlias;
    }

	public int getTableId() {
		return tableId;
	}
}
