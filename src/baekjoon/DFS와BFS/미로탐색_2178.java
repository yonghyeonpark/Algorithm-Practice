package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_2178 {

    private static int[][] map;
    private static boolean[][] v;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int n, m;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        v = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        bfs(0, 0);
        System.out.println(min);
    }

    private static void bfs(int x, int y) {
        v[x][y] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y, 1});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == n-1 && cur[1] == m-1) {
                min = Math.min(min, cur[2]);
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= n || nx < 0 || ny >= m || ny < 0 || map[nx][ny] == 0) {
                    continue;
                }
                if (!v[nx][ny]) {
                    v[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cur[2] + 1});
                }
            }
        }
    }
}
