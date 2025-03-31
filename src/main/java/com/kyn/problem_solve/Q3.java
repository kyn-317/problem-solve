package com.kyn.problem_solve;

import java.util.Map;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Q3 {

    public static void main(String[] args) {

        Map<String, Object> map1 = Map.of("wallet", new int[] { 30, 15 }, "bill", new int[] { 26, 17 }, "result", 1);
        Map<String, Object> map2 = Map.of("wallet", new int[] { 50, 50 }, "bill", new int[] { 100, 241 }, "result", 4);

        System.out.println(solution((int[]) map1.get("wallet"), (int[]) map1.get("bill")));
        System.out.println(solution((int[]) map2.get("wallet"), (int[]) map2.get("bill")));

    }

    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;
        Arrays.sort(wallet);
        Arrays.sort(bill);

        while (IntStream.range(0, 2).anyMatch(i -> bill[i] > wallet[i])) {
            bill[IntStream.range(0, 2).reduce((i, j) -> bill[i] > bill[j] ? i : j).getAsInt()] /= 2;
            answer++;
            Arrays.sort(bill);
        }

        return answer;
    }
}
