package SWEA.Day0828_6190;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner를 이용하여 입력을 받습니다.
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스의 개수를 입력 받습니다.
		int T = sc.nextInt();

		// 각 테스트 케이스를 순회합니다.
		for (int tc = 1; tc <= T; tc++) {
			// N은 배열의 크기입니다.
			int N = sc.nextInt();

			// N개의 수를 입력받아 배열에 저장합니다.
			int[] nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}

			// 가장 큰 값을 저장하는 변수를 초기화합니다.
			int max = -1; // 문제 조건상의 최소값인 -1로 초기화

			// 모든 수 쌍을 곱해보며 가장 큰 값을 찾습니다.
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					int K = nums[i] * nums[j];

					// 곱한 값이 각 자릿수가 증가하는 수인지 확인하는 메서드 호출
					if (isIncreasing(K)) {
						max = Math.max(K, max);
					}
				}
			}

			// 결과 출력
			System.out.println("#" + tc + " " + max);
		}
	}

	// 주어진 숫자가 각 자릿수가 증가하는지 확인하는 메서드
	private static boolean isIncreasing(int num) {
		int prevDigit = 9; // 0부터 9까지 증가하므로 초기값을 9로 설정

		while (num > 0) {
			int digit = num % 10;
			if (digit > prevDigit) {
				return false;
			}
			prevDigit = digit;
			num /= 10;
		}

		return true;
	}
}
