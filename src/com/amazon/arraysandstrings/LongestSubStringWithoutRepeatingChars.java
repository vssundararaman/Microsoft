package com.amazon.arraysandstrings;

import java.util.HashSet;

public class LongestSubStringWithoutRepeatingChars {

    public static void main(String[] args) {
        String string = "abcdabcbb";

        System.out.println (findLongestSubStringWithoutRepeatingChars (string));
    }

    static int findLongestSubStringWithoutRepeatingChars(String string){

        int aPointer = 0, bPointer = 0, max = 0;
        HashSet<Character> hashSet = new HashSet<> ();

        while(bPointer < string.length ()){
            if(!hashSet.contains (string.charAt (bPointer))){
                hashSet.add (string.charAt (bPointer));
                bPointer ++;
                max = Math.max (hashSet.size (),max);
            }else{
                hashSet.remove (string.charAt (aPointer));
                aPointer++;
            }
        }
        return max;
    }
}
