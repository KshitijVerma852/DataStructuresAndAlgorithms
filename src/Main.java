import dataStructures.linkedList.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(5);
        linkedList.append(8);
        linkedList.append(2);
        linkedList.prepend(10);
        linkedList.insert(35, 2);
        linkedList.printList();
    }
}
