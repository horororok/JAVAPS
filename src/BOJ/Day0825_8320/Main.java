package BOJ.Day0825_8320;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// 만들 수 있는 직사각형의 개수
		// 약수의 개수를 센다

		// 입력
		int N = sc.nextInt();
		int[] carr = new int[N + 1];

		for (int k = 1; k < N + 1; k++) {
			// 약수 배열
			boolean[] yak = new boolean[k + 1];
			// 약수의 개수
			int cnt = 0;
			for (int i = 1; i < k + 1; i++) {
				if (k % i == 0) {
					yak[i] = true;
					cnt++;
				}
			}

			// 더해줄 개수
			int c = 0;
			if (cnt % 2 == 0) {
				c = cnt / 2;
			} else if (cnt % 2 == 1) {
				c = cnt / 2 + 1;
			}
			carr[k] = c;
		}

		for (int i = 1; i < N + 1; i++) {
			carr[i] += carr[i - 1];
		}

		System.out.println(carr[N]);

	}
}
