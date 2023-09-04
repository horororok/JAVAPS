package practice.Algorithm_Time;

import java.util.Scanner;

public class BOJ24313 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a1 = sc.nextInt();
		int a0 = sc.nextInt();
		int c = sc.nextInt();
		int n0 = sc.nextInt();

		
	
		if (a1 * n0 + a0 <= c * n0 && c>=a1) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

}
