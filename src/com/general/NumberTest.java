package com.general;

public class NumberTest {

    public static void main(String[] args) {
        System.out.println ("executing...");

        int n = 98710232;
        int reversed = 0;

        while (n>0){
            System.out.println (n%10);
            //System.out.println (n/10);
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }

        System.out.println (reversed);
    }
}
