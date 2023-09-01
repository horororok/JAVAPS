package practice.NextPermutation;

import java.util.Arrays;

// c++ : next_permutation

public class NextPermutation {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 1, 1, 3, 3, 3}; // 주어진 수열
		
		do {
			// 현재 수열 출력
			System.out.println(Arrays.toString(arr));
		} while (next_permutation(arr)); // 다음 순열을 구했다면 출력 반복
		
	}

	private static boolean next_permutation(int[] arr) {
		// 다음 순열 찾는 순서
		// 1. 낭떠러지(A), 꼭대기(B) 찾기
		// 2. 구간(꼭대기 ~ 끝)에서 A보다 커지는 최초의 수(C) 찾기
		// 3. A와 C 교환
		// 4. 구간(B ~ 끝) 뒤집기
		
		// 1. 꼭대기 위치(인덱스): i
		int i = arr.length - 1; // 뒤에서부터 찾기 시작
		while(i > 0 && arr[i-1] >= arr[i]) i--;
		// while 문을 빠져나왔다는 것은
		// arr[i-1]보다 arr[i]가 더 크다
		// i => 꼭대기(B)
		// i-1 => 낭떠러지(A)
		
		// i == 0이 되었을 때도 while문을 빠져나옴
		// => 다음순열이 없음
		if(i==0)
			return false;
		
		
		// 2. 뒤에서 부터 시작해서 낭떠러지보다 커지는 
		// 최초의 수 인덱스 : j
		int j = arr.length - 1;
		
		while(arr[i-1] >= arr[j]) j--;
		// while문을 빠져나오면 arr[j]
		// arr[i-1] < arr[j];
		
		
		// 3.
		swap(arr, i-1, j);
		
		// 4. 뒤집기( B ~ 끝)
		// B의 인덱스는 i에 저장된 상태
		int k = arr.length - 1;
		while(i < k) swap(arr, i++, k--);
		
		// 여기까지 왔다는 것은 다음 순열을 찾은 것임
		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	
}
