# History Manager - Doubly Linked List

## Overview
Custom Java implementation of a Doubly Linked List designed for undo/redo functionality. It avoids Java's built-in collections and implements a manual "current" pointer for state tracking.

## Compilation
Navigate to the `src` folder and run:
`javac DoublyLinkedList.java HistoryManagerApp.java`

## Execution
`java HistoryManagerApp`

## Key Implementation Details
- `addAfterCurrent`: Inserts new nodes and updates the tail if necessary.
- `undo/redo`: $O(1)$ operations moving the `current` reference.
- `Node<T>`: Private static inner class containing `prev` and `next` pointers.