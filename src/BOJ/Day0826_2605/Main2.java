package BOJ.Day0826_2605;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] list = new int[N]; // 학생들의 뽑은 번호를 저장할 배열

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            // 뽑은 번호가 0인 경우: 해당 순서의 학생을 배열의 끝에 추가
            if (num == 0) {
                list[i] = i + 1;
            } else {
                // 뽑은 번호가 0이 아닌 경우:
                // 뽑은 번호를 기준으로 뒤로 밀어내기
                for (int j = i; j >= i - num + 1; j--) {
                    list[j] = list[j - 1];
                }
                list[i - num] = i + 1; // 뽑은 번호의 위치에 학생 추가
            }
        }

        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
