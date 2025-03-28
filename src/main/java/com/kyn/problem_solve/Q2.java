package com.kyn.problem_solve;

import java.util.stream.IntStream;
import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        int[][] triangle = new int[][] { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
        System.out.println(solution(triangle));
    }

    public static int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];

        for (int i = 0; i < triangle.length; i++) {
            dp[i] = new int[triangle[i].length];
        }

        dp[0][0] = triangle[0][0];

        IntStream.range(1, triangle.length)
                .forEach(i -> IntStream.range(0, triangle[i].length).forEach(j -> dp[i][j] = (j == 0 ? dp[i - 1][j]
                        : j == triangle[i].length - 1 ? dp[i - 1][j - 1] : Math.max(dp[i - 1][j - 1], dp[i - 1][j]))
                        + triangle[i][j]));

        return Arrays.stream(dp[dp.length - 1]).max().getAsInt();
    }
}
