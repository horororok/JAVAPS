package BOJ.Day1013_24060_알고리즘수업병합정렬1;


/*
merge_sort(A[p..r]) { # A[p..r]을 오름차순 정렬한다.
    if (p < r) then {
        q <- ⌊(p + r) / 2⌋;       # q는 p, r의 중간 지점
        merge_sort(A, p, q);      # 전반부 정렬
        merge_sort(A, q + 1, r);  # 후반부 정렬
        merge(A, p, q, r);        # 병합
    }
}

# A[p..q]와 A[q+1..r]을 병합하여 A[p..r]을 오름차순 정렬된 상태로 만든다.
# A[p..q]와 A[q+1..r]은 이미 오름차순으로 정렬되어 있다.
merge(A[], p, q, r) {
    i <- p; j <- q + 1; t <- 1;
    while (i ≤ q and j ≤ r) {
        if (A[i] ≤ A[j])
        then tmp[t++] <- A[i++]; # tmp[t] <- A[i]; t++; i++;
        else tmp[t++] <- A[j++]; # tmp[t] <- A[j]; t++; j++;
    }
    while (i ≤ q)  # 왼쪽 배열 부분이 남은 경우
        tmp[t++] <- A[i++];
    while (j ≤ r)  # 오른쪽 배열 부분이 남은 경우
        tmp[t++] <- A[j++];
    i <- p; t <- 1;
    while (i ≤ r)  # 결과를 A[p..r]에 저장
        A[i++] <- tmp[t++]; 
}
 */
	//서로 다른 양의 정수가 저장된 배열 A
	//병합정렬로 배열 A를 오름차순 정렬할 경우 
	//배열 A에 K번째 저장되는 수를 구하기
	
import java.util.Scanner;

public class Main {
    static int K = 0;      // 정렬할 원소의 개수 제한
    static int COUNT = 0;      // 처리된 원소의 개수를 추적하는 카운터
    static int RESULT = -1;     // 결과를 저장하는 변수 (K번째 원소)
    static int[] ARR;           // 정렬할 배열
    static int[] TEMP_ARR;      // 병합을 위한 임시 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열의 원소 개수 입력
        int N = sc.nextInt();

        // 제한 값(K번째 원소) 입력
        K = sc.nextInt();

        // 메인 배열과 임시 배열 초기화
        ARR = new int[N];
        TEMP_ARR = new int[N];

        // 배열의 원소들을 입력
        for (int i = 0; i < N; i++) {
            ARR[i] = sc.nextInt();
        }

        // 배열에 병합 정렬 수행
        mergeSort(0, ARR.length - 1);

        // 결과를 출력 (K번째 원소)
        System.out.println(RESULT);

        sc.close();
    }

    // 병합 정렬을 재귀적으로 수행하는 함수
    public static void mergeSort(int p, int r) {
        // 제한 값에 도달했는지 확인
        if (K < COUNT) {
            return;
        }

        // 재귀적으로 병합 정렬 수행
        if (p < r) {
            // 중간 지점을 계산
            int q = Math.abs((p + r) / 2);

            // 왼쪽과 오른쪽 부분을 재귀적으로 정렬
            mergeSort(p, q);
            mergeSort(q + 1, r);

            // 정렬된 부분을 병합
            merge(p, q, r);
        }
    }

    // 두 정렬된 배열을 병합하는 함수
    public static void merge(int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;

        // 두 부분을 임시 배열에 병합
        while (i <= q && j <= r) {
            if (ARR[i] <= ARR[j]) {
                TEMP_ARR[t++] = ARR[i++];
            } else {
                TEMP_ARR[t++] = ARR[j++];
            }
        }

        // 왼쪽 부분에 남은 원소를 복사
        while (i <= q) {
            TEMP_ARR[t++] = ARR[i++];
        }

        // 오른쪽 부분에 남은 원소를 복사
        while (j <= r) {
            TEMP_ARR[t++] = ARR[j++];
        }

        // 병합된 원소를 원래 배열로 복사
        i = p;
        t = 0;
        while (i <= r) {
            COUNT++;

            // 현재 원소가 K번째 원소인지 확인
            if (COUNT == K) {
                RESULT = TEMP_ARR[t];
                break;
            }

            ARR[i++] = TEMP_ARR[t++];
        }
    }
}
