package practice.Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 순열_2 {
//swap을 통한 순열 생성
	public static int[] nums;// 배열
	public static int N; // 원소수
	public static List<int[]> list;

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		N = nums.length;

		list = new ArrayList<>();

		perm(0);

		System.out.println(list.size());
		for (int[] a : list) {
			System.out.println(Arrays.toString(a));
		}
	}

	// idx 현재 판단 위치
	public static void perm(int idx) {
		if (idx == N) {
			int[] tmp = new int[N];
			for (int i = 0; i < N; i++) {
				tmp[i] = nums[i];
			}
			list.add(tmp);
			return;
		}

		// 재귀
		for (int i = idx; i < N; i++) {
			swap(i, idx);
			perm(idx + 1);
			swap(i, idx);
		}
	}

	public static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}

}
