package test.round1.interm;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointToOrigin {

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int K = 1;
        System.out.println (Arrays.deepToString (KClosest (points, K)));
    }

    static int[][] KClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<> ((a, b) -> (b[0] * b[0] + b[1] * b[1]
                - (a[0] * a[0] + a[1] * a[1])));

        for (int[] point : points) {
            maxHeap.add (point);

            if (maxHeap.size () > K) {
                maxHeap.remove ();
            }
        }

        int[][] result = new int[K][2];

        while (K-- > 0) {
            result[K] = maxHeap.remove ();
        }

        return result;
    }
}
