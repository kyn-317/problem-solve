package com.kyn.problem_solve;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q10 {
    public static void main(String[] args) {
       int[] array = {7, 1, 5, 3, 6, 4};

       // 방식 1: 최대 이익 계산
       int maxProfit = 0;
       int minPrice = Integer.MAX_VALUE;

       for (int price : array) {
           if (price < minPrice) minPrice = price;
           else maxProfit = Math.max(maxProfit, price - minPrice);
       }

       System.out.println(maxProfit);
    }
}
