package BOJ.Day0901_15649;

import java.util.Scanner;

public class Main {
	
	public static int[] arr;       // 조합 결과를 저장할 배열
	public static boolean[] visit; // 방문 여부를 저장할 배열
	public static StringBuilder sb = new StringBuilder(); // 결과를 담을 StringBuilder

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 전체 자연수 범위 [1, N]
		int M = sc.nextInt(); // 조합의 길이

		arr = new int[M];      // 조합 결과 배열 초기화
		visit = new boolean[N]; // 방문 여부 배열 초기화
		dfs(N, M, 0);          // 깊이 우선 탐색 (DFS) 호출
		System.out.println(sb); // 결과 출력
	}

	// DFS로 조합을 생성하고 StringBuilder에 저장하는 메서드
	private static void dfs(int N, int M, int depth) {
		// 조합의 길이가 M과 동일하면 결과를 StringBuilder에 저장하고 반환
		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(' '); // 조합 요소를 StringBuilder에 추가
			}
			sb.append('\n'); // 줄 바꿈 추가
			return;
		}

		// 1부터 N까지의 자연수 중에서 조합을 생성
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {          // 방문하지 않은 자연수를 선택
				visit[i] = true;      // 선택한 자연수를 방문 표시
				arr[depth] = i + 1;   // 선택한 자연수를 조합 배열에 저장
				dfs(N, M, depth + 1); // 다음 깊이의 DFS 호출
				visit[i] = false;     // 이전 단계로 돌아올 때 방문 표시 해제
			}
		}
	}
	 
}
