package practice.DP;

import java.util.Scanner;

public class prac {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//n가지 종류의 동전
		//가치의 합이 K가 되도록
		//최소 개수의 동전 사용
		
		//점화식
		//dp[n] = min(dp[n], dp[n - 동전의 가치]+1)
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		//동전의 가치 입력 받을 배열
		int[] values = new int [N+1];
		for(int i = 1; i<N+1; i++) {
			values[i] = sc.nextInt();
		}
		
		//인덱스를 동전의 가치로 하는 dp배열
		int [] dp = new int[K+1];
		
		//dp배열을 10001로 초기화 해준다(K가 10000까지 이므로)
		for(int i = 1; i<K+1; i++) {
			dp[i] = 10001;
		}
		
		for(int i = 1; i<N+1; i++) {
			for(int v = values[i]; v<K+1; v++) {
				dp[v] = Math.min(dp[v], dp[v - values[i]]+1);
			}
		}
		
		if(dp[K]==10001) {
			System.out.println(-1);
		}
		else {
			System.out.println(dp[K]);
		}
		
	}

}
