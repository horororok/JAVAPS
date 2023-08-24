package SWEA.Day0824_1974;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/SWEA/Day0824_1974/input_1974.txt"));
		Scanner sc = new Scanner(System.in);

		// 가로 탐색 / 세로 탐색 / 1, 4, 7 인덱스의 팔방 탐색

		// test case
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			// 스도쿠를 이차원 배열로
			int[][] arr = new int[9][9];
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			// 중복이면 true
			boolean Dup = false;
			// 중복 탐색을 위한 배열

			// 가로 탐색
			outer: for (int r = 0; r < 9; r++) {
				int num[] = new int[10];
				for (int c = 0; c < 9; c++) {
					int val = arr[r][c];
					num[val]++;
					if (num[val] > 1) {
						Dup = true;
						break outer;
					}
				}
			}

			// 세로 탐색
			if (!Dup) {
				outer: for (int c = 0; c < 9; c++) {
					int num[] = new int[10];
					for (int r = 0; r < 9; r++) {
						int val = arr[r][c];
						num[val]++;
						if (num[val] > 1) {
							Dup = true;
							break outer;
						}
					}
				}
			}

			// 8방 탐색을 위한 배열
			if (!Dup) {
				int[] aa = { 1, 4, 7 };

				int dr[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
				int dc[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

				// 8방 탐색
				outer: for (int x = 0; x < 3; x++) {
					for (int y = 0; y < 3; y++) {
						int num[] = new int[10];
						for (int j = 0; j < 8; j++) {
							int val = arr[aa[x] + dr[j]][aa[y] + dc[j]];
							num[val]++;
							if (num[val] > 1) {
								Dup = true;
								break outer;
							}

						}
					}

				}
			}
			if (Dup) {
				System.out.println("#" + tc + " " + 0);
			} else {
				System.out.println("#" + tc + " " + 1);
			}

		}

	}

}
