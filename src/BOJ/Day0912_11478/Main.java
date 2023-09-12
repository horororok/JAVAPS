package BOJ.Day0912_11478;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String S = sc.next();
		HashSet<String> hs = new HashSet<>();

		//모든 부분집합을 만들어서 set에 넣어준다
		//알아서 중복이 제거된다.
		for (int i = 0; i < S.length(); i++) {
			for (int j = i + 1; j <= S.length(); j++) {
				hs.add(S.substring(i, j));
			}
		}

		int ans = hs.size();
		System.out.println(ans);
	}
}
