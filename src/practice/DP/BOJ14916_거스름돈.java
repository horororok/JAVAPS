package practice.DP;

import java.util.Scanner;

public class BOJ14916_거스름돈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 2월과 5원짜리로만 거스름돈 구성
		// 동전의 개수가 최소가 되도록 거슬러 준다.
		// 거슬러 줄 수 없으면 -1 출력

		// 점화식
		// dp[k] = min(dp[n-2], dp[n-5])+1 (n>5)

		int N = sc.nextInt();

		int[] arr = { -1, -1, 1, -1, 2, 1 };
		int[] dp = new int[N + 1];

		if (N < 6) {
			System.out.println(arr[N]);
			return;
		} else {
			for (int i = 0; i < 6; i++) {
				dp[i] = arr[i];
			}
		}

		for (int i = 6; i < N + 1; i++) {
			if (dp[i - 2] != -1 && dp[i - 5] != -1) {
				dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
			} else if (dp[i - 2] == -1 && dp[i - 5] != -1) {
				dp[i] = dp[i - 5] + 1;
			} else if (dp[i - 2] != -1 && dp[i - 5] == -1) {
				dp[i] = dp[i - 2] + 1;
			}
		}

		System.out.println(dp[N]);

	}

}