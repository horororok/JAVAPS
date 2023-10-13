package practice;

import java.util.Arrays;
import java.util.Scanner;

public class practice3 {

	static int N, R;
	static int[] data;
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		data = new int[N];
		result = new int[R];
		
		for(int i = 0; i<N; i++) {
			data[i] = sc.nextInt();
		}
		
		comb(0, 0);
		
	}

	public static void comb(int idx, int sidx) {
		if (sidx == R) {
			System.out.println(Arrays.toString(result));
			return;
		}

		else if (idx == N) {
			return;
		}
		else {
			result[sidx] = data[idx];
			comb(idx+1, sidx+1);
			comb(idx+1, sidx);
		}
	}

}