package ro.utils;

import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Jun 16, 2004
 * Time: 8:09:52 PM
 * To change this template use Options | File Templates.
 */
public class DateUtils {

    public static synchronized java.sql.Date getDate( String textDate )
                              throws Exception
    {
      if(textDate.length() != 10
        || (textDate.charAt(2)!= '-' && textDate.charAt(2)!= '.' && textDate.charAt(2)!= '/' && textDate.charAt(2)!= ' ' )
        || (textDate.charAt(5)!= '-' && textDate.charAt(5)!= '.' && textDate.charAt(5)!= '/' ) && textDate.charAt(5)!= ' ')
              throw new Exception("Bad date format: "+ textDate);

      java.text.SimpleDateFormat sdfInput =
         new SimpleDateFormat( "dd"+textDate.charAt(2)+"MM"+textDate.charAt(5)+"yyyy" );

//    SimpleDateFormat sdfOutput =
//       new SimpleDateFormat ( "MM/dd/yyyy" );

      java.util.Date d = sdfInput.parse( textDate );
      java.sql.Date date = new Date(d.getTime());
//    System.out.println( sdfOutput.format( date ) );
      return date;
    } // main

    public static synchronized java.util.Date getJavaDate( String textDate )
                              throws Exception
    {
      if(textDate.length() != 10
        || (textDate.charAt(2)!= '-' && textDate.charAt(2)!= '.' && textDate.charAt(2)!= '/' && textDate.charAt(2)!= ' ' )
        || (textDate.charAt(5)!= '-' && textDate.charAt(5)!= '.' && textDate.charAt(5)!= '/' ) && textDate.charAt(5)!= ' ')
              throw new Exception("Bad date format: "+ textDate);

      java.text.SimpleDateFormat sdfInput =
         new SimpleDateFormat( "dd"+textDate.charAt(2)+"MM"+textDate.charAt(5)+"yyyy" );

//    SimpleDateFormat sdfOutput =
//       new SimpleDateFormat ( "MM/dd/yyyy" );

      return sdfInput.parse( textDate );
    } // main


    public static synchronized String getDate( java.util.Date date )
                              throws Exception
    {
    if(date == null)
        return null;
    SimpleDateFormat sdfOutput =
       new SimpleDateFormat ( "dd-MM-yyyy" );
        try {
//    System.out.println( sdfOutput.format( date ) );
    } catch (Exception e){e.printStackTrace();}
      return sdfOutput.format( date );
    } // main

    public static synchronized String getDateToSQL( java.util.Date date )
                              throws Exception
    {
    SimpleDateFormat sdfOutput =
       new SimpleDateFormat ( "yyyy-MM-dd" );
        try {
//    System.out.println( sdfOutput.format( date ) );
    } catch (Exception e){e.printStackTrace();}
      return sdfOutput.format( date );
    } // main


    public static synchronized String getToday()
    {
        SimpleDateFormat sdfOutput = null;
        java.util.Date d = null;
      try {
        sdfOutput =
           new SimpleDateFormat ( "dd-MM-yyyy" );
        d = new java.util.Date();
    //    System.out.println( sdfOutput.format( date ) );
      } catch (Exception e){e.printStackTrace();}
        return sdfOutput.format( d );
    } // main

    public static synchronized String getSqlToRo ( String textDate )
                              throws Exception
    {
        if(textDate.length() != 10)
              throw new Exception("Bad date format: "+ textDate);
        String res = textDate.substring(8) + textDate.substring(7,8) + textDate.substring(5,7) + textDate.substring(4,5)+ textDate.substring(0,4);
      return res;
    } // main

    public static synchronized String getRoToSql( String textDate )
                              throws Exception
    {
      if(textDate.length() != 10
        || (textDate.charAt(2)!= '-' && textDate.charAt(2)!= '.' && textDate.charAt(2)!= '/' && textDate.charAt(2)!= ' ' )
        || (textDate.charAt(5)!= '-' && textDate.charAt(5)!= '.' && textDate.charAt(5)!= '/' ) && textDate.charAt(5)!= ' ')
              throw new Exception("Bad date format: "+ textDate);

      java.text.SimpleDateFormat sdfInput =
         new SimpleDateFormat( "dd"+textDate.charAt(2)+"MM"+textDate.charAt(5)+"yyyy" );

    SimpleDateFormat sdfOutput =
       new SimpleDateFormat ( "yyyy-MM-dd" );

      java.util.Date d = sdfInput.parse( textDate );
      java.sql.Date date = new Date(d.getTime());
//    System.out.println( sdfOutput.format( date ) );
      return sdfOutput.format( date ) ;
    } // main

}
