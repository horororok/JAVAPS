package BOJ.Day1004_2294;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 사용한 동전의 최소 개수 출력, 불가능한 경우 -1 출력
		// n가지 종류의 동전
		// 최소로 쓰면서 가치의 합이 k원이 되도록 만든다.
		// 같은 가치의 동전이 여러 개 나올 수 있다.

		// 점화식
		// dp[n] = min(dp[n], dp[n-동전가치]+1)

		int N = sc.nextInt();
		int K = sc.nextInt();

		// 입력받은 동전의 가치를 저장할 배열
		int[] values = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			int V = sc.nextInt();

			values[i] = V;
		}

		// 인덱스가 동전의 가치
		int[] dp = new int[K + 1];

		// dp를 10001로 초기화 해준다.(k가 10000까지 이므로)
		for (int i = 1; i < K + 1; i++) {
			dp[i] = 10001;
		}

		// 입력받은 동전의가치를 통해 dp의 최소값 갱신
		for (int i = 1; i < N + 1; i++) {
			for (int v = values[i]; v < K + 1; v++) {
				dp[v] = Math.min(dp[v], dp[v - values[i]] + 1);
			}
		}

		if (dp[K] == 10001) {
			System.out.println(-1);
		} else {
			System.out.println(dp[K]);
		}

	}
}
