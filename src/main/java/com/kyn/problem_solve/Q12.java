package com.kyn.problem_solve;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Q12 {
    public static void main(String[] args) {
       int[] intArray = {1,2,3,4,5,6};
       int valueToSearch =6;
        int answer = -1;
       for(int i = 0 ; i < intArray.length; i++) {
        if(intArray[i] == valueToSearch) {
            answer = i;
        }
       }

       System.out.println(answer);
    }
}
