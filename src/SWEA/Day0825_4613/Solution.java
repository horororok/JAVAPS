package SWEA.Day0825_4613;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/SWEA/Day0825_4613/input_4613.txt"));
		Scanner sc = new Scanner(System.in);
		
		//testscase
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T;tc++) {
			//N개의 줄
			int N = sc.nextInt();
			//M개의 문자로 이루어진 문자열
			int M = sc.nextInt();
			
			//색 이차원배열
			char [][] arr = new char[N][M];
			for(int i = 0; i<N; i++) {
				String input = sc.next();
				for(int j = 0;j<M; j++){
					arr[i][j] = input.charAt(j);
				}
			}
			System.out.println(Arrays.deepToString(arr));
			
			
			                                                                                                         
			
			
			
			
			
			
			
			
			
		}
		
	}

}
