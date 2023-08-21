package SWEA.Day0816_1217;

import java.util.Scanner;

public class Solution2 {

	// 재귀함수
	// 함수 power(n,m)은 기저케이스에서 지수 m이 0일때 결과를 1로 반환하며 그렇지 않은 경우
	// n을 n 자체와 m-1번 곱하여 결과를 반환한다
	public static int power(int n, int m) {

		// 재귀함수의 기저 케이스, 지수가 0이면 결과는 1
		if (m == 0) {
			return 1;
		}
		// n^m = n* n^(m-1)
		// 지수가 0이 아니면 n을 m번 곱한 값
		// 재귀적으로 m을 줄여가면서 n을 곱해가는 방식
		return 
				n * power(n, m - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();

			int n = sc.nextInt();
			int m = sc.nextInt();

			// 재귀함수 호출
			int ans = power(n, m);
			System.out.printf("#%d %d%n", tc, ans);

		}

	}

}
