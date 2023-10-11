package forA.BOJ4179_불;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int R, C;
	static char[][] map;
	static Queue<int[]> fireQ, jihunQ;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 맵의 크기(R 행과 C 열)
		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine(); // 개행 문자 제거

		// 맵을 나타내는 2D 배열
		map = new char[R][C];

		// 불과 지훈의 위치를 저장할 큐
		fireQ = new LinkedList<>();
		jihunQ = new LinkedList<>();

		// 맵을 읽고 큐를 초기화
		for (int i = 0; i < R; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'J') {
					// 지훈의 위치를 시간 0으로 큐에 추가
					jihunQ.add(new int[] { j, i, 0 });
				} else if (map[i][j] == 'F') {
					// 불의 위치를 큐에 추가
					fireQ.add(new int[] { j, i });
				}
			}
		}

		int res = -1;
		// 지훈의 움직임과 불의 번지는 것을 시뮬레이션하는 주요 루프
		out: while (true) {
			int fSize = fireQ.size();
			for (int i = 0; i < fSize; i++) {
				int[] p = fireQ.poll();
				fireMoving(p[0], p[1]);
			}

			int pSize = jihunQ.size();
			for (int i = 0; i < pSize; i++) {
				int[] p = jihunQ.poll();
				res = escape(p[0], p[1], p[2]);
				if (res != -1)
					break out;
			}
			if (jihunQ.isEmpty())
				break;
		}

		if (res == -1) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(res);
		}
	}

	// 지훈의 움직임을 시뮬레이션하는 함수
	static int escape(int x, int y, int time) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 지훈이 맵을 벗어난 경우를 확인
			if (nx < 0 || ny < 0 || nx > C - 1 || ny > R - 1) {
				return time + 1;
			}

			// 지훈이 인접한 셀로 이동할 수 있는지 확인
			if (map[ny][nx] == '.') {
				// 지훈의 새로운 위치를 표시하고 시간을 증가시킨 후 큐에 추가
				map[ny][nx] = 'J';
				jihunQ.add(new int[] { nx, ny, time + 1 });
			}
		}
		return -1;
	}

	// 불이 번지는 것을 시뮬레이션하는 함수
	static void fireMoving(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 불이 인접한 셀로 번질 수 있는지 확인
			if (nx < 0 || ny < 0 || nx > C - 1 || ny > R - 1)
				continue;

			// 셀이 비어 있거나 지훈이 있는지 확인
			if (map[ny][nx] == '.' || map[ny][nx] == 'J') {
				// 새로운 불의 위치를 표시하고 불 큐에 추가
				map[ny][nx] = 'F';
				fireQ.add(new int[] { nx, ny });
			}
		}
	}
}
