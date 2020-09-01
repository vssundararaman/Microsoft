package com.amazon.arraysandstrings;

public class ImplementStrSTR {

    public static void main(String[] args) {
        System.out.println (strStr ("hello", "ll"));
    }

    static int strStr(String haystack, String needle) {
        if (needle.isEmpty ()) return 0;

        int len = needle.length ();
        boolean bool = false;
        int i = 0;
        for (i = 0; i < haystack.length () - len + 1; i++) {
            if (needle.equals (haystack.substring (i, len + i))) {
                bool = true;
                break;
            } else {
                continue;
            }
        }

        if (!bool) {
            return -1;
        }

        return i;
    }
}
