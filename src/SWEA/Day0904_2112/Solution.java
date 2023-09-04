package SWEA.Day0904_2112;

import java.io.*;

public class Solution {

//	재귀 함수와 백트래킹을 활용

	static int T; // 테스트 케이스의 수
	static int D, W, K; // 세로 막대 개수, 가로 셀 개수, 연속해야 하는 약품 개수
	static int min; // 최소 약품 주입 횟수
	static int[][] map; // 약품 정보를 저장하는 배열

//    가능한 모든 약품 주입 방법을 탐색
//    `cnt`: 현재 탐색 중인 세로 막대의 인덱스
//    `num`: 현재까지 주입한 약품의 횟수
//    `min`보다 `num`이 크다면 더 이상 탐색하지 않고 종료
//    `check` 함수를 사용하여 모든 세로 막대가 조건을 만족하는지 확인하고, 조건을 만족하면 `min` 값을 업데이트
	static void dfs(int cnt, int num) {
		if (min < num) // 현재 최소 횟수보다 더 많은 약품을 주입한 경우 종료
			return;
		if (check()) { // 모든 세로 막대가 조건을 만족하는 경우
			if (min > num) // 현재 최소 횟수보다 적게 약품을 주입한 경우 최소 횟수 갱신
				min = num;
			return;
		}
		if (cnt == D) { // 모든 세로 막대에 대한 주입을 시도했을 때 종료
			return;
		}

		int[] backup = new int[W]; // 약품 주입 전의 상태를 백업하기 위한 배열
		for (int j = 0; j < W; j++) {
			backup[j] = map[cnt][j]; // 현재 세로 막대를 백업 배열에 복사
		}

		dfs(cnt + 1, num); // 약품 주입 안 함
		injection(cnt, 0); // A 약품 주입
		dfs(cnt + 1, num + 1); // 다음 세로 막대로 이동
		reset(cnt, backup); // 백업한 상태로 복원

		injection(cnt, 1); // B 약품 주입
		dfs(cnt + 1, num + 1); // 다음 세로 막대로 이동
		reset(cnt, backup); // 백업한 상태로 복원
	}

//    주어진 세로 막대에 약품을 주입하는 함수
//    `cnt`번째 세로 막대에 `type` 종류의 약품을 주입
	static void injection(int cnt, int type) {
		for (int j = 0; j < W; j++)
			map[cnt][j] = type; // cnt번째 세로 막대에 type 종류의 약품 주입
	}

//    주입한 약품을 원래 상태로 되돌리는 함수.
//    `backup` 배열에 저장된 값을 사용하여 `cnt`번째 세로 막대를 초기 상태로 복원
	static void reset(int cnt, int[] backup) {
		for (int j = 0; j < W; j++) {
			map[cnt][j] = backup[j]; // cnt번째 세로 막대를 백업 배열의 값으로 복원
		}
	}

//    모든 세로 막대가 조건을 만족하는지 확인하는 함수
//    `outer` 레이블을 사용하여 중첩된 반복문에서 조건을 확인
//    모든 세로 막대의 열에 대해 연속된 약품의 개수가 `K` 이상이면 `true`를 반환하고, 그렇지 않으면 `false`를 반환
	static boolean check() {
		outer: for (int j = 0; j < W; j++) {
			int sumA = 0; // A 약품 연속 개수
			int sumB = 0; // B 약품 연속 개수
			for (int i = 0; i < D; i++) {
				if (map[i][j] == 0) {
					sumA++; // A 약품 연속 개수 증가
					sumB = 0; // B 약품 연속 개수 초기화
				} else {
					sumB++; // B 약품 연속 개수 증가
					sumA = 0; // A 약품 연속 개수 초기화
				}
				if (sumA == K || sumB == K)
					continue outer; // 연속 개수가 K에 도달하면 현재 열 검사 종료
			}
			return false; // 모든 열에 대해 K에 도달하지 않으면 false 반환
		}
		return true; // 모든 열에 대해 K에 도달하면 true 반환
	}

//	 `dfs` 함수를 호출하여 최소 약품 주입 횟수를 계산하고 결과를 출력
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수 입력
		StringBuilder sb = new StringBuilder();
		String[] srr;
		for (int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE; // 초기 최소 약품 주입 횟수 설정
			srr = br.readLine().split(" ");
			D = Integer.parseInt(srr[0]); // 세로 막대 개수 입력
			W = Integer.parseInt(srr[1]); // 가로 셀 개수 입력
			K = Integer.parseInt(srr[2]); // 연속해야 하는 약품 개수 입력
			map = new int[D][W]; // 약품 정보 배열 초기화
			for (int i = 0; i < D; i++) {
				srr = br.readLine().split(" ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(srr[j]); // 약품 정보 입력
				}
			}
			dfs(0, 0); // DFS 탐색 시작
			sb.append("#").append(t).append(" ").append(min).append("\n"); // 결과 출력
		}
		sb.deleteCharAt(sb.length() - 1); // 마지막 개행 문자 제거
		System.out.println(sb); // 결과 출력
	}
}
