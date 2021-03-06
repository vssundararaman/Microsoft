package test.round1;

import java.util.*;
import java.util.stream.Collectors;

public class LongestItemAssociation {

    public static void main(String[] args) {
        List<PairString> pairs = Arrays.asList( //
                new PairString("item1", "item2"), // -> item1, item3, item2
                new PairString("item3", "item4"), //
                new PairString("item2", "item5") //
        );

        System.out.println(largestItemAssociation(pairs));
    }

    // Time complexity O(n2) and space is O(n)
    static List<String> largestItemAssociation(List<PairString> pairs) {
        if (pairs.isEmpty ()) {
            return null;
        }

        PriorityQueue<Set<String>> maxHeap =
                new PriorityQueue<> ((l1, l2) -> Integer.compare (l2.size (), l1.size ()));
        Collections.sort (pairs, (a, b) -> a.first.compareTo (b.first));

        for (int pair = 0; pair < pairs.size (); pair++) {
            Set<String> buildList = new TreeSet<> (Arrays.asList (pairs.get (pair).first,pairs.get (pair).second));

            for(int inner = pair+1; inner<pairs.size ();inner++){
                mergeTag(buildList, pairs.get (inner));
            }
            maxHeap.add (buildList);
        }
        return maxHeap.poll ().stream ().collect(Collectors.toList());
    }

    private static void mergeTag(Set<String> buildList, PairString pairString) {

        if(buildList.contains (pairString.first) && buildList.contains (pairString.second)){
            return;
        }
        if(buildList.contains (pairString.first)){
            buildList.add (pairString.second);
        }else if(buildList.contains (pairString.second)){
            buildList.add (pairString.first);
        }
    }
}

class PairString {
    String first;
    String second;

    public PairString(String first, String second) {
        this.first = first;
        this.second = second;
    }
}
