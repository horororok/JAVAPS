package practice.Graph;

import java.util.Scanner;

public class AdjArr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt(); // 정점의 개수
		int E = sc.nextInt(); // 간선의 수

		int[][] adjArr = new int[V + 1][V + 1]; // 1~V까지의 정점번호를 이용하는 인접행렬

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt(); // 시작 정점
			int B = sc.nextInt(); // 끝 정점
			int w = sc.nextInt(); // 가중치 값(가중치 그래프인 경우)
			
			adjArr[A][B] = 1; 	//가중치가 있다면 1대신 w 저장
			adjArr[A][B] = 1; 	//무향이라면 필수, 유향이라면 생략
			
//			adjArr[A][B] = adjArr[B][A] = 1; 	//이런식도 가능
			
		}
	}

}
