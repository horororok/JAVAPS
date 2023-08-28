package BOJ.Day0825_11399;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
//실패
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// 주어진 숫자들을 배열로 받고
		// 배열을 오름차순 정렬 하고
		// 누적합배열로 바꾸어서
		// 배열의 총 합을 구한다

		// 사람 수 입렭
		 int N = sc.nextInt();
	        int [] arr = new int [N];
	        for(int i = 0; i < N; i++) {
	            int input = sc.nextInt();
	            arr[i] = input;
	        }
//	        System.out.println(Arrays.toString(arr));
		// 오름차순 정렬
		// max
		int max = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		//해당 값을 인덱스로 하는 새로운 배열 값 1증가
		int cntarr[] = new int[N];
		for (int i = 0; i < N; i++) {
			cntarr[arr[i]] += 1;
		}
//		System.out.println(Arrays.toString(cntarr));
		
		//누적합
		int[] accumCntarr = new int[max+1];
		for (int i = 1; i <= max; i++) {
			accumCntarr[i] = accumCntarr[i - 1] + cntarr[i];
		}
//		System.out.println(Arrays.toString(accumCntarr));
		
		//오름차순
		int ansarr[] = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			ansarr[accumCntarr[arr[i]] - 1] = arr[i];
			accumCntarr[arr[i]]--;
		}
//		System.out.println(Arrays.toString(ansarr));
		
		//누적합 배열
		for(int i = 1; i<N; i++) {
			ansarr[i] += ansarr[i-1];
		}
//		System.out.println(Arrays.toString(ansarr));
		// 배열의 합
		int sum =0;
		for(int i = 0; i<N; i++) {
			sum += ansarr[i];
		}
		System.out.println(sum);

	}
}
