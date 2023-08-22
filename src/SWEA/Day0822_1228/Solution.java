package SWEA.Day0822_1228;







public class Solution {
	static class Node{
		public String data;
		public Node link;
		
		public Node() {
		}
		public Node(String Data) {
			this.data = data;
			this.link = null;
		}
	}
	
	static Node head;
	static int size;
	
	static Node get(int idx) {
		if(idx < 0 || idx >= size) {
			return null;
		}
		Node curr = head;
		for(int i = 0; i<idx; i++) {
			curr = curr.link;
		}
		return curr;
	}
	//첫번째 위치에 원소 삽입
	static void addFirst(String data) {
		Node node = new Node(data);
		node.link = head;
		head = node;
		size++;
	}
	//마지막 위치에 원소 삽입
	static void addLast(String data) {
		if(head == null) {
			addFirst(data);
			return;
		}
		Node node = new Node(data);
		Node curr = head;
		while (curr.link != null) {
			curr = curr.link;
		}
		curr.link = node;
		size++;
	}
	//중간에 원소 삽입
	static void add(int idx, String data) {
		if(idx < 0 || idx >size) {
			//유효하지 않은 인덱스
			return;		
		}
		if (idx ==0) {
			addFirst(data);
			return;
		}
		if(idx ==size) {
			addLast(data);
			return;
		}
		//이전 노드 찾기
		Node pre = get(idx -1);
		
		Node node = new Node(data);
		node.link = pre.link;
		pre.link = node;
		size++;
	}

	public static void main(String[] args) {
		
	}
}
