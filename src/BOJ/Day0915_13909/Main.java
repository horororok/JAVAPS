package BOJ.Day0915_13909;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		long N = sc.nextLong();

		// N개의 창문과 N명의 사람
		// N이 1이상이므로 1인경우는 생략하고 창문이 다 열려 있는 상태에서 시작
		// 제곱수일 경우 약수가 홀수 개 -> 창문이 열린 상태가 된다.

		long cnt = 0;
		long num = 1;
		while (num * num <= N) {
			cnt++;
			num++;
		}
		System.out.println(cnt);

	}
}
