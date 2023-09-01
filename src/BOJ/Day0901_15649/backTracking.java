package BOJ.Day0901_15649;

public class backTracking {
	/*
	 * 중복되는 수를 제외한 모든 경우의 수를 탐색한다 재귀를 하면서 이미 방문한 노드(값)이라면 다음 노드를 탐색하도록 하기 위해 N크기의
	 * boolean배열을 생성하고 탐색과정에서 값을 담을 int 배열 arr을 생성한다 depth변수를 추가하여 재귀가 깊어질 때마다
	 * depth를 1씩 증가 시켜 M과 같아지면 더이상 재귀를 호출하지 않고 탐색과정 중 값을 담았던 arr 배열을 출력해주고 return시킨다
	 */

//	boolean[] visit = new boolean[N];
//	int[] aee = new int[M];
//
//	public static void dfs(int N, int M, int depth) {
//
//		// 재귀 깇이가 M과 같아지면 탐색과정에서 담았던 배열을 출력
//		if (depth == M) {
//			for (int cal : arr) {
//				System.out.println(val + " ");
//			}
//			System.out.println();
//			return;
//		}
//
//		for (int i = 0; i < N; i++) {
//
//			// 만약 해당 노드를 방문하지 않았다면
//			if (visit[i] == false) {
//
//				visit[i] = true; // 해당 노드를 방문상태로 변경
//				arr[depth] = i + 1; // 해당 깊이를 index로 하여 i+1 값 저장
//				dfs(N, M, depth + 1); // 다음 자식 노드 방문을 위해 depth를
//										// 1증가시키면서 재귀호출
//
//				// 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
//				visit[i] = false;
//			}
//		}
//		return;
//	}
}

// 중복되는 수는 담을수 없기에 방문할 필요조차 없다. 
// 즉, 방문 상태를 판단하기 위해 visit[] 배열이 있는 것이고, 
// 해당 index가 방문하지 않는 노드(값)일 때만 재귀호출을 해주면 된다. 
// 이게 백트래킹의 가장 기초라 할 수 있다.