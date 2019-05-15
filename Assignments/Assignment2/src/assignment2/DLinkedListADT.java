/**
 *
 * @author Youwei Lu
 * Assignment 2
 * CISC 610-90- O-2018/Late Fall - Data Structures & Algorithms
 *
 * Implement doubly linked list ADT
 * Methods: addFirst, addLast, deleteFist, deleteLast, count, printNextList, printPrevList, getStart, getEnd
 * and deleteFirstInstance (take a int argument num and deletes the first node in the list where the data matches num)
 *
 * Evaluate of time and space complexity of deleteFirstInstance:
 * It uses a Node n to traverse from start to end of the DLinkedListADT, once found match, let the previous Node's next
 * state to the next Node and the next Node's prev state to the previous Node, i.e. link the previous and next nodes.
 * Therefore, no extra space needed, except some space used for system operations, and space complexity is O(1).
 * In the best case, if the first Node is the match, time complexity is O(1). In the worst case, if the last Node is
 * the match or no match, time complexity is O(n). In average case, time complexity is O(n).
 *
 **/

package assignment2;

import java.util.NoSuchElementException;

class Node {
    public int num;
    public Node next;
    public Node prev;

    Node (int n) {
        num = n;
        next = null;
        prev = null;
    }
}

class DLinkedListADT {
    private Node start; // beginning of list
    private Node end; // end of list
    private int size; // number of Node elements in list

    DLinkedListADT() {
        start = null; // empty list
        end = null; // empty list
        size = 0; // no elements
    }

    // add element to beginning of the list
    void addFirst(int num) {
        Node n = new Node(num); // create new Node n with value of num
        if (start == null) { // no elements so make start and end point to new Node n
            start = n;
            end = n;
        } else {
            n.next = start; // connects n to element at start
            start.prev = n; // connects element at start to n
            start = n; // makes n the first element
        }
        size++;
    }

    // add element to the end of the list
    void addLast(int num) {
        Node n = new Node(num); // create new Node n with value of num
        if (start == null) { // no elements so make start and end point to new Node n
            start = n;
            end = n;
        } else {
            end.next = n; // connects last element at end to new
            n.prev = end; // connects new element n to element at end
            end = n; // makes n the last element
        }
        size++;
    }

    // delete first element and return its value
    int deleteFirst() {
        if (start == null) { // no elements
            throw new NoSuchElementException();
        }
        Node n = start; // save the reference to the first node can return
        if (start == end) {// one element so make str/end null since deleting
            start = null;
            end = null;
        } else {
            start = start.next; // setting to next element
            start.prev = null; // set prev to null since now first element
        }
        size--;
        return n.num;
    }

    // delete last element and return its value
    int deleteLast() {
        if (start == null) { // no elements
            throw new NoSuchElementException();
        }
        Node n = end; // save the reference to the last node so can return
        if(start == end) { // one element so make start/end null since deleting
            start = null;
            end = null;
        } else {
            end = end.prev; // setting to prev element
            end.next = null; // set next to null since now last element
        }
        size--;
        return n.num;
    }

    // return the number of nodes in list
    int count() {
        return size;
    }

    // print values of all elements from first to last
    void printNextList() {
        Node n = start; // start with first element
        while (n != null) { // traverse all elements
            System.out.print(n.num + " ");
            n = n.next;
        }
        System.out.print("\n");
    }

    // print values of all elements from last to first
    void printPrevList() {
        Node n = end; // start with last element
        while (n != null) { // traverse all elements
            System.out.print(n.num + " ");
            n = n.prev;
        }
        System.out.print("\n");
    }

    // return value of start
    Node getStart() {
        return start;
    }

    // return value of end
    Node getEnd() {
        return end;
    }

    // delete first instance
    void deleteFirstInstance(int num) {
        if (start == null) { // no element, thus no element to delete
            return;
        }
        if (start.num == num) { // if the first element match
            start = start.next;
            start.prev = null;
            return;
        }
        Node n = start;
        while (n != end) {
            if (n.num == num) { // link the previous and next nodes
                n.prev.next = n.next;
                n.next.prev = n.prev;
                return;
            }
            n = n.next;
        }
        if (end.num == num) { // if the last element match
            end = end.prev;
            end.next = null;
        }
    }
}
