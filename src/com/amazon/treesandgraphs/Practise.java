package com.amazon.treesandgraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practise {

    static List<Integer> finalStates = new ArrayList<>();

    public static void main(String[] args) {
        int[] states = {1,0,0,0,0,1,0,0};

        int[] states1 = {1,1,1,0,1,1,1,1};

        //System.out.println (cellCompete (states, 1));

        System.out.println (cellCompete (states1, 2));
    }


    public static List<Integer> cellCompete(int[] cells, int days) {

        int len = cells.length;
        int[] newCells = new int[cells.length];
        for (int k = 0; k < days; k++) {
            for (int i = 0; i < cells.length; i++) {
                int cell = cells[i];
                int nextCell;
                int prevCell;
                int activenumber;
                if (i == 0) {
                    // edge cases
                    nextCell = cells[1];
                    prevCell = 0;
                } else if (i == cells.length - 1) {
                    // edge case
                    prevCell = cells[cells.length - 2];
                    nextCell = 0;
                } else {
                    nextCell = cells[i + 1];
                    prevCell = cells[i - 1];
                }
                if (nextCell == prevCell) {
                    // set it to inactive
                    activenumber = 0;
                } else {
                    //set it to active
                    activenumber = 1;
                }
                newCells[i] = activenumber;
            }
            for (int i = 0; i < 8; i++) {
                cells[i] = newCells[i];
            }
        }
        List<Integer> stList = new ArrayList<Integer> ();

        for(int i: newCells){
            stList.add (i);
        }
        return stList;
    }


    static List<Integer> cellCompete1(int[] states, int days)
    {
        int[] next = new int[10];

        for(int i = 1; i < states.length; i++) {
            next[i] = states[i];
        }

        for(int i = 1; i < days; i++) {
            for(int j = 1; j < states.length -1; j++) {
                if((states[j-1]==1 && states[j+1]==0) || (states[j-1]==0 && states[j+1]==1)) {
                    next[j] = 1;
                }
                else {
                    next[j] = 0;
                }
            }

        }

        List<Integer> stList = new ArrayList<Integer> ();
        for(int k = 0; k < states.length; k++) {
            states[k] = next[k];
            stList.add(next[k]);
        }

        return stList;
        // WRITE YOUR CODE HERE
    }
}


