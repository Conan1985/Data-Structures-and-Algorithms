/**
 *
 * @author Youwei Lu
 * Assignment 2
 * CISC 610-90- O-2018/Late Fall - Data Structures & Algorithms
 *
 * Test the correct working of each operation of StackADT
 *
 **/

package assignment2;

public class TestStack {

    public static void main(String[] args) {
        StackADT stack = new StackADT(10); // give the stack capacity of 10
        System.out.println("The size of stack is " + stack.size());
        System.out.println("The stack is now empty? " + stack.isEmpty());
        System.out.println("The stack is now full? " + stack.isFull());

        try {
            stack.pop();
        } catch (Exception e) {
            System.out.println("Empty stack could not pop.");
        }

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);

        System.out.println("The size of stack is " + stack.size());
        System.out.println("The stack is now empty? " + stack.isEmpty());
        System.out.println("The stack is now full? " + stack.isFull());

        try {
            stack.push(11);
        } catch (Exception e) {
            System.out.println("Full stack could no push.");
        }

        System.out.println("LIFO, pop to get the most recent element: " + stack.pop());
        System.out.println("The size of stack is: " + stack.size());
    }
}
