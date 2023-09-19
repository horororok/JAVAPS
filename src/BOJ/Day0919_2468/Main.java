package BOJ.Day0919_2468;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		map = new int[N][N];

		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int input = sc.nextInt();
				map[i][j] = input;
				if (input > max) {
					max = input;
				}
			}
		}

		int ans = 0;

		for (int y = 0; y < max; y++) {
			visited = new boolean[N][N];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] > y) {
						cnt++;
						DFS(i, j, y);
					}
				}
			}

			if (cnt > ans) {
				ans = cnt;
			}
		}
		System.out.println(ans);

	}

	private static void DFS(int r, int c, int y) {
		// TODO Auto-generated method stub
		visited[r][c] = true;

		// 사방탐색
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int d = 0; d < 4; d++) {
			int nowR = r + dr[d];
			int nowC = c + dc[d];

			if (nowR >= 0 && nowC >= 0 && nowR < N && nowC < N && !visited[nowR][nowC] && map[nowR][nowC] > y) {
				visited[nowR][nowC] = true;
				DFS(nowR, nowC, y);
			}
		}
	}

}
