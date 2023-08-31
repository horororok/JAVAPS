package BOJ.Day0831_10798;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[][] arr = new char[5][15];
		for (int i = 0; i < 5; i++) {

			String input = sc.next();
			arr[i] = input.toCharArray();

		}

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (i > arr[j].length - 1) {
					continue;
				} else {
					System.out.print(arr[j][i]);
				}
			}
		}

	}
}
