package BOJ.Day0827_2477;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 참외 개수
        int[] input = new int[6];
        int maxR = 0, maxC = 0; // 최대 세로길이, 최대 가로길이
        int indexR = 0, indexC = 0;

        // 6개의 변에 대한 정보 입력 및 처리
        for (int i = 0; i < 6; i++) {
            int dir = sc.nextInt();
            int distance = sc.nextInt();
            if (dir == 3 || dir == 4) { // 남북 방향일 때
                maxR = maxR < distance ? distance : maxR; // 최대 세로길이 갱신
                if (maxR == distance) indexR = i; // 최대 세로길이의 변 인덱스 저장
            } else { // 동서 방향일 때
                maxC = maxC < distance ? distance : maxC; // 최대 가로길이 갱신
                if (maxC == distance) indexC = i; // 최대 가로길이의 변 인덱스 저장
            }
            input[i] = distance; // 입력된 거리를 배열에 저장
        }

        int nextR1 = input[5], nextC1 = input[5]; // nextR1, R2 => 세로길이 후보
        int nextR2 = input[0], nextC2 = input[0]; // nextC1, C2 => 가로길이 후보

        // 인덱스 범위 체크 후 세로길이 후보 갱신
        if (indexC - 1 > -1) nextR1 = input[indexC - 1];
        if (indexC + 1 < 6) nextR2 = input[indexC + 1];

        // 인덱스 범위 체크 후 가로길이 후보 갱신
        if (indexR - 1 > -1) nextC1 = input[indexR - 1];
        if (indexR + 1 < 6) nextC2 = input[indexR + 1];

        // 최대 가로길이 * 세로길이후보 중 작은 길이 + 가로길이후보 중 작은 길이 * (최대 세로길이 - 세로길이후보 중 작은 길이)
        int area = maxC * Math.min(nextR1, nextR2) + Math.min(nextC1, nextC2) * (maxR - (Math.min(nextR1, nextR2)));

        System.out.println(area * N);

    }
}
