package practice.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS_adjList {

    static int V, E;
    static boolean[] visited;
    static List<Integer>[] adjList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt(); // 정점의 개수
        E = sc.nextInt(); // 간선의 개수

        visited = new boolean[V + 1]; // 방문 배열 초기화

        // 인접 리스트
        adjList = new ArrayList[V + 1];

        for (int i = 0; i < V + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int w = sc.nextInt();

            adjList[A].add(B);
            adjList[B].add(A); // 무향 그래프인 경우 필수
        }

        int startV = sc.nextInt(); // 입력받거나 임의의 점 지정
        DFS(startV);
    }

    static void DFS(int v) {
        visited[v] = true; // 방문처리
        System.out.println(v +1); // 출력

        for (int neighbor : adjList[v]) {
            // 방문하지 않았으면서 연결된 정점이 있다면 재귀호출
            if (!visited[neighbor]) {
                DFS(neighbor);
            }
        }
    }
}
