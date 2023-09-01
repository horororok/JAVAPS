package BOJ.Day0901_1193;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();
		int Y = X;
		int k = 1;
		while (Y > 0) {
			Y -= k;
			k++;
		}
//		System.out.println(k);

		int l = 0;
		for (int i = 0; i < k - 1; i++) {
			l += i;
		}
//		System.out.println(l);
		int ans11 = X - l;

		int ans1 = 0;
		int ans2 = 0;

		ans1 = k - ans11;
		ans2 = ans11;

		if ((k - 1) % 2 == 0) {
			System.out.println(ans2 + "/" + ans1);

		} else {
			System.out.println(ans1 + "/" + ans2);
		}
	}
}
