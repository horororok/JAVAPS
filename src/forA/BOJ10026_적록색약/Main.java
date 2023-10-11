package forA.BOJ10026_적록색약;

import java.util.Scanner;

public class Main {
 
    static int n;
    static String s;
    static char map[][];
    static boolean visited[][];
    static int dx[] = {-1, 0, 0, 1}; // 상하좌우 방향을 나타내는 배열
    static int dy[] = {0, 1, -1, 0};
 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 그림의 크기를 입력받음
        map = new char[n][n]; // 그림 배열 초기화
        visited = new boolean[n][n]; // 방문 여부를 저장하는 배열 초기화
 
        // 그림 정보 입력
        for (int i = 0; i < n; i++) {
            s = sc.next(); // 한 줄의 색 정보를 입력
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j); // 그림 정보를 배열에 저장 
            }
        }
 
        // 정상적인 경우의 구역 개수 계산
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j); // DFS 탐색으로 구역을 찾음
                    cnt1++; // 구역 개수 증가
                }
            }
        }
 
        // 색맹 적용한 경우의 구역 개수 계산
        int cnt2 = 0;
        visited = new boolean[n][n]; // 방문 여부 배열 초기화
 
        // G(녹색)을 R(빨강)로 변경
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R'; // 녹색(G)을 빨강(R)로 변경
                }
            }
        }
 
        // 색맹 적용한 경우의 구역 개수 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j); // DFS 탐색으로 구역을 찾음
                    cnt2++; // 구역 개수 증가
                }
            }
        }
        
        // 결과 출력
        System.out.println(cnt1 + " " + cnt2);
    }
 
    // DFS를 사용하여 연결된 지역을 찾는 함수
    public static void dfs(int x, int y) {
        visited[x][y] = true; // 해당 지역을 방문했다고 표시
        char current = map[x][y]; // 현재 지역의 색상을 저장
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i]; // 새로운 좌표 계산
            int ny = y + dy[i];
 
            // 좌표가 그림 범위를 벗어나면 다음 방향으로 진행
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }
 
            // 방문하지 않은 인접한 지역이고, 같은 색상인 경우 재귀 호출
            if (!visited[nx][ny] && map[nx][ny] == current) {
                dfs(nx, ny);
            }
        }
    }
}
