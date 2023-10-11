package forA.BOJ16928_뱀과사다리게임;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int count[] = new int[101]; // 각 칸까지의 이동 횟수를 저장하는 배열
    static int board[] = new int[101]; // 사다리와 뱀의 정보를 저장하는 배열
    static boolean visited[] = new boolean[101]; // 방문 여부를 저장하는 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 사다리의 수
        int M = sc.nextInt(); // 뱀의 수

        for (int i = 0; i < N + M; i++) {
            int x = sc.nextInt(); // 출발 지점
            int y = sc.nextInt(); // 도착 지점
            board[x] = y; // 사다리 또는 뱀 정보 저장
        }

        bfs(); // BFS 탐색 실행
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<Integer>(); // 큐를 사용한 BFS 탐색
        que.offer(1); // 시작 지점을 큐에 추가
        count[1] = 0; // 시작 지점까지의 이동 횟수 초기화
        visited[1] = true; // 시작 지점을 방문 표시

        while (!que.isEmpty()) {
            int current = que.poll(); // 현재 위치를 큐에서 꺼냄
            if (current == 100) { // 목적지(100번 칸)에 도달했을 경우
                System.out.println(count[current]); // 이동 횟수 출력
                return; // 종료
            }

            for (int i = 1; i < 7; i++) { // 주사위를 굴린 결과를 모두 확인
                int x = current + i; // 주사위 눈의 합에 따라 다음 위치 계산
                if (100 < x) continue; // 게임판을 벗어나는 경우 다음 주사위 눈으로 넘어감
                if (visited[x]) continue; // 이미 방문한 칸인 경우 스킵
                visited[x] = true; // 방문 표시

                if (board[x] != 0) { // 사다리 또는 뱀의 위치일 때
                    if (!visited[board[x]]) { // 도착 위치를 방문하지 않았다면
                        que.offer(board[x]); // 도착 위치를 큐에 추가
                        visited[board[x]] = true; // 도착 위치를 방문 표시
                        count[board[x]] = count[current] + 1; // 이동 횟수 증가
                    }
                } else { // 아무것도 아닌 경우 (보통 칸)
                    que.offer(x); // 다음 위치를 큐에 추가
                    count[x] = count[current] + 1; // 이동 횟수 증가
                }
            }
        }
    }
}
