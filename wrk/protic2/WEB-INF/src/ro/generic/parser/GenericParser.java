package ro.generic.parser;

/**
 * Created by IntelliJ IDEA.
 * User: dani
 * Date: Nov 21, 2005
 * Time: 11:49:18 AM
 * To change this template use Options | File Templates.
 */
public class GenericParser {
	protected String replaceChars(String sql){
				return sql.replace('(',' ')
				        .replace(')',' ')
		                .replace('=',' ')
				        .replace('>',' ')
				        .replace('<',' ')
				        .replace('!',' ')
				        .replace(',',' ')
				        .replace('\'',' ');

	}
	protected String replaceQuote(String sql){
				return sql
				        .replace('\'',' ');
	}
	protected String replaceBrackets(String sql){
		return sql
		        .replace('(',' ')
		        .replace(')',' ');
	}
}
