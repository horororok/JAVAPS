package BOJ.Day0825_2941;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String input = sc.next();
		char[] arr = new char[input.length()];
		for (int i = 0; i < input.length(); i++) {
			arr[i] = input.charAt(i);
		}
//		System.out.println(Arrays.toString(arr));
		int cnt = 0;
		int k = 0;
		while (k < input.length()) {
			if (k < input.length() - 1) {
				if (arr[k] == 'c' && (arr[k + 1] == '=' || arr[k + 1] == '-')) {
					k++;
				} else if (arr[k] == 'd' && arr[k + 1] == '-') {
					k++;
				} else if (arr[k] == 'l' && arr[k + 1] == 'j') {
					k++;
				} else if (arr[k] == 'n' && arr[k + 1] == 'j') {
					k++;
				} else if (arr[k] == 's' && arr[k + 1] == '=') {
					k++;
				} else if (arr[k] == 'z' && arr[k + 1] == '=') {
					k++;
				} else if (k < input.length() - 2 && arr[k] == 'd' && arr[k + 1] == 'z' && arr[k + 2] == '=') {
					k += 2;
				}
				k++;
			} else {
				k++;
			}
			cnt++;
			

		}

		System.out.println(cnt);
	}

}
