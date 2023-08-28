package BOJ.Day0828_10157;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// N*M 크기의 좌석
		// 왼쪽 아래부터 시작
		// 위 - 오른쪽 - 아래 - 왼쪽 순서로 진행
		// 벽을 만나면 방향 전환(배열의 범위를 벗어나거나 숫자가 이미 채워져 있는 경우)

		int M = sc.nextInt();
		int N = sc.nextInt();
		int K = sc.nextInt();

		// N*M 이차원 배열 생성
		int[][] seat = new int[N][M];

		// 진행방향 상 - 우 -하 -좌
		int dr[] = { -1, 0, 1, 0 };
		int dc[] = { 0, 1, 0, -1 };

		int r = N - 1;
		int c = 0;
		int x = 0;

		// 배열에 순서 채워 나가기
		for (int i = 1; i <= M * N; i++) {
			seat[r][c] = i;
			int newR = r + dr[x];
			int newC = c + dc[x];
			if (newR >= N || newR < 0 || newC >= M || newC < 0 || seat[newR][newC] != 0) {
				x++;
				x %= 4;
			}
			r = r + dr[x];
			c = c + dc[x];

		}

		// y좌표를 만들어 준다
		int[][] coor = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				coor[i][j] = N - i;
			}
		}

		if (K > N * M) {
			System.out.println(0);
		} else {
			int xco = 0;
			int yco = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (seat[i][j] == K) {
						yco = coor[i][j];
						xco = j + 1;
					}
				}
			}

			System.out.println(xco + " " + yco);

		}

	}

}
