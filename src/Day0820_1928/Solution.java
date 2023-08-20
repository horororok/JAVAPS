package Day0820_1928;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Base64;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/Day0820_1928/input_1928.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		for(int tc = 1; tc<=T; tc++) {
			String encodedData = sc.nextLine();
			
			// Base64 디코딩
	        byte[] decodedBytes = Base64.getDecoder().decode(encodedData);
	        
	        // 디코딩된 바이트 배열을 문자열로 변환
	        String decodedString = new String(decodedBytes);
	        
	        System.out.println("#" + tc+ " " + decodedString);
			
		}
		
		
	}

}
