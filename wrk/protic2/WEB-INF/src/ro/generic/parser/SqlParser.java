package ro.generic.parser;

//import ro.mcr.mindx.beans.GenericBean;
//import ro.mcr.mindx.beans.UsersBean;

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;

/**
 * Created by IntelliJ IDEA.
 * User: dani
 * Date: Nov 18, 2005
 * Time: 1:23:31 PM
 * To change this template use Options | File Templates.
 */
public class SqlParser {

	String sqlu = "UPDATE users SET " +
	        "(UserID = ?, Username=?, Password=?, Firstname='name', Lastname=?, DateOfBirth=?, Gender=?, Address=?, ZIP_Code=?, City=?, Note=?, CountryCode=?, AccountID=?, DefaultPhoneNumber=?, Optional1=?, Optional2=?, Optional3=?) " +
	        "WHERE UserID=? AND Username=? OR (Password<>? OR Firstname<>'name') AND ISNULL(DateOfBirth) OR NOT Address<?";
//
	String sqli = "INSERT INTO users " +
	        " (UserID, 'Username', Firstname, Lastname, DateOfBirth, Gender, Address, ZIP_Code, City, Note, CountryCode, AccountID, DefaultPhoneNumber, Optional1, Optional2, Optional3)" +
	        "VALUES (?, ?, 'value2', ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//	String sqls = "SELECT " +
//	        "UserID, 'Username', Firstname, Lastname, DateOfBirth, Gender, Address, ZIP_Code, City, Note, CountryCode, AccountID, DefaultPhoneNumber, Optional1, Optional2, Optional3" +
//	        " FROM users ";

//	String sqls = "SELECT m.*  FROM mama as m,tata as t,sora as s";

//	String sqls = "SELECT m.meme,t.tete,s.sasa  FROM mama as m,tata as t,sora as s";
//	String sqls = "SELECT tat.id FROM mama AS mam left join tata As tat on mama.a=tata.b LEFT join sora as sor on tata.s=sora.c";
    String sqls = "select PrPDCode,posadistr.* from program left join posadistr on program.PrPDCode=posadistr.PDCode";
//	String sqls = "select PrPDCode,posadistr.PDCode from program left join posadistr on program.PrPDCode=posadistr.PDCode";

//    String sqls = "select * from program left join posadistr on program.PrPDCode=posadistr.PDCode";

//	String fill = "INSERT INTO users " +
///			"(UserID, Username, Password, Firstname, Lastname, DateOfBirth, Gender, Address, ZIP_Code, City, Note, CountryCode, AccountID, DefaultPhoneNumber, Optional1, Optional2, Optional3)" +
//			"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	List crudStatment = null;
	public SqlParser() {
//		InsertSqlParser inspParser = new InsertSqlParser();
//		inspParser.parse(sqli);
//		UpdateSqlParser updateParser = new UpdateSqlParser();
//		updateParser.parse(sqlu);
		SelectSqlParser selectParser = new SelectSqlParser();
		selectParser.parse(sqls);
	}

	public void pase(){extract();
//		if (fill.toLowerCase().startsWith("insert"))
//			parseInsert(fill);
//		if (fill.toLowerCase().startsWith("update"))
//			parseUpdate(fill);

	}

	public static void main(String[] args){
		SqlParser sp =  new SqlParser();
//		sp.pase();
	}
	public void extract(){
		String sql = "UPDATE users SET " +
		        "(UserID = '?', Username=?, Password=?, Firstname=?, Lastname=?, DateOfBirth=?, Gender=?, Address=?, ZIP_Code=?, City=?, Note=?, CountryCode=?, AccountID=?, DefaultPhoneNumber=?, Optional1=?, Optional2=?, Optional3=?) " +
		        "WHERE UserID=? limit ? , ?";
		int index = 0;
		int oldindex = index;
		sql = sql.replace('(',' ').replace(')',' ')
		        .replace('=',' ').replace('>',' ')
		        .replace('<',' ').replace('!',' ')
		        .replace(',',' ').replace('\'',' ');
		while ((index=sql.indexOf('?',index+1)) > 0){
			String column = sql.substring(oldindex,index).trim();
			column = column.substring(column.lastIndexOf(' ')).trim();

			System.out.println(column);
			oldindex = index;
		}


//		PreparedStatement ps;
//		ps.getParameterMetaData().
//		crudStatment = new ArrayList();
//		String theSql = fill;//.substring(fill.indexOf("(") + 1,fill.indexOf(")"));
//		System.out.println(theSql);
//		StringTokenizer st = new StringTokenizer(theSql,"?");
//		int index = 0;
//		while (st.hasMoreElements()){
//			String column = st.nextToken();
//			System.out.println(column + " = " + index);
//			crudStatment.add(new FieldIndex(column.trim(),index));
//			index++;
//		}

	}


}

