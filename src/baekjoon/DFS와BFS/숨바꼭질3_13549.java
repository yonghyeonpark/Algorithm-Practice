package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3_13549 {

    private static int min = Integer.MAX_VALUE;
    private static int a, b;
    private static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        v = new boolean[2 * (Math.max(a, b) + 1)];
        bfs(a);
        System.out.println(min);
    }

    private static void bfs(int start) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start, 0});
        v[start] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int num = cur[0];
            int time = cur[1];
            if (num == b) {
                min = Math.min(min, time);
            }
            if (num != 0 && num * 2 <= b + 1) {
                v[num * 2] = true;
                q.offer(new int[]{num * 2, time});
            }
            if (num - 1 >= 0 && !v[num - 1]) {
                v[num - 1] = true;
                q.offer(new int[]{num - 1, time + 1});
            }
            if (num + 1 <= b && !v[num + 1]) {
                v[num + 1] = true;
                q.offer(new int[]{num + 1, time + 1});
            }
        }
    }
}
