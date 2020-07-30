package com.microsoft.arraysandstrings;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {
       // String[] str = {"tab","eat", "tea", "tan", "ate", "nat", "bat"};
        String[] str = {"bba","abb","cca","acc"};
        System.out.println(groupAnagrams1(str));

    }

    static List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for(String str: strs){
            char[] arr = new char[26];
            for(int i=0; i<str.length(); i++){
                arr[str.charAt(i)-'a']++;
            }

            System.out.println(arr);
            String ns = new String(arr);

            if(map.containsKey(ns)){
                map.get(ns).add(str);
            }else{
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(ns, al);
            }
        }

        result.addAll(map.values());

        return result;
    }
}
