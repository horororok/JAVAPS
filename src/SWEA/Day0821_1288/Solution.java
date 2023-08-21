package SWEA.Day0821_1288;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA/Day0821_1288/input_1288.txt"));

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt(); // 테스트 케이스의 수를 입력 받음
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 현재 테스트 케이스의 입력 숫자 N을 받음
			boolean[] countNum = new boolean[10]; // 0부터 9까지의 숫자 등장 여부를 저장하는 배열
			int count = 0; // 등장한 숫자의 개수를 카운트하는 변수
			int result = 1; // 현재까지의 곱셈 횟수를 나타내는 변수

			while (true) { // 모든 숫자가 최소한 한 번 이상 등장할 때까지 반복
				String tmp = Integer.toString(N * result); // 현재 숫자 계산

				// 숫자의 각 자릿수를 확인하며 등장 여부를 체크
				for (int idx = 0; idx < tmp.length(); idx++) {
					int intNum = Integer.parseInt(tmp.substring(idx, idx + 1)); // 현재 자릿수의 숫자 추출
					if (!countNum[intNum]) { // 해당 숫자가 아직 등장하지 않았다면
						countNum[intNum] = true; // 등장했음을 표시
						count++; // 등장한 숫자의 개수 증가
					}
				}

				if (count == 10) { // 모든 숫자가 최소한 한 번 이상 등장했다면
					sb.append("#").append(test_case).append(" ").append(tmp).append("\n"); // 결과를 StringBuilder에 추가
					break; // 루프 종료
				}
				result++; // 숫자를 계속 곱해나감
			}
		} // end for test_case

		System.out.println(sb); // 모든 테스트 케이스의 결과를 출력

		sc.close(); // Scanner 객체 닫기
	}
}
