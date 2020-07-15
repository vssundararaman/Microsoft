package com.microsoft.others;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    static Map<Character, Integer> values = new HashMap<>();

    static {
        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);
    }


    public static void main(String[] args) {
        String s = "MCMXCIV";

        System.out.println(romanToInt2(s));
        System.out.println(romanToInt(s));
    }

    static int romanToInt2(String s){
        if(s ==null || s.length() == 0){
            return 0;
        }

        int length = s.length();
        int result = values.get(s.charAt(length-1));

        for(int i = length-2; i >=0; i--){
            if(values.get(s.charAt(i)) >= values.get(s.charAt(i+1))){
                result += values.get(s.charAt(i));
            }else{
                result -= values.get(s.charAt(i));
            }
        }

        return result;
    }

    static int romanToInt(String s) {
        int sum = 0;
        int i = 0;

        while (i < s.length()) {
            String currentSymbol = s.substring(i, i + 1);
            int currentValue = values.get(currentSymbol.toString());
            int nextValue = 0;

            if (i + 1 < s.length()) {
                String nextSymbol = s.substring(i + 1, i + 2);
                nextValue = values.get(nextSymbol.toString());
            }

            if (currentValue < nextValue) {
                sum += (nextValue - currentValue);
                i += 2;
            }else{
                sum += currentValue;
                i +=1;
            }

        }
        return sum;
    }
}
