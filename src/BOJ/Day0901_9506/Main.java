package BOJ.Day0901_9506;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		// 약수들의 합이 그 수와 같으면 완전수

		while (true) {
			int N = sc.nextInt();
			if (N == -1) {
				break;
			}

			int cnt = 0;
			for (int i = 1; i < N; i++) {
				if (N % i == 0) {
					cnt++;
				}
			}
			int[] arr = new int[cnt];
			int sum = 0;
			int r = 0;
			for (int i = 1; i < N; i++) {
				if (N % i == 0) {
					arr[r] = i;
					sum += i;
					r++;
				}
			}

//			System.out.println(Arrays.toString(arr));

			if (N == sum) {
				System.out.print(N + " = 1 ");
				for (int i = 1; i < cnt; i++) {
					System.out.print("+ " + arr[i] + " ");
				}
				
			} else {
				System.out.print(N + " is NOT perfect.");
			}
			System.out.println();
		}

	}
}
