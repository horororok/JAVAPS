package Day0820_11315;

import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// 돌이 있는 부분부터
		// 가로, 세로, 오른쪽 아래 대각, 왼쪽 아래 대각 순으로 네개의 돌을 확인한다
		// 오목 판정인 경우 break

		// 테스트 케이스
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// 판 크기
			int N = sc.nextInt();
			sc.nextLine();

			// 판 초기화
			char board[][] = new char[N][N];
			for (int r = 0; r < N; r++) {
				String input = sc.nextLine();
				for (int c = 0; c < N; c++) {
					board[r][c] = input.charAt(c);
				}
			}

			// 각 방향으로 탐색할 변위값 설정
			int dr[] = { 0, 1, 1, 1 }; // 오른쪽, 아래, 오른쪽 아래, 왼쪽 아래
			int dc[] = { 1, 0, 1, -1 };
			// 오목 판정
			boolean isOmok = false;

			// 판에서
			outer: for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// 돌이 있는경우
					if (board[r][c] == 'o') {
						// 4방향 검사
						for (int d = 0; d < 4; d++) {
							// 연속된 돌 개수를 세는 변수
							int cnt = 0;
							// 4개의 돌 검사
							for (int i = 1; i <= 4; i++) {
								// 현재 위치에서 변위값을 더한 새로운 위치
								int newRow = r + dr[d] * i;
								int newCol = c + dc[d] * i;
								// 새로운 위치가 판 안에 있고, 해당 위치의 값이 'o'인 경우
								if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N
										&& board[newRow][newCol] == 'o') {
									cnt++;
								}
							}
							if(cnt == 4) {
								isOmok = true;
								break outer;
							}
						}
					}
				}
			}

			if (isOmok) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}

	}

}
