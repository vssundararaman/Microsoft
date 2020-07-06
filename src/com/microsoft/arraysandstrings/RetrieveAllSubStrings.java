package com.microsoft.arraysandstrings;

public class RetrieveAllSubStrings {

    public static void main(String[] args) {

        String str = "abc";

        char[] chars = str.toCharArray();

        for(int i=0;i<chars.length ;i++){
            for(int j=i+1;j<= chars.length;j++){
                System.out.println(str.substring(i, j));
            }
        }

    }
}
