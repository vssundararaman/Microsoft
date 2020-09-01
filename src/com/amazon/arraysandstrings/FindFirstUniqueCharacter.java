package com.amazon.arraysandstrings;

import java.util.HashMap;

public class FindFirstUniqueCharacter {

    public static void main(String[] args) {
        String string = "loveleetcode";

        System.out.println (firstUniqueCharIndex (string));
    }

    static int firstUniqueCharIndex(String str){

        HashMap<Character,Integer> map = new HashMap<> ();

        for(int i=0; i< str.length () ; i++){

            char current = str.charAt (i);

            if(!map.containsKey (current)){
                map.put (current, i);
            }else{
                map.put (current, -1);
            }
        }

        int min = Integer.MAX_VALUE;

        for(char c: map.keySet ()){
            if(map.get (c) >-1 && map.get (c)< min){
                min = map.get(c);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

