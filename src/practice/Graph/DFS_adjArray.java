package practice.Graph;

import java.util.Scanner;

public class DFS_adjArray {

    static int V, E;
    static boolean[] visited;
    static int[][] adjArray;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt(); // 정점의 개수
        E = sc.nextInt(); // 간선의 개수

        visited = new boolean[V + 1]; // 방문 배열 초기화

        // 인접행렬 선언 및 초기화
        adjArray = new int[V + 1][V + 1];
        for (int i = 0; i < E; i++) {
            int A = sc.nextInt(); // 시작 정점
            int B = sc.nextInt(); // 끝 정점
            int w = sc.nextInt(); // 가중치
            
            adjArray[A][B] = w;
            adjArray[B][A] = w; // 무방향 그래프라면 양방향으로 설정
        }
        
        int startV = sc.nextInt(); // DFS 시작 정점 입력받거나 임의 인덱스(ex: 0)로 시작하거나
        DFS(startV); // DFS 시작
    }
    
    // DFS 재귀함수
    static void DFS(int v) {
        visited[v] = true; // v에 대한 방문처리
        System.out.println(v +1); // 출력
        
        for (int i = 1; i <= V; i++) {
            // 방문하지 않았으면서 연결된 간선이 존재한다면 재귀호출
            if (!visited[i] && adjArray[v][i] != 0) {
                DFS(i);
            }
        }
    }
}
