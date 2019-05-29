/**
 *
 * @author Youwei Lu
 * CISC 610-90- O-2018/Late Fall - Data Structures & Algorithms
 *
 * Test the correct working of each operation of QueueADT
 *
 **/

package assignment2;

public class TestQueue {

    public static void main(String[] args) {
        QueueADT queue = new QueueADT(10); // Give the queue capacity of 10

        System.out.println("The size of queue is " + queue.size());
        System.out.println("The queue is now empty? " + queue.isEmpty());
        System.out.println("The queue is now full? " + queue.isFull());

        try {
            queue.deQueue();
        } catch (Exception e) {
            System.out.println("Empty queue could not deQueue.");
        }

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);
        queue.enQueue(7);
        queue.enQueue(8);
        queue.enQueue(9);
        queue.enQueue(10);

        System.out.println("The size of queue is " + queue.size());
        System.out.println("The queue is now empty? " + queue.isEmpty());
        System.out.println("The queue is now full? " + queue.isFull());

        try {
            queue.enQueue(11);
        } catch (Exception e) {
            System.out.println("Full queue could no enQueue.");
        }

        System.out.println("FIFO, deQueue to get the oldest element: " + queue.deQueue());
        System.out.println("The size of queue is " + queue.size());
    }
}
