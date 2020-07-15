package com.microsoft.others;

public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }

    static int titleToNumber(String s){
        if(s==null || s.length()==0){
            return 0;
        }

        int result = 0;
        for(int i=0; i<s.length();i++){

            result = result * 26;
            // In Java, subtracting characters is subtracting ASCII values of characters
            result += (s.charAt(i) - 'A'+1);
        }

        return result;
    }
}

