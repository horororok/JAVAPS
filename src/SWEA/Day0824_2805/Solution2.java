package SWEA.Day0824_2805;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution2{

    public static void main(String[] args) throws FileNotFoundException {
    	System.setIn(new FileInputStream("src/SWEA/Day0824_2805/input_2805.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			sc.nextLine();

			// 농장 수확량 이차원배열
			int[][] arr = new int[N][N];
			for (int r = 0; r < N; r++) {
				String input = sc.nextLine();
				for (int c = 0; c < N; c++) {
					arr[r][c] = input.charAt(c) - '0';
				}
			}
			
			//좌표 절댓값의 합이 N/2이하일 경우에만 더해준다.
			int sum = 0;
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					if(Math.abs(r-N/2)+ Math.abs(c-N/2)<=N/2) {
						sum += arr[r][c];
					}
				}
			}
			System.out.printf("#%d %d%n",tc, sum);
        }
    }
}
