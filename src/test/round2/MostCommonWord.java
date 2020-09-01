package test.round2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"ball"};

        System.out.println (mostCommonWord (paragraph,banned));
    }

    static String mostCommonWord(String paragraph, String[] banned){

        Set<String> bannedWordSet = new HashSet<> ();

        for(String word: banned){
            bannedWordSet.add (word);
        }

        Map<String, Integer> count = new HashMap<> ();

        for(String word:  paragraph.replaceAll ("[^a-zA-z]", " ").toLowerCase ().split (" ")){
                if(!bannedWordSet.contains (word)){
                    count.put (word,count.getOrDefault (word,0)+1);
                }
        }

        String commonWord = "";
        for(String key: count.keySet ()){
            if(commonWord.equals ("") || count.get (key)>count.get (commonWord)){
                commonWord = key;
            }
        }

        return commonWord;
    }
}
