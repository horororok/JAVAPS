package practice.DP;

import java.util.Scanner;

public class BOJ2839_설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 3키로 봉지와 5키로 봉지를 이용해서 N키로그램 만들기
		// 최대한 적은 봉지의 수
		// 정확하게 N을 만들지 못하면 -1 출력

		//4와 7은 만들 수 없다
		
		// 점화식
		// p(n) = min(p(n-3), p(n-5)) + 1 (n>=8)

		int N = sc.nextInt();

		int[] dp = new int[N + 1];
		//0 1 4 7 은 만들 수 없으므로 -1
		int[] arr = { -1, -1, -1, 1, -1, 1, 2, -1 };

		if (N <= 7) {
			System.out.println(arr[N]);
			return;
		} else {
			for (int i = 0; i <= 7; i++) {
				dp[i] = arr[i];
			}
		}

		//8부터 점화식 적용 ~ N까지
		for (int i = 8; i <= N; i++) {
			//둘다 -1이 아니면 3키로짜리 봉지 쓴 것과 5키로 짜리 봉지 쓴것중 작은값 +1 한값을 dp배열에 넣어줌
			if (dp[i - 5] != -1 && dp[i - 3] != -1) {
				dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
			}
			//5키로 짜리 봉지를 썼을 때 만들 수 없는 수를 만나면 3키로짜리 봉지 쓴것 +1 한값을 dp배열에 넣어줌
			else if (dp[i - 5] == -1 && dp[i - 3] != -1) {
				dp[i] = dp[i - 3] + 1;
			}
			//3키로 짜리 봉지를 썼을 때 만들 수 없는 수를 만나면 5키로짜리 봉지 쓴것 +1 한값을 dp배열에 넣어줌
			else if (dp[i - 5] != -1 && dp[i - 3] == -1) {
				dp[i] = dp[i - 5] + 1;
			}

		}

		System.out.println(dp[N]);

	}

}