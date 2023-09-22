package practice.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class adjList {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();	//정점의 개수
		int E = sc.nextInt();	//간선의 개수
		
		//인접 리스트
		//각 정점들을 인덱스로 하는 배열 안에 해당 정점과 인접한 정점들을 리스트 형태로 넣는다
		List<Integer>[] adjList = new ArrayList[V+1];	
		
		//인접리스트 초기화
		for(int i = 0; i<V+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		//간선 정보 입력
		for(int i = 0; i<E; i++) {
			int A = sc.nextInt();	//시작 정점
			int B = sc.nextInt();	//끝 정점
			int w = sc.nextInt();	//가중치 그래프인 경우 가중치
			
			adjList[A].add(B);	
			adjList[B].add(A);	//무향 그래프라면 필수
			
		}
		
		
	}

}
