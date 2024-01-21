package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보물섬_2589 {

    private static char[][] map;
    private static boolean[][] v;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int n, m;
    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }
        System.out.println(result);
    }

    private static void bfs(int x, int y) {
        v = new boolean[n][m];
        v[x][y] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int a = cur[0];
            int b = cur[1];
            int time = cur[2];
            if (result < time) {
                result = time;
            }
            for (int i = 0; i < 4; i++) {
                int nx = a + dx[i];
                int ny = b + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !v[nx][ny] && map[nx][ny] == 'L') {
                    v[nx][ny] = true;
                    q.offer(new int[]{nx, ny, time + 1});
                }
            }
        }
    }
}
