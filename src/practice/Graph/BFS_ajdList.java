package practice.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS_ajdList {

	static int V, E;
	static Queue<Integer> queue = new LinkedList<>();

	static boolean[] visited = new boolean[V + 1];
	static List<Integer>[] adjList = new ArrayList[V + 1];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		for (int i = 0; i < V + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int w = sc.nextInt();

			adjList[A].add(B);
			adjList[B].add(A);
		}

		int startV = sc.nextInt();
		BFS(startV);
	}

	static void BFS(int v) {
		queue.add(v);
		visited[v] = true;

		for (int i = 0; i < V + 1; i++) {
			if (!visited[i] && adjList[v].get(i) != 0) {
				queue.add(i);
				visited[i] = true;
			}
		}

	}
}
