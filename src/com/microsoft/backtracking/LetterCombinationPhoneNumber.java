package com.microsoft.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationPhoneNumber {


   static List<String> output = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(letterCombination("23"));
    }

    static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    static void backtracking(String combination, String next_digits){
        // if there is no more digits to check
        if(next_digits.length() ==0){
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else{
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0,1);
            String letters = phone.get(digit);
            for(int i=0;i<letters.length();i++){
                String letter = phone.get(digit).substring(i,i+1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtracking(combination+letter, next_digits.substring(1));
            }
        }
    }
    static List<String> letterCombination(String digits){
        if(digits.length()!=0){
            backtracking("", digits);
            return output;
        }
        return null;
    }

}
