package BOJ.Day0831_2745;

import java.util.Scanner;

public class Main {
//틀림
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		// 'A'의 유니코드는 65
		// '1'의 유니코드는 49

		String N = sc.next();
		int B = sc.nextInt();

		int len = N.length();
		long ans = 0;
		for (int i = 0; i < len; i++) {
			int k = (int) N.charAt(i);

			int sum = 1;
			for (int j = 0; j < len - 1 - i; j++) {
				sum *= B;
			}
			if (k < 50) {

				ans += (k - 48) * sum;
			} else {
				ans += (k - 55) * sum;
			}

		}
		System.out.println(ans);

	}

}
