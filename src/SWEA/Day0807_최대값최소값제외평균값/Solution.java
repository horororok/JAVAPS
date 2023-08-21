package SWEA.Day0807_최대값최소값제외평균값;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int[] arr = new int[10];
			for (int j = 0; j < 10; j++) {
				arr[j] = sc.nextInt();
			}
			for (int j = 0; j < 9; j++) {
				for (int k = 0; k < 9 - j; k++) {
					int tmp = 0;
					if (arr[k] > arr[k + 1]) {
						tmp = arr[k];
						arr[k] = arr[k + 1];
						arr[k + 1] = tmp;
					}
				}

			}
			double avg = (arr[1] + arr[2] + arr[3] + arr[4] + arr[5] + arr[6] + arr[7] + arr[8]) / (8.0);

			System.out.println("#" + (i + 1) + " " + Math.round(avg));
		}

	}
}
