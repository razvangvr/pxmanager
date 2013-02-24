/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.apa.pdfwlserver.monitoring;

import at.apa.pdfwlserver.monitoring.data.ReportResult;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.quartz.JobExecutionContext;

/**
 *
 * @author razvan
 */
public class MonitoringProfileJobTest {
    
    public MonitoringProfileJobTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }



    /**
     * Razvan: Idee de test, (folosind TDD) cand implementezi logica de check() si status result
     * 
     * iti creezi o structura de test pentru derstandard si pui acolo in subDir fisire mock de .zip
     * 
     * si daca exista fisierul .zip in subDir "incoming" si isWithinTimePoint, ma astept la status "not processed yet"
     * 
     * Razvan: o alta idee puneti <code>interface</code> peste metodele gen isWithinTimePoint(), 
     * ca sa pot testa mai usor si automat. Daca am interfete pot sa fac mock-uri, 
     * si nu trebe sa astept sa se indeplineasca conditia de timp astfel ca isWithinTimePoint() sa intoarca ce am eu nevoie in test-case
     * 
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        MonitoringProfileJob instance = new MonitoringProfileJob();
        ReportResult expResult = null;
        ReportResult result = instance.check();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
