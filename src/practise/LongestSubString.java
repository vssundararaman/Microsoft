package practise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubString {

    public static void main(String[] args) {
        System.out.println (longestSubString ("abcabcbb"));
    }

    static String longestSubString(String string){
        int aPointer = 0, bPointer=0, max = 0;

        Set<Character> set = new HashSet<> ();

        while(bPointer < string.length ()){
            if(!set.contains (string.charAt (bPointer))){
                set.add (string.charAt (bPointer));
                bPointer++;
                max = Math.max (set.size (),max);
            }else{
                set.remove (string.charAt (aPointer));
                aPointer++;
            }
        }
        return set.toString ();
    }

    static String lengthOfLongestSubstring(String s) {

        int aPointer = 0, bPointer = 0, max = 0;

        HashSet<Character> hashSet = new HashSet<>();

        while(bPointer < s.length()){
            if(!hashSet.contains(s.charAt(bPointer))){
                hashSet.add(s.charAt(bPointer));
                bPointer++;
                max = Math.max(hashSet.size(), max);
            }else{
                hashSet.remove(s.charAt(aPointer));
                aPointer++;
            }
        }
        return hashSet.toString ();
    }
}
