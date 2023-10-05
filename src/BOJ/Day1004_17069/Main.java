package BOJ.Day1004_17069;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] house;
	static int [] dr = {0, 1, 1};
	static int[] dc = {1, 1, 0};
	static int dp[][][];
	

	public static void main(String[] args) {

		// 새집의 크기를 N*N 격자판으로 나타낼 수 있고 r 행번호 , c열번호
		// 파이프 하나는 2개의 연속된 칸을 차지한다
		// 오른쪽, 오른쪽아래, 아래 방향으로 옮길 수 있다. 45도만 회전 가능

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		house = new int[N][N];
		
		for(int d = 0 ; d<3; d++) {
		dp = new int[N - 1][N - 1][d];
		}
	}

}
