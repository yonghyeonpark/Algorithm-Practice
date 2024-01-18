package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7576 {

    private static int[][] box;
    private static Queue<int[]> q = new ArrayDeque<>();
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int n, m;
    private static int day = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        box = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        if (!checkZero()) {
            System.out.println(0);
            return;
        }
        bfs();
        if (checkZero()) {
            System.out.println(-1);
        } else {
            System.out.println(day);
        }
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int j = 0; j < 4; j++) {
                int nx = cur[0] + dx[j];
                int ny = cur[1] + dy[j];

                if (nx >= n || nx < 0 || ny >=m || ny < 0 || box[nx][ny] == -1) {
                    continue;
                }
                if (box[nx][ny] == 0) {
                    box[nx][ny] = 1;
                    q.offer(new int[]{nx, ny, cur[2] + 1});
                    day = cur[2] + 1;
                }
            }
        }
    }

    private static boolean checkZero() {
        return Arrays.stream(box)
                .flatMapToInt(Arrays::stream)
                .anyMatch(element -> element == 0);
    }
}
