package practice.bufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class practice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

//		int arr[] = new int[N];
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		int arr2[] = new int[N];
//		StringTokenizer st2 = new StringTokenizer(br.readLine());
//		for (int i = 0; i < N; i++) {
//			arr2[i] = Integer.parseInt(st2.nextToken());
//		}
		String[] input = br.readLine().split(" ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(arr2));

	}

}
