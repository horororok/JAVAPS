package BOJ.Day0826_2567;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// 둘레의 길이
		// 색종이 왼쪽 아래 좌표 주어짐
		// 100*100 도화지에 10*10짜리 색종이 붙이기
		// 색종이가 붙은 부분은 1로 표시
		// 0에서 1로 바뀌거나 1에서 0으로 바뀌면 더해준다
		//경계조건 고려해서 100*100 배열이 아닌 102*102 배열로 만들어 줌

		// 이차원 배열
		int[][] arr = new int[102][102];
		
		//N번 색칠
		int N = sc.nextInt();
		for (int tc = 0; tc < N; tc++) {
			
			//좌표
			int x = sc.nextInt();
			int y = sc.nextInt();
			//색칠
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					arr[x+i+1][y+j+1] = 1;
				}
			}
		}
		
		int sum = 0;
		//앞 원소와 뒤원소가 다르면 +1
		//가로
		for(int i = 0; i<102; i++) {
			for(int j = 1; j<102; j++) {
				if(arr[i][j] != arr[i][j-1]) {
					sum++;
				}			
			}
		}
		//세로
		for(int i = 0; i<102; i++) {
			for(int j = 1; j<102; j++) {
				if(arr[j][i] != arr[j-1][i]) {
					sum++;
				}			
			}
		}
		System.out.println(sum);
	}

}
