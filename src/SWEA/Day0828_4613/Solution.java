package SWEA.Day0828_4613;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
    	System.setIn(new FileInputStream("src/SWEA/Day0828_4613/input_4613.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 개수
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 깃발의 행 수
            int M = sc.nextInt(); // 깃발의 열 수

            char[][] flag = new char[N][M]; // 깃발을 나타내는 2차원 배열
            for (int i = 0; i < N; i++) {
                String str = sc.next(); // 문자열로 한 줄을 입력받음
                for (int j = 0; j < M; j++) {
                    flag[i][j] = str.charAt(j); // 문자열을 문자(char) 배열로 저장
                }
            }

            int min = Integer.MAX_VALUE; // 최소 횟수를 저장할 변수
            for (int i = 1; i < N - 1; i++) { // 파란색 영역의 범위
                for (int j = i + 1; j < N; j++) { // 빨간색 영역의 범위
                    int cnt = 0; // 새로 칠하는 횟수

                    // 흰색 영역
                    for (int r = 0; r < i; r++) {
                        for (int c = 0; c < M; c++) {
                            if (flag[r][c] != 'W') { // 흰색이 아니면 새로 칠해야 함
                                cnt++;
                            }
                        }
                    }

                    // 파랑 영역
                    for (int r = i; r < j; r++) {
                        for (int c = 0; c < M; c++) {
                            if (flag[r][c] != 'B') { // 파랑색이 아니면 새로 칠해야 함
                                cnt++;
                            }
                        }
                    }

                    // 빨강 영역
                    for (int r = j; r < N; r++) {
                        for (int c = 0; c < M; c++) {
                            if (flag[r][c] != 'R') { // 빨강색이 아니면 새로 칠해야 함
                                cnt++;
                            }
                        }
                    }

                    min = Math.min(min, cnt); // 최소 횟수 갱신
                }
            }

            System.out.println("#" + tc + " " + min); // 결과 출력
        }
    }
}
