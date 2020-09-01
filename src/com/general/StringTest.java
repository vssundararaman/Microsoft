package com.general;

public class StringTest {

    public static void main(String[] args) {
        String s1 = "test";
        String s2 = "test";
        String s3 = new String ("test");

        System.out.println (s1==s2);

        System.out.println (s1==s3);

        System.out.println (s1.equals (s3));
    }
}
