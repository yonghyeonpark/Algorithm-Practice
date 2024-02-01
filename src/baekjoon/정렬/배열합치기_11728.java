package baekjoon.정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. BufferedReader과 BufferedWriter 사용
 * 2. list.foreach() 문 안에서 BufferedWriter 사용 시 IOException에 대한 처리가 따로 필요
 */
public class 배열합치기_11728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> result = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            result.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            result.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(result);
        for (int a : result) {
            bw.write(String.valueOf(a)+ " ");
        }
        bw.flush();
        bw.close();
    }
}
