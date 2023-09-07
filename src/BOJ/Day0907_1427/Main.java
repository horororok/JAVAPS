package BOJ.Day0907_1427;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String N = sc.next();
		
		char arr[] = N.toCharArray();
		
//		System.out.println(Arrays.toString(arr));
		
		int [] arr2 = new int [arr.length];
		for(int i = 0; i<arr.length; i++) {
			arr2[i] = arr[i]-'0';
		}
		
//		System.out.println(Arrays.toString(arr2));
		
		//counting sort
		int max = 0;
		for(int i = 0; i<arr2.length; i++) {
			if(arr2[i]>max) {
				max = arr2[i];
			}
		}
		
		int count[] = new int[max+1];
		for(int i = 0; i<arr2.length; i++) {
			count[arr2[i]]++;
		}
		
		int idx = 0;
		for(int i = max; i>=0; i--) {
			while(count[i]>0) {
				arr2[idx] = i;
				idx++;
				count[i]--;
			}
		}
		
		System.out.println(Arrays.toString(arr2));
		
//		for(int i = arr2.length-1; i>=0; i--) {
//			System.out.print(arr2[i]);
//		}
		
		
		
	}
}
