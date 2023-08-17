package Day0809_Ladder1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/input/input_Ladder1.txt"));

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			int t = sc.nextInt();

			int arr[][] = new int[100][100];
			for (int j = 0; j < 100; j++) {
				for (int x = 0; x < 100; x++) {
					arr[j][x] = sc.nextInt();
				}
			}

			int[] dx = { -1, 1 };
			int dy = -1;

			for (int j = 0; j < 100; j++) {
				int lx;
				if (arr[99][j] == 2) {
					lx = j;
					for (int k = 99; k >= 0; k--) {
						for (int x = 0; x < 2; x++) {
							if (arr[k][lx+ dx[x]] == 1) {
								lx += dx[x];
							} else {
								break;
							}

						}
						
					}
					

				}

			}
		
		}

	}

}
