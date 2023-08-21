package SWEA.Day0818_7102;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("src/Day0818_7102/input_7102.txt"));

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			// 카드 개수 입력
			int n = sc.nextInt();
			int m = sc.nextInt();

			// 각 카드 배열 초기화
			int arr1[] = new int[n];
			int arr2[] = new int[m];
			for (int i = 0; i < n; i++) {
				// 1부터 m까지 숫자 할당
				arr1[i] = i + 1;
			}
			for (int j = 0; j < m; j++) {
				// 1부터 m까지 숫자 할당
				arr2[j] = j + 1;
			}

			// 카드 합산 결과 배열 초기화
			int arr3[] = new int[n * m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					// 두 카드 숫자를 합산하여 arr3배열의 해당 인덱스 값을 증가
					arr3[arr1[i] + arr2[j]]++;
				}
			}

			int max = 0;
			// 최대 빈도값 계산
			for (int i = 0; i < n * m; i++) {
				if (arr3[i] > max) {
					max = arr3[i];
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < n * m; i++) {
				if (arr3[i] == max) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}
	}
}
