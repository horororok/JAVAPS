package BOJ.Day0831_11005;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// 십진법 수를 받아서 B진법으로 바꾸기

		long N = sc.nextLong();
		int B = sc.nextInt();

		int cnt = 0;
		long X = N;
		while (X > 0) {
			X /= B;
			cnt++;
		}
		
		char[] arr = new char[cnt];
		long X1 = N;
		for (int i = cnt - 1; i >= 0; i--) {
			long rem = X1 % B;
			if (rem < 10) {
				arr[i] = (char) (rem + '0'); // 0부터 9까지 숫자는 '0'부터 '9'로 저장
			} else {
				arr[i] = (char) (rem - 10 + 'A'); // 10부터는 'A'부터 저장
			}
			X1 /= B;
		}
		
		for (int i = 0; i < cnt; i++) {
			System.out.print(arr[i]);
		}
	}
}
