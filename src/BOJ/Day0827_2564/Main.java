package BOJ.Day0827_2564;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//실패
		// 상점으로 가는 최단 거리 구하기
		// 통과가 안되므로 양쪽 끝으로 먼저 간 후
		// 가야 하는 거리 중 최단 거리 구하기
		// 1 북 2 남 3 서 4 동
		// 왼쪽 또는 위쪽으로 부터 거리
		// 마지막 줄은 동근이의 위치

		// 크기
		int[] block = new int[2];
		for (int i = 0; i < 2; i++) {
			block[i] = sc.nextInt();
		}
//		System.out.println(Arrays.toString(block));

		// 상점 개수
		int N = sc.nextInt();
		// 상점 위치
		int[][] store = new int[N][2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				store[i][j] = sc.nextInt();
			}
		}
		// 동근 위치
		int[] dk = new int[2];
		for (int i = 0; i < 2; i++) {
			dk[i] = sc.nextInt();
		}

		// 동근이의 위치가 1 or 2 일 경우 왼쪽 끝 또는 오른쪽 끝으로 가서 출발
		// 3or 4일경우 위 또는 아래로 가서 출발
		// 움직인 거리
		int dis = 0;
		// 거리 합
		int sum = 0;
		for (int i = 0; i < N; i++) {
			//동근위치 남 이나 북이고 가게가 서쪽에 있을 경우 동근은 일단 서쪽 끝으로 간다
			if ((dk[0] == 1 || dk[0] == 2) && store[i][0] == 3) {
				int T = dk[1];
				dk[1] = 0;
				dis += T;
				if(dk[0] ==1) {
					dis+= store[i][1];
				}else {
					dis+= block[1]-store[i][1];
				}
			}
			//동근위치 남 이나 북이고 가게가 동쪽에 있을 경우 동근은 동쪽 끝으로
			else if((dk[0] ==1 || dk[0] ==2)&& store[i][0]==4) {
				int T = dk[1];
				dk[1] = block[0];
				dis+= block[0]-T;
				if(dk[0] ==1) {
					dis+= store[i][1];
				}else {
					dis+= block[1]-store[i][1];
				}
			}
			//동근위치 남이나 북 가게가 북에 있으면
			else if((dk[0] ==1 || dk[0] ==2)&& store[i][0]==1) {
				int T = dk[1] - store[i][1];
				if(dk[0] ==1) {
					dis+= Math.abs(T);
				}else {
					dis+= Math.abs(T)+block[1];
				}
			}
		}

	}
}
