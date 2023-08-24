package SWEA.Day0824_2805;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
//x
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("src/SWEA/Day0824_2805/input_2805.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			sc.nextLine();

			// 농장 수확량 이차원배열

			int[][] arr = new int[N][N];
			for (int r = 0; r < N; r++) {
				String input = sc.nextLine();
				for (int c = 0; c < N; c++) {
					arr[r][c] = input.charAt(c) - '0';
				}
			}

			// 좌우 확인

			int dc[] = { -1, 1 };

			int sum = 0;
			// 수확의 마름모 형태 배열
			// 0행부터 N/2+1행 까지 더해주고
			// 나머지 행을 더해줌

			// 위
			for (int r = 0; r < N / 2 + 1; r++) {
				for (int d = 0; d < 2; d++) {
					for (int i = 0; i < r + 1; i++) {
						sum += arr[r][(N / 2) + dc[d] * i];
					}
				}
			}
			// 아래
			for (int r = N / 2 + 1; r < N; r++) {
				for (int d = 0; d < 2; d++) {
					for (int i =( N / 2) - 1; i >= 0; i--) {
						sum += arr[r][N / 2 + dc[d] * i];
					}
				}
			}
			System.out.println(sum);
		}
	}
}
