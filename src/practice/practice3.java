package practice;

import java.util.Scanner;

public class practice3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            int max = -1; // 문제 조건상의 최소값인 -1로 초기화

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    int K = nums[i] * nums[j];

                    if (isIncreasing(K)) {
                        max = Math.max(K, max);
                    }
                }
            }

            System.out.println("#" + tc + " " + max);
        }

    }

    // K의 각 자릿수가 증가하는지 확인하는 메서드
    private static boolean isIncreasing(int num) {
        int prevDigit = 9; // 0부터 9까지 증가하므로 초기값을 9로 설정

        while (num > 0) {
            int digit = num % 10;
            if (digit > prevDigit) {
                return false;
            }
            prevDigit = digit;
            num /= 10;
        }

        return true;
    }
}
