package SWEA.Day0824_12712;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/SWEA/Day0824_12712/input_12712.txt"));
		Scanner sc = new Scanner(System.in);

		// testcase
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			// 이차원 배열
			// N+2(M-1) 크기의 배열
			int arr[][] = new int[N + 2 * (M - 1)][N + 2 * (M - 1)];
			for (int r = M - 1; r < N + M - 1; r++) {
				for (int c = M - 1; c < N + M - 1; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			// 십자 모양 합
			// 위 - 오른쪽 - 아래 - 왼쪾
			int dr1[] = { -1, 0, 1, 0 };
			int dc1[] = { 0, 1, 0, -1 };
			int max1 = 0;

			for (int r = M - 1; r < N + M - 1; r++) {
				for (int c = M - 1; c < N + M - 1; c++) {
					int sum = arr[r][c];
					// 반복횟수
					for (int i = 1; i < M; i++) {
						// 4방향
						for (int d = 0; d < 4; d++) {
							int val = arr[r + dr1[d] * i][c + dc1[d] * i];
							sum += val;
						}
					}
					if (sum >= max1) {
						max1 = sum;
					}
				}
			}

			// x모양 합
			// 왼쪽 위 - 오른쪽 위 - 왼쪽 아래 - 오른쪽 아래
			int dr2[] = { -1, -1, 1, 1 };
			int dc2[] = { -1, 1, -1, 1 };

			int max2 = 0;

			for (int r = M - 1; r < N + M - 1; r++) {
				for (int c = M - 1; c < M + N - 1; c++) {
					int sum = arr[r][c];
					// 반복횟수
					for (int i = 1; i < M; i++) {
						// 4방향
						for (int d = 0; d < 4; d++) {
							int val = arr[r + dr2[d] * i][c + dc2[d] * i];
							sum += val;
						}
					}
					if (sum >= max2) {
						max2 = sum;
					}
				}
			}
			int max = Math.max(max1, max2);
			System.out.printf("#%d %d%n", tc, max);
		}
	}
}
