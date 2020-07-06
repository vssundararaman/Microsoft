package com.microsoft.arraysandstrings;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
    System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0)
            return ans;
        int first_row = 0, last_row = matrix.length - 1;
        int first_col = 0, last_col = matrix[0].length - 1;
        while (first_row <= last_row && first_col <= last_col) {
            for (int c = first_col; c <= last_col; c++){
                ans.add(matrix[first_row][c]);
            }
            for (int r = first_row + 1; r <= last_row; r++) {
                ans.add(matrix[r][last_col]);
            }
            if (first_row < last_row && first_col < last_col) {
                for (int c = last_col - 1; c > first_col; c--) {
                    ans.add(matrix[last_row][c]);
                }
                for (int r = last_row; r > first_row; r--) {
                    ans.add(matrix[r][first_col]);
                }
            }
            first_row++;
            last_row--;
            first_col++;
            last_col--;
        }
        return ans;
    }
}
