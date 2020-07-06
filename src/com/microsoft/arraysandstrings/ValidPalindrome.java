package com.microsoft.arraysandstrings;

public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isValidPalindrome("A man, a plan, a canal: Panama"));

        System.out.println(isValidPalindrome("race a car"));
    }

    public static boolean isValidPalindrome(String str){

        StringBuilder stringBuilder = new StringBuilder();

        for(char ch: str.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                stringBuilder.append(ch);
            }
        }
        String filteredString = stringBuilder.toString();
        String reversedString = stringBuilder.reverse().toString();
        if(filteredString.equalsIgnoreCase(reversedString)){
            return true;
        }
        return false;

    }
}
