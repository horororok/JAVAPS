package Day0816_1217;

import java.util.Scanner;
import java.util.Stack;

public class Solution3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();

			int n = sc.nextInt();
			int m = sc.nextInt();

			Stack<Integer> stack = new Stack<>();
			int ans = 1;
			for (int i = 0; i < m; i++) {
				stack.push(n);
				ans *= stack.pop();
			}
			System.out.printf("#%d %d%n", tc, ans);
		}
	}
}
