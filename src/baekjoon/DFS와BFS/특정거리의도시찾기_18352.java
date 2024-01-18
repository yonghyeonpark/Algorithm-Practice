package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기_18352 {

    private static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    private static boolean[] v;
    private static int distance;
    private static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        distance = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        // 맵 초기화
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        v = new boolean[n + 1];

        // 도시 연결
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b); // 단방향
        }

        bfs(start);

        if (result.isEmpty()) {
            System.out.println(-1);
            return;
        }
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i))
                    .append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        v[start] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (y == distance) {
                result.add(x);
            }
            for (int i = 0; i < map.get(x).size(); i++) {
                int k = map.get(x).get(i);
                if (!v[k]) {
                    v[k] = true;
                    q.offer(new int[]{k, y + 1});
                }
            }
        }
    }
}
