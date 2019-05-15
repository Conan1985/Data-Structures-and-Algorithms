/**
 *
 * @author Youwei Lu
 * Assignment 2
 * CISC 610-90- O-2018/Late Fall - Data Structures & Algorithms
 *
 * Test the correct working of each operation of DLinkedListADT
 *
 **/

package assignment2;

import java.util.NoSuchElementException;

class TestDLinkedList {

    public static void main(String[] args) {

        DLinkedListADT dLinkedList = new DLinkedListADT();

        try {
            dLinkedList.deleteFirst();
        } catch (NoSuchElementException e) {
            System.out.println("dLinkedListADT doesn't have first element.");
        }

        try {
            dLinkedList.deleteLast();
        } catch (Exception e) {
            System.out.println("dLinkedListADT doesn't have last element.");
        }

        dLinkedList.addFirst(1);
        dLinkedList.addFirst(2);
        dLinkedList.addFirst(3);

        dLinkedList.addLast(4);
        dLinkedList.addLast(5);
        dLinkedList.addLast(6);

        // should be 321456 now

        System.out.println("Delete the first element: " + dLinkedList.deleteFirst()); // 3

        System.out.println("Delete the last element: " + dLinkedList.deleteLast());  // 6

        System.out.println("The size of dLinkedListADT now is " + dLinkedList.count()); // only 4 left now

        dLinkedList.printNextList(); // 2145

        dLinkedList.printPrevList(); // 5412

        System.out.println("The number of first node is " + dLinkedList.getStart().num); // 2

        System.out.println("The number of first node is " + dLinkedList.getEnd().num); // 5


    }
}