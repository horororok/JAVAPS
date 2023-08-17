package Day0810_sum;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/input/input_0810_sum.txt"));

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int n = 100;
			int t = sc.nextInt();

			// 대각선 합
			int arr[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int diagonalSum = 0;
			int diagonalSum2 = 0;
			for (int i = 0; i < n; i++) {
				diagonalSum += arr[i][i];
				diagonalSum2 += arr[i][n - 1 - i];
			}

			// 행의 합의 최대값
			int maxRowSum = Integer.MIN_VALUE;// 행 합
			for (int i = 0; i < n; i++) {
				int rowSum = 0;
				for (int j = 0; j < n; j++) {
					rowSum += arr[i][j];
				}
				if (rowSum > maxRowSum) {
					maxRowSum = rowSum;
				}
			}

			// 열의 합의 최대값
			int maxColumnSum = Integer.MIN_VALUE;
			for (int j = 0; j < n; j++) {
				int columnSum = 0;
				for (int i = 0; i < n; i++) {
					columnSum += arr[i][j];
				}
				if (columnSum > maxColumnSum) {
					maxColumnSum = columnSum;
				}
			}

			System.out.println("#" + tc + " " + Math.max(diagonalSum, Math.max(diagonalSum2, Math.max(maxRowSum, maxColumnSum))));

		}

	}

}
