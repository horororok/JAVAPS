package BOJ.Day0910_14425;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

//		HashMap<String, Integer> map = new HashMap<>();
//		for (int i = 0; i < N; i++) {
//			map.put(sc.next(), 0);
//		}
//		int cnt = 0;
//		for (int i = 0; i < M; i++) {
//			if (map.containsKey(sc.next())) {
//				cnt++;
//			}
//		}
		
		HashSet<String> set = new HashSet<>();
		
		for(int i = 0; i<N; i++) {
			set.add(sc.next());
		}
		
		int cnt = 0;
		for(int i = 0; i<M; i++) {
			if(set.contains(sc.next())) {
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}
}