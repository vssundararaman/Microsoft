package com.microsoft.arraysandstrings;

import java.util.Arrays;
import java.util.Collections;

public class RotateMatrixImage {

    public static void main(String[] args) {

        int [][] matrix= {{1,2,3},
                          {4,5,6},
                          {7,8,9}};

        //rotate(matrix);
        rotateImage (matrix);
    }


    static void rotateImage(int[][] matrix){
        Collections.reverse (Arrays.asList (matrix));
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j < i; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]= temp;
            }
        }
        printMatrix(matrix);
    }

    //Transpose the Matrix
    static void rotate(int [][] matrix){

        int n = matrix.length;

        for(int i=0;i<n;i++){
            for(int j=i;j<n; j++){
                int tmp = matrix[j][i];
                matrix[j][i]=matrix[i][j];
                matrix[i][j]=tmp;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int tmp = matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }

        printMatrix(matrix);
    }

    static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
