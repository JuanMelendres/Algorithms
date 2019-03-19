/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juanantoniomelendresvilla
 */
public class ParallelMergeSortTest {
    
    public ParallelMergeSortTest() {
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
     * Test of sort method, of class ParallelMergeSort.
     */
    @Test
    public void testSort() {
        System.out.println("sort");
        ParallelMergeSort instance = null;
        instance.sort();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compute method, of class ParallelMergeSort.
     */
    @Test
    public void testCompute() {
        System.out.println("compute");
        ParallelMergeSort instance = null;
        instance.compute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
     @Test
    public void performanceTest() {
        int[] serial = new Random().ints(100_000_000).toArray();
        int[] parallel = Arrays.copyOf(serial, serial.length);
 
        ParallelMergeSort sorter = new ParallelMergeSort(parallel);
        long start = System.currentTimeMillis();
        sorter.sort();
        System.out.println("Parallel Merge Sort done in: "
                + (System.currentTimeMillis()-start));
 
        assertArrayEquals(parallel, serial);
    }
    
}
