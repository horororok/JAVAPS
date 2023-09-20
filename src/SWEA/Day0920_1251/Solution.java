package SWEA.Day0920_1251;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		// tc
		for (int tc = 1; tc <= T; tc++) {
			// 섬 수
			int N = sc.nextInt();

			// 섬들의 좌표를 저장해 줄 배열
			int[][] arr = new int[N][2];
			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				arr[i][1] = sc.nextInt();
			}

			// 가중치(거리) 배열
			double[][] distance = new double[N-1][N-1];

//			int xx = 0;
//			if (N % 2 == 0) {
//				xx = 2 * (N - 1);
//			} else {
//				xx = 2 * (N - 2) + (N / 2 + 1);
//			}

			int idx = 0;
			for (int i = 0; i < N - 2; i++) {
				for (int j = i + 1; j < N-1; j++) {
					distance[i][j] = Math.sqrt((((arr[i][0] - arr[i + 1][0]) * (arr[i][0] - arr[i + 1][0]))
							+ ((arr[i][1] - arr[i + 1][1]) * (arr[i][1] - arr[i + 1][1]))));

				}
			}
			
			
			System.out.println(Arrays.deepToString(distance));
			// 세율
			double tax = sc.nextDouble();

			
			
			
//			Arrays.sort(distance, new Comparator<int[]>() {
//
//				@Override
//				public int compare(int[] o1, int[] o2) {
//					// TODO Auto-generated method stub
//					return (int) (o1[2] - o2[2]);
//				}
//			});
			
//			Arrays.sort(distance, (o1, o2) -> (int) (o1[2] - o2[1]));

//			for (int[] e : distance) {
//				System.out.println(Arrays.toString(e));
//			}

		}

	}

}
