package com.kyn.problem_solve;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Q6 {
    public static void main(String[] args) {
        
        int[][] myArray2D = {{1,2,3},{4,5,6},{7,8,9}};
        int sum = 0;
        for(int i = 0 ; i < myArray2D.length ; i++){
            sum += myArray2D[i][i];
        }

        int sum2 = IntStream.range(0, myArray2D.length)
                .map(i -> myArray2D[i][i])
                .sum();

        System.out.println(sum);
        System.out.println(sum2);
    }
}
