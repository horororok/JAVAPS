package Day0820_1945;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/Day0820_1945/input_1945.txt"));
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스의 개수 입력
        int T = sc.nextInt();

        // 테스트 케이스 반복
        for (int tc = 1; tc <= T; tc++) {
            // N 입력: 양의 정수
            int N = sc.nextInt();

            // 각 소인수의 개수를 세기 위한 변수들 초기화
            int a = 0; // 2의 개수
            int b = 0; // 3의 개수
            int c = 0; // 5의 개수
            int d = 0; // 7의 개수
            int e = 0; // 11의 개수

            // 소인수 분해 과정: 각 소인수로 나누어지는 동안 반복
            while (N % 2 == 0) {
                a++; // 2로 나누어지면 a 값을 증가
                N /= 2; // N을 2로 나눔
            }
            while (N % 3 == 0) {
                b++; // 3으로 나누어지면 b 값을 증가
                N /= 3; // N을 3으로 나눔
            }
            while (N % 5 == 0) {
                c++; // 5로 나누어지면 c 값을 증가
                N /= 5; // N을 5로 나눔
            }
            while (N % 7 == 0) {
                d++; // 7로 나누어지면 d 값을 증가
                N /= 7; // N을 7로 나눔
            }
            while (N % 11 == 0) {
                e++; // 11로 나누어지면 e 값을 증가
                N /= 11; // N을 11로 나눔
            }
            
            // 각 소인수의 개수와 테스트 케이스 번호 출력
            System.out.printf("#%d %d %d %d %d %d%n", tc, a, b, c, d, e);
        }
    }
}