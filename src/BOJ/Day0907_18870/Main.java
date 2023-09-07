package BOJ.Day0907_18870;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long [] arr = new long[N];
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextLong();
		}
		
		Arrays.sort(arr);
		int idx = 0;
		int ii = 0;
		while(idx <N){
			if(arr[idx] == arr[idx-1]) {
				arr[idx] = ii;
			}else {
				arr[idx] = ii;
				ii++;
			}
			idx++;
		}
		
		
		
		
		
		
		
		
		
		
	}
}
