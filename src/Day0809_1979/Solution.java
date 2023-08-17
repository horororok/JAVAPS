package Day0809_1979;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/input/input_1979.txt"));

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int TC = 1; TC <= t; TC++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			int arr[][] = new int[N+2][N+2];
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					arr[i][j] = sc.nextInt();			//배열 인덱스는 0~n+1 까지 있지만 요소는 1~n까지 인덱스에만 채워짐 인덱스 0과 인덱스 n+1에는 int의 기본값인 0
				}
			}

			int ans = 0;
			// 행
			for (int i = 0; i < N + 1; i++) {			//i는 y좌표	0 <= i <= N+1
				int count = 0;							
				for (int j = 0; j < N + 1; j++) {		//j는 x좌표	0 <= j <= N  y좌표에 따른 x좌표 변화
					if (arr[i][j] == 0) {				
						if (arr[i][j + 1] != arr[i][j])
							count++;
					}
					else {
						if (arr[i][j + 1] == arr[i][j])
							count++;
						else {
							if (count == K)
								ans++;
							count = 0;
						}
					}
				}
				if (count == K) {
					ans++;
				}
			}

			// 열
			for (int i = 0; i < N + 1; i++) {
				int count = 0;
				for (int j = 0; j < N + 1; j++) {		//x좌표에 따른 y좌표 변화
					if (arr[j][i] == 0) {
						if (arr[j + 1][i] != arr[j][i])
							count++;
					}
					else {
						if (arr[j + 1][i] == arr[j][i])
							count++;
						else {
							if (count == K)
								ans++;
							count = 0;
						}
					}
				}
				if (count == K)
					ans++;
			}
			
			System.out.printf("#%d %d\n", TC, ans);
		}

	}
}
