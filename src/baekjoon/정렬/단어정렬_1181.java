package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class 단어정렬_1181{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>(
                Comparator.comparing(String::length)
                        .thenComparing(Comparator.naturalOrder()));
        for (int i = 0; i < a; i++) {
            set.add(br.readLine());
        }
        for (String word : set) {
            System.out.println(word);
        }
    }
}
