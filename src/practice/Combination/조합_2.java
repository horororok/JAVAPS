package practice.Combination;

import java.util.Arrays;

public class 조합_2 {
	//재귀 + 반복문
	
	//재료를 준비를 했다.
		public static String[] 토핑 = {"상추", "패티", "토마토", "치즈", "새우"};
		public static int N = 5;
		public static int R = 3; //문제에서 판단 할 수 있는 부분들
		public static String[] sel = new String[R]; //내가 선택한 토핑
		
		public static void main(String[] args) {
			comb(0, 0);
		}
		
		//idx : 토핑의 시작 인덱스
		//sidx : sel의 인덱스
		public static void comb(int idx, int sidx) {
			if(sidx == R) {
				System.out.println(Arrays.toString(sel));
				return;
			}
			
			for(int i = idx; i<=N-R+sidx; i++) {
				sel[sidx] = 토핑[i];
				comb(i+1, sidx+1);
			}
			
		}
}
