package ro.generic.parser.objects;

import ro.generic.parser.objects.SqlTable;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: daniel
 * Date: Nov 21, 2005
 * Time: 11:13:20 PM
 * To change this template use Options | File Templates.
 */
public class ParsedSql {

    public ParsedSql() {
    }



	private int noOfParameters = 0;
    private ArrayList tables = new ArrayList();
    private ArrayList fields = new ArrayList();

    public ArrayList getTables() {
        return tables;
    }

    public void addTables(SqlTable table) {
        this.tables.add(table);
    }

    public ArrayList getFields() {
        return fields;
    }

    public void addField(SqlField field) {
        this.fields.add(field);
    }
	public int getNoOfParameters() {
		return noOfParameters;
	}

	public void setNoOfParameters(int noOfParameters) {
		this.noOfParameters = noOfParameters;
	}
}
