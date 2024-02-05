package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 점수계산_2822 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> score = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            score.add(Integer.parseInt(br.readLine()));
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            map.put(score.get(i), i + 1);
        }

        List<Integer> top5 = score.stream()
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .collect(Collectors.toList());

        int sum = top5.stream()
                .mapToInt(Integer::intValue)
                .sum();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            result.add(map.get(top5.get(i)));
        }
        Collections.sort(result);

        System.out.println(sum);
        for (int i = 0; i < 5; i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
