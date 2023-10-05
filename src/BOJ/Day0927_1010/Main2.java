package BOJ.Day0927_1010;

import java.util.Scanner;

public class Main2 {

    // memoization
    static int[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        memo = new int[31][31];

        for (int tc = 0; tc < T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int ans = comb(M, N);
            System.out.println(ans);
        }
    }

    public static int comb(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else if (k < 0 || k > n) {
            return 0;
        } else if (memo[n][k] != 0) {
            return memo[n][k]; 
        } else {
            // C(n, k) = C(n-1, k-1) + C(n-1, k)
            memo[n][k] = comb(n - 1, k - 1) + comb(n - 1, k);
            return memo[n][k];
        }
    }
}
