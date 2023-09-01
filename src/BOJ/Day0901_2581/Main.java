package BOJ.Day0901_2581;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		// 범위 내의 소수를 찾아서
		// 합을 구하고
		// 소수중 가장 작은 값을 구한다

		int M = sc.nextInt();
		int N = sc.nextInt();

		if(M==1) {
			M=2;
		}
		
		
		
		int sum = 0;
		int cnt1 = 0;
		int min = 0;
		
		// M부터 N까지
		for (int i = N; i >= M; i--) {
			
			// i가 소수인지 판별
			int cnt = 0;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					cnt++;
					break;
				}
			}
			if (cnt == 0) {
				sum += i;
				cnt1++;
				min = i;
			}
		}
		
		if (cnt1 > 0) {
			System.out.println(sum);
			System.out.println(min);

		} else {
			System.out.println(-1);
		}

	}
}
