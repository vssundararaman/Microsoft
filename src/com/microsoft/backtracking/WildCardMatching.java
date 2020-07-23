package com.microsoft.backtracking;

public class WildCardMatching {

    public static void main(String[] args) {
        String s = "aabbbbc";
        String p = "aa*c";

        String s1 = "azb";
        String p1 = "a?b";

        System.out.println(wildCardMatch(s, p));
    }

    static boolean isMatch(String string, String pattern) {

        int sLen = string.length(), pLen = pattern.length();

        //bothCases
        if (pattern.equals(string) || pattern.equals("*")) return true;
        if (pattern.isEmpty() || string.isEmpty()) return false;

        //Init all matrix except [0][0] element as false
        boolean[][] d = new boolean[pLen + 1][sLen + 1];
        d[0][0] = true;

        for (int pIdx = 1; pIdx < pLen + 1; pIdx++) {
            // the current character in the Pattern is '*'
            if (pattern.charAt(pIdx - 1) == '*') {

                int sIdx = 1;
                //d[pIdx -1][sIdx-1] is a String-pattern match
                // on the previous step. i.e. one character before
                // Find the first idx in String with the previous match.
                while ((!d[pIdx - 1][sIdx - 1]) && (sIdx < sLen)) sIdx++;

                // If (String) matches (Pattern)
                // When String matches (pattern)* as well

                d[pIdx][sIdx - 1] = d[pIdx][sIdx - 1];
                // If (String) matches (pattern)
                //when(string)(whatever_matches) matches pattern * as well
                while (sIdx < sLen + 1) d[pIdx][sIdx++] = true;
            } else if (pattern.charAt(pIdx - 1) == '?') {
                for (int sIdx = 1; sIdx < sLen; sIdx++) {
                    d[pIdx][sIdx] = d[pIdx - 1][sIdx - 1];
                }
            }
            //the current character in the pattern is not * or ?
            else {
                for (int sIdx = 1; sIdx < sLen + 1; sIdx++) {
                    d[pIdx][sIdx] = d[pIdx - 1][sIdx - 1] &&
                            (pattern.charAt(pIdx - 1) == string.charAt(sIdx - 1));
                }
            }
        }

        return d[pLen][sLen];
    }

    static boolean wildCardMatch(String s, String p) {
        char[] chr = s.toCharArray();
        char[] ptr = p.toCharArray();

        //replace multiple * with Single *
        int writeIndex = 0;
        boolean isFirst = true;

        for (int i = 0; i < ptr.length; i++) {
            if (ptr[i] == '*') {
                if (isFirst) {
                    ptr[writeIndex++] = ptr[i];
                    isFirst = false;
                }
            } else {
                ptr[writeIndex++] = ptr[i];
                isFirst = true;
            }
        }
        boolean T[][] = new boolean[chr.length + 1][writeIndex + 1];

        if (writeIndex > 0 && ptr[0] == '*') {
            T[0][1] = true;
        }
        T[0][0] = true;

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (ptr[j - 1] == '?' || chr[i - 1] == ptr[j - 1]) {
                    T[i][j] = T[i - 1][j - 1];
                } else if (ptr[j - 1] == '*') {
                    T[i][j] = T[i - 1][j] || T[i][j - 1];
                }
            }
        }

        return T[chr.length][writeIndex];
    }
}
