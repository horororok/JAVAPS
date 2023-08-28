package BOJ.Day0825_3052;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// 숫자 열개 입력
		// 42로 나눈 나머지를 구한다
		// 서로 다른 값이 몇 개 있는지 출력
		// 42로 나눈 나머지로 배열 생성
		// 같은 값이 몇 개 있는지 찾은후 10에서 빼준다.

		// 배열
		int[] mod = new int[10];
		for (int i = 0; i < 10; i++) {
			int input = sc.nextInt();
			mod[i] = input % 42;
		}
		
		// 다른 값 개수
		
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 10; j++) {
				if (mod[i] == mod[j]) {
					mod[j] = -1;
				}
			}
		}
		
		int cnt = 0;
		for(int i = 0; i<10; i++) {
			if(mod[i]!=-1) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
