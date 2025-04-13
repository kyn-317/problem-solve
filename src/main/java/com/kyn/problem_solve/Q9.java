package com.kyn.problem_solve;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q9 {
    public static void main(String[] args) {
       int[] array = {1, 1, 2, 2, 3, 4, 5};

       // 방식 1: distinct() 사용
       int[] answer = Arrays.stream(array).distinct().toArray();
       System.out.println("distinct() 사용: " + Arrays.toString(answer));
       
       // 방식 2: boxed()와 collect()를 사용하여 Set으로 변환 후 다시 배열로
       int[] answer2 = Arrays.stream(array)
                            .boxed()
                            .collect(Collectors.toCollection(LinkedHashSet::new))
                            .stream()
                            .mapToInt(Integer::intValue)
                            .toArray();
       System.out.println("LinkedHashSet 사용: " + Arrays.toString(answer2));
       
       // 방식 3: 인덱스 기반 필터링으로 첫 등장 요소만 유지
       int[] answer3 = IntStream.range(0, array.length)
                              .filter(i -> IntStream.range(0, i)
                                                  .noneMatch(j -> array[i] == array[j]))
                              .map(i -> array[i])
                              .toArray();
       System.out.println("인덱스 기반 필터링: " + Arrays.toString(answer3));
       
       // 방식 4: 그룹화를 통한 중복 제거
       int[] answer4 = Arrays.stream(array)
                            .boxed()
                            .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                            .keySet()
                            .stream()
                            .mapToInt(Integer::intValue)
                            .toArray();
       System.out.println("그룹화 방식: " + Arrays.toString(answer4));
    }
}
