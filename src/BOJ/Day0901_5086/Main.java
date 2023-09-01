package BOJ.Day0901_5086;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String arr[] = new String[2];

		while (true) {

			String input = sc.nextLine();

			arr = input.split(" ");

//			System.out.println(Arrays.toString(arr));
			int N = Integer.parseInt(arr[0]);
			int P = Integer.parseInt(arr[1]);
			if (N == 0 && P == 0) {
				break;
			}

			if (N < P) {
				if (P % N == 0) {
					System.out.println("factor");
				} else {
					System.out.println("neither");
				}
			} else {
				if (N % P == 0) {
					System.out.println("multiple");
				} else {
					System.out.println("neither");
				}
			}

		}

		
	}
}
