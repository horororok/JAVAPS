package BOJ.Day0919_4963;

import java.util.Scanner;



//DFS
public class Main {
	static int w, h;
	static int map[][];
	static boolean visited[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0) {
				break;
			}
			map = new int[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			visited = new boolean[h][w];
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						cnt++;
						DFS(i, j);
					}
				}
			}

			System.out.println(cnt);

		}

	}

	public static void DFS(int r, int c) {

		// 상 하 좌 우 좌상 우상 좌하 우하
		int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int dc[] = { 0, 0, -1, 1, -1, 1, -1, 1 };
		visited[r][c] = true;
		for (int d = 0; d < 8; d++) {
			int nowR = r + dr[d];
			int nowC = c + dc[d];

			if (nowC >= 0 && nowR >= 0 && nowC < w && nowR < h && !visited[nowR][nowC] && map[nowR][nowC] == 1) {
				visited[nowR][nowC] = true;
				DFS(nowR, nowC);
			}

		}
	}

}
