package SWEA.Day0828_1289;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/SWEA/Day0828_1289/input_1289.txt"));
		Scanner sc = new Scanner(System.in);

		// 입력을 배열로 받아준다

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			
			//한글자씩 받아서 배열 생성
			char[] mem = sc.next().toCharArray();
			
			
			//앞의 배열요소와 다르면 +1
			int cnt = 0;
			//1로 시작하면 개수가 1부터 시작
			if (mem[0] == '1') {
				cnt = 1;
				for (int i = 1; i < mem.length; i++) {
					if (mem[i] != mem[i - 1]) {
						cnt++;
					}
				}
			} else {
				for (int i = 1; i < mem.length; i++) {
					if (mem[i] != mem[i - 1]) {
						cnt++;
					}
				}
			}

			System.out.println("#" + tc + " " + cnt);

		}
	}
}
