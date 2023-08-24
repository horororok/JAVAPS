package BOJ.Day0824_1592;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();

		// 공받은 횟수를 배열로
		int bg[] = new int[N];
		bg[0] = 1;
		// 공던진 횟수
		int cnt = 0;
		// 공던지기 시작
		int k = 0;
		while (bg[k] < M) {
			
			if (bg[k] % 2 == 1) {
				int val = (k + L) % N;
				bg[val]++;
				k = val;
			} else if (bg[k] % 2 == 0) {
				int val = (k - L + N) % N;
				bg[val]++;
				k = val;
			}
			
			cnt++;
		}
		System.out.println(cnt);
	}

}
