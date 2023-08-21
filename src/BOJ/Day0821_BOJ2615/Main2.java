package BOJ.Day0821_BOJ2615;

import java.util.Scanner;

public class Main2 {
    static int[][] map = new int[21][21]; // 오목판을 나타내는 2차원 배열
    static int[][][] memo = new int[21][21][4]; // 메모이제이션을 위한 3차원 배열
    static int[] dx = { 1, 1, 0, -1 }; // 오목을 탐색하기 위한 방향 배열 (우, 우하, 하, 좌하)
    static int[] dy = { 0, 1, 1, 1 };
    static StringBuilder sb = new StringBuilder(); // 결과 출력을 위한 StringBuilder

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 19; i++) { // 오목판 입력 받기
            for (int j = 1; j <= 19; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        System.out.println(findFive()); // 5목을 찾고 결과 출력
        sc.close(); // Scanner 닫기
    }

    private static String findFive() {
        for (int j = 1; j <= 19; j++) { // 오목판을 전체 탐색
            for (int i = 1; i <= 19; i++) {
                if (map[i][j] != 0) { // 비어있지 않은 위치에서 시작
                    for (int d = 0; d < 4; d++) { // 4개의 방향을 검사
                        if (memo[i][j][d] == 0 && calc(i, j, d, map[i][j]) == 5) {
                            // 5목을 찾으면 해당 색과 시작 위치를 결과 문자열에 저장
                            return map[i][j] + "\n" + i + " " + j + "\n";
                        }
                    }
                }
            }
        }
        return "0"; // 5목을 찾지 못한 경우
    }

    private static int calc(int x, int y, int dir, int color) {
        int nx = x + dx[dir]; // 다음 위치로 이동하는 좌표 계산
        int ny = y + dy[dir];

        if (map[nx][ny] == color) {
            // 다음 위치에 같은 색의 돌이 있으면 메모이제이션을 활용하여 탐색 결과 반환
            return memo[nx][ny][dir] = calc(nx, ny, dir, color) + 1;
        }

        return 1; // 다음 위치에 같은 색의 돌이 없는 경우
    }
}
