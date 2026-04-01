public class HistoryManagerApp {
    public static void main(String[] args) {
        DoublyLinkedList<String> history = new DoublyLinkedList<>();

        System.out.println("--- Simulating User Actions ---");
        history.addAfterCurrent("Open File");
        history.addAfterCurrent("Type 'Hello'");
        history.addAfterCurrent("Type 'World'");
        history.printHistory(); // Open File -> Type 'Hello' -> [Type 'World'*]

        System.out.println("\n--- Testing Undo ---");
        history.undo();
        System.out.println("After Undo, current is: " + history.getCurrentData());
        history.printHistory();

        System.out.println("\n--- Testing Redo ---");
        history.redo();
        System.out.println("After Redo, current is: " + history.getCurrentData());
        history.printHistory();

        System.out.println("\n--- Testing MoveToStart and Remove ---");
        history.moveToStart();
        System.out.println("Moved to start. Current: " + history.getCurrentData());
        history.removeCurrent();
        history.printHistory();
    }
}