package SWEA.Day0821_1966;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/SWEA/Day0821_1966/input_1966.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int arr[] = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			insertionSort(arr);

			System.out.print("#" + tc + " ");
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	// 삽입 정렬 함수
	static void insertionSort(int[] arr) {
		int n = arr.length;
		// 배열의 두 번째 원소부터 시작
		for (int i = 1; i < n; i++) {
			// 현재 비교할 원소 저장
			int current = arr[i];
			// 현재 원소의 바로 왼쪽 인덱스
			int j = i - 1;

			// 현재 원소보다 큰 원소들을 오른쪽으로 한 칸씩 이동
			while (j >= 0 && arr[j] > current) {
				arr[j + 1] = arr[j];
				j--;
			}
			// 현재 원소를 올바른 위치에 삽입
			arr[j + 1] = current;
		}
	}
}
