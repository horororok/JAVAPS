package BOJ.Day0904_1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in ));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[3];
		for(int i = 0; i<3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(Arrays.toString(arr));
		
		long num = power(arr[0], arr[1], arr[2]);
//		long ans = num % arr[2];
		System.out.println(num);
	}

	public static long power(int base, int exponent, int k) {
		//기저 사례 : 지수가 0이다
		if(exponent ==0) {
			return 1;
		}
		//지수를 반으로 나누고 재귀적으로 계산
		long halfPower = power(base, exponent/2, k);
		
		//지수가 짝수일 때
		if(exponent % 2 ==0) {
			return halfPower * halfPower % k;
		}else {	//지수가 홀수일 때
			return base * (halfPower *halfPower %k) %k ;
		}
		
	}
}
