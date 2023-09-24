package practice;

import java.util.Arrays;

public class combPrac {
	static int[] arr = { 1, 2, 3, 4 };
	static int[] output;
	static boolean[] visited;
	static int N = 4, R = 3;

	public static void main(String[] args) {
		output = new int[R];
		visited = new boolean[N];

		// 1. 순열
		permutation(0, N, R);
		
		// 2. 중복순열
		repeatPermutation(0, N, R);
		
		// 3. 조합
		combination(0, 0, N, R);
		
		// 4. 중복조합
		repeatCombination(0, 0, N, R);
	}

	// 순열
	static void permutation(int depth, int n, int r) {
		// 순열이 완성된 경우
		if (depth == r) {
			System.out.println(Arrays.toString(output));
			return;
		}

		// 0부터 n까지 반복
		for (int i = 0; i < n; i++) {
			// 방문하지 않은 값이면 넣기
			if (!visited[i]) {
				visited[i] = true; // 방문 처리
				output[depth] = arr[i]; // 현재 depth를 인덱스로 사용
				permutation(depth + 1, n, r); // depth + 1를 전달
				visited[i] = false; // 다음 순열을 뽑기위해 방문처리 제거
			}
		}
	}

	// 중복순열
	static void repeatPermutation(int depth, int n, int r) {
		// 순열이 완성된 경우
		if (depth == r) {
			System.out.println(Arrays.toString(output));
			return;
		}
	
		// 0부터 n까지 반복
		for (int i = 0; i < n; i++) {
			output[depth] = arr[i]; // 현재 depth를 인덱스로 사용
			repeatPermutation(depth + 1, n, r); // depth + 1를 전달
		}
	}
	
	// 조합
	static void combination(int start, int depth, int n, int r) {
		// 조합이 완성된 경우
		if(depth == r) {
			System.out.println(Arrays.toString(output));
			return;
		}
		
		// start 부터 n까지 반복
		for(int i = start; i < n; i++) {
			output[depth] = arr[i];	// 현재 depth를 인덱스로 사용
			combination(i + 1, depth + 1, n, r);	// i + 1, depth + 1를 전달
		}
	}
	
	// 중복조합
	static void repeatCombination(int start, int depth, int n, int r) {
		// 조합이 완성된 경우
		if(depth == r) {
			System.out.println(Arrays.toString(output));
			return;
		}
		
		// start 부터 n까지 반복
		for(int i = start; i < n; i++) {
			output[depth] = arr[i];	// 현재 depth를 인덱스로 사용
			repeatCombination(i, depth + 1, n, r);	// i, depth + 1를 전달
		}
	}
}