/**
 *
 * @author Youwei Lu
 * Assignment 3
 * CISC 610-90- O-2018/Late Fall - Data Structures & Algorithms
 *
 * BST
 * Methods: find, findMin, findMax, insert, delete, traverseInOrder, getRoot
 *
 **/

package assignment3;

class Node {
    private int key;
    private Node left;
    private Node right;

    public Node(int key) {
        this.key = key;
        left = null;
        right = null;
    }

    int getKey() {
        return key;
    }

    Node getLeft() {
        return left;
    }

    Node getRight() {
        return right;
    }

    void setKey(int key) {
        this.key = key;
    }

    void setLeft(Node left) {
        this.left = left;
    }

    void setRight(Node right) {
        this.right = right;
    }

}

public class BST {

    Node root;

    // find and return node in the tree with the key value using recursion
    Node find (int key) {
        return find (root, key);
    }

    // recursive part of find
    Node find(Node root, int key) {
        if (root == null || root.getKey() == key) {
            return root;
        }
        if (key > root.getKey()) {
            return find(root.getRight(), key);
        } else {
            return find(root.getLeft(), key);
        }
    }

    // find smallest node recursively (left most leaf node)
    Node findMin() {
        return findMin(root);
    }

    // recursive part of dinMin
    Node findMin(Node root) {
        if (root.getLeft() == null) {
            return root;
        }
        return findMin(root.getLeft());
    }

    // find max node recursively (right most leaf node)
    Node findMax() {
        return findMax(root);
    }

    // recursive part of indMax
    Node findMax(Node root) {
        if (root.getRight() == null) {
            return root;
        }
        return findMax(root.getRight());
    }

    // insert node in tree using recursion
    // it needs to find the correct place to keep binary search tree
    void insert(int data) {
        root = insert(root, data);
    }

    // recursive part of insert
    Node insert(Node root, int key) {
        if (root == null) {
            return new Node (key);
        }
        if (key < root.getKey()) {
            //call recursively insert for left subtree
            root.setLeft(insert(root.getLeft(), key));
        } else if (key > root.getKey()) {
            //call recursively insert for right subtree
            root.setRight(insert(root.getRight(), key));
        }
        return root;
    }

    // delete node in tree using recursion
    void delete(int data) {
        root = delete (root, data);
    }

    // recursive part of delete
    Node delete (Node root, int key) {
        if (root == null) {
            return root;
        }

        /* recurse down the tree to find the node to delete */

        if (key < root.getKey()) {
            root.setLeft(delete(root.getLeft(), key));
        } else if (key > root.getKey()) {
            root.setRight(delete(root.getRight(), key));
        }
        else { // found node to delete
            // node with only one child or no child
            if (root.getLeft() == null) {
                return root.getRight(); // no child
            } else if (root.getRight() == null) {
                return root.getLeft();
            }

            // node with two children: Get the inorder successor
            // smallest in the right subtree
            root.setKey(minValue(root.getRight()));

            // Delete the inorder successor
            root.setRight(delete(root.getRight(), root.getKey()));
        }
        return root;
    }

    // get smallest value of the tree (left most leaf node)
    int minValue(Node root) {
        int minv = root.getKey(); // current smallest
        while (root.getLeft() != null) {
            minv = root.getLeft().getKey(); // new smallest
            root = root.getLeft();
        }
        return minv;
    }

    // traverse node's in in-order and print key values
    void traverseInOrder() {
        traverseInOrder(root);
    }

    // recursive part of inorder
    void traverseInOrder(Node root) {
        if (root != null) {
            traverseInOrder(root.getLeft());
            visit(root);
            traverseInOrder(root.getRight());
        }
    }

    void visit(Node n) {
        System.out.print(n.getKey());
        System.out.print(' ');
    }

    Node getRoot() {
        return root;
    }

    int sumNodes() {
        return sumNodes(root);
    }

    int sumNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return (
                root.getKey() + sumNodes(root.getLeft()) + sumNodes(root.getRight())
        );
    }

    int averageTree() {
        int sum = sumNodes();
        int count = count(root);
        return (sum / count);
    }

    int count(Node root) {
        if (root == null) {
            return 0;
        }
        return (1 + count(root.getLeft()) + count(root.getRight()));
    }

}
