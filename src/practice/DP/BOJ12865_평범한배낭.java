package practice.DP;

import java.util.Scanner;

public class BOJ12865_평범한배낭 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 물품의 수 N
		// 버틸 수 있는 무게 K
		// 각 물건의 무게 W 물건의 가치 V 가 N번 주어진다
		// 배낭에 넣을 수 있는 물건들의 가치합의 최댓값 출력

		// 재귀적으로 정리
		// w까지의 무게 중에 최대 가치를 갖는 경우는
		// 0번째 이거나 무게가 0일 경우 : 0
		// i번째 물건의 무게가 임시최대무게보다 무거울 경우(해당 무게에서의 최적해)
		// dp[i][w] = dp[i-1][w] 이전 순서의 물건 을 넣었을 때 최대 가치와 같다
		// 첫번째 물건 이고 물건 무게가 임시최대무게보다 가벼운 경우
		// dp[i][w] = dp[i-1][w-weights[i]] + values[i]
		// 이전 순서의 물건을 넣었을 때 임시최대무게에서 현재 물건의 무게를 뺀값에서의 최대 가치에 현재 물건의 가치를 더한 것과 같다.

		int N = sc.nextInt();
		int K = sc.nextInt();

		// 물건의 무게들과 가치들을 넣어줄 배열
		int[] weights = new int[N + 1];
		int[] values = new int[N + 1];

		for (int i = 1; i < N+1; i++) {
			int W = sc.nextInt();
			int V = sc.nextInt();

			weights[i] = W;
			values[i] = V;
		}

		// dp배열 만들어줌
		// 물건개수와 무게
		int[][] dp = new int[N + 1][K + 1];

		// 첫 행은 0으로 초기화
		// 1~ N번째의 물건(i번째 물건)
		for (int i = 1; i < N + 1; i++) {
			// w : 임시최대무게
			for (int w = 1; w < K + 1; w++) {
				// 현재 무게가 임시최대무게보다 가벼울 경우(가방에 넣을 수 있다.)
				if (weights[i] <= w) {
					// 현재 무게에서의 최적해 dp[i-1][w] (최적해가 i번째 물건을 포함하지 않는 경우 전체 가치는 그 전과 동일)
					// 현재 무게에서 i번째 물건을 고려한 최적해 (최적해가 i번째 물건을 포함하는 경우 전체 가치는 i번째 물건의 가치 + 첫번째 물건부터
					// i-1번째 물건까지 고려하여 현재 임시최대무게의 용량(w-(i번째 물건의 무게))인 경우의 최대 가치)
					// dp[i-1][w-weights[i]]+values[i]
					// 두 값 중 더 큰값 선택
					dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i]] + values[i]);
				}
				// 현재 무게가 임시최대무게보다 무거운경우(가방에 넣을 수 없다)
				else {
					dp[i][w] = dp[i - 1][w];
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}