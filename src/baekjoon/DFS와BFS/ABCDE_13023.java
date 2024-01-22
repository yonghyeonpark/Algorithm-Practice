package baekjoon.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// if (result == 0)의 분기 없이 반복문을 전부 돌리면 '시간 초과' 발생
public class ABCDE_13023 {

    private static ArrayList<ArrayList<Integer>> relationship = new ArrayList<>();
    private static boolean[] v;
    private static int n, m;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            relationship.add(new ArrayList<>());
        }
        v = new boolean[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relationship.get(a).add(b);
            relationship.get(b).add(a);
        }
        for (int i = 0; i < relationship.size(); i++) {
            if (result == 0) {
                dfs(i, 0);
            }
        }
        System.out.println(result);
    }

    private static void dfs(int x, int moving) {
        if (moving == 4) {
            result = 1;
            return;
        }
        v[x] = true;
        for (int i = 0; i < relationship.get(x).size(); i++) {
            int y = relationship.get(x).get(i);
            if (!v[y]) {
                dfs(y, moving + 1);
            }
        }
        v[x] = false;
    }
}
