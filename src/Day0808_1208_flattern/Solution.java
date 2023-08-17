package Day0808_1208_flattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/input/input_0808_1208.txt"));
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			int t = sc.nextInt();

			int[] counting = new int[101];
			int[] temp = new int[100];

			int[] arr = new int[101];
			for (int j = 0; j < 100; j++) {
				arr[j] = sc.nextInt();
			}

			// counting sort
			// 1.
			for (int j = 0; j < 100; j++) {
				counting[arr[j]]++;
			}
//			System.out.println(Arrays.toString(counting));
			for (int j = 1; j < 101; j++) {
				counting[j] += counting[j - 1];
			}
//			System.out.println(Arrays.toString(counting));
			for (int j = 99; j >= 0; j--) {
				int value = arr[j];
				counting[value]--;
				temp[counting[value]] = value;
			}
//			System.out.println(Arrays.toString(temp));

			for (int j = 0; j < t; j++) {
				temp[99]--;
				temp[0]++;

				for (int k = 0; k < 100; k++) {
					int tmp = 0;
					if (temp[k] > temp[k + 1]) {
						tmp = temp[k];
						temp[k] = temp[k + 1];
						temp[k + 1] = tmp;
					} else {
						break;
					}
				}
				for (int k = 99; k >= 0; k--) {
					int tmp = 0;
					if (temp[k] < temp[k - 1]) {
						tmp = temp[k];
						temp[k] = temp[k - 1];
						temp[k - 1] = tmp;
					} else {
						break;
					}
				}
			}
			System.out.println("#" + (i+1) + " "+ (temp[99]-temp[0]));
		}
	}
}
