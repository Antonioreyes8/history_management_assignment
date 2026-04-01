import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {

    @Test
    public void testAddAfterCurrentOnEmptyList() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAfterCurrent("First");
        assertEquals(1, list.size());
        assertEquals("First", list.getCurrentData());
    }

    @Test
    public void testAddAfterCurrent() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAfterCurrent("A");
        list.addAfterCurrent("B");
        list.addAfterCurrent("C");
        assertEquals(3, list.size());
        assertEquals("C", list.getCurrentData());
    }

    @Test
    public void testUndo() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAfterCurrent("A");
        list.addAfterCurrent("B");
        list.addAfterCurrent("C");
        assertTrue(list.undo());
        assertEquals("B", list.getCurrentData());
        assertTrue(list.undo());
        assertEquals("A", list.getCurrentData());
        assertFalse(list.undo()); // No more to undo
    }

    @Test
    public void testRedo() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAfterCurrent("A");
        list.addAfterCurrent("B");
        list.addAfterCurrent("C");
        list.undo();
        list.undo();
        assertTrue(list.redo());
        assertEquals("B", list.getCurrentData());
        assertTrue(list.redo());
        assertEquals("C", list.getCurrentData());
        assertFalse(list.redo()); // No more to redo
    }

    @Test
    public void testRemoveCurrent() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAfterCurrent("A");
        list.addAfterCurrent("B");
        list.addAfterCurrent("C");
        list.removeCurrent();
        assertEquals(2, list.size());
        assertEquals("B", list.getCurrentData()); // After removing C, current should be B
    }

    @Test
    public void testRemoveCurrentAtStart() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAfterCurrent("A");
        list.addAfterCurrent("B");
        list.moveToStart();
        list.removeCurrent();
        assertEquals(1, list.size());
        assertEquals("B", list.getCurrentData());
    }

    @Test
    public void testMoveToStart() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAfterCurrent("A");
        list.addAfterCurrent("B");
        list.addAfterCurrent("C");
        list.moveToStart();
        assertEquals("A", list.getCurrentData());
    }

    @Test
    public void testMoveToEnd() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addAfterCurrent("A");
        list.addAfterCurrent("B");
        list.addAfterCurrent("C");
        list.moveToStart();
        list.moveToEnd();
        assertEquals("C", list.getCurrentData());
    }

    @Test
    public void testSizeAndIsEmpty() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        list.addAfterCurrent("A");
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }

    @Test
    public void testGetCurrentDataOnEmpty() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        assertNull(list.getCurrentData());
    }
}