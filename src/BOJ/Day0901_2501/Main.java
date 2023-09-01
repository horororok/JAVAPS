package BOJ.Day0901_2501;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int k = sc.nextInt();

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				cnt++;
				if (cnt == k) {
					System.out.println(i);
				}
			}

		}
		if (cnt < k) {
			System.out.println(0);
		}

	}
}
