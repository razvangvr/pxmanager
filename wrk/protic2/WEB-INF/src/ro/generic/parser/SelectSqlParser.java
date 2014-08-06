package ro.generic.parser;

import ro.generic.parser.objects.*;

import java.util.StringTokenizer;

import ro.auto.dao.BeanFactory;

/**
 * Created by IntelliJ IDEA.
 * User: dani
 * Date: Nov 21, 2005
 * Time: 11:28:37 AM
 * To change this template use Options | File Templates.
 */
public class SelectSqlParser extends GenericParser{

    public SelectSqlParser(){
    }
//	"INSERT INTO users " +
//	        "(UserID, Username, Firstname, Lastname, DateOfBirth, Gender, Address, ZIP_Code, City, Note, CountryCode, AccountID, DefaultPhoneNumber, Optional1, Optional2, Optional3)" +
//	        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public ParsedSql parse(String sql){
        ParsedSql parsedSql = new ParsedSql();

        sql = sql.trim();
        String upperSql = sql.toUpperCase();

        if (upperSql.lastIndexOf(" FROM ") == -1) {
            System.out.println("Sql Parser -> missing 'FROM' "  + sql );
            return null;
        }
	    int count=0;
		for (int i = 0; i < upperSql.length() ; i++) {
			if (upperSql.charAt(i)=='?')
				count++;
		}
		parsedSql.setNoOfParameters(count);

        int fromPos = upperSql.lastIndexOf(" FROM ");
        int wherePos = upperSql.lastIndexOf(" WHERE ");
        String tables = null;
        if (wherePos == -1)
            tables = sql.substring(fromPos + 6).trim();
        else
            tables = sql.substring(fromPos + 6, wherePos).trim();

//        System.out.println("tables ->" + tables);

        boolean haveAlias = false;
        if (upperSql.indexOf(" AS ") > 0) haveAlias = true;
        if (upperSql.indexOf(" JOIN ") > 0) {
            tables = removeJoinWords(tables);
        }
        StringTokenizer tokenizerTabels = new StringTokenizer(tables,",");
        String resultTables = "";
        while (tokenizerTabels.hasMoreTokens()) {
            String strTable = tokenizerTabels.nextToken().trim();
            count = 0;

            for (int i = 0; i < strTable.length() -1 ; i++) {
                if (strTable.charAt(i)==' ' && strTable.charAt(i+1)!=' ')
                    count++;
            }
            if (count == 1) {
                strTable = strTable.replaceFirst(" "," AS ");
                haveAlias = true;
            } else if (count == 2) haveAlias = true;
            resultTables += strTable + ",";
//            System.out.println("TOKI - " + strTable + " spaces =" + count);
        }
        tables = resultTables;

//        System.out.println("TABLES AFTER REMOVE JOINS ->" + tables);
        if (haveAlias) tables=tables.replaceAll(" ",",");
        tokenizerTabels = new StringTokenizer(tables,",");
        while (tokenizerTabels.hasMoreTokens()) {
            String strTable = tokenizerTabels.nextToken().trim();
            String strAS = "";
            String strALIAS = "";
            if (haveAlias) {
                if (tokenizerTabels.hasMoreTokens())
                    strAS = tokenizerTabels.nextToken().trim();
                if (tokenizerTabels.hasMoreTokens())
                    strALIAS = tokenizerTabels.nextToken().trim();
            }
            System.out.println("Table ->[" + strTable + "][" + strALIAS +"]");
            parsedSql.addTables(new SqlTable(strTable,strALIAS));

        }

//        } else {
//            if (haveAlias) tables=tables.replaceAll(" ",",");
//            StringTokenizer tokenizerTabels = new StringTokenizer(tables,",");
//            while (tokenizerTabels.hasMoreTokens()) {
//                String strTable = tokenizerTabels.nextToken().trim();
//                String strAS = "";
//                String strALIAS = "";
//                if (haveAlias) {
//                    if (tokenizerTabels.hasMoreTokens())
//                        strAS = tokenizerTabels.nextToken().trim();
//                    if (tokenizerTabels.hasMoreTokens())
//                        strALIAS = tokenizerTabels.nextToken().trim();
//                }
//                System.out.println("Table ->[" + strTable + "][" + strALIAS +"]");
//                parsedSql.addTables(new SqlTable(strTable,strALIAS));
//            }
//        }


        String fields = sql.substring(6,fromPos).trim();
        fields =  replaceChars(fields);
        System.out.println("fields ->" + fields);
        int index = 0;
        StringTokenizer tokenizerWhere = new StringTokenizer(fields," ");
        if (!tokenizerWhere.hasMoreTokens()){
            //// all fields from tables needed !!!!!!!!!!!!!!!!!!
        }
        while (tokenizerWhere.hasMoreTokens()) {
            String strToken = tokenizerWhere.nextToken();
            strToken.trim();
            System.out.println("column [" + strToken + "]");
            if (strToken.indexOf('.') > 0){
                String alias = strToken.substring(0,strToken.indexOf('.'));
                strToken = strToken.substring(strToken.indexOf('.') + 1);
                System.out.println("alias [" + alias + "]" + "  column [" + strToken + "]");
                for (int i = 0; i < parsedSql.getTables().size(); i++) {
                    SqlTable sqlTable =(SqlTable) parsedSql.getTables().get(i);
                    if (checkName(sqlTable,alias)){
                        int fieldIndex = BeanFactory.getFielIndex(sqlTable.getTableId(),strToken);
                        parsedSql.addField(new SqlField(strToken,sqlTable,fieldIndex));
                        break;
                    }
                }
            } else {
                if (strToken.equals("*")) {
                    parsedSql.addField(new SqlField(strToken,null,-1));
                } else if (parsedSql.getTables().size()==1) {
                    int fieldIndex = BeanFactory.getFielIndex(((SqlTable)parsedSql.getTables().get(0)).getTableId(),strToken);
                    parsedSql.addField(new SqlField(strToken,(SqlTable)parsedSql.getTables().get(0), fieldIndex));
                } else {
                    for (int i = 0; i < parsedSql.getTables().size(); i++) {
                        SqlTable sqlTable =(SqlTable) parsedSql.getTables().get(i);
                        int fieldIndex = BeanFactory.getFielIndex(sqlTable.getTableId(),strToken);
                        if (fieldIndex >=0) {
                            parsedSql.addField(new SqlField(strToken,sqlTable,fieldIndex));
                            break;
                        }

                    }
                }



            }

        }
        return parsedSql;
    }
    private boolean checkName(SqlTable sqlTable,String name){
        if (sqlTable.getTableName().equals(name)) return true;
        if (sqlTable.getTableAlias()!=null && sqlTable.getTableAlias().equals(name)) return true;
        return false;
    }
    private String removeJoinWords(String joinStr){
        String[] extraWords = { " INNER ",
                                " CROSS ",
                                " STRAIGHT_JOIN ",
                                " LEFT ",
                                " OUTER ",
                                " NATURAL ",
//								" ON",
                                " RIGHT"
//								" JOIN"
        };
        String upperJoinStr = joinStr.toUpperCase();
        for (int i = 0; i < extraWords.length; i++) {
            boolean found = true;
            while (found) {
                found = false;
                int index = upperJoinStr.indexOf(extraWords[i]);
                if (index > 0){
                    joinStr = joinStr.substring(0,index +1) + joinStr.substring(index + extraWords[i].length());
                    upperJoinStr = joinStr.toUpperCase();
                    found = true;
                }
            }
        }
        boolean found = true;
        while (found){
            found = false;
            int indexON = upperJoinStr.indexOf(" ON ");
            int indexJOIN = upperJoinStr.indexOf(" JOIN ", indexON);
            if (indexON > 0){
                if (indexJOIN > 0){
                    joinStr = joinStr.substring(0,indexON +1) + joinStr.substring(indexJOIN);
                    upperJoinStr = joinStr.toUpperCase();
                    found = true;
                } else {
                    joinStr = joinStr.substring(0,indexON +1);
                    upperJoinStr = joinStr.toUpperCase();
                    found = true;
                }
            }
        }
        found = true;
        while (found){
            found = false;
            int indexJOIN = upperJoinStr.indexOf(" JOIN ");
            if (indexJOIN > 0){
                joinStr = joinStr.substring(0,indexJOIN +1) + "," + joinStr.substring(indexJOIN + 6);
                upperJoinStr = joinStr.toUpperCase();
                found = true;
            }
        }
//        joinStr =  joinStr.replaceAll(" ",",");
        System.out.println("joinString->" + joinStr );
        return joinStr;
    }
}
