package BOJ.Day0824_2798;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		//카드 숫자의 배열
		int arr[] = new int [N];
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		//3장의 합 중 최댓값
		int sum = 0;
		int max = 0;
		for(int i= 0; i<N; i++) {
			for(int j = 0; j<N; j++) {			
				for(int k = 0; k<N; k++) {
					if(i!=k&&i!=j&&j!=k) {
						sum = arr[i] + arr[j] + arr[k];
						if(sum>= max && sum<=M) {
							max = sum;
						}
					}
				}
			}
		}
		System.out.println(max);
		
	}

}
