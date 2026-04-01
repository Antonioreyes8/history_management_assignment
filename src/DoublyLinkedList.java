public class DoublyLinkedList<T> {

    // Part 1: Node structure with prev and next
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private Node<T> current; // The "pointer" for undo/redo
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        current = null;
        size = 0;
    }

    // Required: addAfterCurrent(T item)
    public void addAfterCurrent(T item) {
        if (isEmpty()) {
            Node<T> newNode = new Node<>(item, null, null);
            head = tail = current = newNode;
        } else {
            // Create node linking back to current and forward to current's next
            Node<T> newNode = new Node<>(item, current, current.next);
            
            if (current.next != null) {
                current.next.prev = newNode;
            } else {
                tail = newNode; // We were at the end
            }
            
            current.next = newNode;
            current = newNode; // Move current to the new action
        }
        size++;
    }

    // Required: undo() -> move backward
    public boolean undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            return true;
        }
        return false; // Nowhere to undo to
    }

    // Required: redo() -> move forward
    public boolean redo() {
        if (current != null && current.next != null) {
            current = current.next;
            return true;
        }
        return false; // Nowhere to redo to
    }

    // Required: removeCurrent()
    public void removeCurrent() {
        if (current == null) return;

        if (current.prev != null) current.prev.next = current.next;
        else head = current.next;

        if (current.next != null) current.next.prev = current.prev;
        else tail = current.prev;

        // After removal, move current to a neighbor
        if (current.next != null) current = current.next;
        else current = current.prev;

        size--;
    }

    // Required: moveToStart()
    public void moveToStart() {
        current = head;
    }

    // Required: moveToEnd()
    public void moveToEnd() {
        current = tail;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Helper to see what is currently "active"
    public T getCurrentData() {
        return (current != null) ? current.data : null;
    }

    public void printHistory() {
        Node<T> temp = head;
        System.out.print("History: ");
        while (temp != null) {
            if (temp == current) System.out.print("[" + temp.data + "*] ");
            else System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}