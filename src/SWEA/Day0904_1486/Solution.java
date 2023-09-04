package SWEA.Day0904_1486;

import java.util.Scanner;

public class Solution {
    public static int[] arr;
    public static int N;
    public static int B;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = scanner.nextInt(); // 테스트 케이스의 수를 입력 받음
        for (int t = 1; t <= T; t++) {
            N = scanner.nextInt(); // 배열 크기 N을 입력 받음
            B = scanner.nextInt(); // 목표 합계 B를 입력 받음
            arr = new int[N]; // N 크기의 정수 배열을 생성
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt(); // 배열의 원소들을 입력 받음
            }
            int sum = 0; // 현재까지의 부분 합을 저장할 변수
            int min = Integer.MAX_VALUE; // B를 넘는 가장 작은 부분 합을 저장할 변수
            min = combi(0, sum, min); // combi 함수를 호출하여 결과를 min에 저장
            sb.append("#" + t + " " + (min - B) + "\n"); // 결과를 문자열에 추가
        }
        System.out.println(sb); // 결과 문자열을 출력
    }

    public static int combi(int idx, int sum, int min) {
        if (idx == N) {
            // 배열을 모두 검사했을 때 (기저 조건)
            if (sum >= B) {
                // 현재 부분 합이 목표 합계 B보다 크거나 같다면
                min = Math.min(min, sum); // min을 현재 합계와 비교하여 더 작은 값으로 업데이트
            }
            return min; // min 값을 반환
        }

        // 현재 값을 포함할 때
        sum += arr[idx]; // 현재 원소를 합계에 더함
        min = combi(idx + 1, sum, min); // 다음 원소로 재귀 호출
        sum -= arr[idx]; // 다음 호출을 위해 현재 원소를 합계에서 뺌

        // 현재 값을 포함하지 않을 때
        min = combi(idx + 1, sum, min); // 다음 원소로 재귀 호출

        return min; // min 값을 반환
    }
}
