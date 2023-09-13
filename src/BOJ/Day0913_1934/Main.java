package BOJ.Day0913_1934;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			int ans = LCM(A, B);
			System.out.println(ans);

		}

	}

	// 최대공약수
	public static int GCD(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return GCD(b, a % b);
		}
	}
	// 최소공배수
	public static int LCM(int a, int b) {
		return (a * b) / GCD(a, b);
	}

}
