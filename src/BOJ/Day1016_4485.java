package BOJ;

import java.io.*;
import java.util.*;

public class Day1016_4485 {

	public static class Node implements Comparable<Node> {
		
		int row, col, cost;
		
		public Node(int row, int col, int cost) {
			this.row = row;
			this.col = col;
			this.cost = cost;
		}
		
		public int compareTo(Node other) {
			return Integer.compare(this.cost, other.cost);
		}
	}
	
	static int N, answer;
	static int INF = 100000000;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] arr, distance;
	static boolean[][] visited;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		int index = 0;
		while(true) {
			index++;
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			answer = 100000000;
			arr = new int[N][N];
			distance = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					distance[i][j] = INF;
				}
			}
			answer = dijkstra(0,0);
			sb.append("Problem ").append(index).append(": ").append(answer).append("\n");
		}//while
		bw.write(sb.toString());
		bw.close();
	}
	
	public static int dijkstra(int row, int col) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(row, col, arr[row][col]));
		visited[row][col] = true;
		distance[row][col] = arr[row][col];
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int r = cur.row;
			int c = cur.col;
			
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr<0 || nc<0 || nr>=N || nc>=N || visited[nr][nc]) continue;
				if(distance[nr][nc] < distance[r][c] + arr[nr][nc]) continue;
				distance[nr][nc] = distance[r][c] + arr[nr][nc];
				visited[nr][nc] = true;
				queue.offer(new Node(nr, nc, distance[nr][nc]));
			}
		}
		return distance[N-1][N-1];
	}
}
