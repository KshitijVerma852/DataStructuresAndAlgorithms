package dataStructures.tests;

import dataStructures.linkedList.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLinkedList {
    LinkedList list;

    @BeforeEach
    public void setup() {
        list = new LinkedList();
    }

    @Test
    void testAppendToEmptyList() {
        list.append(10);

        assertNotNull(list.getHead(), "Head should not be null after appending to empty list");
        assertNotNull(list.getTail(), "Tail should not be null after appending to empty list");
        assertEquals(list.getHead(), list.getTail(), "Head should be the same as tail for a one-element list");
        assertEquals(10, list.getHead().value, "Value of head should be the value appended");
        assertNull(list.getHead().next, "Next of head should be null in a one-element list");
        assertNull(list.getHead().prev, "Previous of head should be null in a one-element list");
        assertEquals(1, list.getLength(), "Length should be 1 after appending to empty list");
    }

    @Test
    void testAppendToOneElementList() {
        list.append(10);
        list.append(20);

        assertNotNull(list.getTail(), "Tail should not be null after appending to one-element list");
        assertEquals(20, list.getTail().value, "Value of tail should be the last appended value");
        assertEquals(list.getHead().next, list.getTail(), "Next of head should point to tail after appending second element");
        assertEquals(list.getTail().prev, list.getHead(), "Previous of tail should point back to head after appending second element");
        assertEquals(2, list.getLength(), "Length should be 2 after appending to one-element list");
    }

    @Test
    void testAppendMultipleElements() {
        list.append(10);
        list.append(20);
        list.append(30);

        assertEquals(3, list.getLength(), "Length should be 3 after appending three elements");
        assertEquals(30, list.getTail().value, "Tail should have the last appended value");
        assertNotNull(list.getHead().next.next, "Third element should exist in the list");
        assertEquals(30, list.getTail().value, "Value of the last node should be the last value appended");
        assertEquals(list.getHead().next.next, list.getTail(), "Third node should be the tail");
        assertEquals(list.getTail().prev.value, 20, "Previous of tail should be second appended value");
    }

    @Test
    void testPrependToEmptyList() {
        list.prepend(10);

        assertNotNull(list.getHead(), "Head should not be null after prepending to empty list");
        assertNotNull(list.getTail(), "Tail should not be null after prepending to empty list");
        assertEquals(list.getHead(), list.getTail(), "Head should be the same as tail when only one element is in the list");
        assertEquals(10, list.getHead().value, "Value of head should be the value prepended");
        assertNull(list.getHead().next, "Next of head should be null in a one-element list");
        assertNull(list.getHead().prev, "Previous of head should be null in a one-element list");
        assertEquals(1, list.getLength(), "Length should be 1 after prepending to empty list");
    }

    @Test
    void testPrependToOneElementList() {
        list.append(20);
        list.prepend(10);

        assertNotNull(list.getHead(), "Head should not be null after prepending to one-element list");
        assertEquals(10, list.getHead().value, "Value of head should be the value prepended");
        assertNotNull(list.getHead().next, "Next of head should not be null when the list has more than one element");
        assertEquals(20, list.getHead().next.value, "Next of head should have the value of the previously only node in the list");
        assertNull(list.getHead().prev, "Previous of head should still be null after prepending");
        assertEquals(list.getHead().next, list.getTail(), "Next of new head should be the old head, now tail");
        assertEquals(2, list.getLength(), "Length should be 2 after prepending to one-element list");
    }

    @Test
    void testPrependMultipleElements() {
        list.prepend(30);
        list.prepend(20);
        list.prepend(10);

        assertEquals(3, list.getLength(), "Length should be 3 after prepending three elements");
        assertEquals(10, list.getHead().value, "Head should have the last prepended value (10)");
        assertEquals(20, list.getHead().next.value, "Second element should be 20, the second last prepended");
        assertEquals(30, list.getTail().value, "Tail should have the first prepended value (30)");
        assertNotNull(list.getHead().next.next, "Third element should exist in the list");
        assertEquals(list.getHead().next.next, list.getTail(), "Last element should be the tail");
        assertEquals(list.getTail().prev.value, 20, "Previous of tail should be the second element prepended");
    }

    @Test
    void testInsertIntoEmptyList() {
        list.insert(10, 0);
        // Expect no change as inserting into an empty list at non-zero index is undefined or should do nothing
        assertEquals(0, list.getLength(), "Length should remain 0 when inserting into an empty list at non-start index");
    }

    @Test
    void testInsertAtStartOfList() {
        list.append(10);
        list.insert(20, 0);

        assertEquals(2, list.getLength(), "Length should be 2 after inserting at the start");
        assertEquals(20, list.getHead().value, "New head value should be the newly inserted value");
        assertEquals(10, list.getHead().next.value, "Old head value should now be second node");
    }

    @Test
    void testInsertAtEndOfList() {
        list.append(10);
        list.append(20);
        list.insert(30, 2); // Insert at the end, equivalent to append

        assertEquals(3, list.getLength(), "Length should be 3 after inserting at the end");
        assertEquals(30, list.getTail().value, "New tail value should be the newly inserted value");
    }

    @Test
    void testInsertInTheMiddleOfList() {
        list.append(10);
        list.append(30);
        list.insert(20, 1); // Insert between 10 and 30

        assertEquals(3, list.getLength(), "Length should be 3 after inserting in the middle");
        assertNotNull(list.getHead().next.next, "Third node should exist");
        assertEquals(20, list.getHead().next.value, "Middle node value should be the newly inserted value");
        assertEquals(10, list.getHead().value, "First node value should remain unchanged");
        assertEquals(30, list.getHead().next.next.value, "Last node value should remain unchanged");
    }

    @Test
    void testInsertOutOfBounds() {
        list.append(10);
        list.append(20);
        list.insert(30, 3); // Out of bounds

        assertEquals(2, list.getLength(), "Length should remain unchanged when inserting out of bounds");
        assertNull(list.getHead().next.next, "No third node should exist");
    }
}