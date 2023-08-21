package SWEA.Day0810_omok;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution2 {

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

			// 검사하는 8방향의 상대좌표
			int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
			int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					char currentChar = arr[i][j];
					for (int dir = 0; dir < 8; dir++) {
						int count = 0;
						int x = i;
						int y = j;

						while (x >= 0 && x < n && y >= 0 && y < n && arr[x][y] == currentChar) {
							count++;
							x += dx[dir];
							y += dy[dir];

							if (count >= 5) {
								break;
							}
						}
					}
				}
			}
		}
	}
}
