package test.round2;

import java.util.*;
import java.util.stream.Collectors;

public class LargestItemAssociation {

    public static void main(String[] args) {
        List<PairString> pairStrings =Arrays.asList (new PairString ("item1","item2"),
                            new PairString ("item3","item4"), new PairString ("item4","item5"));

        System.out.println (largestItemAssociation (pairStrings));
    }

    static List<String>largestItemAssociation(List<PairString> itemAssociation){

        if(itemAssociation == null){
            return null;
        }

        PriorityQueue<Set<String>> maxHeap = new PriorityQueue<> ((l1,l2) ->
                Integer.compare (l2.size (),l1.size ()));
        Collections.sort (itemAssociation, (a,b) -> a.first.compareTo (b.first));

        for(int i=0;i<itemAssociation.size ();i++){

            Set<String> buildList = new TreeSet<> (Arrays.asList (itemAssociation.get (i).first,itemAssociation.get (i).second));

            for(int j = i+1; j<itemAssociation.size ();j++){
                mergeTag(buildList, itemAssociation.get (j));
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

class PairString{
    String first;
    String second;

    PairString(String first, String second){
        this.first = first;
        this.second =second;
    }
}
