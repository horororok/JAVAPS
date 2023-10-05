package BOJ.Day0927_15439;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// 상의 N벌, 하의 N벌이 있을때 상하의 색상이 다른 조합 수
		// i번째 상하의는 색상 i를 가진다

		int ans = (N - 1) * N;
		System.out.println(ans);
	}

}
