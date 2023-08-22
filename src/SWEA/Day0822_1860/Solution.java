package SWEA.Day0822_1860;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SWEA/Day0822_1860/input_1860.txt"));
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스의 개수를 입력 받음
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {

            // N: 손님의 수, M: 붕어빵을 만드는 시간 간격, K: 한 번에 만드는 붕어빵 개수
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            // N명의 손님의 도착 시간을 배열에 저장
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            // 가장 늦게 오는 사람의 도착 시간을 구함
            int max = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > max)
                    max = arr[i];
            }

            // 대기 배열: 붕어빵이 나오는 횟수를 기록하는 배열, M초마다 갱신됨
            int wait[] = new int[(max / M) + 1];
            for (int j = 0; j < N; j++) {
                // 해당 손님이 도착한 시간대에 대기 배열 값을 증가시킴
                wait[arr[j] / M]++;
            }

            // 대기 배열을 누적합으로 변환
            for (int i = 1; i < (max / M) + 1; i++) {
                wait[i] += wait[i - 1];
            }

            boolean isPossible = true;

            // 대기 배열을 이용하여 조건 검사
            for (int i = 0; i < (max / M) + 1; i++) {
                // 붕어빵이 나오기 전에 온 사람이 있거나, i 시간에 있는 붕어빵의 수가 i * K보다 작으면 불가능
                if (wait[0] > 0 || i * K < wait[i]) {
                    isPossible = false;
                }
            }
            
            // 테스트 케이스 번호와 결과 출력
            System.out.print("#" + tc + " ");
            if (isPossible) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }
}
