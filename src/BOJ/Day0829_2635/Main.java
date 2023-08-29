package BOJ.Day0829_2635;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// 첫번 째 정수가 주어졌을 때
		// 첫번째 정수 - 두번째 정수 를했을 때 배열의 길이가 가장 긴 경우

		int input = sc.nextInt();
		
		int arr[] = new int[30001];
		arr[0] = input;
		int ar = input;
		int max = 0;
		int num = 0;
		while(ar>=0) {
			
			int cnt = 0;
			arr[1] = ar;
			for(int i = 2; i<30001;i++) {
				arr[i] = arr[i-2]-arr[i-1];
				
				if(arr[i] <0) {
					cnt = i;
					break;
				}
			}
			if(cnt>max) {
				max = cnt;
				num = ar;
			}
			ar--;
		}
		System.out.println(max);
		int ansarr[] = new int [max];
		ansarr[0] = input;
		ansarr[1] = num;
		for(int i = 2; i<max; i++) {
			ansarr[i] = ansarr[i-2] - ansarr[i-1];
		}
		for(int i = 0; i<max; i++) {
			System.out.print(ansarr[i]+ " ");
		}
	}
}
