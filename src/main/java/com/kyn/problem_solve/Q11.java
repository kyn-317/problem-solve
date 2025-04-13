package com.kyn.problem_solve;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Q11 {
    public static void main(String[] args) {
       int[] nums = {2,7,11,15};
       int target = 9;

       int[] answer = new int[2];
       for(int i = 0; i < nums.length; i++) {
           for(int j = i + 1; j < nums.length; j++) {
               if(nums[i] + nums[j] == target) {
                   answer[0] = i;
                   answer[1] = j;
               }
           }
       }
       System.out.println("기존 방식: " + Arrays.toString(answer));

       // Stream 방식 1: IntStream.range와 flatMap 사용
       int[] answer2 = IntStream.range(0, nums.length)
                               .flatMap(i -> IntStream.range(i + 1, nums.length)
                                                    .filter(j -> nums[i] + nums[j] == target)
                                                    .mapToObj(j -> new int[]{i, j})
                                                    .findFirst()
                                                    .stream()
                                                    .flatMapToInt(Arrays::stream))
                               .toArray();
       System.out.println("Stream 방식 1: " + Arrays.toString(answer2));

       // Stream 방식 2: IntStream.range와 anyMatch 사용
       int[] answer3 = new int[2];
       IntStream.range(0, nums.length)
               .forEach(i -> IntStream.range(i + 1, nums.length)
                                    .filter(j -> nums[i] + nums[j] == target)
                                    .findFirst()
                                    .ifPresent(j -> {
                                        answer3[0] = i;
                                        answer3[1] = j;
                                    }));
       System.out.println("Stream 방식 2: " + Arrays.toString(answer3));
    }
}
