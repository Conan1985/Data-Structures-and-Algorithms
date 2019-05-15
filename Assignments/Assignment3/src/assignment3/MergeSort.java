/**
 *
 * @author Youwei Lu
 * Assignment 3
 * CISC 610-90- O-2018/Late Fall - Data Structures & Algorithms
 *
 * MergeSort
 * Methods: main, mergesort, merge
 * Compare the runtime performance of the sort using different test data
 * (i.e. small set, large set, sorted set, partially sorted, sorted in opposite order, random)
 *
 **/

package assignment3;

import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort merge = new MergeSort();

        System.out.println("For output show the result of the following input: [2, 98, 3, 14, 5, 65, 1]");
        int[] test = {2, 98, 3, 14, 5, 65, 1};
        for (int i = 0; i < test.length; i++) {
            merge.mergesort(test);
            System.out.print(test[i]);
            System.out.print(' ');
        }
        System.out.print('\n');

        // Compare the runtime performances in nanosecond.
        Random random = new Random();

        // Random test numbers from 100 to 1000
        System.out.println("Sort using different length of random test data");
        int[] random10 = merge.generateRandomSet(10, random);
        int[] random100 = merge.generateRandomSet(100, random);
        int[] random1000 = merge.generateRandomSet(1000, random);
        int[] random10000 = merge.generateRandomSet(10000, random);
        int[] random100000 = merge.generateRandomSet(100000, random);

        System.out.println(merge.runtime(random10) + "ns");
        System.out.println(merge.runtime(random100) + "ns");
        System.out.println(merge.runtime(random1000) + "ns");
        System.out.println(merge.runtime(random10000) + "ns");
        System.out.println(merge.runtime(random100000) + "ns");

        // Now compare different type of set in same size
        System.out.println("Now check the runtime of different type of data with length of 100");
        int[] sortedSet = new int[100];
        for (int i = 0; i < 100; i++) {
            sortedSet[i] = i + 1;
        }
        System.out.print("Sort sorted set of test data in ");
        System.out.println(merge.runtime(sortedSet) + "ns");

        int[] partiallySortedSet = new int[100];
        for (int i = 0; i < 25; i++) {
            partiallySortedSet[i] = i + 1;
        }
        for (int i = 25; i < 75; i++) {
            partiallySortedSet[i] = random.nextInt();
        }
        for (int i = 75; i < 100; i++) {
            partiallySortedSet[i] = i + 1;
        }
        System.out.print("Sort partially sorted set of test data in ");
        System.out.println(merge.runtime(partiallySortedSet) + "ns");

        int[] oppositeSortedSet = new int[100];
        for (int i = 0; i < 100; i++) {
            oppositeSortedSet[i] = 100 - i;
        }
        System.out.print("Sort sorted in opposite order set of test data in ");
        System.out.println(merge.runtime(oppositeSortedSet) + "ns");

    }

    int[] generateRandomSet(int num, Random random) {
        int[] test = new int[num];
        for (int i = 0; i < num; i++) {
            test[i] = random.nextInt();
        }
        return test;
    }

    long runtime(int[] test) {
        long start = System.nanoTime();
        mergesort(test);
        long end = System.nanoTime();
        long time = end - start;
        return time ;
    }

    // takes the array of integer elements and sorts it in increasing order
    void mergesort(int num[]) {
        mergesort(num, 0, num.length-1); // beginning index and last index to srt
    }

    //recursive
    void mergesort(int num[], int low, int high) {
        int mid;
        if (low < high) {// have subarray to sort (until single unit - index same)
            mid = (low + high) / 2;
            mergesort(num, low, mid); // recursively sort low to mid subarray
            mergesort(num, mid + 1, high); // recursively sort mid+1 to high subarray
            merge(num, low, mid, mid + 1, high); // merge two sorted subarrays
        }
    }

    //merge two subarrays in sorted order
    void merge(int[] a, int l1, int u1, int l2, int u2) {

        // array 1: l1 ... u1 and array 2: l2 ... u2

        int[] temp = new int[a.length];

        // i is current index of left subarray; j of right subarray; k of temp array
        int i, j, k;
        i = l1;
        j = l2;
        k = l1;

        // loop as long as have elements in both left AND right subarray
        while (i <= u1 && j <= u2) {
            if (a[i] <= a[j]) { // left subarray el val <= right subarray el value
                temp[k] = a[i]; // copy left element to temp
                i = i + 1; // increment to next left element
            } else {
                temp[k] = a[j]; // copy right element to temp
                j = j + 1; // increment to next right element
            }
            k = k + 1;
        }

        // copy remaining elements in left subarray
        while (i <= u1) {
            temp[k] = a[i];
            k = k + 1; // increment index for temp array
            i = i + 1; // increment index for left subarray
        }

        // copy remaining elements in right subarray
        while (j <= u2) {
            temp[k] = a[j];
            k = k + 1; // increment index for temp array
            j = j + 1; // increment index for right subarray
        }

        // copy temp[] back into a[]
        int h = l1;
        while (h <= u2) {
            a[h] = temp[h];
            h = h + 1;
        }

//        System.out.print("Show set at current step:");
//        for (int m = 0; m < temp.length; m++) {
//            System.out.print(temp[m]);
//            System.out.print(' ');
//        }
//        System.out.print('\n');
    }
}
