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
public class UpdateSqlParser extends GenericParser{

	public UpdateSqlParser(){
	}

	public ParsedSql parse(String sql){
		ParsedSql parsedSql = new ParsedSql();

		String upperSql = sql.toUpperCase();
		int count = 0;
		for (int i = 0; i < upperSql.length() ; i++) {
			if (upperSql.charAt(i)=='?')
				count++;
		}
		parsedSql.setNoOfParameters(count);
		int updatePos = upperSql.indexOf("UPDATE");
		int setPos = upperSql.indexOf(" SET ");
		int equalPos = upperSql.indexOf("=");
		int wherePos = upperSql.indexOf(" WHERE ");

		String tableName = sql.substring(updatePos + 6, setPos).trim();
		System.out.println("table ->" + tableName);
        parsedSql.addTables(new SqlTable(tableName));
		String setString = "";
		if (wherePos != -1)
			setString = sql.substring(setPos + 5, wherePos);
		else
			setString = sql.substring(setPos + 5, sql.length());
		setString = replaceBrackets(setString);
		StringTokenizer tokenizerSet = new StringTokenizer(setString, ",");


		System.out.println(setString);
//		int index = 0;
		while (tokenizerSet.hasMoreTokens()) {
		    String strToken = tokenizerSet.nextToken();
			int delimiter = strToken.indexOf("=");
			String column = strToken.substring(0, delimiter).trim();
			String value = strToken.substring(delimiter + 1).trim();
			if (value.equals("?")) {
//				System.out.println("[" + column +"]" );
				int fieldIndex = BeanFactory.getFielIndex(((SqlTable)parsedSql.getTables().get(0)).getTableId(),column);
				if ( fieldIndex >=0 )
						parsedSql.addField(new SqlField(column,(SqlTable)parsedSql.getTables().get(0), fieldIndex));
			}

		}

		if (wherePos != -1) {
		    String strWhere = sql.substring(wherePos + 6).trim();
			strWhere = replaceChars(strWhere);
			System.out.println("where ->" + strWhere);
			StringTokenizer tokenizerWhere = new StringTokenizer(strWhere,"?",true);
			while (tokenizerWhere.hasMoreTokens()) {
				String strToken = tokenizerWhere.nextToken().trim();
				String delim = tokenizerWhere.hasMoreTokens()?tokenizerWhere.nextToken():"";
				if (delim.equals("?")){
					String column = strToken;
					if (strToken.lastIndexOf(" ") >= 0)
					column = strToken.substring(strToken.lastIndexOf(" "));
					column = column.trim();
//					System.out.println("[" + column +"] " );
					int fieldIndex = BeanFactory.getFielIndex(((SqlTable)parsedSql.getTables().get(0)).getTableId(),column);
					parsedSql.addField(new SqlField(column,(SqlTable)parsedSql.getTables().get(0), fieldIndex));

				}
			}
		}
		return parsedSql;
	}
}
