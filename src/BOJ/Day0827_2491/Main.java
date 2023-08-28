package BOJ.Day0827_2491;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		// 배열로 받아서
		// 다음 인덱스의 수가 크거나 같으면 갯수를 세줌
		// 센 갯수를 max 값에 저장해 줌
		// 다음 인덱스의 수가 작을 때 max보다 갯수가 크면 max값에 저장하고 갯수 0으로 초기화
		// 다음 인덱스가 크거나 같으면 다시 갯수를 세줌
		// 센 갯수가 max값보다 크면 max값에 저장 ...반복

		// 숫자의 개수
		int N = sc.nextInt();

		// 배열
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}

		int maxLen = 1;
		int currentLen = 1;

		// 증가하는 수열 길이 구하기
		for (int i = 1; i < N; i++) {
			if (num[i] >= num[i - 1]) {
				currentLen++;
			} else {
				currentLen = 1;
			}
			maxLen = Math.max(maxLen, currentLen);
		}

		// 감소하는 수열 길이 구하기
		currentLen = 1;
		for (int i = 1; i < N; i++) {
			if (num[i] <= num[i - 1]) {
				currentLen++;
			} else {
				currentLen = 1;
			}
			maxLen = Math.max(maxLen, currentLen);
		}
		System.out.println(maxLen);
	}
}
