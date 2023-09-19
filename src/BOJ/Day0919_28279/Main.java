package BOJ.Day0919_28279;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> deque = new ArrayDeque<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		while (N-- > 0) {
			int order = sc.nextInt();

			switch (order) {
			case 1:
				deque.addFirst(sc.nextInt());
				break;
			case 2:
				deque.addLast(sc.nextInt());
				break;
			case 3:
				sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
				break;
			case 4:
				sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
				break;
			case 5:
				sb.append(deque.size()).append("\n");
				break;
			case 6:
				sb.append(deque.isEmpty() ? 1 : 0).append("\n");
				break;
			case 7:
				sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
				break;
			case 8:
				sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
}
