package BOJ.Day0919_28278;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {

			int input = sc.nextInt();
			switch (input) {
			case 1:
				list.add(sc.nextInt());
				break;
			case 2:
				if (list.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(list.get(list.size() - 1)).append("\n");
					list.remove(list.size() - 1);
				}
				break;
			case 3:
				sb.append(list.size()).append("\n");
				break;
			case 4:
				if (list.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;
			case 5:
				if (list.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(list.get(list.size() - 1)).append("\n");
				}
				break;
			}
		}
		System.out.println(sb);

	}
}
