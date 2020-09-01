package test.round3;

import java.util.*;
import java.util.stream.Collectors;

public class LargestItemAssociation {

    public static void main(String[] args) {
        List<PairString> pairs = Arrays.asList( //
                new PairString("item1", "item2"), // -> item1, item3, item2
                new PairString("item3", "item4"), //
                new PairString("item4", "item5") //
        );

        System.out.println(ItemAssociation(pairs));
    }

    static List<String> ItemAssociation(List<PairString> itemAssociation) {

        if (itemAssociation.isEmpty ()) {
            return null;
        }

        PriorityQueue<Set<String>> maxHeap = new PriorityQueue<> ((l1, l2) -> Integer.compare (l2.size (), l1.size ()));
        Collections.sort (itemAssociation, (a, b) -> a.first.compareTo (b.first));

        for (int pair = 0; pair < itemAssociation.size (); pair++) {
            Set<String> buildList = new TreeSet<> (Arrays.asList (itemAssociation.get (pair).first, itemAssociation.get (pair).second));

            for(int inner = pair+1; inner<itemAssociation.size ();inner++){
                mergeTag (buildList,itemAssociation.get (inner));
            }

            maxHeap.add (buildList);

        }

        return maxHeap.poll ().stream ().collect(Collectors.toList());
    }

    static void mergeTag(Set<String> buildList, PairString pairString){
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

    PairString(String first, String second) {
        this.first = first;
        this.second = second;
    }
}
