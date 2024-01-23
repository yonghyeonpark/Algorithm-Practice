package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 다시 풀기
public class 맥주마시면서걸어가기_9205 {

    private static ArrayList<int[]> route;
    private static Map<int[], Boolean> v;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            route = new ArrayList<>();
            v = new HashMap<>();
            n = Integer.parseInt(br.readLine());

            // 각 위치 등록
            for (int j = 0; j < n + 2; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int[] loc = {a, b};
                v.put(loc, false);
                route.add(loc);
            }
            if (bfs()) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    private static boolean bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(route.get(0));
        v.put(route.get(0), true);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int[] p : route) {
                int cx = p[0];
                int cy = p[1];
                int distance = Math.abs(cx - x) + Math.abs(cy - y);
                if (!v.get(p) && distance <= 1000) {
                    v.put(p, true);
                    q.offer(p);
                }
            }
        }
        if (v.get(route.get(n + 1))) {
            return true;
        }
        return false;
    }
}
