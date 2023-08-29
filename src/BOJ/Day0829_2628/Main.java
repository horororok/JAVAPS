package BOJ.Day0829_2628;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// 가로길이와 세로길이에 가로별, 세로별 잘라야 하는 갯수를 더해준 배열을 만들어 준다.
		// 잘라야 하는 라인을 싹다 1로 채워준다.

		// 가로 세로
		int W = sc.nextInt();
		int H = sc.nextInt();

		// 자르는 횟수
		int N = sc.nextInt();

		int arr1[] = new int[N];
		int arr2[] = new int[N];

		int cnt1 = 0;
		int cnt2 = 0;
		for (int i = 0; i < N; i++) {
			// 자르는 방향 : 가로인지 세로인지
			int rc = sc.nextInt();
			// 자르는 번호
			int num = sc.nextInt();

			arr1[i] = rc;
			arr2[i] = num;

			if (arr1[i] == 0) {
				cnt1++;
			} else {
				cnt2++;
			}
		}

		// 가로 번호
		int[] arr3 = new int[cnt1 + 1];
		// 세로 번호
		int[] arr4 = new int[cnt2 + 1];
		int sidx = 0;
		int gidx = 0;
		for (int i = 0; i < N; i++) {

			if (arr1[i] == 0) {
				arr3[sidx] = arr2[i];
				sidx++;
			} else {
				arr4[gidx] = arr2[i];
				gidx++;
			}
		}
		arr3[cnt1] = H;
		arr4[cnt2] = W;

		Arrays.sort(arr3);
		Arrays.sort(arr4);

		for (int i = cnt1; i > 0; i--) {
			arr3[i] = arr3[i] - arr3[i - 1];
		}
		for (int i = cnt2; i > 0; i--) {
			arr4[i] = arr4[i] - arr4[i - 1];
		}

		int max = 0;
		for (int i = 0; i < cnt1 + 1; i++) {
			for (int j = 0; j < cnt2 + 1; j++) {
				if (arr3[i] * arr4[j] > max) {
					max = arr3[i] * arr4[j];
				}
			}
		}
		System.out.println(max);
	}
}
