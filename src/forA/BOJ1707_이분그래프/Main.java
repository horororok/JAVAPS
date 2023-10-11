package forA.BOJ1707_이분그래프;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int K, V, E;
	static ArrayList<Integer> list[];
	static int visited[];
	static String result = "";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt(); // 테스트 케이스 개수 입력

		for (int i = 0; i < K; i++) {
			result = ""; // 결과값 초기화
			V = sc.nextInt(); // 정점의 개수 입력
			E = sc.nextInt(); // 간선의 개수 입력
			list = new ArrayList[V + 1];

			for (int j = 1; j <= V; j++) {
				list[j] = new ArrayList<>();
			}

			visited = new int[V + 1];

			for (int k = 1; k <= E; k++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				list[s].add(e);
				list[e].add(s);
			}

			boolean ans = true;

			for (int t = 1; t <= V; t++) {
				if (visited[t] == 0) {
					ans = DFS(t, 1);
				}
				if (!ans)
					break;
			}

			System.out.println(result);
		}
	}

	static boolean DFS(int node, int color) {
		visited[node] = color;

		for (int v : list[node]) {
			if (visited[v] == 0) {
				DFS(v, color * -1); // 다음 노드를 반대 색으로 칠하고 DFS 호출
			} else if (visited[v] == visited[node]) {
				result = "NO"; // 이분 그래프가 아닌 경우
				return false;
			}
			if (result.equals("NO")) {
				return false; // 이미 이분 그래프가 아닌 경우
			}
		}
		result = "YES"; // 모든 노드를 탐색하고 이분 그래프일 경우
		return true;
	}
}
