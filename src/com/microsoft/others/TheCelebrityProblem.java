package com.microsoft.others;

public class TheCelebrityProblem {


    // Person with 2 is celebrity
    static int MATRIX[][] = {{0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}};

    // Returns true if a knows
    // b, false otherwise
    static boolean knows(int a, int b) {
        boolean res = (MATRIX[a][b] == 1) ?
                true :
                false;
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int result = findCelebrity(n);
        if (result == -1)
        {
            System.out.println("No Celebrity");
        }
        else
            System.out.println("Celebrity ID " +
                    result);
    }

    static int findCelebrity(int n) {
        int candidate = 0;

        for (int i = 1; i < n; i++) {
            if(knows(candidate,i)){
                candidate = i;
            }
        }

        for(int i=0;i<n;i++){
            if(i != candidate && knows(candidate,i)|| !knows(i,candidate)){
                return -1;
            }
        }
        return candidate;
    }
}
