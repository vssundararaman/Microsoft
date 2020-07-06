package com.microsoft.arraysandstrings;

public class StringToIntegerATOI {

    public static void main(String[] args) {

        String str = "42";
        System.out.println(atoi(str));

        str = "   -42";
        System.out.println(atoi(str));

        str = "4193 with words";
        System.out.println(atoi(str));

        str = "words and 987";
        System.out.println(atoi(str));

        str = "-91283472332";
        System.out.println(atoi(str));
    }

    static int atoi(String string) {
        if (string == null || string.trim().length() == 0) {
            return 0;
        }
        char flag = '+';
        int i = 0;

        string = string.trim();

        if (string.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (string.charAt(0) == '+') {
            i++;
        }
        double result = 0;

        while (string.length() > i && string.charAt(i) >= '0' && string.charAt(i) <= '9') {
            result = result * 10 + (string.charAt(i) - '0');
            i++;
        }

        if (flag == '-') {
            result = -result;
        }

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }
}
