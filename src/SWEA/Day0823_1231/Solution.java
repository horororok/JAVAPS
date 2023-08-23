package SWEA.Day0823_1231;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

    static int N; // 노드의 개수
    static char[] arr; // 각 노드의 값을 저장할 배열

    // 중위 순회를 수행하는 함수
    static void inorder(int i) {
        if (i <= N) {
            inorder(2 * i); // 왼쪽 자식 방문
            if (arr[i] != ' ') {
                System.out.print(arr[i]); // 현재 노드 출력
            }
            inorder(2 * i + 1); // 오른쪽 자식 방문
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
    	System.setIn(new FileInputStream("src/SWEA/Day0823_1231/input_1231.txt"));
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            // 입력 받기
            N = sc.nextInt(); // 노드의 개수
            arr = new char[N + 1]; // 노드 값 배열 초기화
            sc.nextLine(); // 개행 문자 제거

            for (int i = 1; i <= N; i++) {
                if (sc.hasNextInt()) {
                    sc.nextInt(); // 정수 입력 (무시)
                    i--; // 인덱스 보정
                } else
                    arr[i] = sc.next().charAt(0); // 문자 입력 받아 배열에 저장
            }

            System.out.print("#" + tc + " "); // 테스트 케이스 번호 출력
            inorder(1); // 중위 순회 시작
            System.out.println(); // 줄 바꿈
        }
    }
}
