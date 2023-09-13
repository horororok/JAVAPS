package BOJ.Day0913_2485;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// 나무 사이의 간격들을 배열로 뽑아낸다
		// 간격 들의 최대공약수를 구해준다
		// 각 수를 최대공약수로 나누면 갯수가 ㅇ나온다

		int N = sc.nextInt();

		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			long input = sc.nextLong();
			arr[i] = input;
		}

		long[] arr2 = new long[N - 1];
		for (int i = 1; i < N; i++) {
			arr2[i - 1] = arr[i] - arr[i - 1];
		}

		long gcd = arr2[0];
		for (int i = 0; i < N - 1; i++) {
			gcd = GCD(arr2[i], gcd);
		}

//		System.out.println(gcd);

		int cnt = 0;
		for (int i = 0; i < N - 1; i++) {
			if (arr2[i] / gcd == 0) {
				continue;
			} else {
				cnt += (arr2[i] / gcd - 1);
			}

		}

		System.out.println(cnt);

	}

	public static long GCD(long a, long b) {
		if (b == 0) {
			return a;
		} else {
			return GCD(b, a % b);
		}
	}

}
