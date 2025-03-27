package com.kyn.problem_solve;

import java.util.Map;
import java.util.stream.IntStream;

public class Q1 {
    public static void main(String[] args) {

        Map<String, Object> map1 = Map.of("schedules", new int[] { 700, 800, 1100 },
                "timelogs",
                new int[][] { { 710, 2359, 1050, 700, 650, 631, 659 },
                        { 800, 801, 805, 800, 759, 810, 809 },
                        { 1105, 1001, 1002, 600, 1059, 1001, 1100 } },
                "startday", 5, "result", 3);
        Map<String, Object> map2 = Map.of("schedules", new int[] { 730, 855, 700, 720 },
                "timelogs", new int[][] { { 710, 700, 650, 735, 700, 931, 912 },
                        { 908, 901, 805, 815, 800, 831, 835 },
                        { 705, 701, 702, 705, 710, 710, 711 },
                        { 707, 731, 859, 913, 934, 931, 905 } },
                "startday", 1, "result", 2);

        System.out.println(
                solution((int[]) map1.get("schedules"), (int[][]) map1.get("timelogs"), (int) map1.get("startday")));
        System.out.println(
                solution((int[]) map2.get("schedules"), (int[][]) map2.get("timelogs"), (int) map2.get("startday")));
    }

    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        return (int) IntStream.range(0, schedules.length)
                .filter(i -> IntStream.range(0, timelogs[i].length)
                        .filter(j -> {
                            int currentDay = (j + startday) % 7;
                            if (currentDay != 0 && currentDay != 6) {
                                return timeCalculator(timelogs[i][j]) <= timeCalculator(schedules[i] + 10);
                            }
                            return true;
                        })
                        .count() >= 7)
                .count();
    }

    public static int timeCalculator(int wantTime) {
        return (wantTime / 100) * 60 + wantTime % 100;
    }
}
