package forA.BOJ1600_말이되고픈원숭이;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	// 체스의 나이트와 같은 움직임
	// 원숭이는 k번만 나이트처럼 움직일수 있다.
	// 이후에는 사방으로만 이동 가능
	// 왼쪽위에서 오른쪽 아래로
	// 0은 평지, 1은 장애물
	// 가로길이 W, 세로길이 H

	static int K, W, H;
	static int[][] map;
	// 원숭이 움직임
	static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
	// 나이트 움직임
	static int[] hx = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] hy = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static Queue<int[]> que;
	static boolean[][][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt(); // 나이트로 움직일 수 있는 횟수
		W = sc.nextInt(); // 가로길이
		H = sc.nextInt(); // 세로길이

		map = new int[H][W];

		// 맵 정보 입력
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt(); // 0은 평지, 1은 장애물
			}
		}

		// bfs를 통해 최단 경로 탐색하고 결과 출력
		int result = bfs(0, 0);
		System.out.println(result);
	}

	// bfs를 이용하여 최단 경로 탐색
	static int bfs(int x, int y) {
		que = new LinkedList<>();
		// x, y 좌표와 사용한 나이트 움직임 횟수, 총 이동한 칸 수를 저장하는 배열
		visited = new boolean[H][W][K + 1]; // 방문 여부를 체크
		visited[y][x][0] = true; // 방문처리
		que.add(new int[] { x, y, 0, 0 }); // 시작 위치와 초기값 설정
		while (!que.isEmpty()) {
			int[] move = que.poll();
			int px = move[0], py = move[1];
			int chance = move[2], moves = move[3]; // 나이트 움직임 기회와 이동한 칸 수

			// 목적지에 도달한 경우 이동한 칸 수를 리턴
			if (px == W - 1 && py == H - 1) {
				return moves;
			}

			// 나이트 움직임 (k번까지만 가능)
			if (chance < K) {
				for (int i = 0; i < 8; i++) {
					int nx = px + hx[i];
					int ny = py + hy[i];

					if (nx >= 0 && nx < W && ny >= 0 && ny < H && !visited[ny][nx][chance + 1] && map[ny][nx] != 1) {
						// 범위 내에 있고 방문하지 않았으며 장애물이 아닌 경우
						visited[ny][nx][chance + 1] = true;
						que.add(new int[] { nx, ny, chance + 1, moves + 1 });
					}
				}
			}

			// 원숭이 움직임 (상하좌우)
			for (int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];

				if (nx >= 0 && nx < W && ny >= 0 && ny < H && !visited[ny][nx][chance] && map[ny][nx] != 1) {
					// 범위 내에 있고 방문하지 않았으며 장애물이 아닌 경우
					visited[ny][nx][chance] = true;
					que.add(new int[] { nx, ny, chance, moves + 1 });
				}
			}
		}

		// 목적지에 도달하지 못한 경우 -1 리턴
		return -1;
	}
}