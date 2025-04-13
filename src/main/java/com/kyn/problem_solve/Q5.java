package com.kyn.problem_solve;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Q5 {
    public static void main(String[] args) {
        
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(arr));

        int[] arr2 = new int[arr.length-2];

        for(int i = 1 ; i < arr.length-1 ; i++){
            arr2[i-1] = arr[i];
        }
        System.out.println(Arrays.toString(arr2));
        
        int[] streamArr = IntStream.range(1, arr.length - 1)
                                 .map(i -> arr[i])
                                 .toArray();
        System.out.println("IntStream 방식 1: " + Arrays.toString(streamArr));
        

        int[] streamArr2 = IntStream.of(arr)
                                  .skip(1)
                                  .limit(arr.length - 2)
                                  .toArray();
        System.out.println("IntStream 방식 2: " + Arrays.toString(streamArr2));

    }
}
