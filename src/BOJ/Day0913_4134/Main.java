package BOJ.Day0913_4134;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			long n = Long.parseLong(br.readLine());

			while (!isPrime(n)) {
				n++;

			}
			sb.append(n).append("\n");
		}
		System.out.println(sb);
	}

	public static boolean isPrime(long a) {
		if (a < 2) {
			return false;
		}

		for (long i = 2; i * i <= a; i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;

	}
}
