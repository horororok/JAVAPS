package AlgoTest.Day0821_AlgoTest2;

import java.util.Arrays;
import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// 8*8 바둑판
		// 0은 빈 공간 1은 백돌
		// 가로 세로 오목 판정
		// 6개연속일 경우 오목이 아니다
		// 오목 판정이 날 경우 앞으로 돌아가서 돌이 있나 확인

		// testcase
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			// 오른쪽 , 아래쪽 으로 가면서 판정
			int dr[] = { 0, 1 };
			int dc[] = { 1, 0 };

			// 주어진 바둑판
			int arr[][] = new int[8][8];
			for (int r = 0; r < 8; r++) {
				for (int c = 0; c < 8; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			boolean isOmok = false;

			// 바둑판 검사	
			
			int r1 = 0;
			int c1 = 0;
			
			for(int r = 0; r<8; r++) {
				if (arr[r][c1] == 1) {
					
					
				}
				
			}

		}

	}

}
