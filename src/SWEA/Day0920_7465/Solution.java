package SWEA.Day0920_7465;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	static int[] p;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			sb.append("#").append(tc).append(" ");

			int n = sc.nextInt();
			int m = sc.nextInt();

			p = new int[n + 1];
			for (int i = 0; i < n + 1; i++) {
				p[i] = i;
			}

			for (int i = 0; i < m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				union(x, y);
			}

			Set<Integer> set = new HashSet<>();
			for (int i = 1; i < n + 1; i++) {
				set.add(findSet(i));
			}
			sb.append(set.size()).append("\n");

		}
		System.out.println(sb);

	}

	static int findSet(int x) {
		if (x == p[x]) {
			return x;
		} else {
			return p[x] = findSet(p[x]);
		}
	}

	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}

}
