package SWEA.Day0823_1230;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
    	System.setIn(new FileInputStream("src/SWEA/Day0823_1230/input_1230.txt"));
        Scanner sc = new Scanner(System.in);
 
        for (int tc = 1; tc <= 10; tc++) { // 10개의 테스트 케이스에 대해서 반복
            LinkedList list = new LinkedList(); // LinkedList 인스턴스 생성
 
            int n = sc.nextInt(); // 암호문 길이 입력
            for (int i = 0; i < n; i++) {
                list.addLast(sc.nextInt()); // 암호문을 순차적으로 LinkedList에 추가
            }

            int w = sc.nextInt(); // 명령어 수 입력
            for (int i = 0; i < w; i++) {
                String str = sc.next(); // I, D, A 중 하나의 명령어 입력
                if (str.equals("I")) { // 삽입 명령어
                    int x = sc.nextInt(); // 삽입 위치 번호
                    int y = sc.nextInt(); // 삽입할 숫자 개수
                    for (int j = 0; j < y; j++) {
                        list.addMid(x + j, sc.nextInt()); // x+j 위치에 숫자를 삽입
                    }
                } else if (str.equals("D")) { // 삭제 명령어
                    int dx = sc.nextInt(); // 삭제 위치 번호
                    int dy = sc.nextInt(); // 삭제할 숫자 개수
                    for (int dj = 0; dj < dy; dj++) {
                        list.remove(dx); // dx 위치의 숫자를 삭제
                    }
                } else if (str.equals("A")) { // 추가 명령어
                    int ay = sc.nextInt(); // 맨 뒤에 추가할 숫자 개수
                    for (int aj = 0; aj < ay; aj++) {
                        list.addLast(sc.nextInt()); // 맨 뒤에 숫자를 추가
                    }
                }
            }
 
            System.out.print("#" + tc + " ");
            for (int i = 0; i < 10; i++) { // 처음 10개 항만 출력
                System.out.print(list.get(i).data + " ");
            }
            System.out.println();
        }
    }
}
 
class Node {
    int data;
    Node next;
 
    public Node() {
    }
 
    public Node(int data) {
        this.data = data;
    }
}
 
class LinkedList {
    private Node head; // 연결 리스트의 헤드 노드
    private int size; // 연결 리스트의 크기
 
    public void add(int data) {
        Node newNode = new Node(data); // 새 노드 생성
        newNode.next = head; // 새 노드를 헤드 노드의 다음으로 설정
        head = newNode; // 헤드 노드 업데이트
        size++; // 크기 증가
    }
 
    public void addLast(int data) {
        if (head == null) {
            add(data); // 빈 리스트일 경우 데이터를 추가하고 종료
            return;
        }
 
        Node newNode = new Node(data); // 새 노드 생성
        Node lastNode = head; // 마지막 노드 탐색용 변수
 
        while (lastNode.next != null)
            lastNode = lastNode.next; // 마지막 노드까지 이동
 
        lastNode.next = newNode; // 마지막 노드의 다음을 새 노드로 설정
        size++; // 크기 증가
    }
 
    public Node get(int idx) {
        if (idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException(); // 범위를 벗어나면 예외 발생
 
        Node curr = head;
 
        for (int i = 0; i < idx; i++) {
            curr = curr.next; // idx 위치의 노드까지 이동
        }
        return curr;
    }
 
    public void addMid(int idx, int data) {
        if (idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException(); // 범위를 벗어나면 예외 발생
 
        if (idx == 0) {
            add(data); // 맨 앞에 추가
            return;
        }
 
        if (idx == size) {
            addLast(data); // 맨 뒤에 추가
            return;
        }
 
        Node newNode = new Node(data); // 새 노드 생성
        Node preNode = get(idx - 1); // 이전 노드 찾기
 
        newNode.next = preNode.next; // 새 노드를 이전 노드의 다음으로 설정
        preNode.next = newNode; // 이전 노드의 다음을 새 노드로 설정
        size++; // 크기 증가
    }
 
    public void remove(int data) {
        if (head == null)
            return;
 
        if (head.data == data) {
            head = head.next; // 헤드 노드를 다음 노드로 변경하여 삭제
            size--;
            return;
        }
 
        Node prev = head;
        Node curr = head.next;
 
        while (curr != null) {
            if (curr.data == data) {
                prev.next = curr.next; // 이전 노드의 다음을 현재 노드의 다음으로 설정하여 삭제
                size--;
                return;
            }
            prev = curr; // 이전 노드를 현재 노드로 업데이트
            curr = curr.next; // 현재 노드를 다음 노드로 이동
        }
    }
}