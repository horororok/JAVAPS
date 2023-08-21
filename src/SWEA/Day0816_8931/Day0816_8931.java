package SWEA.Day0816_8931;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Day0816_8931 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/Day0816_8931/input_8931.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스 개수
		int T = sc.nextInt();
		//각 테스트 케이스에 대한 반복문
		for(int tc = 1; tc<=T; tc++) {
			
			//스택 크기
			int k = sc.nextInt();
			
			//정수를 저장할 스택 생성
			Stack<Integer> stack = new Stack<>();
			
			//스택에 데이터 추가 또는 삭제하면서 반복문 실행
			for(int i=0; i<k; i++) {
				int st = sc.nextInt();
				
				//0이 아닌 경우 스택에 추가
				if(st != 0) {
					stack.push(st);
					//0인 경우 스택에서 요소를 삭제
				}else {
					stack.pop();
				}
			}
			
			int sum = 0;
			//스택의 요소를 순회하며 합 계산
			while(!stack.isEmpty()) {
				sum += stack.pop();
			}
			System.out.printf("#%d %d%n", tc, sum);
			
			
			
			
			
		}
		
	}

}
