package com.amazon.codechallenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrisonAfterNDays {

    public static void main(String[] args) {
        int[] cells = {0,1,0,1,1,0,0,1};
        int N = 7;

        System.out.println (Arrays.toString (prisonAfterNDays (cells, N)));
    }
    static int[] prisonAfterNDays(int[] cells, int N){

        Set<String> set = new HashSet<> ();
        int size = 0;
        int cellSize = cells.length;
        boolean flag = false;

        //For Days
        for (int i = 0; i< N; i++){
            int[] nextState = new int[cellSize];

            for(int j = 1; j < cellSize-1; j++){
                nextState[j] = (cells[j-1] == cells[j+1]? 1: 0);
            }

            String result = Arrays.toString (nextState);

            if(set.contains (result)){
                flag = true;
                break;
            }else{
                set.add (result);
                size++;
            }
            cells = nextState;
        }

        if(flag){
            N = N%size;
            for(int i = 0; i< N; i++){
                int[] nextState = new int[cellSize];
                for(int j = 1; j< cellSize-1; j++){
                    nextState[j] = cells[j+1] == cells[j-1]?1:0;
                }
                cells = nextState;
            }
        }
        return cells;
    }
}
