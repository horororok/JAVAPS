package BOJ.Day0907_18870;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		//해시맵을 사용하여 각 숫자에 대한 압축된 좌표를 저장하고 조회하며 이를 구현
		int N = sc.nextInt();

		 int[] arr = new int[N]; // 원본 배열
	        int[] arr2 = new int[N]; // 정렬된 배열
	        for (int i = 0; i < N; i++) {
	            int input = sc.nextInt();
	            arr[i] = input; // 원본 배열에 값 저장
	            arr2[i] = input; // 정렬된 배열에 값 저장
	        }

	        Arrays.sort(arr2); // 정렬된 배열을 생성

	        HashMap<Integer, Integer> hm = new HashMap<>(); 
	        // 숫자와 그에 대한 압축된 좌표(순위)를 저장하는 해시맵 생성

	        hm.put(arr2[0], 0); // 정렬된 배열의 첫 번째 요소를 해시맵에 추가하고 압축된 좌표를 0으로 초기화

	        int rank = 1; // 압축된 좌표(순위)를 나타내는 변수 초기화
	        int idx = 1; // 정렬된 배열의 인덱스를 나타내는 변수 초기화
	        while (idx < N) {
	            if (arr2[idx] != arr2[idx - 1]) { // 현재 원소와 이전 원소가 다르다면
	                hm.put(arr2[idx], rank); // 해시맵에 현재 원소와 그에 대한 압축된 좌표(순위) 추가
	                rank++; // 압축된 좌표(순위) 증가
	            }
	            idx++; // 다음 원소로 이동
	        }

	        StringBuilder sb = new StringBuilder(); // 결과를 저장하기 위한 문자열 빌더 생성

	        for (int i = 0; i < N; i++) {
	            sb.append(hm.get(arr[i])).append(" "); 
	            // 각 원본 배열의 원소를 해시맵에서 찾아 압축된 좌표(순위)를 문자열에 추가
	        }
	        System.out.println(sb); // 결과 출력
	    }
	}