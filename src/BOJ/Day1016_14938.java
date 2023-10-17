package BOJ;

import java.io.*;
import java.util.*;

public class Day1016_14938 {

	static int n, m, r, item, answer;
	static int INF = 100000000;
	static int[] distance, value;
	static List<List<Node>> list;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static class Node implements Comparable<Node> {
		int index, cost;
		
		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
		
		public int compareTo(Node other) {
			return Integer.compare(this.cost, other.cost);
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		distance = new int[n+1];
		value = new int[n+1];
		list = new ArrayList<List<Node>>();
		Arrays.fill(distance, INF);
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b,c));
			list.get(b).add(new Node(a,c));
		}
		
		
		
	}//main
	
	public static void dijkstra(int index, int cost) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(index, cost));
		distance[index] = value[index];
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if(distance[cur.index] < cur.cost) continue;
		}
	}
}
