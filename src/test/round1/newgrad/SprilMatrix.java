package test.round1.newgrad;

import java.util.Arrays;

public class SprilMatrix {

    public static void main(String[] args) {
        System.out.println (Arrays.deepToString (generateMatrix (4)));
    }

    static int[][] generateMatrix(int n) {
        //Declaration
        int[][] matrix = new int[n][n];

        //Edge Case
        if (n == 0) {
            return matrix;
        }

        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int num = 1; //Change

        while (rowStart <= rowEnd && colStart <= colEnd) {

            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = num++; //Change
            }

            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = num++; //Change
            }

            colEnd--;

            for (int i = colEnd; i >= colStart; i--) {
                if (rowStart <= rowEnd) {
                    matrix[rowEnd][i] = num++;
                }

            }
            rowEnd--;

            for(int i = rowEnd; i>=rowStart; i--){
                if(colStart <= colEnd){
                    matrix[i][colStart] = num++;
                }
            }

            colStart++;

        }

        return matrix;
    }
}
