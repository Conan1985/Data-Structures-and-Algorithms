package assignment4;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * Assignment 4
 * CISC 610-90- O-2018/Late Fall - Data Structures & Algorithms
 *
 * Algorithm 4.4 Scheduling with Deadlines
 *
 * Problem: Determine the schedule with maximum total profit given that each job has a profit that will be obtained only
 * if the job is scheduled by its deadline
 *
 *  In schedule method:
 *  Inputs:
 *  n - the number of jobs
 *  deadline - array with deadline values, indexed 1 to n, where deadline[i] is the deadline for the ith job; array has
 *  been sorted in nonincreasing order based on profit
 *  job - array with job number values that corespond to sorted deadline[]
 *  profits - array with profit values that correspond to sorted deadline[]
 *
 *  Output:
 *  returns optimal sequence J for the jobs
 *
 **/

public class Schedule {

    public static void main(String[] args) {

        int[] job = {0, 5, 2, 1, 6, 4, 3};
        int[] deadline = {0, 2, 4, 2, 1, 3, 3};
        int[] profit = {0, 56, 52, 46, 40, 36, 30};
        int n = 6;

        Schedule schedule = new Schedule();
        ArrayList<Integer> J = schedule.schedule(n, deadline);

        System.out.print("Final set: ");
        System.out.print(Arrays.toString(J.toArray()));
        System.out.print("\n");
        System.out.print("Feasible sequence: ");
        J.forEach(j -> System.out.print(job[j] + " "));
        System.out.print("\n");
        System.out.print("Corresponding deadline: ");
        J.forEach(j -> System.out.print(deadline[j] + " "));
        System.out.print("\n");
        int profitSum = 0;
        for (int j : J) {
            profitSum += profit[j];
        }
        System.out.print("Profit: ");
        System.out.println(profitSum);

    }

    private ArrayList<Integer> schedule(int n, int[] deadline) {
        ArrayList<Integer> J = new ArrayList<>();
        J.add(1);

        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> K = new ArrayList<>(J);
            K.add(i);
            if (feasible(K, deadline)) {
                J = new ArrayList<>(K);
            }
        }
        return J;
    }

    private boolean feasible(ArrayList<Integer> K, int[] deadline) {
        ArrayList<Integer> tmp = new ArrayList<>(K);
        boolean isFeasible = true;

        for (int i = 0; i < tmp.size() - 1; i++) {
            for (int j = i + 1; j < tmp.size(); j++) {
                int index1 = tmp.get(i);
                int index2 = tmp.get(j);
                if (deadline[index1] > deadline[index2]) { // swap job numbers in tmp
                   tmp.set(i, index2);
                   tmp.set(j, index1);
                }
            }
        }

        for (int k = 0; k < tmp.size(); k++) {
            int job = tmp.get(k);
            if (deadline[job] < k + 1) {
                isFeasible = false;
                break;
            }
        }

        return isFeasible;
    }

}

