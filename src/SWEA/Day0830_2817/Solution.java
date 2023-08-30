package SWEA.Day0830_2817;

import java.util.Scanner;

public class Solution {
	static int N; // 원소의 수를 저장하는 변수
	static int K; // 부분 수열의 합을 저장하는 변수
	static int count; // 부분 수열의 합이 K와 같은 경우의 수를 세는 변수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt(); // 테스트 케이스의 개수 입력

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt(); // 원소의 수 입력
			K = sc.nextInt(); // 부분 수열의 합 입력
			count = 0; // 초기화

			int[] seq = new int[N]; // 입력된 원소들을 저장할 배열
			boolean[] visit = new boolean[N]; // 해당 원소를 부분 수열에 포함시킬지 여부를 저장할 배열

			for (int i = 0; i < N; i++) {
				seq[i] = sc.nextInt(); // 원소들을 입력받아 배열에 저장
			}

			rec(seq, visit, 0); // 부분 수열 생성을 위한 재귀 함수 호출
			sb.append("#").append(t).append(" ").append(count).append("\n"); // 결과 문자열에 결과 저장
		}
		System.out.println(sb.toString()); // 결과 출력
	}

	static void rec(int[] seq, boolean[] visit, int n) {
		if (n == N) { // 모든 원소에 대한 선택 여부를 결정한 경우
			int sum = 0; // 부분 수열의 합을 저장할 변수
			for (int i = 0; i < N; i++) {
				if (visit[i]) {
					sum += seq[i]; // 선택된 원소들의 합 계산
				}
			}
			if (sum == K) { // 부분 수열의 합이 K와 같은 경우
				count++; // 경우의 수 증가
			}
			return;
		}

		visit[n] = true; // 현재 원소를 부분 수열에 포함시킴
		rec(seq, visit, n + 1); // 다음 원소로 재귀 호출
		visit[n] = false; // 현재 원소를 부분 수열에서 제외시킴
		rec(seq, visit, n + 1); // 다음 원소로 재귀 호출
	}
}
