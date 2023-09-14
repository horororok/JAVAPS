package BOJ.Day0914_17103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

//		Scanner sc = new Scanner(System.in);

		
		//시간초과
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 골드바흐의 추측 : 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다
		// 짝수 N을 두 소수의 합으로 나타낸 돌드바흐 파티션

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 1000000; i++) {
			if (isPrime(i)) {
				list.add(i);
			}
		}

		for (int tc = 0; tc < T; tc++) {

			int N = Integer.parseInt(br.readLine());
			
//			System.out.println(list);

			int idx = 0;
			while(list.get(idx)<N) {
				idx++;
			}
			
			int cnt = 0;
			outer: for (int i = 0; i < idx-1; i++) {
				for (int j = i; j < idx; j++) {
					if (list.get(i) + list.get(j) == N) {
						cnt++;
						continue outer;
					}
				}
			}
			sb.append(cnt).append("\n");

		}
		System.out.println(sb);

	}

	// 소수 판별
	public static boolean isPrime(int a) {
		if (a < 2) {
			return false;
		}
		for (int i = 2; i * i <= a; i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

}