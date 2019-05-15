/**
 *
 * @author Youwei Lu
 * Assignment 3
 * CISC 610-90- O-2018/Late Fall - Data Structures & Algorithms
 *
 * Test BST
 * Test the methods in BST: find, findMin, findMax, insert, delete, traverseInOrder, getRoot
 *
 **/

package assignment3;

public class TestBST {
    public static void main(String[] args) {

        BST bst = new BST();
        TestBST testBST = new TestBST();

        // Test insert method
        bst.insert(90);
        bst.insert(21);
        bst.insert(38);
        bst.insert(50);
        bst.insert(40);
        bst.insert(45);
        bst.insert(87);

        // Test find method
        testBST.findNode(90, bst);
        testBST.findNode(100, bst);

        // Test findMin method
        System.out.println("The minimum node key is " + bst.findMin().getKey());

        // Test findMax method
        System.out.println("The maximum node key is " + bst.findMax().getKey());

        // Test delete method
        bst.delete(90);
        System.out.println("After deletion, the maximum node key is " + bst.findMax().getKey());

        // Test traverseInOrder
        bst.traverseInOrder();
        System.out.print('\n');

        // Test getRoot
        System.out.println("The root of the tree is " + bst.getRoot().getKey());

    }

    void findNode(int key, BST bst) {
        if (bst.find(key) == null) {
            System.out.println("Could not find " + key);
        } else {
            System.out.println("Find the node " + key);
        }
    }

}
