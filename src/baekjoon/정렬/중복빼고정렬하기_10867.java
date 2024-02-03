package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 중복빼고정렬하기_10867 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        /* 1. Set 사용
        Set<Integer> s = new HashSet<>();
        for (int i = 0 ; i < n; i++) {
            s.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> result = new ArrayList<>(s);
        result.sort(Comparator.naturalOrder());
        for (int a : result) {
            System.out.print(a + " ");
        }*/

        // 2. stream.distinct 사용
        List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < n; i++) {
            result.add(Integer.parseInt(st.nextToken()));
        }
        result = result.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        for (int a : result) {
            System.out.print(a + " ");
        }
    }
}
