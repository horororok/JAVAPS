package SWEA.Day0817_1948;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/Day0817_1948/input_1948.txt"));
		Scanner sc = new Scanner(System.in);

		// 월/ 일, 월/일 두 가지로 받는다
		// 날짜의 차이를 계산
		// 1<= 월<=12

		int T = sc.nextInt();
		// 테스트케이스 개수
		for (int tc = 1; tc <= T; tc++) {

			// 입력을 배열로 받아 준다
			int arr[] = new int[4];
			for (int i = 0; i < 4; i++) {
				arr[i] = sc.nextInt();
			}

			// 월별 날짜
			int monD[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

			// 같은 월 의 경우 일끼리의 차 +1
			// 다른 월의 경우
			// 뒤에 날짜가 첫 번째 날짜보다 항상 크게 주어진다 했으므로
			// 앞월 ~ (뒤월-1) 까지 의 총 일수 + (뒤에 일 - 앞에 일 +1)
			int day = 0;
			if (arr[0] == arr[2]) {
				day = arr[3] - arr[1] + 1;
			} else {
				for (int i = arr[0]; i < arr[2]; i++) {
					day += monD[i];
				}
				day += arr[3] - arr[1] + 1;
			}
			System.out.println("#" + tc + " " + day);
		}

	}

}
