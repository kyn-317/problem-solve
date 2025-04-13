package com.kyn.problem_solve;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Q8 {
    public static void main(String[] args) {
       int[] array = {1,2,3,4,6};
       
       int answer =  (array.length+1)*(array.length+2)/2 - Arrays.stream(array).sum();
       System.out.println("기존 방식: " + answer);
       
       
       int answer2 = IntStream.rangeClosed(1, array.length+1)
                            .sum() - Arrays.stream(array).sum();
       System.out.println("rangeClosed 사용: " + answer2);
       
       int answer3 = IntStream.rangeClosed(1, array.length+1)
                            .filter(num -> Arrays.stream(array).noneMatch(n -> n == num))
                            .sum();
       System.out.println("스트림 필터링 사용: " + answer3);
       }
}
