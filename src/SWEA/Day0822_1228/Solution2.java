package SWEA.Day0822_1228;

import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            LinkedList list = new LinkedList();

            // 원본 데이터의 길이를 입력받아 리스트에 추가
            int L = Integer.parseInt(sc.next());
            for (int i = 0; i < L; i++) {
                list.addLast(Integer.parseInt(sc.next()));
            }

            // 삽입 연산 횟수를 입력받아 수행
            int N = Integer.parseInt(sc.next());
            for (int i = 0; i < N; i++) {
                // 삽입 연산의 시작 위치 (x)와 삽입할 원소의 개수 (y)를 입력받음
                sc.next(); // 삽입 연산 표시 'I'는 무시
                int x = Integer.parseInt(sc.next());
                int y = Integer.parseInt(sc.next());

                // 삽입 위치에 원소들을 추가
                for (int j = 0; j < y; j++) {
                    list.addMid(x + j, Integer.parseInt(sc.next()));
                }
            }

            // 결과 출력
            System.out.print("#" + tc + " ");
            for (int i = 0; i < 10; i++) {
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

    // 노드 생성자, 데이터를 인자로 받아 초기화
    public Node(int data) {
        this.data = data;
    }
}

class LinkedList {
    private Node head;
    private int size;

    // 리스트에 데이터 추가
    public void add(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // 리스트의 마지막에 데이터 추가
    public void addLast(int data) {
        if (head == null) {
            add(data);
            return;
        }

        Node newNode = new Node(data);
        Node lastNode = head;

        while (lastNode.next != null)
            lastNode = lastNode.next;

        lastNode.next = newNode;
        size++;
    }

    // 인덱스에 해당하는 노드 반환
    public Node get(int idx) {
        if (idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException();

        Node curr = head;

        for (int i = 0; i < idx; i++) {
            curr = curr.next;
        }
        return curr;
    }

    // 인덱스에 해당하는 위치에 데이터 추가
    public void addMid(int idx, int data) {
        if (idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException();

        if (idx == 0) {
            add(data);
            return;
        }

        if (idx == size) {
            addLast(data);
            return;
        }

        Node newNode = new Node(data);
        Node preNode = get(idx - 1);

        newNode.next = preNode.next;
        preNode.next = newNode;
        size++;
    }
}