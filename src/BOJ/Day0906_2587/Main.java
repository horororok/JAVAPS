package BOJ.Day0906_2587;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);


		int sum = 0;
		int[] arr = new int[5];
		int[] arr2 = new int[5];
		for (int i = 0; i < 5; i++) {
			int input = sc.nextInt();
			arr[i] = input;
			arr2[i] = input / 10;
			sum += arr[i];
		}
//		System.out.println(Arrays.toString(arr));
		System.out.println(sum / 5);
		
		//counting sort
		int max = 0; 
		for(int i = 0; i<5; i++) {
			if(arr2[i]>max) {
				max = arr2[i];
			}
		}
//		System.out.println(Arrays.toString(arr2));
		
		int arr3[] = new int[max+1];
		for(int i = 0; i<5; i++) {
			arr3[arr2[i]]++;
		}
//		System.out.println(Arrays.toString(arr3));
		
		int idx = 0;
		for(int i = 0; i<max+1;i++) {
			while(arr3[i]>0) {
				arr2[idx] = i;
				arr3[i]--;
				idx++;
			}
		}
//		System.out.println(Arrays.toString(arr2));
		System.out.println(arr2[2]*10);
		
		
	}
}
