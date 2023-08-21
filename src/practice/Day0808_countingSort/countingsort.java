package practice.Day0808_countingSort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class countingsort {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input_0808_02.txt"));
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int i = 0; i < TC; i++) {
			int t = sc.nextInt();
			
			int[] counting = new int[101]; // 점수의 범위 0~100
			int temp[] = new int[1000]; // 정렬 될 배열

			int[] arr = new int[1000]; // 수열의 원소 1000개
			for (int j = 0; j < 1000; j++) {
				arr[j] = sc.nextInt();
			}

			// counting sort
			// 1.
			for (int j = 0; j < 1000; j++) {
				// arr의 value 값을 index로 하는 counting 배열의 값 1증가
				counting[arr[j]] += 1;
			}
//			System.out.println(Arrays.toString(counting));

			// 2.
			for (int j = 1; j < 101; j++) {
				// 누적합

				counting[j] += counting[j - 1];
			}

			// 3.
			for (int j = 999; j >= 0; j--) {
				// i번째 원소를 인덱스로 하는 counting 배열을 1 감소시킨 뒤
				// counting 배열의 값을 인덱스로 하여 temp에 value 값 저장
				int value = arr[j];
				counting[value]--;
				temp[counting[value]] = value;
			}

//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(counting));
			System.out.println(Arrays.toString(temp));

		}
	}

}
