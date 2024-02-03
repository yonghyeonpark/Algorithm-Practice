package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class A를B로_16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        boolean[] v = new boolean[(int) (b + 1)];
        v[(int ) a] = true;
        Queue<long[]> q = new ArrayDeque<>();
        q.offer(new long[]{a, 1});
        while (!q.isEmpty()) {
            long[] cur = q.poll();
            long i = (cur[0] * 10) + 1;
            long j = cur[0] * 2;
            long k = cur[1] + 1;
            if (cur[0] == b) {
                System.out.println(cur[1]);
                return;
            }
            if (i <= b) {
                v[(int) i] = true;
                q.offer(new long[]{i, k});
            }
            if (j <= b && !v[(int) j]) {
                q.offer(new long[]{j, k});
            }
        }
        System.out.println(-1);
    }
}
