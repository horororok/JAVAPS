package forA.BOJ24479_깊이우선탐색1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class prac {
	// 깊이 우선탐색
	// 인접리스트 만들어주고
	// 방문처리할 배열 만들어주고
	// 방문 순서 체크

	static ArrayList<ArrayList<Integer>> ajdList;
	static int[] nextNode;
	static boolean visited[];
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();

		// 인접리스트
		ajdList = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			ajdList.add(new ArrayList<>());
		}
		// 간선 정보 입력
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			ajdList.get(u).add(v);
			ajdList.get(v).add(u);
		}
		// 오름차순 정렬
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(ajdList.get(i));
		}

		// 정점 방문 순서 저장할 배열
		nextNode = new int[N + 1];
		nextNode[R] = 1; // 시작정점 방문순서

		// 방문처리 배열
		visited = new boolean[N + 1];

		cnt = 2; // 방문순서는 2부터(시작정점이 1부터)
		dfs(R); // dfs 호출

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			sb.append(nextNode[i] + "\n");
		}
		System.out.println(sb);

	}

	// dfs
	public static void dfs(int R) {
		visited[R] = true; // 시작정점 방문처리
		for (int r : ajdList.get(R)) {
			if (!visited[r]) {
				nextNode[r] = cnt++; // 다음 방문 정점
				visited[r] = true; // 방문처리
				dfs(r); // 재귀
			}
		}

	}
}
