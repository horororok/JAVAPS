package BOJ.Day0913_4948;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		
		while (true) {
			long input = sc.nextLong();
			if (input == 0) {
				break;
			} 
			
			long cnt = 0;
			for(long i = input+1; i<=2*input; i++) {
				if(isPrime(i)) {
					cnt++;
				}
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	//소수 판별
	public static boolean isPrime(long a) {
		if (a < 2) {
			return false;
		}
		for (long i = 2; i * i <= a; i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

}