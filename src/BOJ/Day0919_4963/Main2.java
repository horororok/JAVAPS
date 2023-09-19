package BOJ.Day0919_4963;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//BFS
public class Main2 {
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
						BFS(i, j);
					}
				}
			}

			System.out.println(cnt);

		}

	}

	public static void BFS(int row, int col) {

		// 상 하 좌 우 좌상 우상 좌하 우하
		int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int dc[] = { 0, 0, -1, 1, -1, 1, -1, 1 };
		visited[row][col] = true;

		// 큐를 만들고 시작정점을 방문 체크 후 큐에 삽입
		// 와일문 큐가 빌때까지
		// 탑색할 현재 정점을 꺼내고 현재 정점에서 이웃한 정점들을 확인(조건 확인)
		// 해당 점점을 큐에 삽입

		Queue<int[]> q = new LinkedList<>();

		visited[row][col] = true;
		q.offer(new int[] { row, col });

		while (!q.isEmpty()) {
			int[] v = q.poll();
			int r = v[0];
			int c = v[1];

			for (int d = 0; d < 8; d++) {
				int nowR = r + dr[d];
				int nowC = c + dc[d];

				if (nowC >= 0 && nowR >= 0 && nowC < w && nowR < h && !visited[nowR][nowC] && map[nowR][nowC] == 1) {
					visited[nowR][nowC] = true;
					q.offer(new int[] { nowR, nowC });
				}

			}
		}

	}

}
