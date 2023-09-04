package BOJ.Day0904_19532;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		// 연립방정식의 풀이
		// x의 계수를 없애고 y값을 구해준다
		// 구해준 y값을 대입해서 x값을 구해준다.

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		int f = sc.nextInt();
		
		int x = 0;
		int y = 0;
		
		if (a!=0) {
			y = (c*d - a*f) / (b*d - a*e);
			 x = (c-b*y)/a;
			
			
		}else {
			 y = c / b;
			 x = (f - (e*c)/b)/d;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(x).append(" ").append(y);
		
		System.out.println(sb);
		
		
		
		
	}
}
