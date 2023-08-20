import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class practice {

	public static void main(String[] args) throws FileNotFoundException {
		// System.setIn(new FileInputStream("src/Day0820_11315/input_11315.txt"));
		Scanner sc = new Scanner(System.in);

		// N*N행렬에 1부터 N*N까지 숫자를 채워준다
		// 오른쪽 - 아래 - 왼쪽 - 위 순으로 진행하며
		// 벽을 만나면 방향을 바꾼다
		// 배열의 끝이거나, 이미 숫자가 채워져 있을 경우 방향 전환

		// 테스트 케이스
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			// N 입력
			int N = sc.nextInt();

			// 진행 방향
			int dr[] = { 0, 1, 0, -1 };
			int dc[] = { 1, 0, -1, 0 };

			// 이차원 배열의 인덱스
			int r = 0;
			int c = 0;
			// 진행방향 인덱스
			int x = 0;

			// 이차원 배열을 만들어줌
			int arr[][] = new int[N][N];
			// 배열 초기화
			for (int i = 1; i <= N * N; i++) {
				// 배열
				arr[r][c] = i;

				int newRow = r + dr[x];
				int newCol = c + dc[x];
				if (newRow >= N || newRow < 0 || newCol >= N || newCol < 0 || arr[newRow][newCol] != 0) {
					x++;
					x %= 4;
				}
				r = r+dr[x];		
				c = c+dc[x];
			}

			System.out.println(Arrays.deepToString(arr));

			// 벽을 만나면 방향을 바꾼다
			// 경계조건

		}
	}

}
