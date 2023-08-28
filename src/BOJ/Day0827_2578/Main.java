package BOJ.Day0827_2578;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//실패
		// 5*5 빙고판 입력
		// 사회자가 부르는 25개의 번호
		// 세줄이 빙고면 빙고

		// 사회자가 수를 부를때마다 횟수 세주기
		// 사회자가 부른 수는 빙고판 배열에서 0으로 바꾼다
		// 대각선, 가로, 세로 탐색 0이 다섯개 이면 빙고수+1
		// 빙고수3개가 되면 멈추고 몇 번째 수를 불렀는지 확인

		// 빙고판 배열
        int[][] board = new int[5][5];
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                board[r][c] = sc.nextInt();
            }
        }

        int[] calls = new int[25];
        for (int i = 0; i < 25; i++) {
            calls[i] = sc.nextInt();
        }

        int ans = 0;
        int bingo = 0;

        for (int i = 0; i < 25; i++) {
            int rr = 0;
            int cc = 0;
            int input = calls[i];

            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if (board[r][c] == input) {
                        board[r][c] = 0;
                        rr = r;
                        cc = c;
                    }
                }
            }

			// 오른쪽 아래대각선 탐색
			if (rr == cc) {

				int rdcnt = 0;
				for (int k = 0; k < 5; k++) {
					if (board[k][k] == 0) {
						rdcnt++;
					}
				}
				if (rdcnt == 5) {
					bingo++;
				}
			}
			// 오른쪽위 대각선 탐색
			else if (rr + cc == 4) {
				int rucnt = 0;
				for (int u = 0; u < 5; u++) {
					if (board[4 - u][u] == 0) {
						rucnt++;
					}
				}
				if (rucnt == 5) {
					bingo++;
				}
			} else {
				// 가로세로 탐색
				// 가로
				int ccnt = 0;
				int rcnt = 0;
				for (int d = 0; d < 5; d++) {
					if (board[rr][d] == 0) {
						ccnt++;
					}
					if (board[d][cc] == 0) {
						rcnt++;
					}
				}
				if (ccnt == 5) {
					bingo++;
				}
				if (rcnt == 5) {
					bingo++;
				}
			}
			if (bingo == 3) {
				break;
			}
			ans++;
		}
		System.out.println(ans);
	}
}
