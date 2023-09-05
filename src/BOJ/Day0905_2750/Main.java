package BOJ.Day0905_2750;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N];
		int max = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] > max) {
				max = arr[i];
			}
		}
//		System.out.println(Arrays.toString(arr));
		
		//bubblesort
		for (int i = 0; i < N - 1; i++) {
			for (int j = 1; j < N - i; j++) {
				if (arr[j - 1] > arr[j]) {
					int tmp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);

		}
	}
}
