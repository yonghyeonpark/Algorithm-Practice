package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 3차원 배열
public class 미로탈출_14923 {

    private static int[][] map;
    private static boolean[][][] v;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int n, m, sx, sy, ex, ey;
    private static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        v = new boolean[n][m][2];

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken()) - 1;
        sy = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken()) - 1;
        ey = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        v[sx][sy][0] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy, 0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dt = cur[2];
            int st = cur[3];

            if (x == ex && y == ey) {
                result = dt; // 가장 먼저 도달했기 때문에 크기 비교 필요없음
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 0 && !v[nx][ny][st]) {
                        v[nx][ny][st] = true;
                        q.offer(new int[]{nx, ny, dt + 1, st});
                    }
                    if (map[nx][ny] == 1 && st == 0 && !v[nx][ny][1]) {
                        v[nx][ny][1] = true;
                        q.offer(new int[]{nx, ny, dt + 1, 1});
                    }
                }
            }
        }
    }
}
