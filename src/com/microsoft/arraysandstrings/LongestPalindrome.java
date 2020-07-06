package com.microsoft.arraysandstrings;

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        if(s==null || s.length()==0){
            return "";
        }

        int start =0;
        int end = 0;

        for(int i=0;i<s.length();i++){
            int length1 = expandFromMiddle(s,i,i);
            int length2 = expandFromMiddle(s,i,i+1);

            int length = Math.max(length1,length2);

            if(length > end - start){
                start = i - ((length - 1)/2);
                end = i + (length/2);
            }
        }

        return s.substring(start, end+1);
    }

    static int expandFromMiddle(String string, int left, int right){

        if(string==null || string.length()==0 || left > right){
            return 0;
        }

        while(left >= 0 && right < string.length() && string.charAt(left) == string.charAt(right)){
            left --;
            right ++;
        }
        return right - left - 1;
    }
}
