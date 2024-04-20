package dataStructures.linkedList;

import java.util.Arrays;

public class LinkedList implements ILinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList() {
        this.length = 0;
    }

    public void append(int value) {
        if (length == 0) {
            head = new Node(null, value, null);
            tail = head;
        } else {
            Node newNode = new Node(tail, value, null);
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void prepend(int value) {
        if (length == 0) {
            append(value);
        } else {
            Node newNode = new Node(null, value, head);
            head.prev = newNode;
            head = newNode;
            length++;
        }
    }

    public void insert(int value, int index) {

    }

    public void printList() {
        Node currNode = head;
        int[] ans = new int[length];
        for (int x = 0; x < length; x++) {
            ans[x] = currNode.value;
            currNode = currNode.next;
        }
        System.out.println(Arrays.toString(ans));
    }
}