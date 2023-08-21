package SWEA.Day0814_1213;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day0814_1213 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/input/input_1213.txt"));

		Scanner sc = new Scanner(System.in);

		for (int tc = 0; tc < 10; tc++) {
			int T = sc.nextInt();
			sc.nextLine();
			String target = sc.nextLine(); // 찾을 문자열
			String words = sc.nextLine();

			int cnt = 0; // 문자열 개수를 세기 위한 변수
			int idx = 0; // 마지막으로 착은 인덱스를 저장하는 변수

			// 문자열 내에서 찾을 문자열의 인덱스를 찾아가며 반복
			while (idx != -1) {
				idx = words.indexOf(target, idx); // indexof
				if (idx != -1) {
					cnt++; // 문자열을 찾으면 카운트 증가
					idx += target.length(); // 다음 검색을 위해 인덱스 업데이트
				}
			}
			System.out.println("#" + T + " " + cnt);
		}
	}
}
