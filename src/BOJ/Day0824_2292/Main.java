package BOJ.Day0824_2292;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner (System.in);
		
		long N = sc.nextLong();
		
		//k번째 껍데기
		int k = 1;
		//누적합을 구해준다
		int sum = 1;
		while(N> sum) {
			sum += 6*k;
			k++;
		}
		System.out.println(k);
		
	}

}
