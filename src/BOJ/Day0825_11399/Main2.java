package BOJ.Day0825_11399;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사람 수 입력
        int N = sc.nextInt();
        // 주어진 숫자들을 배열로 받음
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            arr[i] = input;
        }

        // 주어진 숫자 중 최대값 찾기
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 빈도수 배열 생성 및 초기화
        int cntarr[] = new int[max + 1];
        for (int i = 0; i < N; i++) {
            cntarr[arr[i]] += 1;
        }

        // 누적 빈도수 배열 생성 및 초기화
        int[] accumCntarr = new int[max + 1];
        accumCntarr[0] = 0; // 초기화
        for (int i = 1; i <= max; i++) {
            accumCntarr[i] = accumCntarr[i - 1] + cntarr[i];
        }

        // 정렬된 배열 생성
        int ansarr[] = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            ansarr[accumCntarr[arr[i]] - 1] = arr[i];
            accumCntarr[arr[i]]--;
        }

        // 정렬된 배열의 누적합 배열 생성
        for (int i = 1; i < N; i++) {
            ansarr[i] += ansarr[i - 1];
        }
        
        // 누적합 배열의 합 계산
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += ansarr[i];
        }
        
        // 결과 출력
        System.out.println(sum);
    }
}
