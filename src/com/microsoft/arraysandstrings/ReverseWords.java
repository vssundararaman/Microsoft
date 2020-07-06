package com.microsoft.arraysandstrings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {
    public static void main(String[] args) {
        String input = "the sky is blue";
        System.out.print(reverseWords(input));
    }

    static String reverseWords(String str){
        //Remove Leading Spaces
        str = str.trim();

        List<String> wordList = Arrays.asList(str.split("\\s+"));
        Collections.reverse(wordList);
        String result = String.join(" ", wordList);
        return result;
    }
}


