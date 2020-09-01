package test.round1;

import java.util.*;

public class SubStringOfKWithKDistictChars {

    public static void main(String[] args) {
        System.out.println (setAllPosibleString ("abcabc", 3));
        System.out.println (setAllPosibleString ("abacab", 3));
        System.out.println (setAllPosibleString ("awaglknagawunagwkwagl", 4));

        System.out.println (listAllPossibleString ("awaglknagawunagwkwagl", 4));
    }

    static List<String> listAllPossibleString(String s, int k) {
        List<String> result = new ArrayList<> ();

        Map<Character, Integer> hMap = new HashMap<> ();

        for (int i = 0, j = 0; i < s.length (); i++) {
            char c = s.charAt (i);

            if (hMap.containsKey (c)) {
                j = Math.max (hMap.get (c), j);
            }

            if (i - j + 1 == k && !result.contains (s.substring (j, i + 1))) {
                result.add (s.substring (j, i + 1));
                j++;
            }
            hMap.put (c,i+1);
        }
        return result;
    }

    static Set<String> setAllPosibleString(String s, int k) {
        Set<String> result = new HashSet<> ();

        Map<Character, Integer> hMap = new HashMap<> ();

        for (int i = 0, j = 0; i < s.length (); i++) {
            char c = s.charAt (i);

            if (hMap.containsKey (c)) {
                j = Math.max (hMap.get (c), j);
            }

            if (i - j + 1 == k) {
                result.add (s.substring (j, i + 1));
                j++;
            }

            hMap.put (c, i + 1);
        }

        return result;
    }
}
