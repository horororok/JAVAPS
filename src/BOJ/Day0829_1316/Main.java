package BOJ.Day0829_1316;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// n개의 단어 입력
		// 단어를 배열로 변환해준다
		// 인덱스하나를 확인했을 때 다음 인덱스의 원소와 다를 때
		// 그 후에 똑같은 원소가 나오면 break

		int N = sc.nextInt();
		int cnt = 0;
		for (int tc = 0; tc < N; tc++) {
			String input = sc.next();

			char[] arr = input.toCharArray();
//			System.out.println(Arrays.toString(arr));
			int len = input.toCharArray().length;
			boolean isGroup = true;
			for (int i = 1; i < len; i++) {
				for (int j = i + 1; j < len; j++) {
					if (arr[i - 1] != arr[i] && arr[i - 1] == arr[j]) {
						isGroup = false;
						break;
					}
				}

			}
			if (isGroup) {
				cnt++;
			}

		}
		System.out.println(cnt);

	}

}
