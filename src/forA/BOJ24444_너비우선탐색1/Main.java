package forA.BOJ24444_너비우선탐색1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static ArrayList<ArrayList<Integer>> adjList; // 인접 리스트
    static int[] nextNode; // 각 정점의 탐색 순서를 저장할 배열
    static boolean[] visited; // 정점 방문 여부를 저장할 배열

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점의 개수
        int M = sc.nextInt(); // 간선의 개수
        int R = sc.nextInt(); // 시작 정점

        adjList = new ArrayList<>(); // 인접 리스트 초기화
        for (int i = 0; i <= N; i++)
            adjList.add(new ArrayList<>()); // 인접 리스트 초기화
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList.get(u).add(v); // 간선 정보를 인접 리스트에 추가
            adjList.get(v).add(u); // 무방향 그래프이므로 양방향으로 추가
        }
        for (int i = 1; i <= N; i++)
            Collections.sort(adjList.get(i)); // 인접 리스트 정렬하여 오름차순으로 정점 방문 순서 유지

        nextNode = new int[N + 1]; // 각 정점의 탐색 순서 배열 초기화
        visited = new boolean[N + 1]; // 정점 방문 여부 배열 초기화
        
        bfs(R); // BFS 탐색 시작

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++)
            sb.append(nextNode[i]).append("\n"); // 결과를 StringBuilder에 저장

        System.out.print(sb); // 결과 출력

    }

    public static void bfs(int R) {

        nextNode[R] = 1; // 시작 정점을 1로 초기화
        visited[R] = true; // 시작 정점 방문 표시
        int cnt = 2; // 탐색 순서 초기화

        Queue<Integer> que = new LinkedList<>();
        que.offer(R); // 시작 정점을 큐에 추가

        while (!que.isEmpty()) {
            int cur = que.poll(); // 큐에서 정점을 꺼냄
            for (int v : adjList.get(cur)) { // 현재 정점의 인접 정점들을 반복
                if (!visited[v]) { // 방문하지 않은 정점이면
                    nextNode[v] = cnt++; // 다음 순서로 탐색 순서를 업데이트
                    visited[v] = true; // 방문 표시
                    que.offer(v); // 큐에 추가하여 탐색 계속
                }
            }
        }
    }
}
