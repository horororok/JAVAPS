package practice.Permutation;

import java.util.Arrays;

public class 순열_3 {
//방문체크를 통한 순열 생성
	public static int[] nums; // 배열
	public static int N; // 원소수
	public static int[] result; // 결과저장
	public static boolean[] visited; // 해당 원소 사용 여부

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		N = nums.length;
		result = new int[N];
		visited = new boolean[N];
		perm(0);
	}

	public static void perm(int idx) {
		// 기저조건
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}

		// 재귀
		// 사용할 수 있는 모든 원소 체크
		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				continue; // 이미 사용한 원소는 패스
			}
			result[idx] = nums[i]; // 해당 i번째의 원소 저장
			visited[i] = true; // i번째 원소 사용 표시
			perm(idx + 1); // 재귀
			visited[i] = false; // i번째 원상복구
		}
	}
}
