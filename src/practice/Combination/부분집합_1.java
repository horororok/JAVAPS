package practice.Combination;

import java.util.Arrays;

public class 부분집합_1 {
//반복문 이용
	public static String[] 재료 = { "오이", "우엉", "햄", "참치" };

	public static void main(String[] args) {
		int N = 4;
		int[] sel = new int[N];

		// 4개 중에 뽑기
		// 1이면 뽑았다
		for (int a = 0; a < 2; a++) {
			sel[0] = a;
			for (int b = 0; b < 2; b++) {
				sel[1] = b;
				for (int c = 0; c < 2; c++) {
					sel[2] = c;
					for (int d = 0; d < 2; d++) {
						sel[3] = d;
						System.out.println(Arrays.toString(sel));
						for (int i = 0; i < N; i++) {
							if (sel[i] == 1) {
								System.out.print(재료[i]);
							}
						}
						System.out.println(":김밥");
					}
				}
			}
		}

	}

}
