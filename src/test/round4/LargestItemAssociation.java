package test.round4;

import java.util.*;
import java.util.stream.Collectors;

public class LargestItemAssociation {

    public static void main(String[] args) {

        List<PairString> pairs = Arrays.asList (new PairString ("item1","item2"),
                new PairString ("item3","item4"),
                new PairString ("item4","item5"));


        System.out.println (largestItemAssociation (pairs));
    }

    static List<String> largestItemAssociation(List<PairString> itemAssociation){

        if(itemAssociation ==null || itemAssociation.size ()==0){
            return new ArrayList<> ();
        }

        //PriorityQueue<Set<String>> maxHeap = new PriorityQueue<> ((l1,l2) -> Integer.compare (l2.size (),l1.size ()));

        PriorityQueue<Set<String>> maxHeap = new PriorityQueue<> ((l1,l2)-> Integer.compare (l2.size (),l1.size ()));

        Collections.sort (itemAssociation, (a,b)-> a.first.compareTo (b.first));
        //Collections.sort (itemAssociation, Comparator.comparing (a -> a.first));


        for(int pair=0;pair<itemAssociation.size ();pair++){

            //Set<String> buildList = new TreeSet<> (Arrays.asList (itemAssociation.get (pair).first,itemAssociation.get (pair).second));

            Set<String> buildList = new TreeSet<> (Arrays.asList (itemAssociation.get (pair).first,itemAssociation.get (pair).second));

            for(int inner = pair+1;inner<itemAssociation.size ();inner++ ){
                mergeTag (buildList,itemAssociation.get (inner));
            }

            maxHeap.add (buildList);
        }

        return maxHeap.poll ().stream ().collect(Collectors.toList());
    }

    static void mergeTag(Set<String> buildSet, PairString pairString){

        if(buildSet.contains (pairString.first) && buildSet.contains (pairString.second)){
            return;
        }
        if(buildSet.contains (pairString.first)){
            buildSet.add (pairString.second);
        }else if(buildSet.contains (pairString.second)){
            buildSet.add (pairString.first);
        }
    }
}

class PairString{
    String first;
    String second;

    PairString(String first,String second){
        this.first = first;
        this.second = second;
    }
}