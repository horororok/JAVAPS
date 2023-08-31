package practice.QuickSort;

import java.util.Arrays;

public class Pivot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 8, 14, 2, 15, 6, 10, 17, 8, 1, 4 };

		// 8의 위치는?
		int i = 0;
		int pivot = arr[i];

		int j = arr.length; // 구간의 오른쪽 끝(exclusive)
		// 한 구간은 매우 큰 값으로 끝난다고 가정

		// i, j가 교환할 필요가 있다면
		// i는 왼쪽에서 pivot보다 큰 값
		// j는오른쪽에서부터 pivot보다 작은 값

		while (i < j) {
			i++;
			while (arr[i] <= pivot) { // 작거나 같다면 증가시킨다
				i++;
			} // arr[i]는 pivot보다 큰 수
			j--;
			while (arr[j] > pivot) { // pivot보다 크다면 증가시키다
				j--; // arr[j]는 pivot보다 작거나 같은 수
			}

			if (i < j) {
				swap(arr, i, j);
			}

		}

		// while문이 종료되었다는 것은 현재 j <= i 인 상황
		// 왼쪽[0, j]에는 pivot보다 작거나 같은 수가
		// 오른쪽[j+1, n-1]에는 pivot보다 큰 수가 있음
		// pivot -> j
		swap(arr, 0, j);

		System.out.println(Arrays.toString(arr));
		System.out.println("정렬된 위치:" + j);

	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}