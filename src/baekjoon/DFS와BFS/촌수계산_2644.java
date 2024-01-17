package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 촌수계산_2644 {

    private static ArrayList<ArrayList<Integer>> relationship = new ArrayList<>();
    private static boolean[] v;
    private static int b;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        // 관계도 초기화
        for (int i = 0; i <= n; i++) {
            relationship.add(new ArrayList<>());
        }
        v = new boolean[n+1];

        // 관계 연결
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            relationship.get(x).add(y);
            relationship.get(y).add(x);
        }
        int num = 0;
        result = -1;
        dfs(a, num);
        System.out.println(result);
    }

    private static void dfs(int x, int num) {
        v[x] = true;
        for (int i = 0; i < relationship.get(x).size(); i++) {
            int y = relationship.get(x).get(i);
            if (!v[y]) {
                if (y == b) {
                    result = num + 1;
                    return;
                }
                dfs(y, num + 1);
            }
        }
    }
}
