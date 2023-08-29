package BOJ.Day0829_10158;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int W = sc.nextInt();
        int H = sc.nextInt();
        int P = sc.nextInt();//행
        int Q = sc.nextInt();//열
        int T = sc.nextInt();

        int x = W - Math.abs(W - (P + T) % (W * 2));
        int y = H - Math.abs(H - (Q + T) % (H * 2));

        System.out.println(x + " " + y);

        sc.close();
    }
}
