package Day0810_omok;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/input/input_0814_Omok.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();

			char[][] arr = new char[n][n];
			for (int i = 0; i < n; i++) {
				String str = sc.next();
				for (int j = 0; j < n; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			// 행, 열, 대각선 별 o 다섯개 연속 확인

			

			// 행(가로방향 검사)
			for (int i = 0; i < n; i++) {
				int cnt = 1;
				for (int j = 1; j < n; j++) {
					if (arr[i][j] == arr[i][j - 1]) {
						cnt += 1;
					}
					if (cnt == 5) {
						System.out.println("YES");
						break;
					} else {
						cnt = 1;
					}
				}
			}

			// 열(세로 방향 검사)
			for (int j = 0; j < n; j++) {
				int cnt = 1;
				for (int i = 1; i < n; i++) {
					if (arr[i][j] == arr[i - 1][j]) {
						cnt++;
						if (cnt == 5) {
							System.out.println("YES");
							break;
						} else {
							cnt = 1;
						}
					}
				}
			}

			// 대각선 방향 검사
			
			int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
			int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int cnt = 1;
					for (int dir = 1; dir < 4; dir++) {
						int x = i + dx[dir];
						int y = j + dy[dir];
						if (x >= 0 && x < n && y >= 0 && y < n && arr[x][y] == arr[i][j]) {
							cnt++;
							if (cnt == 5) {
								System.out.println("YES");
								break;
							} else {
								cnt = 1;
								
							}
						}
					}
				}
			}
			
			
		}
	}
}
