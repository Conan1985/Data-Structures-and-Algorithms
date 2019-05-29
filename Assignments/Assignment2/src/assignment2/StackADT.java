/**
 *
 * Assignment 2
 * CISC 610-90- O-2018/Late Fall - Data Structures & Algorithms
 *
 * Implement StackADT using the DLinkedListADT
 * Methods: isEmpty, isFull, push, pop, size
 *
 **/

package assignment2;

public class StackADT {
    DLinkedListADT items; // class attribute/member to store tack items in linked list
    int capacity; // limit on how many elements there can be

    StackADT(int max) { // constructor to initialize list and capacity
        if (max <= 0) {
            throw new NumberFormatException();
        }
        items = new DLinkedListADT();
        capacity = max;
    }

    boolean isEmpty() { // return true if empty and otherwise false
        return items.count() == 0;
    }

    boolean isFull() { // return true if full and otherwise false
        return items.count() == capacity;
    }

    void push(int item) { // add item to stack
        if (items.count() == capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }
        items.addFirst(item);
    }

    int pop() { // remove item from stack
        if (items.count() == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return items.deleteFirst();
    }

    int size() {
        return items.count();
    }

}
