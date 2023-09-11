package BOJ.Day0911_1764;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		HashSet<String> hm = new HashSet<>();
		for(int i = 0; i<N; i++) {
			hm.add(sc.next());
		}
		
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0; i<M; i++) {
			String input = sc.next();
			if(hm.contains(input)) {
				list.add(input);
			}
		}
		Collections.sort(list);
		
		
		System.out.println(list.size());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb);
		
	}
}
