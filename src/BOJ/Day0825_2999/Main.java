package BOJ.Day0825_2999;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String input = sc.next();
		int N = input.length();

		// N을 약수를 저장할 배열
		boolean[] ys = new boolean[N + 1];
		int cnt = 0;
		int k = 1;
		while (k <= N) {
			if (N % k == 0) {
				ys[k] = true;
				cnt++;
			}
			k++;
		}

		// 약수를 원소로 갖는 배열
		int p = 0;
		int[] num = new int[cnt];
		for (int i = 0; i < N + 1; i++) {
			if (ys[i]) {
				num[p] = i;
				p++;
			}
		}

		int r, c;
		if (cnt % 2 == 0) {
			r = num[cnt / 2 - 1];
			c = num[cnt / 2];
		} else {
			r = num[cnt / 2];
			c = num[cnt / 2];
		}

		// 이차원 배열
		char[][] arr = new char[r][c];
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				arr[j][i] = input.charAt(i * r + j);
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(arr[i][j]);
			}
		}
	}
}
