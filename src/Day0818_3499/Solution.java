package Day0818_3499;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/Day0818_3499/input_3499.txt"));

        Scanner sc = new Scanner(System.in);

        //테케 개수
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
        	//카드 개수
            int n = sc.nextInt();

            //원래 카드 순서를 저장할 배열
            String[] arr1 = new String[n];
            //섞은 카드 순서를 저장할 배열
            String[] arr2 = new String[n];
            for (int i = 0; i < n; i++) {
            	//카드 순서를 입력받아서 arr1배열에 저장
                arr1[i] = sc.next();
            }

            // arr2에 추가할 인덱스	
            int idx = 0; 
            for (int i = 0; i < n / 2; i++) {
            	// 짝수 번째 원소 추가
                arr2[idx++] = arr1[i]; 
                // 홀수 번째 원소 추가
                arr2[idx++] = arr1[i + Math.round((n+1) / 2)]; 
            }
            //n이 홀수라면 마지막 원소 추가
            if(n%2 != 0) {
            	arr2[idx] = arr1[n/2];
            }

            System.out.print("#" + tc + " "); 
            for (String card : arr2) {
                System.out.print(card + " ");
            }
            System.out.println();
            
        }
    }
}
