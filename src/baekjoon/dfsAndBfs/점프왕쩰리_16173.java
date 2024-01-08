package baekjoon.dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점프왕쩰리_16173 {

    private static int[][] map;
    private static boolean[][] visited;
    private static int N;
    private static String result = "Hing";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N =Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            StringTokenizer st = new StringTokenizer(row);
            for (int j = 0; j < N; j++) {
                map[i][j] =Integer.parseInt(st.nextToken());
            }
        }

        jump(0, 0, map[0][0]);
        System.out.println(result);
    }

    private static void jump(int x, int y, int value) {
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        if (value == -1) {
            result = "HaruHaru";
            return;
        }
        if (x + value < N) {
            jump(x + value, y, map[x + value][y]);
        }
        if (y + value < N) {
            jump(x, y + value, map[x][y + value]);
        }
    }
}
