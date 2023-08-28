package BOJ.Day0827_2578;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 5*5 빙고판 입력
		// 사회자가 부르는 25개의 번호 배열로 입력
		// 세줄이 빙고면 빙고

		// 사회자가 수를 부를때마다 횟수 세주기
		// 사회자가 부른 수는 빙고판 배열에서 0으로 바꾼다
		// 대각선, 가로, 세로 탐색 0이 다섯개 이면 빙고수+1
		// 빙고수3개가 되면 멈추고 몇 번째 수를 불렀는지 확인

		// 5x5 빙고판 입력 받기
		int[][] board = new int[5][5];
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				board[r][c] = sc.nextInt();
			}
		}

		// 25개의 숫자 호출 입력 받기
		int[] calls = new int[25];
		for (int i = 0; i < 25; i++) {
			calls[i] = sc.nextInt();
		}

		int ans = 0; // 정답으로 출력할 숫자 호출 횟수
		int bingo = 0; // 빙고 개수 카운트

		for (int i = 0; i < 25; i++) {
			int input = calls[i];
			boolean found = false;

			// 숫자 찾기
			outer: for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (board[r][c] == input) {
						board[r][c] = 0; // 해당 숫자를 0으로 처리하여 사용한 것으로 표시
						found = true;
						break outer;
					}
				}
			}

			// 빙고 개수 검사
			bingo = 0; // 빙고 개수 초기화
			for (int r = 0; r < 5; r++) {
				int rcnt = 0; // 각 행의 0의 개수
				int ccnt = 0; // 각 열의 0의 개수
				for (int c = 0; c < 5; c++) {
					if (board[r][c] == 0) {
						rcnt++;
					}
					if (board[c][r] == 0) {
						ccnt++;
					}
				}
				if (rcnt == 5) {
					bingo++;
				}
				if (ccnt == 5) {
					bingo++;
				}
			}

			// 대각선 검사
			int d1cnt = 0; // 왼쪽 위에서 오른쪽 아래 대각선의 0의 개수
			int d2cnt = 0; // 오른쪽 위에서 왼쪽 아래 대각선의 0의 개수
			for (int d = 0; d < 5; d++) {
				if (board[d][d] == 0) {
					d1cnt++;
				}
				if (board[d][4 - d] == 0) {
					d2cnt++;
				}
			}
			if (d1cnt == 5) {
				bingo++;
			}
			if (d2cnt == 5) {
				bingo++;
			}

			// 빙고가 3개 이상이면 정답으로 출력할 숫자 호출 횟수 설정하고 종료
			if (bingo >= 3) {
				ans = i + 1;
				break;
			}
		}

		System.out.println(ans); // 결과 출력
	}
}
