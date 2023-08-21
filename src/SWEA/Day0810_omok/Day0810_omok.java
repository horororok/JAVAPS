package SWEA.Day0810_omok;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day0810_omok {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("src/input/input_0810_omok.txt"));

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();

			char arr[][] = new char[n][n];
			for (int i = 0; i < n; i++) {
				String str = sc.next();
				for (int j = 0; j < n; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			int consecutiveThreshold = 5; // 연속으로 중복되어야 하는 횟수
			char targetChar = 'o'; // 특정 문자

			boolean found = false;

			for (int row = 0; row < arr.length; row++) {
				char prevChar = '\0'; // 이전 문자를 초기화
				int consecutiveCount = 1; // 연속된 문자 개수를 초기화

				for (int col = 0; col < arr[row].length; col++) {
					char currentChar = arr[row][col];

					if (currentChar == targetChar) {
						if (currentChar == prevChar) {
							consecutiveCount++;
							if (consecutiveCount >= consecutiveThreshold) {
								System.out
										.println("Consecutive duplicate " + targetChar + " found in row " + (row + 1));
								found = true;
								break; // 다섯 번 중복을 찾았으므로 루프를 종료
							}
						} else {
							consecutiveCount = 1; // 다른 문자를 만났으므로 연속 개수 초기화
						}
					} else {
						consecutiveCount = 1; // 다른 문자를 만났으므로 연속 개수 초기화
					}

					prevChar = currentChar; // 이전 문자 업데이트
				}

				if (found) {
					break; // 이미 다섯 번 중복을 찾았으므로 전체 루프를 종료
				}
			}
		}
	}
}
