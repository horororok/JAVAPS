package BOJ.Day0919_12789;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		List<Integer> list = new ArrayList<>();
		List<Integer> stack = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();
			list.add(input);
		}

		int ord = 1;

		while (list.size() > 0) {
			if (list.get(0) == ord) {
				list.remove(0);
				ord++;
			} else if (stack.size() ==0 || stack.get(stack.size() - 1) != ord) {
				stack.add(list.get(0));
				list.remove(0);
			} else if (stack.get(stack.size() - 1) == ord) {
				stack.remove(stack.size() - 1);
				ord++;
			}
		}

		while (stack.size() > 0) {
			if (stack.get(stack.size() - 1) == ord) {
				stack.remove(stack.size() - 1);
				ord++;
			} else {
				System.out.println("Sad");
				break;
			}
		}
		if (ord == N + 1) {
			System.out.println("Nice");
		}

	}
}
