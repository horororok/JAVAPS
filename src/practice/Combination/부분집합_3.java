package practice.Combination;

public class 부분집합_3 {
//재귀 호출
	public static String[] 재료 = { "오이", "우엉", "햄", "참치" };
	public static int N = 4;
	public static boolean[] sel = new boolean[N];

	public static void main(String[] args) {
		powerSet(0);
	}
	//4개 중 고를 수 있는 부분집합
	
	//idx : 해당 위치 판단
	public static void powerSet(int idx) {
		if(idx == N) {
			//모든 재료의 넣을지 말지 판단 끝
			for(int i = 0; i<N; i++) {
				if(sel[i]) {
					System.out.print(재료[i]);
				}
			}
			System.out.println();
			return;
		}
		//재귀
		
		
		sel[idx] = false;
		powerSet(idx+1);
		
		sel[idx] = true;
		powerSet(idx +1);
		
		
	}
	
}
