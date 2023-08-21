package SWEA.Day0809_Ladder1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/input/input_Ladder1.txt"));

		Scanner sc = new Scanner(System.in);

		for (int TC = 1; TC <= 10; TC++) {
			sc.next();

			int map[][] = new int[100][100];

			int endR = -1;
			int endC = -1;

			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					int num = sc.nextInt();

					if (num == 1) {
						map[r][c] = 1;

					} else if (num == 2) {
						endR = r;
						endC = c;
					}
				}
			}

			int r = endR;		//r은 y좌표
			int c = endC;		//c는 x좌표

			while (r > 0) {
				// 반복조건, 종료조건
				if (c - 1 >= 0 && map[r][c - 1] == 1) {			//경계조건 설정 & 왼쪽에 1이 있다면 왼쪽으로 간다
					while (c - 1 >= 0 && map[r][c - 1] == 1) {
						c--;
					}
				} else if (c + 1 < 100 && map[r][c + 1] == 1) {	//경계조건 설정 & 오른쪽에 1이 있다면 오른쪽으로 간다.
					while (c + 1 < 100 && map[r][c + 1] == 1) {
						c++;
					}
				}
				r--;	//둘다 아니면 위로 간다
			}
			System.out.println("#" + TC + " " + c);
		}
	}

}
