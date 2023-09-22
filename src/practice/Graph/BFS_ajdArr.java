package practice.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_ajdArr {
	static int V, E;
	static int[][] adjArr = new int[V + 1][V + 1];
	static boolean[] visited = new boolean[V + 1];
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		int[][] adjArr = new int[V + 1][V + 1];

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int w = sc.nextInt();

			adjArr[A][B] = w;
			adjArr[B][A] = w;
		}

		int startV = sc.nextInt();
		BFS(startV);
	}

	static void BFS(int v) {
		// 시작 정점을 큐에 넣는다.
		queue.add(v);

		visited[v] = true; // 방문처리

		// 큐가 공백이 될 때까지 반복문 순회
		while (!queue.isEmpty()) {
			// 정점
			int t = queue.poll();
			System.out.println(t + 1);

			// 인접하면서 방문하지 않은 노드들은 큐에 넣고 방문처리를 한다.
			for (int i = 0; i < adjArr.length; i++) {
				if (!visited[i] && adjArr[t][i] != 0) {
					queue.add(i); // 큐에 넣고
					visited[i] = true; // 방문처리
				}
			}

		}

	}
}
