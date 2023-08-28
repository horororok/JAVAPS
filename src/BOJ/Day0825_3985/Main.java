package BOJ.Day0825_3985;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
//실패
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//케이크 길이
		int L = sc.nextInt();
		//사람 수
		int N = sc.nextInt();
		
		
		//가장 많은 조각을 원하는 방청객
		int maxN = 0;
		//원하는 조각수
		int max = 0;
		int[] arr = new int[N];
		int[] start = new int[N];
		int PK [][] = new int [N][2]; 
		for (int i = 0; i < N; i++) {
			int P = sc.nextInt();
			int K = sc.nextInt();
			
			arr[i] = K - P + 1;
			if (arr[i] > max) {
				max = arr[i];
				maxN = i + 1;
			}
			start[i] = P;
			
		}
		System.out.println(maxN);

		// 조각 나눠주기
		int[] cake = new int[L];

		// 방청객 번호
		for (int i = 0; i < N; i++) {
			// 케이크 번호
			for (int k = start[i]; k < start[i] + arr[i]; k++) {
				if (cake[k] == 0) {
					cake[k] = i + 1;
				} else if(cake[k] != 0 && start[i]<N) {
					start[i] += 1;
				}
			}
		}

		int q = 0;
		int[] mm = new int[N + 1];
		for (int i = 1; i <= N + 1; i++) {
			for (int j = 0; j < L; j++) {
				if (cake[j] == i) {
					mm[i] += 1;
				}
			}
		}

		int mmm = 0;
		int ll = 0;
		for (int i = 0; i < N + 1; i++) {
			if (mm[i] > mmm) {
				mmm = mm[i];
				ll = i;
			}
		}
		System.out.println(ll);
	}
}
