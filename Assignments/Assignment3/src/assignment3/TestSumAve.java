/**
 *
 * @author Youwei Lu
 * Assignment 3
 * CISC 610-90- O-2018/Late Fall - Data Structures & Algorithms
 *
 * Test SumNodes and averageTree
 *
 **/

package assignment3;

public class TestSumAve {

    public static void main(String[] args) {
        BST bst = new BST();

        bst.insert(90);
        bst.insert(21);
        bst.insert(38);
        bst.insert(50);
        bst.insert(40);
        bst.insert(45);
        bst.insert(87);

        System.out.println("sumNodes should return: " + bst.sumNodes());
        System.out.println("averageTree should return: " + bst.averageTree());

    }
}
