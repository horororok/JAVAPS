package BOJ.Day0913_13241;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long A = sc.nextLong();
		long B = sc.nextLong();

		long ans = LCM(A, B);
		System.out.println(ans);

	}

	//최대공약수
	public static long GCD(long a, long b) {
		if (b == 0) {
			return a;
		} else {
			return GCD(b, a % b);
		}
	}
	
	//최소공배수
	public static long LCM(long a, long b) {
		return (a * b) / GCD(a, b);
	}

}
