package BOJ.Day0901_2903;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N + 1];
		arr[0] = 2;
		for (int i = 1; i < N + 1; i++) {
			arr[i] = arr[i - 1] * 2 - 1;
		}
		int ans = (int) Math.pow(arr[N], 2);
		System.out.println(ans);
	}
}
