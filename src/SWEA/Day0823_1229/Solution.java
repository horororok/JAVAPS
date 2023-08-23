package SWEA.Day0823_1229;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int testCase = 1; testCase <= 10; testCase++) {
            int N = Integer.parseInt(scanner.nextLine());
            String originalPassword = scanner.nextLine();
            int commandCount = Integer.parseInt(scanner.nextLine());

            LinkedList linkedList = new LinkedList();

            for (int i = 0; i < N; i++) {
                linkedList.addLast(originalPassword.charAt(i) - '0');
            }

            for (int i = 0; i < commandCount; i++) {
                String command = scanner.nextLine();
                String[] parts = command.split(" ");
                char operation = parts[0].charAt(0);
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);

                if (operation == 'I') {
                    String s = parts[3];
                    for (int j = 0; j < y; j++) {
                        linkedList.addMid(x + j, s.charAt(j) - '0');
                    }
                } else if (operation == 'D') {
                    for (int j = 0; j < y; j++) {
                        linkedList.remove(x);
                    }
                }
            }

            System.out.print("#" + testCase + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(linkedList.get(i).data + " ");
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
    private Node head;
    private int size;
 
    public void add(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
 
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
 
    public Node get(int idx) {
        if (idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException();
 
        Node curr = head;
 
        for (int i = 0; i < idx; i++) {
            curr = curr.next;
        }
        return curr;
    }
 
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
 
    public void remove(int data) {
        if (head == null)
            return;
 
        if (head.data == data) {
            head = head.next;
            size--;
            return;
        }
 
        Node prev = head;
        Node curr = head.next;
 
        while (curr != null) {
            if (curr.data == data) {
                prev.next = curr.next;
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
     public String getModifiedPassword() {
        StringBuilder password = new StringBuilder();
        Node curr = head;
        for (int i = 0; i < 10; i++) {
            if (curr != null) {
                password.append(curr.data);
                curr = curr.next;
            } else {
                break;
            }
        }
        return password.toString();
    }
}