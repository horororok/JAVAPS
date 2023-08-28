package BOJ.Day0826_2839;

import java.util.Scanner;

public class Main {
//����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// N�� 5���� ������ 3���� ������
		// 3���� ���� �������� 0���� ũ�� -1 0�̸� �� ���
		// N�� 5�� ���� ��� �������� ���Ѵ�.
		// �������� 3���� ������ �������� 0�̸� �״�� ����� ���
		// 3���� ���� �������� 0���� ũ��
		// 5�� ���� ���� �ϳ��� ���̰� 3���� ����
		// �߰��� 3���� ���� �������� 0�� ��� ���

		int N = sc.nextInt();

		int fiveq = 0;
		int fiver = 0;
		int thrq = 0;
		int thrr = 0;

		if (N == 3) {
			System.out.println(1);
		} else if (N == 4) {
			System.out.println(-1);
		} else if (N == 5) {
			System.out.println(1);
		} else {
			fiveq = N / 5;
			fiver = N % 5;
			if (fiver == 0) {
				System.out.println(fiveq);
			} else {
				thrq = fiver / 3;
				thrr = fiver % 3;
				if (thrr == 0) {
					System.out.println(fiveq + thrq);
				} else {

					while (fiveq > 1) {
						fiver += 5;
						fiveq--;
						thrq = fiver / 3;
						thrr = fiver % 3;
						if (thrr == 0) {
							System.out.println(fiveq + thrq);
							break;
						} else {
							System.out.println(-1);
						}
					}
				}
			}
		}
	}
}
