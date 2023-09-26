package BOJ.Day0926_15663;

import java.util.*;

class Main {
	static int N, M;
	static int[] ans, arr;
	static boolean[] visited;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		ans = new int[M];
		visited = new boolean[N];
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		perm(0);
		System.out.println(sb);
	}

	private static void perm(int idx) {
		// 원하는 만큼 뽑았으면 탈출
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
			return;
		} else {
			// 이전에 뽑았던 값을 저장
			int before = 0;
			for (int i = 0; i < N; i++) {
				// 뽑았던 값이면 패스
				if (visited[i]) {
					continue;
				} else if (before != arr[i]) {
					visited[i] = true;
					ans[idx] = arr[i];
					before = arr[i];
					perm(idx + 1);
					visited[i] = false;
				}
			}
		}
	}
}
