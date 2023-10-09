package forA.BOJ16234_인구이동;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	// N*N크기의 땅 1칸당 하나의 나라 존재
	// r행 c열에 있는 나라에는 A[r][c]명이 살고 있다.
	// 인점한 두 나라의 인구차이가 L이상 R이하이면 합치고 한칸당 (총 인구수 / 칸수)의 인구수를 갖는다.
	// 며칠동안 발생하는지 구하기
	
	//전체 노드를 돌면서 
	//방문하지 않은 노드부터 BFS를 실행하여 연합 구성노드의 좌표를 구하고, 연합의 총 인구수를 구한다
	//연합의 수가 1이상이라면(연합이 존재한다면) 연합의 인구수의 평균을 구한다
	
	static int N, l, R;	//N : 크기, L이상 R이하의 인구차이는 국경개방
	static int[][] map;	//N*N
	static ArrayList<int[]> list;	//국경개방한 나라의 좌표
	static boolean[][] visit;		//방문 확인
	static int[] dr = { 0, 1, 0, -1 };	//사방탐색 동남서북
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		l = sc.nextInt();
		R = sc.nextInt();

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		System.out.println(days());
	}

	//총 걸린 일수
	static int days() {
		int result = 0;
		while (true) {
			visit = new boolean[N][N];
			//연합이 생겼는지(일수 확인용)
			boolean isUnion = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j]) {	//방문하지 않은 노드
						//BFS 실행
						int sum = BFS(i, j);
						//리스트의 크기가 1이상(연합이 하나 이상 생겼다)이면
						if (list.size() > 1) {						
							avg(sum);	//평균인구수를 구해서 넣어줌
							isUnion = true;	//연합 유무 true
						}
					}
				}
			}
			if (!isUnion)
				return result;
			result++;
		}
	}

	//총 인구수의 평균을 구해서 각 노드에 넣어줌
	static void avg(int sum) {
		int population = sum / list.size();
		for (int i = 0; i < list.size(); i++) {
			int r = list.get(i)[0];
			int c = list.get(i)[1];
			map[r][c] = population;
		}
	}
	
	
	//BFS 실행
	static int BFS(int r, int c) {
		//연합의 구성 노드 좌표를 넣어줄 큐(poll을 위해 만들어줌)
		Queue<int[]> que = new LinkedList<>();
		//연합의 구성노드 좌표 저장할 리스트
		list = new ArrayList<>();

		que.add(new int[] { r, c });
		list.add(new int[] { r, c });
		visit[r][c] = true;	//방문처리
		int sum = map[r][c];

		while (!que.isEmpty()) {
			int[] t = que.poll();
			
			//사방탐색
			for (int i = 0; i < 4; i++) {
				int nr = t[0] + dr[i];
				int nc = t[1] + dc[i];
				//범위
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (!visit[nr][nc]) {	//방문하지 않은 경우
						int tmp = Math.abs(map[t[0]][t[1]] - map[nr][nc]);
						if (tmp >= l && tmp <= R) {
							visit[nr][nc] = true;	//방문처리
							que.add(new int[] { nr, nc });	//큐에넣어주고
							list.add(new int[] { nr, nc });	//리스트에 넣어주고
							sum += map[nr][nc];	//연합의 총인구수
						}
					}
				}
			}
		}
		return sum;
	}
}