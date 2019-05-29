/**
 *
 * Assignment 2
 * CISC 610-90- O-2018/Late Fall - Data Structures & Algorithms
 *
 * Implement a method of queueReverseMiddle that takes as input an instance of QueueADT and two integers: low and high,
 * to reverse the order of the low to high inclusive elements in the QueueADT instance.
 *
 * Evaluate of time and space complexity of queueReverseMiddle:
 * It keeps moving items in queue from the head to the back, but pauses for the items from low to high. The items from
 * low to high are reversed by a stack, and pushed to the back of queue as well. After that, the queue continues to
 * move all items left to the back.
 * Let's assume the whole number of items in queue is n, and the numbers to be reversed is m.
 * It always traverse all n elements from front to back, plus m operated in stack, so the total time complexity is
 * O(n + 2m) = O(n), and time complexity is the same for both best and worst cases.
 * It only uses a stack as extra space, so space complexity is O(m).
 *
 **/

package assignment2;

public class QueueReverseMiddle {

    public static void main (String[] args) {
        testQueueReverseMiddle (0, 8);
        testQueueReverseMiddle (1, 8);
        testQueueReverseMiddle (2, 8);
        testQueueReverseMiddle (3, 6);
    }

    static private void queueReverseMiddle(QueueADT queue, int low, int high) {
        if (queue == null) {
            throw new IllegalArgumentException();
        }

        int size = queue.size();
        if ( size == 0 ||  low < 1 || high >size) {
            throw new IllegalArgumentException();
        }

        // move 1 to low-1 items to the back of queue
        if (low != 1) {
            for (int i = 1; i < low; i++) {
                queue.enQueue(queue.deQueue());
            }
        }

        // save low to high items in a stack and put to back of queue
        StackADT s = new StackADT(high - low + 1);


        while (!s.isFull()) {
            s.push(queue.deQueue());
        }

        while (!s.isEmpty()) {
            queue.enQueue(s.pop());
        }

        // move the left of q to the back
        if (high != size) {
            for (int i = high + 1; i <= size; i++) {
                queue.enQueue(queue.deQueue());
            }
        }
    }

    static private QueueADT generateQueue () {
        QueueADT queue = new QueueADT(8);
        queue.enQueue(12);
        queue.enQueue(34);
        queue.enQueue(65);
        queue.enQueue(76);
        queue.enQueue(23);
        queue.enQueue(22);
        queue.enQueue(36);
        queue.enQueue(90);
        return queue;
    }

    static private void testQueueReverseMiddle (int low, int high) {
        QueueADT q = generateQueue();
        System.out.println("low=" + low + " " + "high=" + high);
        System.out.print("Original Queue contents: ");
        while (!q.isEmpty()) {
            System.out.print(q.deQueue() + " ");
        }
        System.out.print('\n');
        q = generateQueue();
        System.out.print("New Queue contents: ");
        try {
            queueReverseMiddle(q, low, high);
            while (!q.isEmpty()) {
                System.out.print(q.deQueue() + " ");
            }
            System.out.print('\n');
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

}
