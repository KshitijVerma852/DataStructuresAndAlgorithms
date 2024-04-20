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

    private Node traverseToIndex(int index) {
        Node currNode = head;
        for (int x = 0; x < index; x++) {
            currNode = currNode.next;
        }
        return currNode;
    }

    public void insert(int value, int index) {
        if (length == 0) return;
        if (index == 0) prepend(value);
        else if (index == length - 1) append(value);
        else {
            Node prevNode = traverseToIndex(index - 1);
            Node nextNode = prevNode.next;
            Node newNode = new Node(prevNode, value, nextNode);
            prevNode.next = newNode;
            nextNode.prev = newNode;
            length++;
        }
    }

    public void delete(int index) {
        if (length == 0) return;
        if (index == 0) {
            Node nextNode = head.next;
            nextNode.prev = null;
            head.next = null;
            head = nextNode;
        } else if (index == length - 1) {
            Node prevNode = tail.prev;
            tail.prev = null;
            prevNode.next = null;
            tail = prevNode;
        } else {
            Node delNode = traverseToIndex(index);
            Node prevNode = delNode.prev;
            Node nextNode = delNode.next;
            delNode.prev = null;
            delNode.next = null;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        length--;
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