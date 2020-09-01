package test.round1;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public static void main(String[] args) {
        System.out.println (partitionLabel ("ababcbacadefegdehijhklij"));

        System.out.println (partitionLabel1 ("ababcbacadefegdehijhklij"));
    }

    static List<Integer> partitionLabel(String string){

        int[] last = new int[26];

        for(int i = 0; i<string.length ();i++){
            last[string.charAt (i)-'a']=i;
        }

        int j = 0; int anchor=0;

        List<Integer> answer = new ArrayList<> ();

        for(int i=0; i<string.length ();i++){

            j = Math.max (j, last[string.charAt (i)-'a']);
            if(i == j){
                answer.add (i-anchor+1);
                anchor = i+1;
            }
        }

        return answer;
    }

    static List<Integer> partitionLabel1(String string){
        if (string == null || string.length () == 0)
            return null;

        List<Integer> outputArray = new ArrayList<> ();

        int[] last_indices = new int[26];
        for (int i = 0; i < string.length (); i++) {
            last_indices[string.charAt (i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < string.length (); i++) {
            end = Math.max (end, last_indices[string.charAt (i) - 'a']);
            if (end == i) {
                outputArray.add (end - start + 1);
                start = end + 1;
            }
        }

        return outputArray;
    }
}
