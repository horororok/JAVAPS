package SWEA.Day0820_11315;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("src/Day0820_11315/input_11315.txt"));
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스의 개수 입력
		int T = sc.nextInt();

		// 테스트 케이스 반복
		for (int tc = 1; tc <= T; tc++) {
			// 오목판 크기 입력
			int N = sc.nextInt();
			sc.nextLine(); // 개행 문자 제거

			// 각 방향으로 탐색할 변위값 설정
			int dr[] = { 0, 1, 1, 1 }; // 오른쪽, 아래, 오른쪽 아래, 왼쪽 아래
			int dc[] = { 1, 0, 1, -1 };

			// 오목판 초기화
			char[][] board = new char[N][N];
			for (int r = 0; r < N; r++) {
				String input = sc.nextLine();
				for (int c = 0; c < N; c++) {
					board[r][c] = input.charAt(c);
				}
			}
			boolean isOmok = false; // 오목 여부를 저장할 변수

			// 오목 검사
			outer: for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (board[r][c] == 'o') { // 현재 위치가 'o'인 경우에만 검사 수행
						for (int d = 0; d < 4; d++) { // 4방향 검사: 오른쪽, 아래, 오른쪽 아래, 왼쪽 아래
							int cnt = 0; // 연속된 'o'의 개수를 세는 변수
							for (int i = 1; i <= 4; i++) { // 4개의 돌을 검사
								int newRow = r + dr[d] * i; // 현재 위치에서 변위값을 더한 새로운 행 위치
								int newCol = c + dc[d] * i; // 현재 위치에서 변위값을 더한 새로운 열 위치
								// 새로운 위치가 오목판 내에 있고, 해당 위치의 값이 'o'인 경우 연속된 돌의 개수 증가
								if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N
										&& board[newRow][newCol] == 'o') {
									cnt++;
								}
							}
							if (cnt == 4) { // 연속된 'o'의 개수가 4개인 경우
								isOmok = true; // 오목이 확인됨
								break outer; // 더 이상 검사할 필요 없음
							}
						}
					}
				}
			}
			// 결과 출력
			if (isOmok) {
				System.out.println("#" + tc + " " + "YES");
			} else {
				System.out.println("#" + tc + " " + "NO");
			}
		}
	}
}
