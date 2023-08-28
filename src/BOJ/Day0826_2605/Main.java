package BOJ.Day0826_2605;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// 학생 수 입력 
		int N = sc.nextInt();

		// 학생들의 뽑은 번호를 저장할 ArrayList 생성.
		ArrayList<Integer> list = new ArrayList<>();

		// 각 학생들이 뽑은 번호를 입력 받고, ArrayList에 순서에 맞게 삽입
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();

			// 뽑은 번호가 0인 경우: 해당 순서의 학생을 리스트의 끝에 추가
			if (num == 0) {
				list.add(i + 1);
			} else {
				// 뽑은 번호가 0이 아닌 경우:
				// 현재 리스트의 크기에서 뽑은 번호를 뺀 위치에 학생을 추가.
				list.add(list.size() - num, i + 1);
			}
		}

		// 최종적으로 조정된 순서 출력
		for (int i : list) {
			System.out.print(i + " ");
		}
	}
}
