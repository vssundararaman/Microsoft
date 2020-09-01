package com.amazon.codingchallenge;

import java.util.*;

public class TopFeatures {

    public static void main(String[] args) {

        int k1 = 2;
        String[] keywords1 = { "anacell", "cetracular", "betacellular" };
        String[] reviews1 = { "Anacell provides the best services in the city", "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell", };
        int k2 = 2;
        String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
        String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services", "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell", "Betacellular is better than deltacellular.", };
        System.out.println(getFrequent(k1, keywords1, reviews1));
        System.out.println(getFrequent(k2, keywords2, reviews2));
    }

    static List<String> getFrequent(int k, String[] keywords, String[] words){
        Map<String,Integer> count= new HashMap<> ();
        List<String> keywordsList= Arrays.asList(keywords);
        for(String word:words){
            for(String s:word.split("\\s+")){
                if(keywordsList.contains(s)){
                    count.put(s,count.getOrDefault(s,0)+1);
                }
            }
        }

        List<String> ls = new ArrayList<> (count.keySet());
        Collections.sort(ls, (a,b)-> (count.get(a)).equals(count.get(b))?a.compareTo(b):count.get(b)-count.get(a));

        return ls.subList(0,k);
    }
}
