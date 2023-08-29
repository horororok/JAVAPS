package SWEA.Day0829_10726;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// 먼저 M을 이진수로 표현
		// 끝에서부터 1인지 검사
		// 아니면 break하고 오프
		// 맞으면 on

		// testcase
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			// 이진수를만들어 저장해줄 배열 크기는 N으로 만들어서 끝에 N개만 확인해 준다
			int[] arr = new int[N];
			for (int i = N - 1; i >= 0; i--) {
				arr[i] = M % 2;
				M /= 2;
			}
			
			//on인지 판별할 불리언
			boolean isOn = false;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i] == 1) {
					cnt++;
				}
			}
			//1이 N개면 on
			if (cnt == N) {
				isOn = true;
			}

			if (isOn) {
				System.out.println("#" + tc + " " + "ON");
			} else {
				System.out.println("#" + tc + " " + "OFF");
			}

		}

	}

}
