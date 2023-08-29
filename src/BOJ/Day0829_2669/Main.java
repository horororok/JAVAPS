package BOJ.Day0829_2669;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// 네 개의 사각형이 입력
		// 100*100 배열 만들어서
		// 입력 들어오는 것들 다 1 넣고
		// 1갯수 세주자

		// 배열
		int[][] arr = new int[100][100];

		for (int T = 0; T < 4; T++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					arr[i][j] = 1;
				}
			}

		}
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 1) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);

	}

}
