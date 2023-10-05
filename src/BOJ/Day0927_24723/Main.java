package BOJ.Day0927_24723;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		double N = sc.nextDouble();

		// 최단 경로로 탑 내려오는 경우의 수
		// 2의N승

		int ans = (int) Math.pow(2, N);

		System.out.println(ans);

	}

}
