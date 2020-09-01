package test.round1.interm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};

        System.out.println (mostCommonWord (paragraph,banned));
    }

    static String mostCommonWord(String paragraph, String[] bannedWords) {

        Set<String> bannedWordsSet = new HashSet<> ();
        Map<String, Integer> wordMap = new HashMap<> ();

        for (String word : bannedWords) {
            bannedWordsSet.add (word);
        }

        System.out.println (paragraph);
        System.out.println (paragraph.replaceAll ("[^a-zA-Z]"," "));

        for (String word : paragraph.replaceAll ("[^a-zA-z]", " ").toLowerCase ().split (" ")) {
            if (!bannedWordsSet.contains (word)) {
                wordMap.put (word, wordMap.getOrDefault (word, 0) + 1);
            }
        }

        String commonWord = "";

        for(String word: wordMap.keySet ()){
            if(commonWord.equals ("") || wordMap.get (word) > wordMap.get (commonWord) ){
                commonWord = word;
            }
        }

        return commonWord;
    }
}


