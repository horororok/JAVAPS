package SWEA.Day0919_1226;

import java.util.Scanner;

public class Main {

	static int[][] map;
	static boolean[][] visit;

	static int res;
	static StringBuilder sb;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		sb = new StringBuilder();

		for (int x = 0; x < 10; x++) {
			res = 0;
			int tc = sc.nextInt();

			sb.append("#").append(tc).append(" ");

			map = new int[16][16];
			for (int k = 0; k < 16; k++) {
				String input = sc.next();
				for (int j = 0; j < 16; j++) {
					map[k][j] = Character.getNumericValue(input.charAt(j));
				}
			}

			visit = new boolean[16][16];

			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 16; j++) {
					if (!visit[i][j] && map[i][j] == 2) {
						DFS(i, j);
					}

				}
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}

	private static void DFS(int r, int c) {
		// TODO Auto-generated method stub
		visit[r][c] = true;
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int d = 0; d < 4; d++) {
			int nowR = r + dr[d];
			int nowC = c + dc[d];

			if (!visit[nowR][nowC] && map[nowR][nowC] != 1) {
				visit[nowR][nowC] = true;

				if (map[nowR][nowC] == 3) {
					res = 1;
					return;
				}
				DFS(nowR, nowC);
			}
		}

	}
}
