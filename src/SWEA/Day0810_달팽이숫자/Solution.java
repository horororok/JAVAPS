package SWEA.Day0810_달팽이숫자;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/input/input_0810_달팽이숫자.txt"));

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc < t+1; tc++) {
			
			int n = sc.nextInt();

			int[][] arr = new int[n][n];

			int r = 0;
			int c = 0;
			int cnt = 1;
			
			int idx = 0;								// 우 하 좌 상

			arr[r][c] = cnt;							//배열에 요소 대입

			while (cnt < n * n) {						//0~(n*n-1) 까지 반복
				if (idx == 0) { 						//idx가 0이면  열 인덱스++(오른쪽으로 진행
					c++; 
					if (c >= n || arr[r][c] != 0) { 	//2차배열이 끝나거나(벽을 만나거나) 0이 아니면(이미 채워져있으면) 
						c--;							//열 인덱스 --	다시 돌아와서
						r++;							//행 인덱스 ++   아래로 진행
						idx = 1;						//idx=1일 경우로 간다
					}
				} else if (idx == 1) { 					
					r++;								//idx가 1이면 행인덱스++(아래로 진행)
					if (r >= n || arr[r][c] != 0) {		//벽을 만나거나, 0이아니면(이미 채워져있으면)
						r--;							//행 인덱스 --		다시 돌아와서 
						c--;							//열인덱스 --		왼쪽으로 진행
						idx = 2;						//idx=2일경우로 간다
					}
				} else if (idx == 2) {					//idx가 2이면 열인덱스--(위로 진행) 
					c--; 
					if (c < 0 || arr[r][c] != 0) {		//벽을 만나거나 (왼쪽의 벽이므로 0) 0이  아니면(이미 채워져 있으면)
						c++;							//열 인덱스++		다시 돌아와서
						r--;							//행 인덱스--		위로 진행
						idx = 3;						//idx가 3일경우로 간다
					}
				} else { 								//idx가 3이면 위로 진행
					r--;
					if (r < 0 || arr[r][c] != 0) {		//벽을 만나거나(위쪽의 벽이므로 0) 0이 아니면(이미 채워져 있으면)
						c++;							//열 인덱스 ++		다시 돌아와서
						r++;							//행 인덱스 ++		오른쪽으로 진행
						idx = 0;						//idx가 0일때로 간다
					}
				}
				arr[r][c] = ++cnt;						//r행 c열의 값은 ++cnt
			}

			System.out.println("#" + tc);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
		
		
		
		
		
		
	}
}
