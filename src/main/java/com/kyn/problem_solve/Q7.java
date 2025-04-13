package com.kyn.problem_solve;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Q7 {
    public static void main(String[] args) {
       int[] myArray = {84,85,86,87,85,90,85,83,23,45,84,1,2,0};
       
       int[] topTwo2 = IntStream.of(myArray)
                              .boxed()
                              .sorted((a, b) -> b - a)
                              .mapToInt(Integer::intValue)
                              .limit(2)
                              .toArray();
       System.out.println(Arrays.toString(topTwo2));
       
       }
}
