package SWEA.Day0817_1948;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("src/Day0817_1948/input_1948.txt"));
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int t = sc.nextInt();

		// 각 테스트 케이스에 대해 반복
		for (int tc = 1; tc <= t; tc++) {
			// 월별 일 수 저장 배열
			int[] day = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

			// 출발 월일과 도착 월일을 저장하는 배열
			int[] arr = new int[4];
			for (int i = 0; i < 4; i++) {
				arr[i] = sc.nextInt();
			}

			// 결과 출력을 위한 테스트 케이스 번호 출력
			System.out.print("#" + tc + " ");

			// 출발 월과 도착 월이 같은 경우
			if (arr[0] == arr[2]) {
				System.out.println(arr[3] - arr[1] + 1); // 일 수 차이에 1을 더한 값 출력
			} else {
				int sum = 0;
				// 출발 월부터 도착 월 직전까지의 일 수 더하기
				for (int i = arr[0]; i < arr[2]; i++) {
					sum += day[i];
				}
				// 출발 월의 남은 일 수와 도착 월의 일 수 더하여 출력
				System.out.println(sum - arr[1] + arr[3] + 1);
			}
		}

	}

}
