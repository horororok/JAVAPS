package forA;

import java.util.Scanner;

public class BOJ17070_파이프옮기기1 {
	public static void main(String[] args) {
		
		//x,y 까지 파이프를 이동시킬 수 있는 방법의 수 : dp[x][y][3] 
    	//0 가로, 1 세로, 2 대각
    	//dp[x][y][0] += dp [x][y - 1][0] + dp[x][y - 1][2]
    	//dp[x][y][1] += dp [x - 1][y][1] + dp[x - 1][y][2]
    	//dp[x][y][2] += dp [x - 1][y - 1][0] + dp[x - 1][y - 1][1] + dp[x - 1][y - 1][2]
    	
    	
    	
		Scanner sc = new Scanner(System.in);
		
		//집의 크기
        int N = sc.nextInt();

        //(x,y)로 0:가로/ 1:세로/ 2:대각아래 의 방법으로 이동하는 방법의 수  dp배열
        long[][][] dp = new long[N + 1][N + 1][3];
        
        //집의 구조
        int[][] house = new int[N + 1][N + 1];
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                house[x][y] = sc.nextInt();
            }
        }

        //시작 지점을 1로 초기화
        dp[1][2][0] = 1;

        //순회하면서 경로의 개수 계산
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {

            	//벽이 있으면 건너 뛴다
                if (house[x][y] == 1)
                    continue;

                //왼쪽과 위쪽에서 오는 경로의 수 계산
                dp[x][y][0] += dp[x][y - 1][0] + dp[x][y - 1][2];
                dp[x][y][1] += dp[x - 1][y][1] + dp[x - 1][y][2];

                //위쪽과 왼쪽 셀에 벽이 없는 경우, 대각선 경로 계산
                if (house[x - 1][y] == 0 && house[x][y - 1] == 0) {
                    dp[x][y][2] += dp[x - 1][y - 1][0] + dp[x - 1][y - 1][1] + dp[x - 1][y - 1][2];
                }
            }
        }

        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
		
	}

}
