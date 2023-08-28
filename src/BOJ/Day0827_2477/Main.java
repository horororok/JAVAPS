package BOJ.Day0827_2477;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// 길이가 500이하라 했으므로 500*500 이차원 배열 생성
		// 주어진 방향과 길이를 따라 모두 1로 바꾼다
		// 각 행 별로 원소가0인 경우
		// 왼쪽이 1 위쪽이 1인 경우 1로 바꿔줌

		int K = sc.nextInt();

		// 502*502 배열 만들어줌
		int[][] field = new int[1002][1002];

		// 주어진 방향과 길이
		// 출발점의 좌표
		
		int curr = 500;
		int curc = 500;
		for (int i = 0; i < 6; i++) {
			int dir = sc.nextInt();
			int len = sc.nextInt();
			// 현재 좌표
			
			switch (dir) {
			// 동
			case 1:
				for (int j = 0; j < len; j++) {
					field[curr][curc + j] = 1;
					
				}
				curc +=len;
				break;
			// 서
			case 2:
				for(int j = 0; j<len;j++) {
					field[curr][curc-j] = 1;
					
				}
				curc -= (len);
				break;
				//남
			case 3:
				for (int j = 0; j<len;j++) {
					field[curr+j][curc] =1;
					
				}
				curr += len;
				break;
				//북
			case 4:
				for(int j =0; j<len;j++) {
					field[curr-j][curc]=1;
					
				}
				curr -= (len);
				break;
			}
		}
		
		for(int i = 1; i<1002; i++) {
			for(int j = 1; j<1002; j++) {
				if(field[i-1][j] == 1 && field[i][j-1]==1) {
					field[i][j] =1;
				}	
			}
		}
		
		int cnt = 0;
		for(int i = 0; i<1002; i++) {
			for(int j = 0; j<1002; j++) {
				if(field[i][j]==1) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt *K);
		
	}
}
