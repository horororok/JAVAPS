package BOJ.Day0901_11653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // N이 1일 경우는 제외
        if (N == 1) {
            System.out.println();
        } else {
            // 소수 구해주기
            int X = (int) Math.sqrt(N);
            int[] arr = new int[X + 1];
            int r = 0;
            for (int i = 2; i <= X; i++) {
                if (arr[i] == 0) {
                    arr[r] = i;
                    r++;
                    for (int j = i * i; j <= X; j += i) {
                        arr[j] = 1;
                    }
                }
            }

            int c = 0;
            while (N > 1 && c < r) {
                if (N % arr[c] == 0) {
                    System.out.println(arr[c]);
                    N /= arr[c];
                } else {
                    c++;
                }
            }

            if (N > 1) {
                System.out.println(N);
            }
        }
    }
}
