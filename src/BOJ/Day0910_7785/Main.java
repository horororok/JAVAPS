package BOJ.Day0910_7785;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N은 출입 기록의 수
        int N = sc.nextInt();

        // HashMap을 생성하여 이름을 키(key), 출입 여부를 값(value)으로 저장
        HashMap<String, String> map = new HashMap<>();

        // N번 반복하며 출입 기록을 입력받고 처리
        for (int i = 0; i < N; i++) {
            String key = sc.next(); // 이름 입력
            String val = sc.next(); // 출입 여부 입력

            // 만약 출입이 "enter"이면, 이름을 HashMap에 추가
            if (val.equals("enter")) {
                map.put(key, val);
            } 
            // 출입이 "leave"이면, 해당 이름을 HashMap에서 제거
            else {
                map.remove(key);
            }
        }

        // HashMap의 키(key)를 arraylist로 받고 역순으로 정렬
        ArrayList<String> arr = new ArrayList<>(map.keySet());
        Collections.sort(arr, Collections.reverseOrder());
        
        for(String key : arr) {
            System.out.println(key);
        }
        
    }
}