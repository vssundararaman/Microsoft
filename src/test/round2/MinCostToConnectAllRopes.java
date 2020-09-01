package test.round2;

import java.util.PriorityQueue;

public class MinCostToConnectAllRopes {

    public static void main(String[] args) {
        int[] ropes = {8, 4, 6, 12};

        System.out.println (connectAllRopes (ropes));
    }

    static int connectAllRopes(int[] number){
        if(number == null || number.length ==0 ){
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<> ();

        for(int num: number){
            queue.add (num);
        }

        int cost = 0;

        while ((queue.size () !=1)){
            int sum = queue.poll () + queue.poll ();
            cost += sum;
            queue.offer (sum);
        }

        return cost;
    }
}
