package Day0810_달팽이숫자;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/Day0810_달팽이숫자/input_1954.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			// N*N 크기의 배열 초기화
			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			// 초기 위치 및 방향 설정
			int r = 0;
			int c = 0;
			int x = 0;

			// 각 방향으로 이동하는 변위값 설정
			int dr[] = { 0, 1, 0, -1 }; // 오른쪽, 아래, 왼쪽, 위
			int dc[] = { 1, 0, -1, 0 };

			// 달팽이 숫자 채우기
			for (int i = 1; i <= N * N; i++) {
				arr[r][c] = i; // 현재 위치에 숫자 저장
				int newRow = r + dr[x]; // 새로운 행 위치 계산
				int newCol = c + dc[x]; // 새로운 열 위치 계산

				// 새로운 위치가 배열 범위를 벗어나거나 이미 값이 채워진 경우
				if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= N || arr[newRow][newCol] != 0) {
					x++; // 방향 전환
					x %= 4; // x 값이 0, 1, 2, 3 순환하도록 조정
				}

				// 현재 위치 업데이트
				r = r + dr[x];
				c = c + dc[x];
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println("#" + tc + "\n" + sb);
		}
	}
}
