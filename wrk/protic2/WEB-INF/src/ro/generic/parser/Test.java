package ro.generic.parser;

import ro.generic.parser.objects.SqlTable;
import ro.generic.parser.objects.SqlField;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: daniel
 * Date: Nov 21, 2005
 * Time: 11:22:48 PM
 * To change this template use Options | File Templates.
 */
public class Test {
    public static void main(String[] a){
        Random r = new Random();
        java.util.Hashtable list = new java.util.Hashtable();
        SqlTable sql = new SqlTable(r.nextFloat() + "",r.nextFloat() + "");
        for (int i = 0; i < 10000; i++) {
//            list.put(r.nextFloat() + "",new SqlField(r.nextFloat() + "",fill));
        }
        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
        }
    }
}
