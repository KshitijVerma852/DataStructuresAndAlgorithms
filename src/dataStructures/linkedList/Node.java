package dataStructures.linkedList;

public class Node {
    public Node prev;
    public int value;
    public Node next;

    public Node(Node prev, int value, Node next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }
}
