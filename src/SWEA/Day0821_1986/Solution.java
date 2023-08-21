package SWEA.Day0821_1986;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/SWEA/Day0821_1986/input_1986.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			int arr[] = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = i + 1;
			}
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i] % 2 == 1) {
					sum += arr[i];
				}else {
					sum-= arr[i];
				}
			}
			System.out.println("#" + tc + " " +sum);

		}

	}

}
