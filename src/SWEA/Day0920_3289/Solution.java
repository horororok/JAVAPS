package SWEA.Day0920_3289;

import java.util.Scanner;

public class Solution {

	static int p[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append('#').append(tc).append(" ");
			int n = sc.nextInt();
			int m = sc.nextInt();

			p = new int[n + 1];
			for (int i = 0; i < n + 1; i++) {
				p[i] = i;
			}

			for (int i = 0; i < m; i++) {
				int x = sc.nextInt();
				int num1 = sc.nextInt();
				int num2 = sc.nextInt();

				if (x == 0) {
					union(num1, num2);

				}
				// 1이 들어오면
				else {
					if (findSet(num1) == findSet(num2)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}

			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int findSet(int x) {
		if (x == p[x])
			return x;
		p[x] = findSet(p[x]);
		return p[x];

	}

	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}

}
