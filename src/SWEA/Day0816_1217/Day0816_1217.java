package SWEA.Day0816_1217;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day0816_1217 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/Day0816_1217/input_1217.txt"));

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();

			int n = sc.nextInt();
			int m = sc.nextInt();

			int ans = 1;
			while (m > 0) {
				ans *= n;
				m--;
			}
			System.out.printf("#%d %d%n", tc, ans);

		}
	}

}
