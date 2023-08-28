package BOJ.Day0826_2309;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        int nums[] = new int[9];
        for (int i = 0; i < 9; i++) {
            nums[i] = sc.nextInt(); // 9개의 수 입력 받기
        }

        // 합이 100인 7개의 수 찾기
        outer: // 바깥쪽 반복문에 이름을 붙임
        for (int i = 0; i < 3; i++) { // 첫 번째 수의 인덱스
            for (int j = i + 1; j < 4; j++) { // 두 번째 수의 인덱스
                for (int k = j + 1; k < 5; k++) { // 세 번째 수의 인덱스
                    for (int l = k + 1; l < 6; l++) { // 네 번째 수의 인덱스
                        for (int m = l + 1; m < 7; m++) { // 다섯 번째 수의 인덱스
                            for (int n = m + 1; n < 8; n++) { // 여섯 번째 수의 인덱스
                                for (int o = n + 1; o < 9; o++) { // 일곱 번째 수의 인덱스
                                    int sum = nums[i] + nums[j] + nums[k] + nums[l] + nums[m] + nums[n] + nums[o];
                                    if (sum == 100) { // 합이 100이면
                                        int[] result = { nums[i], nums[j], nums[k], nums[l], nums[m], nums[n],
                                                nums[o] }; // 조합 배열 생성
                                        sortArray(result); // 정렬
                                        printArray(result); // 배열 출력
                                        break outer; // 바깥쪽 반복문도 종료
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
	
	// counting 정렬
	// 매개변수로 받은 arr 배열을 오름차순으로 정렬
	public static void sortArray(int[] arr) {
	    int max = arr[0]; // 배열의 첫 번째 요소를 최대값으로 초기화
	    for (int num : arr) {
	        if (num > max) {
	            max = num; 
	        }
	    }

	    int[] count = new int[max + 1]; // 최대값을 기준으로 count 배열을 생성
	    for (int num : arr) {
	        count[num]++; // 배열 내 각 요소의 빈도를 count 배열에 저장
	    }

	    int index = 0; // 정렬된 값을 저장하기 위한 인덱스 변수
	    for (int i = 0; i < count.length; i++) {
	        while (count[i] > 0) {
	            arr[index++] = i; // count 배열에 따라 값을 배열에 정렬
	            count[i]--; // 해당 값의 빈도 -
	        }
	    }
	}

	// 배열 출력
	public static void printArray(int[] arr) {
		for (int num : arr) {
			System.out.println(num + " ");
		}
	}
}
