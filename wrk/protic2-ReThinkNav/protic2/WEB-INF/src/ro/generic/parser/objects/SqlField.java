package ro.generic.parser.objects;

import ro.generic.parser.objects.SqlTable;

/**
 * Created by IntelliJ IDEA.
 * User: daniel
 * Date: Nov 21, 2005
 * Time: 11:20:43 PM
 * To change this template use Options | File Templates.
 */
public class SqlField {
    private String fieldName;
    private SqlTable table;
	private int fieldIndex = -1;

    public SqlField(String fieldName, SqlTable table, int fieldIndex) {
        this.fieldName = fieldName;
        this.table = table;
	    this.fieldIndex = fieldIndex;
        System.out.println("Fied ->[" + fieldName + "][" +(table!=null?table.getTableName():"") + "][" + fieldIndex + "]");
    }

	public String getFieldName() {
		return fieldName;
	}

	public SqlTable getTable() {
		return table;
	}

	public int getFieldIndex() {
		return fieldIndex;
	}
}
