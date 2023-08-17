package Day0816_1216;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day0816_1216 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/Day0816_1216/input_1216.txt"));

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();
			sc.nextLine();

			char arr[][] = new char[100][100];
			for (int i = 0; i < 100; i++) {
				String input = sc.nextLine();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = input.charAt(j);
				}
			}

			// 행 검사
			// 최대길이를 최소길이 1로 초기화
			int maxlen = 1;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					// 현재까지 확인한 회문의 길이보다 1 큰 길이부터 시작
					for (int len = maxlen + 1; len <= 100; len++) {
						// 현재 열의 범위를 벗어나면 break
						if (j + len > 100) {
							break;
						}
						// 회문 여부 판단
						boolean isPal = true;
						for (int k = 0; k < len / 2; k++) {
							if (arr[i][j + k] != arr[i][j + len - k - 1]) {
								isPal = false;
								break;
							}
						}
						// 회문이면 최대길이 갱신
						if (isPal == true) {
							maxlen = len;
						}
					}
				}
			}

			// 열 검사 (행열 위치만 바꾼다)
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					// 현재까지 확인한 회문의 길이보다 1 큰 길이부터 시작
					for (int len = maxlen + 1; len <= 100; len++) {
						// 현재 열의 범위를 벗어나면 break
						if (j + len > 100) {
							break;
						}
						// 회문 여부 판단
						boolean isPal = true;
						for (int k = 0; k < len / 2; k++) {
							if (arr[j + k][i] != arr[j + len - k - 1][i]) {
								isPal = false;
								break;
							}
						}
						// 회문이면 최대길이 갱신
						if (isPal == true) {
							maxlen = len;
						}
					}
				}
			}

			System.out.printf("#%d %d%n", tc, maxlen);

		}
	}
}
