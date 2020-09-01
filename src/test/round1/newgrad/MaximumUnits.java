package test.round1.newgrad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumUnits {

    public static void main(String[] args) {
        // ===================================================
        int num = 2;
        ArrayList<Integer> boxes = new ArrayList<>(Arrays.asList (2,2));

        int unitSize = 2;
        ArrayList<Integer> unitsPerBox = new ArrayList<>(Arrays.asList (3, 1));
        int truckSize = 3;

        // ===================================================

        System.out.println(getMaxUnit1(num,boxes,unitSize,unitsPerBox,truckSize));
    }

    /**
     * @param num
     * @param boxes
     * @param unitSize
     * @param unitsPerBox
     * @param truckSize
     * @return maxUnit
     */
    static long getMaxUnit(int num, List<Integer> boxes, int unitSize, List<Integer> unitsPerBox, long truckSize) {


        PriorityQueue<int[]> maxHeap = new PriorityQueue<> ((b1,b2)-> b2[1]-b1[1]);

        for(int i = 0;i<boxes.size ();i++){
            maxHeap.add (new int[]{boxes.get (i),unitsPerBox.get (i)});
        }

        long count = 0;

        while (truckSize > 0 && !maxHeap.isEmpty ()){
            int[] curr = maxHeap.poll ();

            long boxesToTruckCanHold = Math.min(curr[0],truckSize );

            count = count + (boxesToTruckCanHold* curr[1]);
            truckSize = truckSize - boxesToTruckCanHold;
        }

        return count;

    }


    static int getMaxUnit1(int num, ArrayList<Integer> boxes, int unitSize, ArrayList<Integer> unitsPerBox, long truckSize){
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for(int i=0;i<num;i++){
            int n= boxes.get(i);
            for(int j=0;j<n;j++){
                PQ.add(unitsPerBox.get(i));
                if(PQ.size()>truckSize) PQ.remove();
            }
        }
        int max=0;
        while(!PQ.isEmpty()){
            max += PQ.remove();
        }
        return max;
    }


}
