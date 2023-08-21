package SWEA.Day0814_1989;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/input/input_1989.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			char[] arr = new char[str.length()];
			char[] arr2 = str.toCharArray();
			for (int i = str.length() - 1, idx = 0; i >= 0; i--) {
				arr[idx++] = str.charAt(i);
			}
//			System.out.println(Arrays.toString(arr));

			int cnt = 0;
			for (int i = 0; i < str.length(); i++) {
				if (arr2[i] == (arr[i])) {
					cnt++;
				}
			}
			if (cnt == str.length()) {
				System.out.println("#" + tc + " " + 1);
			} else {
				System.out.println("#" + tc + " " + 0);
			}
		}
	}
}
