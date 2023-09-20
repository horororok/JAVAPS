package BOJ.Day0920_2346;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 원형 큐

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();

		Deque<int[]> deq = new ArrayDeque<>();

		//풍선 번호와 풍선 내부 숫자를 동시에 가져오기 위해 배열로 덱을 가져와 준다
		for (int i = 0; i < N; i++) {
			int[] input = { i + 1, sc.nextInt() };
			deq.add(input);
		}

		
		//풍선 내부 숫자가 0보다 크면 제일 앞 숫자를 떼서 제일 뒤에 붙여준다 //0보다 작으면 반대로
		//마지막 풍선 남을 때까지 반복
		while (deq.size() > 1) {
			int[] arr = deq.pollFirst();
			sb.append(arr[0]).append(" ");
			int num = arr[1];

			if (num > 0) {
				for (int j = 1; j < num; j++) {
					deq.offerLast(deq.pollFirst());
				}
			} else {
				for (int j = num; j < 0; j++) {
					deq.offerFirst(deq.pollLast());
				}
			}
		}

		sb.append(deq.poll()[0]);

		System.out.println(sb);
	}
}
