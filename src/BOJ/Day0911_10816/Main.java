package BOJ.Day0911_10816;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		HashMap<Integer, Integer> cardCounts = new HashMap<>();

		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			// hashmap에 존재하는 키이면 해당 키의 값, 그렇지 않으면 0
			// 1을 더하여 해당 숫자 카드의 개수를 업데이트
			cardCounts.put(num, cardCounts.getOrDefault(num, 0) + 1);
		}

		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			int input = sc.nextInt();

			// 입력된 숫자를 HashMap에서 찾아 해당 숫자 카드의 개수를 가져온다.
			// 만약 해당 숫자가 없으면 개수를 0
			int count = cardCounts.getOrDefault(input, 0);
			sb.append(count).append(" ");
		}

		System.out.println(sb.toString());
	}
}
