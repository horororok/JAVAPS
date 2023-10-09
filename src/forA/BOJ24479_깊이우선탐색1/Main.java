package forA.BOJ24479_깊이우선탐색1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    // N: 정점의 수, M: 간선의 수, R: 시작 정점
    // ajdList: 인접 리스트를 표현하기 위한 ArrayList
    // nextNode: 정점 방문 순서를 저장하기 위한 배열
    // visited: 정점 방문 여부를 표시하는 배열
    // cnt: 방문 순서를 나타내는 변수

	static ArrayList<ArrayList<Integer>> ajdList;
	static int[] nextNode;
	static boolean[] visited;
	static int cnt;
	
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점의 수
        int M = sc.nextInt(); // 간선의 수
        int R = sc.nextInt(); // 시작 정점

        // 인접 리스트 초기화
        ajdList = new ArrayList<>();
        for (int i = 0; i <= N; i++)
            ajdList.add(new ArrayList<>());

        //인덱스와 정점번호 맞춰줌
        nextNode = new int[N + 1];
        visited = new boolean[N + 1];
        
        // 간선 정보 입력 및 정렬
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            //양쪽에 모두 넣어줌(무방향)
            ajdList.get(u).add(v);
            ajdList.get(v).add(u);
        }
        
        //오름차순 정렬
        for (int i = 1; i <= N; i++)
            Collections.sort(ajdList.get(i));

        nextNode[R] = 1; // 시작 정점 방문 순서 설정
        visited[R] = true; // 시작 정점 방문 표시
        cnt = 2; // 방문 순서 초기화
        dfs(R); // DFS 호출하여 정점 방문 순서 계산

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++)
            sb.append(nextNode[i] + "\n");

        System.out.println(sb);
    }

    // 깊이 우선 탐색 (DFS) 함수
    public static void dfs(int R) {
        for (int r : ajdList.get(R)) {
            if (!visited[r]) {
                nextNode[r] = cnt++; // 다음 정점 방문 순서 설정
                visited[r] = true; // 정점 방문 표시
                dfs(r); // 재귀적으로 다음 정점 방문
            }
        }
    }
}
