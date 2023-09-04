package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class practice {

	public static void main(String[] args) {
		// System.setIn(new FileInputStream("src/Day0820_11315/input_11315.txt"));
		Scanner sc = new Scanner(System.in);

		int[] xc = new int[3];
		int[] yc = new int[3];
		for (int tc = 0; tc < 3; tc++) {
			int x = sc.nextInt();
			xc[tc] = x;
			int y = sc.nextInt();
			yc[tc] = y;
		}
		int x1 = xc[0];
		int y1 = yc[0];
		int xans = 0;
		int yans = 0;
		if(xc[0] != xc[1] && xc[0] !=xc[2]) {
			xans = xc[0]; 
		}else if(xc[1] != xc[0] && xc[1] != xc[2]) {
			xans = xc[1];
		}else {
			xans = xc[2];
		}

		if(yc[0] != yc[1] && yc[0] !=yc[2]) {
			yans = yc[0]; 
		}else if(yc[1] != yc[0] && yc[1] != yc[2]) {
			yans = yc[1];
		}else {
			yans = yc[2];
		}
		
		
		System.out.printf("%d %d", xans, yans);

	}

}
