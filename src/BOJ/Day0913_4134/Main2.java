package BOJ.Day0913_4134;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();

		// 1000000까지 소수
		// 소수이면 false
		boolean[] isPrime = new boolean[1000001];
		isPrime[0] = isPrime[1] = true;
		//i가 소수라면 i의 배수들은 전부 소수가 아니다
		for (int i = 2; i * i <= 1000000; i++) {
			if (!isPrime[i]) {
				for (int j = 2 * i; j <= 1000000; j += i) {
					isPrime[j] = true;
				}
			}
		}

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();

			int cnt = 0;
			//소수쌍의 개수
			//두 소수의 합으로 표현할 때 한 소수는 최대 절반 이상의 값을 가질 수 없다
			for (int i = 2; i <= N / 2; i++) {
				if (!isPrime[i] && !isPrime[N - i]) {
					cnt++;
				}
			}
			
			sb.append(cnt).append("\n");

		}

		System.out.println(sb);

	}
}
