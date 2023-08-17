package Day0808_최빈수구하기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/input/input_0808_02.txt"));
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		
		for (int i = 0; i < TC; i++) {
			int t = sc.nextInt();
			int[] counting = new int[101]; // 점수의 범위 0~100
			
			
			int[] arr = new int[1000]; // 수열의 원소 1000개
			for (int j = 0; j < 1000; j++) {
				arr[j] = sc.nextInt();
			}
			
			
			for (int j = 0; j < 1000; j++) {
				// arr의 value 값을 index로 하는 counting 배열의 값 1증가
				counting[arr[j]]++;
			}
			
			int max = 0;
			int ans = 0;
			for(int j = 0; j<100; j++) {
				if(counting[j]>=max) {
					max = counting[j];
					ans = j;
				}
			}
			System.out.printf("#%d %d%n", i+1, ans);

		}
	}
}
