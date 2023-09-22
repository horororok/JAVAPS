package BOJ.Day0921_24511;

import java.util.Arrays;
import java.util.Scanner;


//시간초과
public class Main {
	
	static int idx, ans;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int[] arr1 = new int[N]; // 자료구조 형태 (큐 또는 스택)저장할 배열
		int[] arr2 = new int[N]; // 자료구조의 원소
		for (int i = 0; i < N; i++) {
			arr1[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			arr2[i] = sc.nextInt();
		}

		int M = sc.nextInt();
		int[] arr3 = new int[M]; // 삽입할 수열
		for (int i = 0; i < M; i++) {
			arr3[i] = sc.nextInt();
		}

		// 큐(0)이면 기존원소가 pop
		// 스택(1)이면 삽입된 원소가 pop

		for (int j = 0; j < M; j++) {
			ans = arr3[j]; // 마지막에 pop되어 나올 답
			for (int i = 0; i < N; i++) {
				if (arr1[i] == 0) {
					idx = arr2[i];
					arr2[i] = ans;
					ans = idx;
				} else {
					continue;
				}
			}
			sb.append(ans).append(" ");
		}
		System.out.println(sb);

	}

}
