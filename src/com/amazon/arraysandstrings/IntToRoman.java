package com.amazon.arraysandstrings;

public class IntToRoman {
    final static String[] ONES = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    final static String[] TENS = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    final static String[] HUNDREDS = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    final static String[] THOUSANDS = {"","M","MM","MMM"};

    public static void main(String[] args) {
        System.out.println (intToRoman (1000));
    }

    public static String intToRoman(int num) {
        int place = 1;
        String ans="";
        while(num>0){
            int rem = num % 10;
            rem *= place;
            ans = helper(rem) + ans;
            place*= 10;
            num = num / 10;
        }
        return ans;
    }

    static String helper(int num){
        if(num < 10) return ONES[num];
        else if(num<100) return TENS[num/10];
        else if(num<1000) return HUNDREDS[num/100];
        else return THOUSANDS[num/1000];
    }
}


