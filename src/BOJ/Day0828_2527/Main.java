package BOJ.Day0828_2527;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 4개의 경우를 입력으로 처리
        // 두 직사각형의 공통부분 출력: a, 선분 출력: b, 점 출력: c, 공통부분 없음: d
        // x 좌표 비교, y 좌표 비교

        for (int i = 0; i < 4; i++) {
            int x1 = sc.nextInt();  // 첫 번째 직사각형의 왼쪽 아래 x 좌표
            int y1 = sc.nextInt();  // 첫 번째 직사각형의 왼쪽 아래 y 좌표
            int p1 = sc.nextInt();  // 첫 번째 직사각형의 오른쪽 위 x 좌표
            int q1 = sc.nextInt();  // 첫 번째 직사각형의 오른쪽 위 y 좌표
            int x2 = sc.nextInt();  // 두 번째 직사각형의 왼쪽 아래 x 좌표
            int y2 = sc.nextInt();  // 두 번째 직사각형의 왼쪽 아래 y 좌표
            int p2 = sc.nextInt();  // 두 번째 직사각형의 오른쪽 위 x 좌표
            int q2 = sc.nextInt();  // 두 번째 직사각형의 오른쪽 위 y 좌표

            // 두 직사각형이 서로 아무런 공통 부분이 없는 경우
            if (p1 < x2 || q1 < y2 || p2 < x1 || q2 < y1) {
                System.out.println("d");
            }
            // 두 직사각형의 꼭지점이 겹치는 경우
            else if ((x1 == p2 && y1 == q2) || (x1 == p2 && q1 == y2) || (p1 == x2 && q1 == y2) || (p1 == x2 && y1 == q2)) {
                System.out.println("c");
            }
            // 두 직사각형의 변이 겹치는 경우
            else if (p1 == x2 || q1 == y2 || p2 == x1 || y1 == q2) {
                System.out.println("b");
            }
            // 나머지 경우는 두 직사각형이 공통 부분이 있음
            else {
                System.out.println("a");
            }
        }
    }
}
