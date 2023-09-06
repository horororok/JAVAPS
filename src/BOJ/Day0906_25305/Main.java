package BOJ.Day0906_25305;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int k = sc.nextInt();

		int arr[] = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] > max) {
				max = arr[i];
			}
		}
//		System.out.println(Arrays.toString(arr));

		// counting sort
		int arr2[] = new int[max + 1];
		for (int i = 0; i < N; i++) {
			arr2[arr[i]]++;
		}
//		System.out.println(Arrays.toString(arr2));

		int idx = 0;
		for (int i = 0; i < max + 1; i++) {
			while (arr2[i] > 0) {
				arr[idx] = i;
				idx++;
				arr2[i]--;
			}
		}
//		System.out.println(Arrays.toString(arr));

		System.out.println(arr[N - k]);
	}

}
