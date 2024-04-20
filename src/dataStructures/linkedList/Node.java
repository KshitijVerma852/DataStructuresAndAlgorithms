package dataStructures.linkedList;

public class Node {
    protected Node prev;
    protected int value;
    protected Node next;

    public Node(Node prev, int value, Node next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }
}
