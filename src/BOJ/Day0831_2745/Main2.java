package BOJ.Day0831_2745;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // B진법으로 표현된 숫자 N을 입력 받습니다.
        String N = sc.next();

        // 변환할 진법 B를 입력 받습니다.
        int B = sc.nextInt();

        // 입력된 숫자의 길이를 계산합니다.
        int len = N.length();

        // 변환된 10진수 값을 저장할 변수를 초기화합니다.
        long ans = 0;

        // 입력된 숫자의 각 자리를 처리합니다.
        for (int i = 0; i < len; i++) {
            char c = N.charAt(i); // 문자열에서 i번째 문자를 가져옵니다.

            int digitValue = 0; // 문자의 숫자값을 저장할 변수를 초기화합니다.

            // 문자가 '0'부터 '9' 사이에 있는 경우
            if (c >= '0' && c <= '9') {
                digitValue = c - '0'; // 문자를 숫자로 변환합니다.
            } else { // 문자가 'A'부터 'Z' 사이에 있는 경우
                digitValue = c - 'A' + 10; // 문자를 숫자로 변환합니다. 'A'는 10부터 시작합니다.
            }
            
            int power = len - 1 - i; // 현재 자리의 B진법에서의 위치를 계산합니다.
            ans += digitValue * Math.pow(B, power); // 10진수로 변환된 값을 누적합니다.
        }
        
        
        
        // 변환된 10진수 값을 출력합니다.
        System.out.println(ans);
    }
}
