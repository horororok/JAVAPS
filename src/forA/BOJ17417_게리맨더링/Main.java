package forA.BOJ17417_게리맨더링;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static int[] population, area;
    static ArrayList<Integer>[] list;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        population = new int[n + 1]; // 각 지역의 인구 수
        list = new ArrayList[n + 1]; // 인접한 지역 정보를 저장할 리스트 배열
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            population[i] = sc.nextInt(); // 각 지역의 인구 수를 입력받음
        }

        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            for (int j = 0; j < num; j++) {
                list[i].add(sc.nextInt()); // 각 지역의 인접한 지역 정보를 입력받음
            }
        }

        area = new int[n + 1]; // 각 지역구가 속한 선거구를 저장하는 배열 (1 또는 2)
        dfs(1); // 가능한 모든 지역구 조합을 시도하는 DFS 탐색

        if (min == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(min);
    }

    // 가능한 모든 지역구 조합을 시도하는 DFS 탐색
    public static void dfs(int k) {
        if (k == n + 1) { // 모든 지역을 선거구에 할당했을 경우
            int area1 = 0; // 1번 선거구의 인구 수
            int area2 = 0; // 2번 선거구의 인구 수
            for (int i = 1; i <= n; i++) {
                if (area[i] == 1)
                    area1 += population[i];
                else
                    area2 += population[i];
            }

            visited = new boolean[n + 1];
            int link = 0; // 연결된 지역들의 개수를 세는 변수
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    bfs(i, area[i]); // 연결된 지역들을 모두 방문표시하는 BFS 탐색
                    link++;
                }
            }
            
            // 두 지역구로 나누어지고, 두 지역구가 서로 연결되어 있다면 최소값 계산
            if (link == 2)
                min = Math.min(min, Math.abs(area1 - area2));

            return;
        }

        area[k] = 1; // k지역을 1번 선거구에 할당
        dfs(k + 1);

        area[k] = 2; // k지역을 2번 선거구에 할당
        dfs(k + 1);
    }

    // BFS를 사용하여 연결된 지역을 찾는 함수
    public static void bfs(int idx, int areaNum) {
        Queue<Integer> que = new LinkedList<>();
        visited[idx] = true;
        que.offer(idx);

        while (!que.isEmpty()) {
            int current = que.poll();

            for (int i = 0; i < list[current].size(); i++) {
                int next = list[current].get(i);
                if (area[next] == areaNum && !visited[next]) {
                    que.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
