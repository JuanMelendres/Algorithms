/*
    Juan Antonio Melendres Villa A00369017
    Martín Giovanni Esquivel A01633334
*/
//dp[i][j] = (arr[i] <= j) ? (dp[i-1][j] || dp[i-1][j-arr[i]]) : dp[i - 1][j];  impotance for sets that sum x line 61
import java.util.Scanner;
import java.util.Arrays;
import java.util.concurrent.RecursiveAction;
 
public class ParallelMergeSort extends RecursiveAction {
 
    // Decides when to fork or compute directly:
    private static final int THRESHOLD = 500;
 
    private final int[] values;
    private final int from;
    private final int to;
 
    public ParallelMergeSort(int[] values) {
        this(values, 0, values.length-1);
    }
 
    public ParallelMergeSort(int[] values, int from, int to) {
        this.values = values;
        this.from = from;
        this.to = to;
    }
 
    public void sort() {
        compute();
    }
 
    @Override
    protected void compute() {
        if (from < to) {
            int size = to - from;
            if (size < THRESHOLD) {
                insertionSort();
            } 
            else {
                int mid = from + Math.floorDiv(size, 2);
                invokeAll(new ParallelMergeSort(values, from, mid), new ParallelMergeSort(values, mid + 1, to));
                merge(mid);
            }
        }
    }
 
    private void insertionSort() {
        for (int i = from+1; i <= to; ++i) {
            int current = values[i];
            int j = i-1;
            while (from <= j && current < values[j]) {
                values[j+1] = values[j--];
            }
            values[j+1] = current;
        }
    }
 
    private void merge(int mid) {
        int[] left = Arrays.copyOfRange(values, from, mid+1);
        int[] right = Arrays.copyOfRange(values, mid+1, to+1);
        int f = from;
 
        int li = 0, ri = 0;
        while (li < left.length && ri < right.length) {
            if (left[li] <= right[ri]) {
                values[f++] = left[li++];
            } 
            else {
                values[f++] = right[ri++];
            }
        }
 
        while (li < left.length) {
            values[f++] = left[li++];
        }
 
        while (ri < right.length) {
            values[f++] = right[ri++];
        }
    }
    
    public static void main(String Args[]) {
        ParallelMergeSort ob;
        long TInicio, TFin, tiempo;
        System.out.println("Parallel MergeSort");
        Scanner in = new Scanner(System.in); 
        System.out.printf("Enter size:  ");
        int size = in.nextInt();
        int[] array = new int[size];
        System.out.println("Unsorted array");
        for (int i = 0; i < size; i++){
            int n = (int)(Math.random()*100000 + 1);
            array[i] = n;
        }
        System.out.println("Sorted array");
        TInicio = System.currentTimeMillis();
        ParallelMergeSort arr = new ParallelMergeSort(array);
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio; 
        System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
    }
}