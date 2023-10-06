package forA.BOJ7576_토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	// N*M크기의 토마토 창고
	// 동서남북 방향의 토마토에게만 영향을 준다
	// 익은 토마토의 동서남북 방향의 토마토는 하루후에 익는다
	// -1 :안들어 있음 0 :안익음 1: 익음
	// 토마토가 모두 익을때까지의 최소날짜
	// 토마토가 모두 익지 못하면 -1 출력

	// 최소날짜 -> BFS
	// 빈 공간을 만났을 때 -> 지나갈 수 없다
	// 익지 않은 토마토를 만났을 때 -> 익은 토마토로 만들기

	static int[] dx = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M; // 행과 열의 크기
	static int[][] map; // 토마토 상태를 저장하는 배열
	static Queue<int[]> que = new LinkedList<>(); // BFS 탐색을 위한 큐

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt(); // 열의 수 입력
		N = sc.nextInt(); // 행의 수 입력
		map = new int[N][M]; // 토마토 상태를 저장하는 배열 초기화

		// 토마토 상태 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					que.add(new int[] { i, j }); // 익은 토마토의 위치를 큐에 추가
				}
			}
		}

		System.out.println(bfs()); // BFS 탐색 결과 출력
	}

	private static int bfs() {
		while (!que.isEmpty()) {
			int[] t = que.poll();
			int x = t[0];
			int y = t[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				// 범위를 벗어난 경우 무시
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (map[nx][ny] == 0) {
					// 익지 않은 토마토를 익은 상태로 변경하고 날짜를 증가
					map[nx][ny] = map[x][y] + 1;
					// 새로 익은 토마토를 큐에 추가
					que.add(new int[] { nx, ny });
				}
				else {
					continue;
				}
			}
		}

		// 익는데 걸린 일수
		int date = Integer.MIN_VALUE;
		if (check()) {
			return -1; // 모든 토마토가 익지 못한 경우 -1 반환
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (date < map[i][j]) {
						date = map[i][j];
					}
				}
			}

			return date - 1; // 1을 뺀 값이 익는데 걸린 일수(익은 토마토가 처음에 1부터 시작했으므로)
		}
	}

	// 토마토의 익음 여부 확인
	private static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					return true; // 0 -> 토마토가 익지 않았다 -> true 반환
			}
		}
		return false; // 모든 토마토가 익었으면 false 반환
	}
}