package BOJ.Day0927_11050;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		// 이항 계수 nCk 구하기
		// 이항 계수(조합) 구하기
		// n! / (n-k)! * k!

		int ans = factorial(N) / (factorial(N - K) * factorial(K));
		System.out.println(ans);

	}

	public static int factorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}

	}

}
