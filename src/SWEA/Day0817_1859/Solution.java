package SWEA.Day0817_1859;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
         System.setIn(new FileInputStream("src/Day0817_1859/input_1859.txt"));

        Scanner sc = new Scanner(System.in);

        // 테스트 케이스의 개수
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {

            // n개의 요소를 갖는 배열 만들어주기
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            long maxProfit = 0; // 최대 이익
            long currentMaxPrice = arr[n - 1]; // 마지막 값을 초기 최대값으로 설정

            // 배열의 뒤에서부터 역순으로 순회하며 최대 이익 계산
            for (int i = n - 2; i >= 0; i--) {
                // 현재 값이 현재까지의 최대값보다 큰 경우
                if (arr[i] > currentMaxPrice) {
                    currentMaxPrice = arr[i]; // 최대값 갱신
                } else {
                    // 현재 값이 최대값보다 작거나 같은 경우
                    // 차이를 최대 이익에 더해준다
                    maxProfit += currentMaxPrice - arr[i];
                }
            }

            // 최대 이익 출력
            System.out.println("#" + tc + " " + maxProfit);
        }
    }
}
