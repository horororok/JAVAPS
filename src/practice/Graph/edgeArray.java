package practice.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class edgeArray {

	static class Edge{
		int st, ed;
		
		public Edge(int st, int ed) {
			this.st = st;
			this.ed = ed;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();	//정점의 개수
		int E = sc.nextInt();	//간선의 개수
		
		
		//이차원 배열을 이용해서 저장
		int[][] edges1 = new int[E][3];	//[i][0] : 시작정점, [i][1] : 끝 정점, [i][2] : 가중치
		
		//배열로 간선 정보 저장
		Edge[] edges2 = new Edge[E];

		//리스트로 간선정보 저장
		List<Edge> edges3 = new ArrayList<>();
		
		for(int i = 0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int w = sc.nextInt();
			
			//간선 정보 자체를 배열로 저장, 유향/무향 따질 필요 없다
			edges2[i] = new Edge(A, B);
			
			//리스트를 이용했을 때 이런식으로 저장 가능
			edges3.add(new Edge(A,B));
		}
	}

}
