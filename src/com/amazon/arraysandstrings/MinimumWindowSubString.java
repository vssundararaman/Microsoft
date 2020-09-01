package com.amazon.arraysandstrings;

public class MinimumWindowSubString {

    public static void main(String[] args) {
        String S = "ADOBECODEBANC", T = "ABC";

        System.out.println (minWindowSubString (S,T));
    }
    static String minWindowSubString(String string, String t){

        if(string == null || t == null) return "";
        String result = "";

        int[] letterCount = new int[128];
        int left = 0, count = 0, minLen = Integer.MAX_VALUE;

        for(char c: t.toCharArray ()){
            ++letterCount[c];
        }
        for(int right = 0; right <string.length (); right++){
            if(--letterCount[string.charAt (right)] >=0){
                ++count;
                while (count == t.length ()){
                    if(minLen > right - left+1){
                        minLen = right - left+1;
                        result = string.substring (left,right+1);
                    }
                    if(++letterCount[string.charAt (left)]>0){
                        --count;
                    }
                    ++left;
                }
            }
        }
        return result;
    }
}
