package test.round1;

import java.util.PriorityQueue;

public class MinCostToConnectRopes {

    public static void main(String[] args) {
        int[] ropes1 = {8, 4, 6, 12};
        int[] ropes2 = {20, 4, 8, 2};
        int[] ropes3 = {1, 2, 5, 10, 35, 89};
        int[] ropes4 = {2, 2, 3, 3};
        System.out.println (minCost (ropes1));
        System.out.println(minCost(ropes2));
        System.out.println(minCost(ropes3));
        System.out.println(minCost(ropes4));
    }

    static int minCost(int[] ropes) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<> ();

        for (int rope : ropes) {
            priorityQueue.add (rope);
        }

        int cost = 0;

        while (priorityQueue.size () != 1) {
            int temp = priorityQueue.poll () + priorityQueue.poll ();
            cost += temp;
            priorityQueue.offer (temp);
        }

        return cost;
    }
}
