package forA.BOJ17135_캐슬디펜스;

import java.util.Scanner;

public class Main3 {
	static int N, M, D, result;
	static int[] archer;
	static int[][] arr, copyarr;

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		arr = new int[N][M];
		copyarr = new int[N][M];
		archer = new int[3];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		// 궁수 위치의 최적 조합 찾기
		combination(0, 0);

		// 결과 출력
		System.out.println(result);
	}

	// 궁수 위치의 모든 조합을 찾는 재귀 함수
	public static void combination(int start, int idx) {
		if (idx == 3) {
			// 세 궁수 위치가 선택되면 이 조합에 대한 결과 계산
			result = Math.max(result, game());
			return;
		}

		for (int i = start; i < M; i++) {
			// 다양한 궁수 위치의 조합을 시도
			archer[idx] = i;
			combination(i + 1, idx + 1);
		}
	}

	// 특정 궁수 위치 조합에 대한 게임 시뮬레이션
	public static int game() {
		int total = 0;
		// 원본 보드를 수정하지 않고 공격을 시뮬레이션하기 위해 게임 보드의 복사본 생성
		copyarr = new int[N][M];

		// 각 적 라인에 대해 반복
		for (int enedist = N; enedist > 0; enedist--) {
			// 선택된 각 궁수에 대해 반복
			for (int attacker : archer) {
				// 궁수가 공격할 수 있는 가능한 거리에 대해 반복
				for (int atkdist = 1; atkdist <= D; atkdist++) {
					// 공격을 수행하고 적을 처치한 수를 얻음
					int kill = attack(copyarr, atkdist, enedist, attacker);
					if (kill < 0)
						continue; // 해당 방향에 유효한 대상이 없으면 계속 진행
					total += kill;
					break; // 궁수는 턴당 하나의 적만 공격 가능
				}
			}
		}
		return total; // 이 시뮬레이션에서 처치된 전체 적의 수 반환
	}

	// 특정 거리와 방향에 대한 공격을 시뮬레이션
	public static int attack(int[][] copyarr, int dist, int line, int pick) {
		// 궁수가 공격할 수 있는 가능한 위치에 대해 반복
		for (int m = pick - dist; m <= pick + dist; m++) {
			int n = line - (dist - Math.abs(pick - m));

			// 대상 위치가 유효하고 해당 위치에 적이 있는지 확인
			if (n < 0 || m < 0 || n >= line || m >= M || arr[n][m] == 0)
				continue;

			// 대상 위치가 이미 이 턴에 공격당했는지 확인
			if (copyarr[n][m] == 0) {
				// 복사본에서 해당 위치의 적을 처치했다고 표시하여 중복 계산 방지
				copyarr[n][m] = line;
				return 1; // 적이 처치되었음을 나타내는 1 반환
			} else if (copyarr[n][m] == line) {
				return 0; // 해당 대상이 이미 이 턴에 공격당했음을 나타내는 0 반환
			}
		}
		return -1; // 해당 방향에 유효한 대상이 없음을 나타내는 -1 반환
	}
}
