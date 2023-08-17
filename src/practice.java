public class practice{
	
	
	public static void main(String[] args) {
		
		System.out.println(fibo(10));
		
		
		
		
	}
	//피보나치는 n을 구하려면 이전과 이이전을 알고 ㅇㅆ어야 한다
	public static int fibo(int n) {
		//기본 파트 fibo(0) = 0/ fibo(1) = 1
		if(n==0)return 0;
		if(n==1)return 1;
		
		//재귀파트
		return fibo(n-1) + fibo(n-2);
		
		
	}
	
	
	
}