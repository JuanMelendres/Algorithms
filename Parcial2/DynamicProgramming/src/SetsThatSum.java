/*
    Juan Antonio Melendres Villa A00369017
    Martín Giovanni Esquivel A01633334
*/

import java.util.ArrayList; 

public class SetsThatSum {
    // DP is going to store true if sum j is possible
    static boolean[][] dp; 
    
    public static void display(ArrayList<Integer> a) { 
        System.out.println(a); 
    } 
    
    // A recursive function to print all subsets with the help of dp[][].
    public static void findSubsets(int arr[], int i, int sum, ArrayList<Integer> p) { 
        // If we reached end and sum is non-zero we print p[]
        if (i == 0 && sum != 0 && dp[0][sum]) { 
            p.add(arr[i]); 
            display(p); 
            p.clear(); 
            return; 
        } 
        // If sum becomes 0 
        if (i == 0 && sum == 0) { 
            display(p); 
            p.clear(); 
            return; 
        } 
        // If given sum can be achieved after ignoring current element. 
        if (dp[i - 1][sum]) { 
            // Create a new vector to store path 
            ArrayList<Integer> b = new ArrayList<>(); 
            b.addAll(p); 
            findSubsets(arr, i - 1, sum, b); 
        } 
        // If given sum can be achieved after considering current element. 
        if (sum >= arr[i] && dp[i - 1][sum - arr[i]]) { 
            p.add(arr[i]); 
            findSubsets(arr, i - 1, sum - arr[i], p); 
        } 
    } 
    
    // Prints all subsets
    public static void printAllSubsets(int arr[], int n, int sum) { 
        if (n == 0 || sum < 0) {
           return; 
        }
        dp = new boolean[n][sum + 1]; 
        for (int i = 0; i < n; i++) { 
            dp[i][0] = true;   
        } 
        if (arr[0] <= sum) {
           dp[0][arr[0]] = true; 
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < sum + 1; ++j) {
                if(arr[i] <= j) {
                    dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - arr[i]]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        if (dp[n - 1][sum] == false) { 
            System.out.println("No subsets with " +  "sum = " + sum); 
            return; 
        } 
        ArrayList<Integer> p = new ArrayList<>(); 
        findSubsets(arr, n - 1, sum, p); 
    } 
    
}
