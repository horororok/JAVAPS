package practice.MergeSort;

import java.util.Arrays;

public class Merge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 오름차순으로 정렬된 두 배열
		int[] A = new int[] { 2, 9, 11, 14 };
		int[] B = new int[] { 1, 3, 5, 12, 17 };

		// 두 배열을 합쳐서 정렬된 배열 만들기
		int[] C = new int[A.length + B.length];

		// 포인터
		int i = 0; // A의 현재 가장 작은 값의 위치
		int j = 0; // B의 현재 가장 작은 값의 위치
		int k = 0; // C의 현재 가장 작은 값의 위치

		// i , j 를 비교할 때
		// i와 j가 배열의 튿정 위치를 가리키고 있다면
		while (i < A.length && j < B.length) {
			if (A[i] < B[j]) {// i가 가리키는 대상이 더 작다면
				C[k] = A[i];
				i++;
			} else {
				C[k] = B[j];
				j++;
			}
			k++;
		}
		System.out.println(Arrays.toString(C));
		
		
		// i또는 j가 범위 밖에 있다면
		//아직 범위 안에 있는 것을 -> 비교할 필요 없이 바로 옮기면 된다.
		//만얃 i가 남아 있다면
		for(;i<A.length; i++) {
			C[k] = A[i];
			k++;
		}
		
		//만약 j가 남아 있다면
		for(;j<B.length; j++) {
			C[k] =B[j];
			k++;
		}
		
		System.out.println(Arrays.toString(C));
		
		
		

	}

}
