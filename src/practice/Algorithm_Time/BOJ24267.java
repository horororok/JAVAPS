package practice.Algorithm_Time;

import java.util.Scanner;

public class BOJ24267 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		
		
		long sum = 0;
		long cumsum = 0;
		for(int i = 1; i<n-1;i++) {
			sum+= i;
			cumsum+= sum;
		}
		
		
		System.out.println(cumsum);
		System.out.println(3);
		
	}

}
