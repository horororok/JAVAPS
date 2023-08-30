package BOJ.Day0830_25206;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		double sum = 0;
		double total = 0;
		for (int tc = 0; tc < 20; tc++) {
			String arr[] = new String[3];
			for (int i = 0; i < 3; i++) {
				String input = sc.next();
				arr[i] = input;
			}

			double k = Double.parseDouble(arr[1]);

			if (arr[2].equals("A+")) {
				sum += k * 4.5;
			} else if (arr[2].equals("A0")) {
				sum += k * 4.0;
			} else if (arr[2].equals("B+")) {
				sum += k * 3.5;
			} else if (arr[2].equals("B0")) {
				sum += k * 3.0;
			} else if (arr[2].equals("C+")) {
				sum += k * 2.5;
			} else if (arr[2].equals("C0")) {
				sum += k * 2.0;
			} else if (arr[2].equals("D+")) {
				sum += k * 1.5;
			} else if (arr[2].equals("D0")) {
				sum += k * 1.0;
			} else if (arr[2].equals("F")) {
				// 빵점
			} else if (arr[2].equals("P")) {
				continue;
			}
			total += k;

		}
		// 0으로 나누는 경우 제외해준다
		double ans = (total != 0) ? (sum / total) : 0;

		// 소수 여섯번째 자리 까지 출력
		System.out.printf("%.6f%n", ans);

	}
}
