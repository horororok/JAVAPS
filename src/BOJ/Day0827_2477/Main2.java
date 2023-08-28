package BOJ.Day0827_2477;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);

        // 참외의 개수 입력 받기
        int K = sc.nextInt();

        // 첫 번째 변은 사용하지 않으므로 스킵
        sc.nextInt();

        // 첫 번째 변의 길이 입력 받기
        int first = sc.nextInt();
        int pre = first; // 이전 변의 길이를 저장할 변수 초기화

        int sum = 0; // 참외의 총 개수를 저장할 변수 초기화
        int max = Integer.MIN_VALUE; // 최대 참외 개수를 저장할 변수 초기화

        // 나머지 5개의 변에 대한 정보 입력 받기
        for (int i = 1; i < 6; i++) {
            sc.nextInt(); // 변의 방향은 사용하지 않으므로 스킵
            int cur = sc.nextInt(); // 현재 변의 길이 입력 받기
            max = Math.max(cur * pre, max); // 최대 참외 개수 갱신
            sum += cur * pre; // 참외의 총 개수 누적
            pre = cur; // 이전 변의 길이 갱신
        }

        // 마지막 변과 첫 번째 변의 정보를 사용하여 최대 참외 개수 갱신
        max = Math.max(pre * first, max);
        sum += pre * first; // 마지막 변과 첫 번째 변의 참외 개수 누적

        // 실제 참외의 개수를 계산하고 출력
        System.out.println((sum - max * 2) * K);
    }
}
