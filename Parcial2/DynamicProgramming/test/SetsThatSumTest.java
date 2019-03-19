/*
    Juan Antonio Melendres Villa A00369017
    Martín Giovanni Esquivel A01633334
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author juanantoniomelendresvilla
 */
public class SetsThatSumTest {
    
    public SetsThatSumTest() {
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
     * Test of printAllSubsets method, of class SetsThatSum.
     */
    @Test
    public void test1() {
        System.out.println("Test 1");
        int arr[] = {1, 2, 3, 4, 5}; 
        int n = arr.length; 
        int sum = 10; 
        SetsThatSum.printAllSubsets(arr, n, sum);
    }

    /**
     * Test of printAllSubsets method, of class SetsThatSum.
     */
    @Test
    public void test2() {
        System.out.println("Test 2");
        int[] arr = {3, 34, 4, 12, 5, 2};
        int n = arr.length;
        int sum = 9;
        SetsThatSum.printAllSubsets(arr, n, sum);
    }
    
    /**
     * Test of printAllSubsets method, of class SetsThatSum.
     */
    @Test
    public void test3() {
        System.out.println("Test 3");
        int[] arr = {2, 4, 6, 10};
        int n = arr.length;
        int sum = 16;
        SetsThatSum.printAllSubsets(arr, n, sum);
    }
    
}
