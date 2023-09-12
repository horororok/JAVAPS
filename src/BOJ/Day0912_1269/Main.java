package BOJ.Day0912_1269;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();

		ArrayList<Integer> aA = new ArrayList<>();
		ArrayList<Integer> aB = new ArrayList<>();
		ArrayList<Integer> AB = new ArrayList<>();

		HashSet<Integer> hA = new HashSet<>();
		HashSet<Integer> hB = new HashSet<>();

		
		//교집합의 개수를 구해서 각각의 크기에서 빼줌
		for (int i = 0; i < A; i++) {
			int input = sc.nextInt();
			hA.add(input);
		}

		for (int i = 0; i < B; i++) {
			int input = sc.nextInt();
			hB.add(input);
			if (hA.contains(input)) {
				AB.add(input);
			}
		}

		int ans = hA.size() + hB.size() - 2 * AB.size();

		System.out.println(ans);

	}
}
