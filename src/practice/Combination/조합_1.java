package practice.Combination;

import java.util.Arrays;

public class 조합_1 {
//재귀
	public static String[] 토핑 = { "상추", "패티", "토마토", "치즈", "새우" };
	public static int N = 5;
	public static int R = 2; // 문제에서 판단 할 수 있는 부분들
	public static String[] sel = new String[R]; // 내가 선택한 토핑
	
	//5개 중에 2개 선택
	public static void main(String[] args) {
		comb(0,0);
	}
	
	//idx : 토핑의 index
	//sidx : sel의 index
	public static void comb(int idx, int sidx) {
		//sel index가 넘어가면 끝
		if(sidx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(idx == N) {
			return;
		}
		
		//재귀
		//해당재료 삽입
		sel[sidx] = 토핑[idx];
		//idx번째 재료 뽑기
		comb(idx+1, sidx +1);
		//idx번째 재료 안뽑은거
		comb(idx+1, sidx);
	}
}
