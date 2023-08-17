import java.util.Arrays;

public class practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {7, 2, 3, 5, 7, 1, 4, 6, 7, 5, 0, 1 };
		
		int counts [] = new int[8];	//수의 범위 0~7
		int result [] = new int[array.length];
		
		//과정1
		//array의 value값을 index로 하는 counts 배열 값 1 증가
		for(int i = 0; i<array.length; i++) {
			counts[array[i]] += 1;
		}
		
		//과정2
		//counts 배열의 각 값을 누적합으로 변환
		for (int i = 1; i<counts.length; i++) {
			counts[i] += counts[i-1];
		}
		
		//과정3
		//i번째 원소를 인덱스로 하는 counts배열의 값을 1 감소시킨 뒤
		//counts 배열의 값을 인덱스로 하여 result에  array의 value값을 저장한다.
		//array의 마지막 index부터 순회한다.
		for (int i = array.length-1; i>=0; i--) {
			int value = array[i];
			counts[value] -= 1;
			result[counts[value]]= value;
		}
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(counts));
		System.out.println(Arrays.toString(result));
		
		
		
		
	}

}
