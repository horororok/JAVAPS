package forA.BOJ7576_토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class main2 {
	// 토마토가 익는 최소일자 -> BFS
	// 토마토의 상태를 입력 받으면서 다익은 토마토의 위치(좌표)를 큐에 저장
	// 다익은 토마토의 위치에서 사방탐색

	private static int N, M; // 세로, 가로
	private static Queue<int[]> queue = new LinkedList<>(); // 익은 토마토 좌표를 담아줄 큐
	private static int map[][]; // 토마토의 상태를 받을 배열
	private static int dx[] = { 0, 0, -1, 1 }; // 사방탐색
	private static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					queue.add(new int[] { i, j });
				}
			}
		}
		System.out.println(BFS());
	}

	private static int BFS() {
		while (!queue.isEmpty()) {
			int[] t = queue.poll();
			int x = t[0];
			int y = t[1];
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				if (map[nx][ny] == 0) {
					map[nx][ny] = map[x][y] + 1;
					queue.add(new int[] { nx, ny });
				} else {
					continue;
				}
			}
		}
		int date = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					return -1;
				} else {
					if (map[i][j] > date) {
						date = map[i][j];
					}
				}
			}
		}
		return date - 1;

	}
}
