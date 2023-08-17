package Day0810_omok;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution3 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/input/input_0814_Omok.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			char[][] arr = new char[N][N];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			// 검사하는 8방향의 상대좌표
			int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
			int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					char currentChar = arr[i][j];
					for (int dir = 0; dir < 8; dir++) {
						int x = i;
						int y = j;
						int consecutiveCount = 0;

						while (x >= 0 && x < N && y >= 0 && y < N && arr[x][y] == currentChar) {
							consecutiveCount++;
							x += dx[dir];
							y += dy[dir];

							if (consecutiveCount >= 5) {
								System.out.println("YES");
								break; // 검사가 끝났으므로 프로그램 종료
							}
						}
						break;
					}
				}
			}

			System.out.println("NO"); // 위의 검사에서 발견되지 않았으면 "NO" 출력

		}

	}
}
