package BOJ.Day0824_2851;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }
        
        // 배열의 각 원소를 누적 합으로 변경
        for (int i = 1; i < 10; i++) {
            arr[i] += arr[i - 1];
        }

        int a = 0;
        int sum = 0;
        // 100에 가까운 값의 인덱스를 찾음
        while (a < 10 && sum <= 100) {
            sum = arr[a];
            a++;
        }

        int num1, num2;
        // 예외 처리: a가 1일 때와 그 외의 경우로 나눠서 처리
        if (a == 1) {
            num1 = arr[a - 1];
            num2 = arr[a - 1];
        } else {
            num1 = arr[a - 2];
            num2 = arr[a - 1];
        }

        // 가장 가까운 값 출력
        if (100 - num1 >= num2 - 100) {
            System.out.println(num2);
        } else {
            System.out.println(num1);
        }
    }
}
