package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 소트인사이드_1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        while (a != 0) {
            list.add(a % 10);
            a /= 10;
        }
        Collections.sort(list, Collections.reverseOrder());
        for (int n : list) {
            System.out.print(n);
        }
    }
}
