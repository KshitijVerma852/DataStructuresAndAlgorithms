package dataStructures.linkedList;

public interface ILinkedList {
    void append(int value);

    void prepend(int value);

    void insert(int value, int index);

    void delete(int index);

    void printList();
}
