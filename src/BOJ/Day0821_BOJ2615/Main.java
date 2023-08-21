package BOJ.Day0821_BOJ2615;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 19*19 board 입력
        int board[][] = new int[19][19];
        for (int r = 0; r < 19; r++) {
            for (int c = 0; c < 19; c++) {
                board[r][c] = sc.nextInt();
            }
        }

        int result = 0; // 승부 결과 (0: 미결정, 1: 검은색 승, 2: 흰색 승)
        int row = -1;   // 가장 왼쪽에 있는 바둑알의 가로줄 번호
        int col = -1;   // 가장 왼쪽에 있는 바둑알의 세로줄 번호

        int dr[] = {0, 1, 1, 1}; // 오른쪽, 아래, 오른쪽 대각선 아래, 왼쪽 대각선 아래 방향을 나타내는 변위 배열
        int dc[] = {1, 0, 1, -1};

        // 바둑판 검사
        outer: for (int r = 0; r < 19; r++) {
            for (int c = 0; c < 19; c++) {
                int color = board[r][c]; // 현재 위치의 바둑알 색상

                // 바둑알이 놓여있는 경우에만 검사 수행
                if (color != 0) {
                    for (int d = 0; d < 4; d++) {
                        int cnt = 1; // 연속된 돌 개수 카운트
                        int newRow = r + dr[d]; // 변위를 이용해 다음 위치 계산
                        int newCol = c + dc[d];

                        // 연속된 돌이 검사할 범위 내에 있고 같은 색인 경우 반복
                        while (newRow >= 0 && newRow < 19 && newCol >= 0 && newCol < 19 &&
                               board[newRow][newCol] == color) {
                            cnt++; // 연속된 돌 개수 증가
                            newRow += dr[d]; // 다음 위치로 이동
                            newCol += dc[d];
                        }

                        // 5개 이상, 6개 미만인 경우 승부 결정
                        if (cnt >= 5 && cnt < 6) {
                            result = color; // 승부 결과 저장
                            row = r + 1; // 바둑알 위치 저장 (1부터 시작)
                            col = c + 1;
                            break outer; // 바깥쪽 반복문 종료
                        }
                    }
                }
            }
        }

        System.out.println(result); // 승부 결과 출력
        if (result != 0) {
            System.out.println(row + " " + col); // 바둑알 위치 출력
        }
    }
}
