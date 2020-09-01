package test.round1;

import java.util.*;

public class OptimalUtilization {

    public static void main(String[] args) {
        int[] a = new int[]{1, 8};
        int[] a1 =new int[] {2, 7};
        int[] a2 = new int[]{3, 14};
        List<int[]> list1 = new ArrayList<> ();
        list1.add (a);
        list1.add (a1);
        list1.add (a2);


        int[]b = new int[]{1, 5};
        int[]b1 = new int[] {2, 10};
        int[] b2 = {3, 14};
        List<int[]> list2 = new ArrayList<> ();
        list2.add (b);
        list2.add (b1);
        list2.add (b2);
        int target = 20;

        System.out.println (solution (list1,list2,target));
    }

    static List<int[]> solution(List<int[]> list1, List<int[]> list2, int target) {

        //Key is sum,value is the list of ids from a and b
        Map<Integer, List<int[]>> map = new HashMap<> ();

        for (int i = 0; i < list1.size (); i++) {
            for (int j = 0; j < list2.size (); j++) {
                List<int[]> sums = map.getOrDefault (list1.get (i)[1] + list2.get (j)[1], new ArrayList<> ());
                sums.add (new int[]{list1.get (i)[0], list2.get (j)[0]});
                map.put (list1.get (i)[1] + list2.get (j)[1], sums);
            }
        }

        List<Integer> allSums = new ArrayList<> ();

        for (Integer i : map.keySet ()) {
            if (i < target) {
                allSums.add (i);
            } else if (i == target) {
                return map.get (target);
            }
        }

        if (allSums.size () == 0) {
            return new ArrayList<> ();
        }

        return map.get (Collections.max (allSums));
    }
}
