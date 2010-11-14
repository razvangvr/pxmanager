/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package raz.pex.util;

/**
 *
 * @author razvan
 */
public class Assert {

    public static void assertNotNull(Object subject, String message){
        if(null == subject) {
            throw new IllegalArgumentException(message);
        }
    }

}
