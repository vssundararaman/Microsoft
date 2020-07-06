package com.microsoft.arraysandstrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {

    public static void main(String[] args) {
        int [][] matrix = {{1,1,1},
                {1,0,1},
                {1,1,1}};

        System.out.println(Arrays.toString(setZeros(matrix)));
    }

    static int[][] setZeros(int[][] matrix) {

        int R = matrix.length;
        int C = matrix[0].length;

        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }
}
