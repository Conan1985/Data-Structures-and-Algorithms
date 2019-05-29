/**
 *
 * Assignment 2
 * CISC 610-90- O-2018/Late Fall - Data Structures & Algorithms
 *
 * Test the deleteFirstInstance operation in DLinkedListADT
 *
 **/

package assignment2;

public class TestDeleteFirstInstance {

    public static void main(String[] args) {

        DLinkedListADT q = new DLinkedListADT();
            q.addLast(12);
            q.addLast(34);
            q.addLast(65);
            q.addLast(76);
            q.addLast(23);
            q.addLast(22);
            q.addLast(36);
            q.addLast(90);

            System.out.print("Original list elements: "); // 12 34 65 76 23 22 36 90
            q.printNextList();

            q.deleteFirstInstance(10);  // no such element so list doesn't change
            System.out.print("Try delete 10: \nModified list elements: ");
            q.printNextList();

            q.deleteFirstInstance(12); // first element removed
            System.out.print("Try delete 12: \nModified list elements: ");
            q.printNextList();

            q.deleteFirstInstance(90); // last element removed
            System.out.print("Try delete 90: \nModified list elements: ");
            q.printNextList();

            q.deleteFirstInstance(76); // '76' is removed
            System.out.print("Try delete 76 \nModified list elements: ");
            q.printNextList();
    }
}
