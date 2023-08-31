package practice.QuickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// arr에 대해 퀵정렬
		// 퀵정렬: 하나의 원소를 정렬된 위치에 놓는 것은 쉽다
		// mergeSort(arr, 0, N-1);
		quickSort(arr, 0, N);

		// 한줄씩 출력
		// 모아서 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append('\n');
		}
		System.out.println(sb.toString());

	}

	private static void quickSort(int[] arr, int l, int h) {
		if (l < h) { // 구간의 크기가 2 이상이라면

			int j = partition(arr, l, h);
			// arr에서 pivot을 정렬된 위치에 놓고
			// 정렬된 위치를 반환 받아 j에 저장

			quickSort(arr, l, j);
			quickSort(arr, j + 1, h);

		}

	}

	private static int partition(int[] arr, int l, int h) {
		int pivot = arr[l];
		int i = l;
		int j = h;

		while (i < j) {
			do
				i++;
			while (arr[i] <= pivot);

			do
				j--;
			while (arr[j] > pivot);

			if (i < j)
				swap(arr, i, j);

		}
		swap(arr, l, j); // pivot을 정렬된 위치에 놓기
		return j; // 정렬된 위치를 반환
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

}
