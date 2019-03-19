/*
    Juan Antonio Melendres Villa A00369017
    Martín Giovanni Esquivel A01633334
*/

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CountPathsTest {
    
    public CountPathsTest() {
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
     * Test of result method, of class CountPaths.
     */
    @Test
    public void test1() {
        System.out.println("Test 1");
        CountPaths res = new CountPaths();
        int[][] m = {{0,0,0,0,0,1,0},{0,0,0,0,0,0,0},{0,1,0,1,0,0,0},{0,0,1,0,0,0,0},{0,0,0,0,0,1,0},{0,0,0,0,0,0,0}};
        CountPaths.result(res, m);
    }

    /**
     * Test of result method, of class CountPaths.
     */
    @Test
    public void tes2() {
        System.out.println("Test 2");
        CountPaths res = new CountPaths();
        int[][] m = {{0,0,0,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,1,0},{0,0,0,0,0}};
        CountPaths.result(res, m);
    }
    
    /**
     * Test of result method, of class CountPaths.
     */
    @Test
    public void test3() {
        System.out.println("Test 3");
        CountPaths res = new CountPaths();
        int[][] m = {{0,0,0},{0,0,0},{0,0,0}};
        CountPaths.result(res, m);
    }
}
