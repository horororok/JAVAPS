package Day0816_1215;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day0816_1215 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/Day0816_1215/input_1215.txt"));

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			sc.nextLine();

			char arr[][] = new char[8][8];
			for (int i = 0; i < 8; i++) {
				String input = sc.nextLine();
				for (int j = 0; j < 8; j++) {
					arr[i][j] = input.charAt(j);
				}
			}

			// 회문 개수 세는 변수
			int cnt = 0;

			// 행 검사
			for (int i = 0; i < 8; i++) { // 행 인덱스
				for (int j = 0; j <= 8 - n; j++) { // 열인덱스(길이 n인 회문을 찾으므로)
					boolean isPalindrome = true; // 회문인지 판단하는 변수
					for (int k = 0; k < n / 2; k++) { // 회문의 앞에서부터 vs 뒤에서부터 같은지 비교
						if (arr[i][j + k] != arr[i][(j + n) - k - 1]) { // j+n은 회문의 마지막 인덱스
							isPalindrome = false;
							break;
						}
					}
					if (isPalindrome==true) {
						cnt += 1;
					}
				}
			}
			
			// 열 검사 (행 검사에서 이차원배열 인덱스 순서만 바꿔주면 된다.
			for (int i = 0; i < 8; i++) { // 열 인덱스
				for (int j = 0; j <= 8 - n; j++) { // 행인덱스(길이 n인 회문을 찾으므로)
					boolean isPalindrome = true; // 회문인지 판단하는 변수
					for (int k = 0; k < n / 2; k++) { // 회문의 앞에서부터 vs 뒤에서부터 같은지 비교
						if (arr[j + k][i] != arr[(j + n) - k - 1][i]) { // j+n은 회문의 마지막 인덱스
							isPalindrome = false;
							break;
						}
					}
					if (isPalindrome==true) {
						cnt += 1;
					}
				}
			}
			System.out.printf("#%d %d%n",tc, cnt);
		}
	}

}
