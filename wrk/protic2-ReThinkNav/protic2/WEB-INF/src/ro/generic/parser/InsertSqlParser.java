package ro.generic.parser;

import ro.generic.parser.objects.ParsedSql;
import ro.generic.parser.objects.SqlTable;
import ro.generic.parser.objects.SqlField;

import java.util.StringTokenizer;

import ro.auto.dao.BeanFactory;

/**
 * Created by IntelliJ IDEA.
 * User: dani
 * Date: Nov 21, 2005
 * Time: 11:28:37 AM
 * To change this template use Options | File Templates.
 */
public class InsertSqlParser extends GenericParser{

	public InsertSqlParser(){
	}
//	"INSERT INTO users " +
//	        "(UserID, Username, Firstname, Lastname, DateOfBirth, Gender, Address, ZIP_Code, City, Note, CountryCode, AccountID, DefaultPhoneNumber, Optional1, Optional2, Optional3)" +
//	        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public ParsedSql parse(String sql){
        ParsedSql parsedSql = new ParsedSql();
		String upperSql = sql.toUpperCase();
		int pINTO = 0;
        if (upperSql.indexOf(" INTO ") != -1)
          pINTO = upperSql.indexOf(" INTO ") + 6;
        else
          pINTO = upperSql.indexOf("INSERT ") + 7;
        int bracketPos = upperSql.indexOf("(");
        int lastBracketPos = upperSql.indexOf(")");
        int bracketPosLast = upperSql.lastIndexOf("(");
        int lastBracketPosLast = upperSql.lastIndexOf(")");
        String  tableName = sql.substring(pINTO, bracketPos).trim();
		System.out.println("Table - > " + tableName);

        parsedSql.addTables(new SqlTable(tableName));

		String fields = sql.substring(bracketPos+1,lastBracketPos);
		String values = sql.substring(bracketPosLast+1,lastBracketPosLast);
        fields = replaceQuote(fields);
		values = replaceQuote(values);

		StringTokenizer st = new StringTokenizer(fields,",");
		StringTokenizer stvalues = new StringTokenizer(values,",");

		int index = 0;
		while (st.hasMoreElements() && stvalues.hasMoreElements()){
			String column = st.nextToken().trim();
			String value = stvalues.nextToken().trim();
			if (value.equals("?")) {
                int fieldIndex = BeanFactory.getFielIndex(((SqlTable)parsedSql.getTables().get(0)).getTableId(),column);
                parsedSql.addField(new SqlField(column,(SqlTable)parsedSql.getTables().get(0), fieldIndex));
//				System.out.println("[" + column +"] - ["+value + "] <-> " + index);
				index++;
			}
		}
     return parsedSql;
	}
}
