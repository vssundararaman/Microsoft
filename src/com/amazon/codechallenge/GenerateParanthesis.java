package com.amazon.codechallenge;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public static void main(String[] args) {
        System.out.println (generateParanthesis (3));
    }

    static List<String> generateParanthesis(int n){
        List<String> outPutArray = new ArrayList<> ();
        backTrack (outPutArray, "",0,0, n);
        return outPutArray;
    }

    static void backTrack(List<String> outPutArray, String currentString,int open, int close, int max){
        //BaseCases
        if(currentString.length () ==max*2){
            outPutArray.add (currentString);
            return;
        }

        if(open < max){
            backTrack (outPutArray,currentString + "(", open+1, close,max);
        }

        if(close < open){
            backTrack (outPutArray,currentString+")",open,close+1,max);
        }

    }
}
