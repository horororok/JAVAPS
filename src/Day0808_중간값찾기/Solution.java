package Day0808_중간값찾기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input/input_0808_01.txt"));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			int minIdx = i;
			int tmp = arr[i];
			for (int j = i; j < n; j++) {
				if (arr[j] < arr[minIdx]) {
					minIdx = j;
				}
				
			}
			arr[i] = tmp;
			arr[i] = arr[minIdx];
			arr[minIdx] = tmp;

		}
//		System.out.println(Arrays.toString(arr));
		System.out.println(arr[n / 2]);

	}

}
