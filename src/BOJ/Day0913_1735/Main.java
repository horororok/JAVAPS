package BOJ.Day0913_1735;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A1 = sc.nextInt();
        int A2 = sc.nextInt();
        int B1 = sc.nextInt();
        int B2 = sc.nextInt();

        int numerator = A1 * B2 + B1 * A2;
        int denominator = A2 * B2;

        int gcd = GCD(numerator, denominator);

        int ans1 = numerator / gcd;
        int ans2 = denominator / gcd;

        System.out.println(ans1 + " " + ans2);
    }

    // 최대공약수
    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }
}
