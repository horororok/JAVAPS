package SWEA.Day0918_2814;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int M = sc.nextInt();
			// M이 0이면 최대길이는 1일 수 밖에..
			if (M == 0) {
				sb.append("#").append(tc).append(" ").append(1).append("\n");
				continue;
			} else {

				// 간선이 존재하는지 확인하기 위한 이차원배열
				int[][] arr = new int[N + 1][N + 1];

				for (int i = 0; i < M; i++) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					// 간선이 있으면 1을 넣어 줍니다
					arr[x][y] = arr[y][x] = 1;
				}

				for (int i = 0; i < M; i++) {
					
					
					
				}

			}

			System.out.println(sb);
		}
	}

}
