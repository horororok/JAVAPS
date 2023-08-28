package BOJ.Day0825_3985;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 가장 많은 조각을 원하는 방청객의 번호 출력
		// P와 K를 원소로 가지는 이차원 배열 생성
		// 케이크 배열 생성
		// 케이크를 가져갈 때 방청객의 번호를 케이크 배열에 삽입
		// 케이크 배열에서 가장 많이 가지고 있는 방청객의 번호 출력

		// 케이크 길이
		int L = sc.nextInt();
		// 방청객 수
		int N = sc.nextInt();

		// 이차원 배열
		int PK[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				PK[i][j] = sc.nextInt();
			}
		}

		// 가장 많은 조각을 원하는 방청객
		int max = 0; // 조각수
		int maxP = 0; // 방청객 번호
		for (int i = 0; i < N; i++) {
			if (PK[i][1] - PK[i][0] > max) {
				max = PK[i][1] - PK[i][0];
				maxP = i + 1;
			}
		}
		System.out.println(maxP);

		// cake 배열생성
		int cake[] = new int[L + 1];
		for (int i = 0; i < N; i++) {
			for (int j = PK[i][0]; j <= PK[i][1]; j++) {
				if (cake[j] == 0) {
					cake[j] = i + 1;
				}
			}
		}

		int maxcnt = 0;
		int pig = 0;
		for (int i = 1; i < N + 1; i++) {
			int cnt = 0;
			for (int j = 0; j < L + 1; j++) {
				if (cake[j] == i) {
					cnt++;
				}
			}
			if (cnt > maxcnt) {
				maxcnt = cnt;
				pig = i;
			}
		}
		System.out.println(pig);
	}

}
