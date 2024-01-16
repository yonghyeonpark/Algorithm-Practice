package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추_1012 {

    private static int[][] graph;
    private static boolean[][] v;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            graph = new int[n][m];

            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x][y] = 1;
            }

            int result = 0;
            for (int o = 0; o < n; o++) {
                for (int p = 0; p < m; p++) {
                    if (dfs(o, p)) {
                        result += 1;
                    }
                }
            }
            System.out.println(result);
        }
    }

    private static boolean dfs(int x, int y) {
        if (graph[x][y] == 0) {
            return false;
        }
        graph[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || graph[nx][ny] == 0) {
                continue;
            }
            dfs(nx, ny);
        }
        return true;
    }
}
