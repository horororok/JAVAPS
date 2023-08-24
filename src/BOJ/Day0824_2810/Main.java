package BOJ.Day0824_2810;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		
		int N = sc.nextInt();
		sc.nextLine();
		
		//배열로 사람 받기
		char[] arr = new char[N];
		String input = sc.nextLine();
		for(int i = 0; i<N; i++) {			
			arr[i] = input.charAt(i);
		}

		//컵홀더 개수
		int sum =1;
		int i = 0;
		while(i<N) {
			if(arr[i] == 'S') {
				sum++;
			}else if(arr[i] == 'L') {
				sum++;
				i++;
			}		
			i++;			
		}
		System.out.println(Math.min(sum,  arr.length));
	}
}
