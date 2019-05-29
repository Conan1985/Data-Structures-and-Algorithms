package assignment5;

import java.util.Random;

/**
 *
 * Assignment 5
 * CISC 610-90- O-2018/Late Fall - Data Structures & Algorithms
 *
 * Implement Algorithm 7.4 mergesort 4 (Linked Version)
 *
 **/

public class MergeSort {

    static class Node {
        int key;
        int link;
        Node(int key, int link) {
            this.key = key;
            this.link = link;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        Random random = new Random();
        Node[] S = new Node[n + 1];
        for (int i = 1; i < n + 1; i++) {
            S[i] = new Node(Math.abs(random.nextInt(100)), 0);
        }

//        long start = System.nanoTime();
        int listfront = mergesort4(1, n, S);
//        long end = System.nanoTime();
//        long time = end - start;
        Node pointer = S[listfront];
        while (pointer.link != 0) {
            System.out.print(pointer.key);
            System.out.print((' '));
            pointer = S[pointer.link];
        }
        System.out.print(pointer.key);
//        System.out.println("The algorithm completes in " + time + " ns.");
}

    static int mergesort4 (int low, int high,  Node[] S) {
        int mid, list1, list2, mergedlist;
        if (low == high) {
            mergedlist = low;
            S[mergedlist].link = 0;
        } else {
            mid = ((low + high)/ 2);
            list1 = mergesort4(low, mid, S);
            list2 = mergesort4(mid+1, high, S);
            mergedlist = merge4(list1, list2, S);
        }
        return mergedlist;
    }

    static int merge4 (int list1, int list2, Node[] S) {
        int lastsorted, mergedlist;
        if (S[list1].key < S[list2].key) { // Find the start of the merged list
            mergedlist = list1;
            list1 = S[list1].link;
        } else {
            mergedlist = list2;
            list2 = S[list2].link;
        }
        lastsorted = mergedlist;
        while(list1 != 0 && list2 != 0) {
            if (S[list1].key < S[list2].key) { // Attach smaller key to merged list
                S[lastsorted].link = list1;
                lastsorted = list1;
                list1 = S[list1].link;
            } else {
                S[lastsorted].link = list2;
                lastsorted = list2;
                list2 = S[list2].link;
            }
        }
        if (list1 == 0) { // After one list ends, attach remainder of the other.
            S[lastsorted].link = list2;
        } else {
            S[lastsorted].link = list1;
        }
        return mergedlist;
    }

}
