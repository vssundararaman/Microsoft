package com.amazon.codechallenge;

import java.util.ArrayList;
import java.util.List;

public class SubStringOfKwithKDistinctChars {

    public static void main(String[] args) {
        System.out.println (Count("abcabc", 3));
    }

    public static List<String> Count(String S, int k){
        int[] arr = new int[26];
        List<String> res = new ArrayList<> ();
        for(int i = 0, j = 0; j < S.length(); j++){
            i = Math.max(arr[S.charAt(j) - 'a'], i);
            if(j - i + 1 == k && !res.contains(S.substring(i, j + 1))){
                res.add(S.substring(i, j + 1));
                i++;
            }
            arr[S.charAt(j) - 'a'] = j + 1;
        }
        return res;
    }
}
