package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 바닥장식_1388 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Character>> floor = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            floor.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            String row = br.readLine();
            for (int j = 1; j <= M; j++) {
                floor.get(i).add(row.charAt(j-1));
            }
        }

        /*boolean rowCheck = false;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (j != M && floor.get(i).get(j-1) == '-') {
                    rowCheck = true;
                }
                if (floor.get(i).get(j-1) == '|' && rowCheck) {
                    rowCheck = false;
                    count++;
                }
                if (j == M && floor.get(i).get(j-1) == '-') {
                    count++;
                }
            }
            rowCheck = false;
        }

        boolean columnCheck = false;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (j != N && floor.get(j).get(i-1) == '|') {
                    columnCheck = true;
                }
                if (floor.get(j).get(i-1) == '-' && columnCheck) {
                    columnCheck = false;
                    count++;
                }
                if (j == N && floor.get(j).get(i-1) == '|') {
                    count++;
                }
            }
            columnCheck = false;
        }
        System.out.println(count);*/

        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (floor.get(i).get(j-1) == '-' && (j == 1 || floor.get(i).get(j-2) == '|')) {
                    count++;
                }
            }
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (floor.get(j).get(i-1) == '|' && (j == 1 || floor.get(j-1).get(i-1) == '-')) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
