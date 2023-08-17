package Day0809_파리퇴치;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/input/input_파리퇴치.txt"));

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int[][] arr = new int[n][n];		//2차원배열 설정
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					arr[j][k] = sc.nextInt();
				}
			}

			int max = 0;
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {				//2차원 배열 순회
					int sum = 0;
					for (int k = y; k < y + m; k++) {		//y좌표
						for (int l = x; l < x + m; l++) {	//x좌표
							if (y + m <= n && x + m <= n) {	//경계조건 설정
								sum += arr[k][l];			//합을 구해준다.
							}
						}
					}
					if (sum > max) {
						max = sum;
					}
				}
			}

			System.out.println("#" + (i+1)+" "+ max);
		}

	}

}
