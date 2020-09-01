package com.amazon.codingchallenge;

import java.util.*;

public class AmazonKindleTopFeatures {

    public static void main(String[] args) {
        int numFeatures = 6;
        int topFeatures = 2;
        String[] possibleFeaturesArr = {"storage", "battery", "hover", "alexa", "waterproof", "solar"};
        int numFeatureRequests = 7;
        String[] featureRequests = {"I wish my Kindle had even more storage",
                "I wish the battery life on my Kindle lasted 2 years", "I read in the bath and would enjoy a waterproof Kindle",
                "I want to take my Kindle into the hover. Waterproof please waterproof!", "It would be neat if my Kindle would hover on my desk when not in use",
                "How cool would it be if my Kindle charged in the sun via solar power?"};


        String[] possibleFeatures = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};

        String[] reviews = {
                "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular.",
        };


       // System.out.println (topKFreqWords (numFeatures, numFeatureRequests, topFeatures, Arrays.asList (possibleFeaturesArr), Arrays.asList (featureRequests)));

        System.out.println (topKFreqWords (5, 2, 2, Arrays.asList (possibleFeatures), Arrays.asList (reviews)));

    }

    public static List<String> topKFreqWords(int numFeatures, int numFeatureRequest, int topFeatures, List<String> possibleFeatures, List<String> featureRequest) {
        HashSet set = new HashSet<> ();

        for (String s : possibleFeatures) {
            set.add (s.toLowerCase ());
        }


        HashMap<String, Integer> words = new HashMap<> ();
        for (String s : featureRequest) {
            Set<String> seen = new HashSet<> ();
            for (String str : s.split ("\\W"))
                if (set.contains (str.toLowerCase ()) && !seen.contains (str.toLowerCase ())) {
                    words.put (str.toLowerCase (), words.getOrDefault (str.toLowerCase (), 0) + 1);
                    seen.add (str.toLowerCase ());
                }
        }

        List<String> list = new ArrayList<> (words.keySet ());
        Collections.sort (list, (a, b) -> (words.get (a).equals (words.get (b))) ? a.compareTo (b) : (words.get (b) - words.get (a)));
        if (topFeatures > numFeatures)
            return list;
        return list.subList (0, topFeatures);
    }
}
