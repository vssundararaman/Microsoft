package test.round1;

import java.util.*;

public class TopKFrequentlyMentionedKeywords {

    public static void main(String[] args) {
        int k1 = 2;
        String[] keywords1 = { "anacell", "cetracular", "betacellular" };
        String[] reviews1 = { "Anacell provides the best services in the city", "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell", };


        String[] keywords2 = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular.",};


       // System.out.println (frequent (keywords1,reviews1,k1));

//        System.out.println (frequentWords(keywords1,reviews1,k1));
//
//        System.out.println (frequent(keywords2,reviews2,k1));

        System.out.println (solve(keywords1,reviews1,k1));

        System.out.println (solve(keywords2,reviews2,k1));
    }

    static List<String> frequent(String[] keywords,String[] reviews, int k){

        List<String> keywordList = Arrays.asList (keywords);

        Map<String, Integer> map = new HashMap<> ();

        for(String words: reviews){

            Set<String> added = new HashSet<> ();

            for(String str: words.split ("\\s+")){
                str = str.toLowerCase ();

                if(keywordList.contains (str) && !added.contains (str)){
                    map.put (str, map.getOrDefault (str,0+1));
                    added.add (str);
                }
            }
        }

        List<String> result = new ArrayList<> (map.keySet ());

        Collections.sort (result,(a,b)->(map.get (a).equals (map.get (b))?a.compareTo (b):map.get (b)-map.get(a)));

        return result.subList (0,k);
    }

    static List<String> frequentWords(String[] keywords,String [] review, int k){
        Set<String> keywordSet = new HashSet<> (Arrays.asList (keywords));

        Map<String, Integer> wordMap = new HashMap<> ();

        for(String words: review){
            for(String word: words.split ("\\s+")){
                if(keywordSet.contains (word)){
                    wordMap.put (word, wordMap.getOrDefault (word,0+1));
                }
            }
        }

        List<String> result = new ArrayList<> (wordMap.keySet ());

        Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b)->a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        maxHeap.addAll(wordMap.entrySet());
        while(!maxHeap.isEmpty() && k-- > 0) {
            result.add(maxHeap.poll().getKey());
        }

        return result;
    }

    static List<String> solve(String[] keywords, String[] reviews, int k) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(keywords));
        Map<String, Integer> map = new HashMap<>();
        for(String r : reviews) {
            String[] strs = r.split("\\W");
            Set<String> added = new HashSet<>();
            for(String s : strs) {
                s = s.toLowerCase();
                if(set.contains(s) && !added.contains(s)) {

                    System.out.println (" ****** " + map.getOrDefault(s, 0) + 1);
                    map.put(s, map.getOrDefault(s, 0) + 1);
                    added.add(s);
                }
            }
        }
        Queue<Map.Entry<String, Integer>> maxHeap =
                new PriorityQueue<>((a, b)->a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        while(!maxHeap.isEmpty() && k-- > 0) {
            res.add(maxHeap.poll().getKey());
        }
        return res;
    }
}
