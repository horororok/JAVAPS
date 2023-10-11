package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class practice3 {

	static int N, M, R;
	static ArrayList<ArrayList<Integer>> adjList;	//인접 리스트
	static boolean[] visited;	//방문 여부 
	static int[] order; //방문 순서 저장 배열
	static int cnt;	//방문 순서 나타내는 변수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();

		visited = new boolean[N + 1];
		
		adjList = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}

		for (int i = 0; i < N + 1; i++) {
			Collections.sort(adjList.get(i));
		}

		order = new int[N + 1];
		order[R] = 1;	//시작 정점은 첫번째니까 1
		
		cnt = 1;
		
		dfs(R);

		for (int i = 1; i < N + 1; i++) {
			System.out.println(order[i]);
		}
	}

	private static void dfs(int r) {
		visited[r] = true;

		for (int nextnode : adjList.get(r)) {
			if (!visited[nextnode]) {
				order[nextnode] = ++cnt;
				dfs(nextnode);
			}
		}
	}
}
