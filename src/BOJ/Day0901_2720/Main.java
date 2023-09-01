package BOJ.Day0901_2720;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 큰것부터 나눠서 나머지를 더해 준다

		Scanner sc = new Scanner(System.in);

		// testcase
		int T = sc.nextInt();

		int[] coin = { 25, 10, 5, 1 };

		for (int tc = 0; tc < T; tc++) {

			int change = sc.nextInt();

			int[] arr = new int[4];
			int X = change;
			for (int i = 0; i < 4; i++) {
				arr[i] = X / coin[i];
				X %= coin[i];
			}

			for (int i = 0; i < 4; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();

//			int c1 = change % 25;
//			int nc1 = change / 25;
//			
//			int c2 = c1 % 10;
//			int nc2 = c1 / 10;
//			
//			int c3 = c2 %10;
//			int nc3 = c2 / 10;
//			
//			int c4 = c3 % 1;
//			int nc4 = c3 /1;

		}
	}
}
