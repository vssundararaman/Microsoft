package com.microsoft.arraysandstrings;

import java.util.Arrays;

public class ReverseWholeAndEachWord {

    public static void main(String[] args) {

        String str = "Void Matters";
        reverseWord(str.toCharArray(),0,str.length()-1);
    }

    static void reverse(char[]c, int left, int right){

        while(left < right){
            char tmp = c[left];
            c[left++] = c[right];
            c[right--]= tmp;
        }

        //System.out.println(Arrays.toString(c));
    }

    static void reverseWord(char[] chars ,int left, int right){

        int n = chars.length;
        int start = 0; int end = 0;

        while(start< n){

            while(end < n && chars[end] !=' ') {
                ++end;
            }

            reverse(chars, start, end-1);

            start = end +1;
            ++end;
        }

        System.out.println(Arrays.toString(chars));
    }
}
