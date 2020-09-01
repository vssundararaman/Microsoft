package com.microsoft.backtracking;

public class RegularExpressionMatching {

    public static void main(String[] args) {

//        String s = "ab";
//        String p = ".*";

//        String s = "aa";
//        String p = "a*";

//        String s = "aab";
//        String p = "c*a*b";

        String s = "mississippi";
        String p = "mis*is*p*.";

        System.out.println (isMatch (s,p));
    }

    static boolean isMatch(String text, String pattern){
        if(pattern.isEmpty ())return text.isEmpty ();

        boolean firstMatch = (!text.isEmpty () &&
                    (pattern.charAt (0) == text.charAt (0)
                            || pattern.charAt (0) == '.'));

        if(pattern.length () >= 2 && pattern.charAt (1) == '*'){
            return isMatch (text, pattern.substring (2)) ||
                    (firstMatch && isMatch (text.substring (1), pattern));
        }else{
            return firstMatch && isMatch (text.substring (1), pattern.substring (1));
        }

    }
}
