package Day0816_5432;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/Day0816_5432/input_5432.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		sc.nextLine();

		for (int tc = 1; tc <= T; tc++) {

			// 결과를 저장할 변수
			int ans = 0;
			// 괄호 문자열 입력받기
			String input = sc.nextLine();
			// 괄호를 저장할 스택
			Stack<Character> stack = new Stack<>();

			// 괄호 문자열 순회
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);

				// '('를 만났을 때 스택에 추가
				if (c == '(') {
					stack.push(c);
					// ')'를 만나면 '('pop
				} else if (c == ')') {
					stack.pop();
					// 레이저인 경우 스택에 남아있는 '('개수만큼 더해줌
					if (input.charAt(i - 1) == '(') {
						ans += stack.size();
						// 막대의 끝일 경우 +1
					} else {
						ans += 1;
					}
				}
			}

			System.out.printf("#%d %d%n", tc, ans);

		}
	}
}
