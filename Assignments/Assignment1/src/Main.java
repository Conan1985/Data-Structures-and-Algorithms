/**
 *
 * Assignment 1
 * CISC 610-90- O-2018/Late Fall - Data Structures & Algorithms
 *
 *
 **/

public class Main {
    public static void main(String[] args) {
        Print print = new Print();
        print.welcome(args);
    }
}

class Print {
    void welcome(String[] names) {
        System.out.println("Hello, World!");
        if (names.length != 0) {
            System.out.println("author: " + names[0]);
        }
    }
}