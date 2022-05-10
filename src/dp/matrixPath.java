package dp;

import static sun.swing.MenuItemLayoutHelper.max;

public class matrixPath {

    public static int dp(int a[][], int n) {
       int[][] cost = new int[n][n];
       cost[0][0] = a[0][0];

       for(int i = 1; i < n; i++) {
           cost[i][0] = a[i][0] + cost[i-1][0];
       }

       for(int j = 1; j < n; j++) {
           cost[0][j] = a[0][j] + cost[0][j-1];
       }

       for(int i = 1; i < n; i++) {
           for(int j = 1; j < n; j++) {
               cost[i][j] = a[i][j] + max(cost[i-1][j], cost[i][j-1]);
           }
       }

       return cost[n-1][n-1];
    }

    public static void main(String[] args) {
        int[][]a = new int[][] {{6, 7, 12, 5}, {5, 3, 11, 18}, {7, 17, 3, 3}, {8, 10, 14, 9}};
        int n = a[0].length;

        int maxSum = dp(a, n);

        System.out.println(maxSum);
    }
}
