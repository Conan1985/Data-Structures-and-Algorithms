/**
 *
 * @author Youwei Lu
 * Assignment 2
 * CISC 610-90- O-2018/Late Fall - Data Structures & Algorithms
 *
 * Implement raw array Queue ADT
 * Methods: isEmpty, isFull, enQueue, deQueue, size
 *
 **/

package assignment2;

public class QueueADT {
    private int end; // keep track of number of items and next slot
    private int[] items; // array to store items
    private int capacity;

    QueueADT(int max) { // constructor to initialize queue to max capacity
        items = new int[max];
        end = 0;
        capacity = max;
    }

    boolean isEmpty() {
        return end == 0; // no elements in queue
    }

    boolean isFull() {
        return end == capacity; // max items in array/queue
    }

    void enQueue(int item) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        items[end] = item; // end/rear of items/queue
        end++;
    }

    int deQueue() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int x = items[0];  //first item in queue
        for (int i = 0; i < items.length - 1; i++) {
            items[i] = items[i+1];
        }
        end--;
        return x;
    }

    int size() {
        return end; // number of items in array
    }

}
