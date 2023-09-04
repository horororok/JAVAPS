package SWEA.Day0904_2105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, ans, startX, startY;
	static int[][] map;
	static int[] dx = { 1, 1, -1, -1 }, dy = { 1, -1, -1, 1 };

//    격자 크기(N)를 입력 받고, N x N 크기의 격자 정보를 입력 받는다
//    `ans`를 초기화하고, 모든 지점에서 `dfs` 함수를 호출하여 최대 사각형 크기를 찾는다.
//    `ans`가 0이면 사각형을 만들 수 없는 경우로 처리하고, 그렇지 않으면 `ans` 값을 출력 문자열에 추가
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine()); // 격자의 크기 N
			map = new int[N][N]; // 격자 정보를 저장하는 배열 초기화

			// 격자 정보 입력
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 0; // 최대 사각형 크기 초기화

			// 모든 시작점에 대해 DFS 호출하여 최대 사각형 크기 계산
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					startX = i;
					startY = j;
					dfs(i, j, 0, 0, new boolean[101]);
				}
			}
			if (ans == 0)
				sb.append("#" + t + " -1\n"); // 사각형을 만들 수 없는 경우
			else
				sb.append("#" + t + " " + ans + "\n"); // 최대 사각형 크기 출력
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y, int d, int cnt, boolean number[]) {
		if (startX == x && startY == y && cnt >= 3) {
			ans = Math.max(ans, cnt); // 최대 사각형 크기 갱신
		}

		for (int i = d; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 격자 범위를 벗어나면 무시
			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;

			// 이미 방문한 숫자는 무시
			if (number[map[nx][ny]])
				continue;

			number[map[nx][ny]] = true; // 숫자를 방문 표시
			dfs(nx, ny, i, cnt + 1, number); // 다음 위치로 이동
			number[map[nx][ny]] = false; // 숫자 방문 표시 초기화
		}
	}
}

//1. 시작점으로 돌아왔고(`startX`, `startY`와 `x`, `y`가 같음) `cnt`가 3 이상이면, 현재까지의 칸 수를 `ans`와 비교하여 큰 값을 `ans`에 저장
//2. 현재 위치에서 가능한 다음 이동 방향(`d`부터 3까지)에 대해 다음 위치(`nx`, `ny`)를 계산
//3. 다음 위치가 격자 밖이면 무시
//4. 다음 위치에 이미 방문한 숫자가 있으면 무시
//5. 다음 위치의 숫자를 방문 표시하고(`number` 배열을 사용), `dfs` 함수를 재귀 호출
//6. 재귀 호출이 끝나면 해당 숫자의 방문 표시를 해제