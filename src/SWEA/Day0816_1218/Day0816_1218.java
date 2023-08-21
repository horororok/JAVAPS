package SWEA.Day0816_1218;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Day0816_1218 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("src/Day0816_1218/input_1218.txt"));

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();

			Stack<Character> stack = new Stack<>();

			// 괄호가 올바르게 짝이 맞는지 여부
			boolean isBalanced = true;

			for (int i = 0; i < n; i++) {
				char ans = str.charAt(i);

				if (ans == '(' || ans == '{' || ans == '['|| ans == '<') {
					stack.push(ans);
				} else if (ans == ')' || ans == '}' || ans == ']'|| ans == '>') {
					if (stack.isEmpty()) {
						// 스택이 비어있는데도 짝이 맞지 않는 괄호가 나온 경우
						isBalanced = false;
						break;
					}
					// 짝이 맞는지 확인하여 pop
					if ((stack.peek() == '(' && ans == ')') || (stack.peek() == '{' && ans == '}')
							|| (stack.peek() == '[' && ans == ']')|| (stack.peek() == '<' && ans == '>')) {
						stack.pop();
					} else {
						// 짝이 맞지 않는 괄호가 나온 경우
						isBalanced = false;
						break;
					}
				}
			}

			if (isBalanced && stack.isEmpty()) {
				System.out.printf("#%d 1%n",tc);
			} else {
				System.out.printf("#%d 0%n",tc);
			}

		}
	}
}
