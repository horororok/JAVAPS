package BOJ.Day0927_1010;

import java.util.Scanner;

public class Main {
//재귀로 풀어봄
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// 서쪽에 N개의 사이트, 동쪽에 M개의 사이트
		// 사이트끼리 연결하는 다리를 만들때, 다리끼리 겹치면 안된다
		// 총 다리 수는 N개
		// ->동쪽에 있는 사이트를 골랐을때 이전 사이트는 고를 수 없음

		// 동쪽의 사이트 개수 중 서쪽 사이트 개수를 고르는 조합 수
		// MCN

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int ans = comb(M, N);
			System.out.println(ans);
		}
	}

	public static int comb(int n, int k) {
		if (n == k || n == 1 || k == 0) {
			return 1;
		}
		// C(n, k) = C(n-1, k-1)+C(n-1, k)
		else {
			return comb(n - 1, k - 1) + comb(n - 1, k);
		}

	}

}
