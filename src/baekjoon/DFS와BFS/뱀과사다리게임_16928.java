package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀과사다리게임_16928 {

    private static ArrayList<ArrayList<Integer>> route = new ArrayList<>();
    private static boolean[] v = new boolean[101];
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int snake = Integer.parseInt(st.nextToken());
        int ladder = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= 100; i++) {
            route.add(new ArrayList<>());
        }

        for (int i = 0; i < snake + ladder; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            route.get(a).add(b); // 단방향
        }
        bfs(1);
        System.out.println(result);
    }

    private static void bfs(int start) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int count = cur[1];
            if (x == 100 && count < result) {
                result = count;
            }
            for (int i = 1; i <= 6; i++) {
                if (x + i <= 100 && !v[x + i]) {
                    v[x + i] = true;
                    if (!route.get(x + i).isEmpty()) {
                        v[route.get(x + i).get(0)] = true;
                        q.offer(new int[]{route.get(x + i).get(0), count + 1});
                    } else {
                        q.offer(new int[]{x + i, count + 1});
                    }
                }
            }
        }
    }
}
