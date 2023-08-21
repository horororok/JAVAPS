package SWEA.Day0818_1225;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/Day0818_1225/input_1225.txt"));

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			// 테스트 케이스 번호 무시하고 입력값 읽음
			sc.nextInt();
			
			int arr[] = new int[8];
			for (int i = 0; i < 8; i++) {
				int m = sc.nextInt();
				arr[i] = m;
			}
			
			// 사이클 수행
			// 현재 사이클
			int cycle = 1;
			while (true) {
				// 현재 사이클에서 감소할 양
				int temp = arr[0] - cycle;
				// 음수가 나오면 첫 번째 숫자를 0으로 설정하고 나머지 숫자를 이동
				if (temp <= 0) {
					arr[0] = 0;
					for (int i = 0; i < arr.length - 1; i++) {
						arr[i] = arr[i + 1];
					}
					arr[arr.length - 1] = 0;
					break;
				}
				// 숫자 이동
				for (int i = 0; i < arr.length - 1; i++) {
					arr[i] = arr[i + 1];
				}
				// 마지막 위치에 현재 사이클에서 감소한 숫자 저장
				arr[arr.length - 1] = temp;

				// 다음 사이클로 넘어가기 위한 cycle값 조정
				// 1, 2, 3, 4, 5 순환
				cycle = (cycle % 5) + 1;
			}
			
			System.out.print("#" + tc + " ");
			// 사이클 수행 결과
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
