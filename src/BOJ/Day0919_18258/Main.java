package BOJ.Day0919_18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Integer> que = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		int N =Integer.parseInt(br.readLine());
		
		int back = 0;
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			switch(input) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				back = num;
				que.offer(num);
				break;
			case "pop":
				if(que.size()==0) {
					sb.append(-1).append("\n");
				}else {
				sb.append(que.poll()).append("\n");
				}
				break;
			case "size":
				sb.append(que.size()).append("\n");
				break;
			case "empty":
				if(que.isEmpty()) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
				break;
			case "front":
				if(que.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(que.peek()).append("\n");
				}
				break;
			case "back":
				if(que.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
//					int n = 0;
//					for(int num : que) {
//						n = num;
//					}
					sb.append(back).append("\n");
				}
				break;
			}
		}
		System.out.println(sb);
		
	}
}
