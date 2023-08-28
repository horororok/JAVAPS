package BOJ.Day0827_2564;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		// 입력 받기: n - 가로 길이, m - 세로 길이, k - 상점의 개수
		int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
		int cnt = 0, dk = 0;

		// 각 상점의 위치를 저장하는 배열
		int[] map = new int[k];

		// 입력 받기: 방향, 위치
		for (int i = 0; i < k + 1; i++) {
			int dir = sc.nextInt(); // 방향 (1: 북쪽, 2: 남쪽, 3: 서쪽, 4: 동쪽)
			int loc = sc.nextInt(); // 위치

			int tmp = 0; // 위치 임시 저장 변수

			switch (dir) {
			case 1:
				tmp = loc; // 북쪽 방향은 위치 그대로
				break;
			case 2:
				tmp = n + m + n - loc; // 남쪽 방향은 가로길이 + 세로길이 + 가로길이에서 위치 빼기
				break;
			case 3:
				tmp = n + m + n + m - loc; // 서쪽 방향은 가로길이 + 세로길이 + 가로길이 + 세로길이에서 위치 빼기
				break;
			case 4:
				tmp = n + loc; // 동쪽 방향은 가로길이 + 위치
				break;
			}

			if (i < k)
				map[i] = tmp; // 상점 위치 저장
			else
				dk = tmp; // 동근 위치 저장
		}

		// 동근으로부터 상점까지의 최단 거리 계산
		for (int i = 0; i < k; i++) {
			int path1 = Math.abs(dk - map[i]); // 동근과 상점 사이의 거리
			int path2 = 2 * n + 2 * m - path1; // 반대편 경로의 거리

			// 두 경로 중 더 짧은 거리 선택하여 카운트에 더함
			cnt += Math.min(path1, path2);
		}
		System.out.println(cnt);
	}
}
