package SWEA.Day0901_14229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 병합정렬 오름차순
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = 1000000; // 입력 크기
        int[] A = new int[N]; // 입력된 정수를 저장할 배열

        // 입력된 값을 배열에 저장
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 병합 정렬을 사용하여 배열 A를 정렬
        mergeSort(A, 0, N - 1);

        // 정렬된 배열 A에서 중간값을 출력
        System.out.println(A[500000]);
    }

    // 병합 정렬 수행
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            // 두 구간으로 쪼갠다.
            int m = (l + r) / 2;
            mergeSort(arr, l, m); // 왼쪽 부분을 병합 정렬
            mergeSort(arr, m + 1, r); // 오른쪽 부분을 병합 정렬

            // 합치는 과정 수행
            merge(arr, l, m, r);
        }
    }

    // 두 개의 배열을 병합하는 함수
    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1; // 왼쪽 배열의 길이
        int n2 = r - m; // 오른쪽 배열의 길이

        int[] L = new int[n1]; // 왼쪽 배열
        int[] R = new int[n2]; // 오른쪽 배열

        // 왼쪽 배열 복사
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }

        // 오른쪽 배열 복사
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0; // 왼쪽 배열의 인덱스
        int j = 0; // 오른쪽 배열의 인덱스
        int k = l; // 병합할 부분의 시작 인덱스

        // 두 개의 배열을 합치면서 정렬 수행
        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // 남은 값들을 복사
        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }
}
