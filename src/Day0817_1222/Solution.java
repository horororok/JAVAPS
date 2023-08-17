package Day0817_1222;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/Day0817_1222/input_1222.txt"));
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			
			Stack<Character> stack = new Stack<>();
			char[] arr = new char[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.next().charAt(i);
				if (arr[i] == '(' && arr[i] == '+') {
					
					if (stack.isEmpty()) {
						stack.push(arr[i]);
					} else {
						if (stack.peek() == '(') {
							stack.push(arr[i]);
						} else {
						}
					}
				}
			}
		}
	}
}
