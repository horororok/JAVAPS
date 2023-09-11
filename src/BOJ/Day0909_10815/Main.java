package BOJ.Day0909_10815;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int N; // 배열의 크기
    private static int[] arr; // 입력된 숫자들을 저장할 배열
    private static int M; // 찾을 숫자의 개수
    private static StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 기존 수 N개 주어짐
        N = sc.nextInt(); // 배열의 크기를 입력 받음
        arr = new int[N]; // 크기 N의 정수 배열 생성
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt(); // N개의 정수를 배열에 입력 받음
        }
        Arrays.sort(arr); // 입력된 숫자들을 오름차순으로 정렬

        // M개의 숫자 입력
        M = sc.nextInt(); // 찾을 숫자의 개수를 입력 받음
        for (int i = 0; i < M; i++) {
            int m = sc.nextInt(); // 찾을 숫자를 입력 받음
            int left = 0; // 이분 탐색의 왼쪽 인덱스
            int right = N - 1; // 이분 탐색의 오른쪽 인덱스
            while (left <= right) {
                int mid = (left + right) / 2; // 중간 인덱스 계산
                int n = arr[mid]; // 중간 인덱스의 숫자를 가져옴
                if (n == m) { // 숫자를 찾았을 때
                    sb.append(1 + " "); // 1을 결과 StringBuilder에 추가
                    break;
                }
                if (n > m) { // 중간 값이 찾는 값보다 큰 경우
                    right = mid - 1; // 오른쪽 범위를 줄임
                } else {
                    left = mid + 1; // 중간 값이 찾는 값보다 작은 경우
                }
                if (left > right) { // 숫자를 찾지 못한 경우
                    sb.append(0 + " "); // 0을 결과 StringBuilder에 추가
                    break;
                }
            }
        }
        System.out.println(sb.toString()); // 결과 출력
    }
}